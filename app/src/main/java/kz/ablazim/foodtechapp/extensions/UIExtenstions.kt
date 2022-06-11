package kz.ablazim.foodtechapp.extensions

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import kz.ablazim.foodtechapp.R
import org.koin.ext.getFullName

fun FragmentManager.replaceFragment(
    @IdRes containerViewId: Int = R.id.container,
    fragment: Fragment,
    tag: String? = fragment.tag,
    backStackName: String = fragment::class.getFullName(),
    shouldAddToBackStack: Boolean = true
) {
    commit {
        replace(containerViewId, fragment, tag)
        if (shouldAddToBackStack) addToBackStack(backStackName)
    }
}