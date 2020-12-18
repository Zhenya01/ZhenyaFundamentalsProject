package com.zhenya.zhenyaFundamentalsProject

data class Movie(
        val name: String,
        val img: Int,
        var isLiked: Boolean,
        val age: Int,
        val genre: String,
        val rating: Float,
        val reviewsCount: Int,
        val duration: Int
) {
}
