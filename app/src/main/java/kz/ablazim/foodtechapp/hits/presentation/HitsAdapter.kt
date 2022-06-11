package kz.ablazim.foodtechapp.hits.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kz.ablazim.foodtechapp.R
import kz.ablazim.foodtechapp.base.BaseAdapter
import kz.ablazim.foodtechapp.base.BaseViewHolder
import kz.ablazim.foodtechapp.databinding.ItemHitBinding
import kz.ablazim.foodtechapp.hits.data.model.HitInfo

class HitsAdapter(private val onItemClicked: (item: HitInfo) -> Unit) : BaseAdapter<HitInfo>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<HitInfo> = HitViewHolder(
        ItemHitBinding.inflate(LayoutInflater.from(parent.context), parent, false),
        onItemClicked
    )

    private class HitViewHolder(
        private val viewBinding: ItemHitBinding,
        onItemClicked: (item: HitInfo) -> Unit
    ) : BaseViewHolder<HitInfo>(viewBinding.root, onItemClicked) {
        override fun onBind(item: HitInfo) {
            super.onBind(item)
            with(viewBinding) {
                Glide.with(root.context).load(item.productImageUrl).placeholder(R.drawable.ic_menu).into(hitImageView)
                hitTextView.text = item.productName
            }
        }
    }
}