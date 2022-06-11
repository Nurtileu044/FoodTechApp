package kz.ablazim.foodtechapp.restaurants.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kz.ablazim.foodtechapp.base.BaseViewModel
import kz.ablazim.foodtechapp.restaurants.data.model.RestaurantInfo
import kz.ablazim.foodtechapp.restaurants.domain.GetLocalRestaurantsByName
import kz.ablazim.foodtechapp.restaurants.domain.GetLocalRestaurantsUseCase
import kz.ablazim.foodtechapp.restaurants.domain.GetRestaurantsUseCase
import kz.ablazim.foodtechapp.restaurants.domain.SaveLocalRestaurantsUseCase
import timber.log.Timber

class RestaurantsViewModel(
    private val getRestaurantsUseCase: GetRestaurantsUseCase,
    private val getLocalRestaurantsUseCase: GetLocalRestaurantsUseCase,
    private val saveLocalRestaurantsUseCase: SaveLocalRestaurantsUseCase,
    private val getLocalRestaurantsByName: GetLocalRestaurantsByName
) : BaseViewModel() {
    private val _items = MutableLiveData<List<RestaurantInfo>>()
    val items: LiveData<List<RestaurantInfo>> = _items

    private val _progressLoading = MutableLiveData(false)
    val progressLoading: LiveData<Boolean> = _progressLoading

    fun onViewCreated() {
        launchSafe(
            start = { _progressLoading.value = true },
            finish = { _progressLoading.value = false },
            body = {
                val localRestaurants = getLocalRestaurantsUseCase.invoke(Unit)
                if (localRestaurants.isEmpty()) {
                    val remoteRestaurants = getRestaurantsUseCase.invoke(Unit)
                    saveLocalRestaurantsUseCase(remoteRestaurants)
                    _items.postValue(remoteRestaurants)
                    return@launchSafe
                }
                _items.postValue(localRestaurants)
            },
            handleError = {
                Timber.e(it, "Could not get restaurants")
            })
    }

    fun onSearchTextChanged(text: String) {
        if (text.isNotEmpty()) {
            launchSafe(
                body = { _items.postValue(getLocalRestaurantsByName.invoke(text)) },
                handleError = {
                    Timber.e(it, "Could not get restaurants by name")
                }
            )
        } else {
            launchSafe(
                body = { _items.postValue(getLocalRestaurantsUseCase.invoke(Unit)) },
                handleError = {
                    Timber.e(it, "Could not get restaurants in search")
                }
            )
        }
    }
}