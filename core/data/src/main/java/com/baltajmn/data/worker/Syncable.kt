package com.baltajmn.data.worker

interface Syncable {
    suspend fun sync(): Result<Boolean>
}