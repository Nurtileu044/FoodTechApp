package kz.ablazim.foodtechapp.comments.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kz.ablazim.foodtechapp.base.BaseViewModel
import kz.ablazim.foodtechapp.comments.data.model.CommentInfo
import kz.ablazim.foodtechapp.comments.domain.GetCommentsUseCase
import timber.log.Timber

class CommentsViewModel(private val commentsUseCase: GetCommentsUseCase) : BaseViewModel() {
    private val _items = MutableLiveData<List<CommentInfo>>()
    val items: LiveData<List<CommentInfo>> = _items

    private val _progressLoading = MutableLiveData(false)
    val progressLoading: LiveData<Boolean> = _progressLoading

    fun onViewCreated() {
        launchSafe(
            start = { _progressLoading.value = true },
            finish = { _progressLoading.value = false },
            body = {
                _items.postValue(commentsUseCase.invoke(Unit))
            },
            handleError = {
                Timber.e(it, "Could not get comments")
            }
        )
    }
}