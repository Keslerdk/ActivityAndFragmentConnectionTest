package com.example.activityandfragmentconnectiontest

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.activityandfragmentconnectiontest.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    private val viewModel: SharedViewModel by viewModels()

    private var navController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        navController =
            (supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment)
                .navController

        viewModel.showSnackBarEvent.observe(this) { t ->
            t.getContentIfNotHandled()?.apply {
                showSnackBar(this)
            }
        }

        viewModel.updateNavController.observe(this) {t->
            t.getContentIfNotHandled()?.apply {
                setupActionBarWithNavController(this)
            }
        }

        viewModel.updateNavController(navController!!)
        binding!!.bottomNavigationView.setupWithNavController(navController!!)
//        setupActionBarWithNavController(navController!!)
    }

    private fun showSnackBar(msg: String) {
        Snackbar.make(this, binding!!.root, msg, Snackbar.LENGTH_LONG).show()
    }

    override fun onSupportNavigateUp(): Boolean {
        return super.onSupportNavigateUp() || viewModel.updateNavController.value!!.peekContent().navigateUp()
    }
}