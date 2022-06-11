package kz.ablazim.foodtechapp.restaurants.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kz.ablazim.foodtechapp.R
import kz.ablazim.foodtechapp.base.BaseAdapter
import kz.ablazim.foodtechapp.base.BaseViewHolder
import kz.ablazim.foodtechapp.databinding.ItemRestaurantBinding
import kz.ablazim.foodtechapp.restaurants.data.model.RestaurantInfo

class RestaurantsAdapter(private val onItemClicked: (info: RestaurantInfo) -> Unit) : BaseAdapter<RestaurantInfo>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<RestaurantInfo> =
        RestaurantViewHolder(
            ItemRestaurantBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            onItemClicked
        )

    private class RestaurantViewHolder(
        private val viewBinding: ItemRestaurantBinding,
        onItemClicked: (info: RestaurantInfo) -> Unit
    ) : BaseViewHolder<RestaurantInfo>(viewBinding.root, onItemClicked) {

        override fun onBind(item: RestaurantInfo) {
            super.onBind(item)
            with(viewBinding) {
                Glide.with(root.context).load(item.logoUrl).placeholder(R.drawable.ic_feed).into(logoImageView)
                restaurantNameTextView.text = item.name
                val specializationString: StringBuilder = StringBuilder("")
                item.specializations.forEachIndexed { index, specialization ->
                    if (index == 0) {
                        specializationString.append(specialization.name)
                    } else {
                        specializationString.append(" / ${specialization.name}")
                    }
                }
                typeOfFoodsTextView.text = specializationString
                likeTextView.text = root.context.getString(R.string.like_percent, item.positiveReviews)
            }
        }
    }
}