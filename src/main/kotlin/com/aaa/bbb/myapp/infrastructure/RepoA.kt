package com.aaa.bbb.myapp.infrastructure

import com.aaa.bbb.myapp.domain.ServiceA
import kotlinx.coroutines.delay
import org.springframework.stereotype.Repository

@Repository
class RepoA : ServiceA {
    override fun getValue(name: String): String? {
        return if (name == "hao") {
            name
        } else {
            null
        }
    }

    override suspend fun suspendFun() {
        delay(1000L)
    }
}