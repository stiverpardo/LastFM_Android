package com.mistpaag.lastfm.trainee.data.remote

import com.mistpaag.lastfm.trainee.models.responses.topartist.TopArtistFM
import com.mistpaag.lastfm.trainee.models.responses.toptrack.TopTrackFM
import com.mistpaag.lastfm.trainee.utils.Const
import kotlinx.coroutines.Deferred
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET(Const.URL_TOP_ARTIST)
    fun fetchTopArtist(
        @Query("page") int: Int
    ): Deferred<TopArtistFM>

    @GET(Const.URL_TOP_TRACK)
    fun fetchTopTrack(
        @Query("page") int: Int
    ): Deferred<TopTrackFM>
}