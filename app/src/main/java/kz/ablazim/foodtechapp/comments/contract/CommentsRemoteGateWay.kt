package kz.ablazim.foodtechapp.comments.contract

import kz.ablazim.foodtechapp.comments.data.model.CommentInfo

interface CommentsRemoteGateWay {
    suspend fun getComments(): List<CommentInfo>
}