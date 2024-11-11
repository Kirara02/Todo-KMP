package org.kirara.kmp_todo

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform