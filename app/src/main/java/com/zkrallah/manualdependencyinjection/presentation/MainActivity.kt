package com.zkrallah.manualdependencyinjection.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.zkrallah.manualdependencyinjection.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import kotlin.random.Random
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /**
         * Making it automatic with Dagger Hilt.
         */
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
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