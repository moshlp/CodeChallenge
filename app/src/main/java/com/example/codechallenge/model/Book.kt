package com.example.codechallenge.model

import com.google.gson.annotations.SerializedName

data class Book(@SerializedName("author") var author : String = "", @SerializedName("title") var title : String = "", @SerializedName("imageURL") var imageURL : String = "") {
}