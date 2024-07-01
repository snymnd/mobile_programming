package com.bangkit.hargain.data.product.remote.dto

import com.google.gson.annotations.SerializedName

data class ProductResponse(
    @SerializedName("id") val id: String,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("image") val image: String,
    @SerializedName("brand") val brand: Brand,
    @SerializedName("category") val category: Category,
    @SerializedName("currentPrice") val currentPrice: Double,
    @SerializedName("optimalPrice") val optimalPrice: Double,
    @SerializedName("cost") val cost: Double,
    @SerializedName("startPrice") val startPrice: Double,
    @SerializedName("endPrice") val endPrice: Double,
    @SerializedName("pricePredictions") val pricePredictions: List<PricePrediction>
)