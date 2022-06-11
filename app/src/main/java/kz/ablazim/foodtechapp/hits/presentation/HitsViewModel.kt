package kz.ablazim.foodtechapp.hits.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kz.ablazim.foodtechapp.base.BaseViewModel
import kz.ablazim.foodtechapp.hits.data.model.HitInfo
import kz.ablazim.foodtechapp.hits.domain.GetHitsUseCase
import timber.log.Timber

class HitsViewModel(private val getHitsUseCase: GetHitsUseCase) : BaseViewModel() {
    private val _items = MutableLiveData<List<HitInfo>>()
    val items: LiveData<List<HitInfo>> = _items

    private val _progressLoading = MutableLiveData(false)
    val progressLoading: LiveData<Boolean> = _progressLoading

    fun onViewCreated() {
        launchSafe(
            start = { _progressLoading.value = true },
            finish = { _progressLoading.value = false },
            body = {
                _items.postValue(getHitsUseCase.invoke(Unit))
            },
            handleError = {
                Timber.e(it, "Could not get hits")
            }
        )
    }
}