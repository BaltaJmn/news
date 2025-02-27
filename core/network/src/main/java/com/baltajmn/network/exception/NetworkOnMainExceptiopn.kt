package com.baltajmn.network.exception

data class NetworkOnMainException(
    val url: String
) : Exception() {

    override val message: String
        get() = "Network call on main thread.\n URL: $url"

}