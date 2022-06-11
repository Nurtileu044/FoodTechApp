package kz.ablazim.foodtechapp.hits.presentation

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import kz.ablazim.foodtechapp.R
import kz.ablazim.foodtechapp.databinding.FragmentHitsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HitsFragment : Fragment(R.layout.fragment_hits) {

    private lateinit var binding: FragmentHitsBinding
    private val viewModel: HitsViewModel by viewModel()
    private val adapter: HitsAdapter by lazy {
        HitsAdapter(onItemClicked = {})
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHitsBinding.bind(view)

        binding.hitsRecyclerView.adapter = adapter

        viewModel.items.observe(viewLifecycleOwner) { items ->
            adapter.setItems(items)
        }

        viewModel.progressLoading.observe(viewLifecycleOwner) { isLoading ->
            binding.progressStateView.isVisible = isLoading
        }

        viewModel.onViewCreated()
    }
}