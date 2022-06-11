package kz.ablazim.foodtechapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kz.ablazim.foodtechapp.databinding.ActivitySingleBinding
import kz.ablazim.foodtechapp.extensions.replaceFragment
import kz.ablazim.foodtechapp.main.MainFragment

class SingleActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySingleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySingleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.replaceFragment(fragment = MainFragment())
        }
    }
}
