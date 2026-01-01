package com.example.simplelottonew.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

// 로또 API 요청 규격 정의
interface LottoApiService {
    // 당첨번호 조회를 위한 GET 요청 엔드포인트
    @GET("common.do")
    fun getLottoNumber(

        /* method (URL 쿼리 키)
         -서버가 호출할 API를 식별하는 고정 쿼리 파라미터
         -기본값 "getLottoNumber" (호출 시 생략 가능)
         -다른 값으로 바꾸면 요청 실패 */
        @Query("method") method: String = "getLottoNumber",

        @Query("drwNo") drwNo: Int // 조회할 회차 번호
    ): Call<LottoResponse> // API 응답 -> LottoResponse 객체
}