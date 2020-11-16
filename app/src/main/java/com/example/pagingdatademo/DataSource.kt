package com.example.paging3demo

import android.util.Log
import androidx.paging.PagingSource
import com.example.paging3demo.http.DataRespority
import com.example.pagingdatademo.http.reqdata.DemoReqData
import java.io.IOException
import java.lang.Exception

/**
 * @author huanglinqing
 * @project Paging3Demo
 * @date 2020/11/7
 * @desc 数据源
 */
class DataSource : PagingSource<Int, DemoReqData.DataBean.DatasBean>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, DemoReqData.DataBean.DatasBean> {

        return try {

            //页码未定义置为1
            var currentPage = params.key ?: 1
            //仓库层请求数据
            Log.d("MainActivity", "请求第${currentPage}页")
            var demoReqData = DataRespority().loadData(currentPage)
            //当前页码 小于 总页码 页面加1
            var nextPage = if (currentPage < demoReqData.data?.pageCount ?: 0) {
                currentPage + 1
            } else {
                //没有更多数据
                null
            }

            LoadResult.Page(
                data = demoReqData.data.datas,
                prevKey = null,
                nextKey = nextPage
            )


        } catch (e: Exception) {
            if (e is IOException) {
                Log.d("测试错误数据", "-------连接失败")
            }
            Log.d("测试错误数据", "-------${e.message}")
            LoadResult.Error(throwable = e)
        }

    }

}