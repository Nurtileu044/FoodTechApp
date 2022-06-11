package kz.ablazim.foodtechapp.comments.domain

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kz.ablazim.foodtechapp.base.UseCase
import kz.ablazim.foodtechapp.comments.contract.CommentsRemoteGateWay
import kz.ablazim.foodtechapp.comments.data.model.CommentInfo

class GetCommentsUseCase(private val commentsRemoteGateWay: CommentsRemoteGateWay) :
    UseCase<Unit, List<CommentInfo>>() {
    override val dispatcher: CoroutineDispatcher = Dispatchers.IO

    override suspend fun execute(parameters: Unit): List<CommentInfo> = commentsRemoteGateWay.getComments()
}