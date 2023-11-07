package com.zkrallah.manualdependencyinjectiondemo.domain.model

import com.zkrallah.manualdependencyinjection.domain.model.Rating

data class Response(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val rating: Rating,
    val title: String
)