package com.mistpaag.lastfm.trainee.models.responses.toptrack

import com.google.gson.annotations.SerializedName

data class Streamable(
    @SerializedName("#text")
    val text: String,
    val fulltrack: String
)