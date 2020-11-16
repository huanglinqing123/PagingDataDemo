package com.example.paging3demo.mvvm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.paging3demo.DataSource
import kotlinx.coroutines.flow.map

/**
 * @author huanglinqing
 * @project Paging3Demo
 * @date 2020/11/7
 * @desc viewModel 对象
 */
class MainActivityViewModel : ViewModel() {

    /**
     * 获取数据
     */
    fun getData() = Pager(PagingConfig(pageSize = 1)) {
        DataSource()
    }.flow
}