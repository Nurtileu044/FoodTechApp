package kz.ablazim.foodtechapp.comments.presentation

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import kz.ablazim.foodtechapp.R
import kz.ablazim.foodtechapp.databinding.FragmentCommentsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class CommentsFragment : Fragment(R.layout.fragment_comments) {

    private lateinit var binding: FragmentCommentsBinding
    private val viewModel: CommentsViewModel by viewModel()
    private val adapter: CommentsAdapter by lazy {
        CommentsAdapter(onItemClicked = {})
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCommentsBinding.bind(view)

        binding.commentsRecyclerView.adapter = adapter

        viewModel.items.observe(viewLifecycleOwner) { items ->
            adapter.setItems(items)
        }

        viewModel.progressLoading.observe(viewLifecycleOwner) { isLoading ->
            binding.progressStateView.isVisible = isLoading
        }

        viewModel.onViewCreated()
    }
}