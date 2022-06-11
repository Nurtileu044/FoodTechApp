package kz.ablazim.foodtechapp.comments.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import kz.ablazim.foodtechapp.R
import kz.ablazim.foodtechapp.base.BaseAdapter
import kz.ablazim.foodtechapp.base.BaseViewHolder
import kz.ablazim.foodtechapp.comments.data.model.CommentInfo
import kz.ablazim.foodtechapp.databinding.ItemCommentBinding

class CommentsAdapter(private val onItemClicked: (info: CommentInfo) -> Unit) : BaseAdapter<CommentInfo>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<CommentInfo> = CommentViewHolder(
        ItemCommentBinding.inflate(LayoutInflater.from(parent.context), parent, false),
        onItemClicked
    )

    private class CommentViewHolder(
        private val viewBinding: ItemCommentBinding,
        onItemClicked: (info: CommentInfo) -> Unit
    ) : BaseViewHolder<CommentInfo>(viewBinding.root, onItemClicked) {
        override fun onBind(item: CommentInfo) {
            super.onBind(item)
            with(viewBinding) {
                reviewerNameTextView.text =
                    root.context.getString(R.string.review_of_reviewer, item.userFio, item.restaurantName)
                reviewerNameTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(
                    if (item.isPositive) R.drawable.ic_thumb_up else R.drawable.ic_thumb_down, 0, 0, 0
                )
                commentTextView.text = item.message
                dateTextView.text = item.dateAdded
            }
        }
    }
}