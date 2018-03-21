package de.jbamberger.api.provider.jodel.model

data class StickyPost(
        val message: String,
        val type: String,
        val stickypostId: String,
        val color: String,
        val locationName: String,
        val link: String,
        val linkedPostColor: String,
        val buttons: List<StickyButton>?,
        var voted: String) {

    data class StickyButton constructor(val title: String)
}
