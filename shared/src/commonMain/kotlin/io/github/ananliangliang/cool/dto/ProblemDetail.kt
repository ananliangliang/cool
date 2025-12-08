package io.github.ananliangliang.cool.dto

import kotlinx.serialization.Serializable

/** Representation for an RFC 9457 problem detail. */
@Serializable
data class ProblemDetail(
    val type: String = "about:blank",
    val status: Int,
    var title: String? = null,
    var detail: String? = null,
    var instance: String? = null,
)