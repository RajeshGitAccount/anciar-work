package com.anciar.technologies.network

import java.io.IOException

data class NetworkNotConnectedException(var errorMessage: String): IOException(errorMessage)