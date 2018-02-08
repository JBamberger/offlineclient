package de.jbamberger.api.jodel.model

class StickyPost(val message: String, val type: String, val stickypostId: String, val color: String, val locationName: String, val link: String, val linkedPostColor: String, val buttons: List<StickyButton>?, var voted: String) {

    inner class StickyButton internal constructor(val title: String)

    companion object {
        val STYCKYPOST_TYPE_BUTTONS = "buttons"
        val STYCKYPOST_TYPE_INFO = "info"
        val STYCKYPOST_TYPE_LINK = "link"
        val STYCKYPOST_TYPE_SURVEY = "survey"
    }
}
