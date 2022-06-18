package com.atahar.cvdprediction.view

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.navigation.Navigation.findNavController
import com.atahar.cvdprediction.R
import com.atahar.cvdprediction.utils.AppConstants

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                openUserStatusFragment()
                true
            }
            else -> false
        }
    }

    private fun openUserStatusFragment() {
        val navController = findNavController(this, R.id.nav_host_fragment)
        navController.navigate(
            R.id.action_userInputFragment_to_userStatusFragment,
            bundleOf(AppConstants.CVD_STATUS to -1)
        )
    }


}