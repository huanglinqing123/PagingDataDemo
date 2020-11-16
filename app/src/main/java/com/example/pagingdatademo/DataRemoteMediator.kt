package com.example.pagingdatademo

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.example.pagingdatademo.http.reqdata.DemoReqData

/**
 * @author huanglinqing
 * @project PagingDataDemo
 * @date 2020/11/14
 * @desc
 */
@ExperimentalPagingApi
class DataRemoteMediator : RemoteMediator<Int, DemoReqData.DataBean.DatasBean>() {
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, DemoReqData.DataBean.DatasBean>
    ): MediatorResult {
        TODO("Not yet implemented")
    }

}