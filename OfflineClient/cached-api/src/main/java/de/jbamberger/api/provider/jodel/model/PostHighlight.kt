package de.jbamberger.api.provider.jodel.model

class PostHighlight(val startIndex: Int, val length: Int) {

    val endIndex: Int
        get() = startIndex + length
}
