package com.example.paging3demo.http

import com.example.pagingdatademo.http.reqdata.DemoReqData
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author huanglinqing
 * @project Paging3Demo
 * @date 2020/11/7
 * @desc
 */
interface DataApi {

    /**
     * 获取数据
     */
    @GET("wenda/list/{pageId}/json")
    suspend fun getData(@Path("pageId") pageId: Int): DemoReqData
}