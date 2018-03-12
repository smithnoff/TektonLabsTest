package com.smithnoff.cesarsmith.tektonlabstest.background.firebase

import java.io.Serializable

/**
 * Created by jesusflores on 11-03-18.
 */
data class EventFeed(
        var id:String="",
        val title:String="",
        val place:String="",
        val date:String="",
        val time:String=""
):Serializable