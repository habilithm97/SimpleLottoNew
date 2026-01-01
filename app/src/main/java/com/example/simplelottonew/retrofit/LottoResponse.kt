package com.example.simplelottonew.retrofit

// 로또 API 응답(JSON)을 코틀린 객체로 담음
data class LottoResponse(
    val returnValue: String,
    val drwNo: Int,
    val drwNoDate: String,
    val drwtNo1: Int,
    val drwtNo2: Int,
    val drwtNo3: Int,
    val drwtNo4: Int,
    val drwtNo5: Int,
    val drwtNo6: Int,
    val bnusNo: Int
)