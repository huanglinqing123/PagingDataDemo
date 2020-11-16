package com.example.paging3demo.http

import android.util.Log
import com.example.pagingdatademo.http.reqdata.DemoReqData

/**
 * @author huanglinqing
 * @project Paging3Demo
 * @date 2020/11/7
 * @desc 数据仓库层
 */
class DataRespority {

    private var netWork = RetrofitService.createService(
        DataApi::class.java
    )

    /**
     * 查询护理数据
     */
    suspend fun loadData(
        pageId: Int
    ): DemoReqData {
        return netWork.getData(pageId)
    }
}