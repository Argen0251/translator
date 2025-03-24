package com.example.translator.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

    @Serializable
    data class TranslateResponse(
        @SerialName("audio_links")
        var audioLinks: List<AudioLink?>? = null,
        @SerialName("featured")
        var featured: Boolean? = null,
        @SerialName("pos")
        var pos: String? = null,
        @SerialName("text")
        var text: String? = null,
        @SerialName("translations")
        var translations: List<Translation?>? = null
    ) {
        @Serializable
        data class AudioLink(
            @SerialName("lang")
            var lang: String? = null,
            @SerialName("url")
            var url: String? = null
        )
    
        @Serializable
        data class Translation(
            @SerialName("examples")
            var examples: List<Example?>? = null,
            @SerialName("featured")
            var featured: Boolean? = null,
            @SerialName("pos")
            var pos: String? = null,
            @SerialName("text")
            var text: String? = null,
        ) {
            @Serializable
            data class Example(
                @SerialName("dst")
                var dst: String? = null,
                @SerialName("src")
                var src: String? = null
            )
        }
    }
