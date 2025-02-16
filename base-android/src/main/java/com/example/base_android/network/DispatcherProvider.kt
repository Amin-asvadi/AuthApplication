@file:Suppress("PackageNaming", "PackageName")

package com.example.base_android.network

import kotlinx.coroutines.CoroutineDispatcher

interface DispatcherProvider {
    val ui: CoroutineDispatcher
    val io: CoroutineDispatcher
    val bg: CoroutineDispatcher
}
