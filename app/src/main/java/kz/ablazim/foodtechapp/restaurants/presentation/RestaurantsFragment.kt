package kz.ablazim.foodtechapp.restaurants.presentation

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import kz.ablazim.foodtechapp.R
import kz.ablazim.foodtechapp.databinding.FragmentRestaurantsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class RestaurantsFragment : Fragment(R.layout.fragment_restaurants) {

    private lateinit var binding: FragmentRestaurantsBinding
    private val viewModel: RestaurantsViewModel by viewModel()
    private val adapter: RestaurantsAdapter by lazy {
        RestaurantsAdapter(onItemClicked = {})
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRestaurantsBinding.bind(view)

        binding.restaurantsRecyclerView.adapter = adapter
        binding.searchEditText.doAfterTextChanged { editableText ->
            editableText?.toString()?.let { viewModel.onSearchTextChanged(it) }
        }

        viewModel.progressLoading.observe(viewLifecycleOwner) { isLoading ->
            binding.progressStateView.isVisible = isLoading
        }

        viewModel.items.observe(viewLifecycleOwner) { items ->
            adapter.setItems(items)
        }
        viewModel.onViewCreated()
    }
}