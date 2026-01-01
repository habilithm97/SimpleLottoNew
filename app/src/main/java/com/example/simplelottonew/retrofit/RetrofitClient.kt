package com.example.simplelottonew.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Retrofit을 싱글톤으로 관리하기 위한 객체
object RetrofitClient {
    private const val BASE_URL = "https://www.dhlottery.co.kr/"

    // 인터페이스를 구현한 Retrofit 객체 초기화
    val apiService: LottoApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            // JSON <-> 코틀린 객체 자동 변환
            .addConverterFactory(GsonConverterFactory.create())
            .build() // Retrofit 객체 생성
            .create(LottoApiService::class.java) // 인터페이스 구현체 생성
    }
}