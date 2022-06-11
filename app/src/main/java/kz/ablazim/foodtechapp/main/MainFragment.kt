package kz.ablazim.foodtechapp.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kz.ablazim.foodtechapp.R
import kz.ablazim.foodtechapp.comments.presentation.CommentsFragment
import kz.ablazim.foodtechapp.databinding.FragmentMainBinding
import kz.ablazim.foodtechapp.extensions.replaceFragment
import kz.ablazim.foodtechapp.hits.presentation.HitsFragment
import kz.ablazim.foodtechapp.restaurants.presentation.RestaurantsFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment(R.layout.fragment_main) {

    private lateinit var binding: FragmentMainBinding
    private val viewModel: MainViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)

        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            viewModel.onNavigationItemClicked(it.itemId)
            true
        }

        viewModel.actions.observe(viewLifecycleOwner) { action ->
            when (action) {
                is MainAction.ShowRestaurants -> childFragmentManager.replaceFragment(
                    containerViewId = R.id.childContainer,
                    fragment = RestaurantsFragment()
                )
                is MainAction.ShowHits -> childFragmentManager.replaceFragment(
                    containerViewId = R.id.childContainer,
                    fragment = HitsFragment()
                )
                is MainAction.ShowComments -> childFragmentManager.replaceFragment(
                    containerViewId = R.id.childContainer,
                    fragment = CommentsFragment()
                )
            }
        }
    }
}