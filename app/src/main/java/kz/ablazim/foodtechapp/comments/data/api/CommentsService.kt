package kz.ablazim.foodtechapp.comments.data.api

import kz.ablazim.foodtechapp.comments.data.model.CommentInfo
import retrofit2.http.GET

interface CommentsService {
    @GET("v1/reviews")
    suspend fun getReviews(): List<CommentInfo>
}