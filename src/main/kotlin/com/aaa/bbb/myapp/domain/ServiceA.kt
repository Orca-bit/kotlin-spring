package com.aaa.bbb.myapp.domain

interface ServiceA {
    fun getValue(name: String): String?

    suspend fun suspendFun()
}