package com.zkrallah.manualdependencyinjection.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.zkrallah.manualdependencyinjection.App
import com.zkrallah.manualdependencyinjection.databinding.ActivityMainBinding
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /**
         * Now we are just creating the ViewModel instance without the
         * hassle of creating the other instances it requires.
         */
        val appContainer = (application as App).appContainer
        val viewModel = MainViewModel(appContainer.repository)

        viewModel.getItems()

        lifecycleScope.launch {
            viewModel.items.collect { response ->
                val i = Random.nextInt(0, 11)
                binding.title.text = response?.get(i)?.title ?: "Title..."
                binding.description.text = response?.get(i)?.description ?: "Description..."
                binding.price.text = response?.get(i)?.price?.toString() ?: "Price..."
                Glide.with(this@MainActivity).load(response?.get(i)?.image).into(binding.image)
            }
        }
    }
}