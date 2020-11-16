package com.example.pagingdatademo

import androidx.paging.PagingSource
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pagingdatademo.http.reqdata.DemoReqData

/**
 * @author huanglinqing
 * @project PagingDataDemo
 * @date 2020/11/14
 * @desc 实例数据dao
 */
interface DemoDataDao {

    /**
     * 插入数据
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(users: List<DemoReqData>)

    /**
     * 查询作者名为 query的数据
     */
    @Query("SELECT * FROM databean WHERE author LIKE :query")
    fun pagingSource(query: String): PagingSource<Int, DemoReqData.DataBean.DatasBean>

    /**
     * 清除全部
     */
    @Query("DELETE FROM databean")
    suspend fun clearAll()
}