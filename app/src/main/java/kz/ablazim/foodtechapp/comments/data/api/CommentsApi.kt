package kz.ablazim.foodtechapp.comments.data.api

import kz.ablazim.foodtechapp.comments.contract.CommentsRemoteGateWay
import kz.ablazim.foodtechapp.comments.data.model.CommentInfo

class CommentsApi(private val commentsService: CommentsService) : CommentsRemoteGateWay {
    override suspend fun getComments(): List<CommentInfo> = commentsService.getReviews()
}