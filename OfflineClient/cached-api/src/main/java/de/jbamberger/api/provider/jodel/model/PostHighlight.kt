package de.jbamberger.api.provider.jodel.model

data class PostHighlight(val startIndex: Int, val length: Int) {

    val endIndex = startIndex + length
}
