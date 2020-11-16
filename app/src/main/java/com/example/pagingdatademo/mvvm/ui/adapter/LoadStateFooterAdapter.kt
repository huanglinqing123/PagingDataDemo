package com.example.pagingdatademo.mvvm.ui.adapter

import android.util.Log
import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter

/**
 * @author huanglinqing
 * @project PagingDataDemo
 * @date 2020/11/14
 * @desc 底部布局
 */
class LoadStateFooterAdapter(private val retry: () -> Unit) :
    LoadStateAdapter<LoadStateViewHolder>() {

    override fun onBindViewHolder(holder: LoadStateViewHolder, loadState: LoadState) {
        Log.d("MainActivity", "---去绑定 onBindViewHolder")
        holder.bindState(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadStateViewHolder {
        return LoadStateViewHolder(parent, retry)
    }

}