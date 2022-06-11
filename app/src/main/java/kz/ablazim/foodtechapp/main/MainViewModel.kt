package kz.ablazim.foodtechapp.main

import androidx.lifecycle.LiveData
import kz.ablazim.foodtechapp.R
import kz.ablazim.foodtechapp.base.Action
import kz.ablazim.foodtechapp.base.BaseViewModel
import kz.ablazim.foodtechapp.base.SingleLiveEvent

class MainViewModel() : BaseViewModel() {
    private val _actions = SingleLiveEvent<MainAction>()
    val actions: LiveData<MainAction> = _actions

    private var currentItemId: Int = R.id.restaurants

    init {
        invalidateNavigationItems()
    }

    fun onNavigationItemClicked(itemId: Int) {
        currentItemId = itemId
        invalidateNavigationItems()
    }

    private fun invalidateNavigationItems() {
        when (currentItemId) {
            R.id.restaurants -> _actions.value = MainAction.ShowRestaurants
            R.id.hits -> _actions.value = MainAction.ShowHits
            R.id.comments -> _actions.value = MainAction.ShowComments
        }
    }
}

sealed class MainAction : Action {
    object ShowRestaurants : MainAction()
    object ShowHits : MainAction()
    object ShowComments : MainAction()
}