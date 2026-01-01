package com.example.simplelottonew.retrofit

// 동행복권 로또 당첨번호 API 응답(JSON)을 코틀린 객체로 담기 위한 데이터 클래스
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