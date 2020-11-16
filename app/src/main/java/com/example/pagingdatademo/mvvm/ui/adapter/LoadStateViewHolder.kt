package com.example.pagingdatademo.mvvm.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import com.example.pagingdatademo.R
import com.example.pagingdatademo.databinding.ItemLoadstateBinding

/**
 * @author huanglinqing
 * @project PagingDataDemo
 * @date 2020/11/14
 * @desc 尾部adapter
 */
class LoadStateViewHolder(parent: ViewGroup, var retry: () -> Unit) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context)
        .inflate(R.layout.item_loadstate, parent, false)
) {

    var itemLoadStateBindingUtil: ItemLoadstateBinding = ItemLoadstateBinding.bind(itemView)

    fun bindState(loadState: LoadState) {
        when (loadState) {
            is LoadState.Error -> {
                itemLoadStateBindingUtil.btnRetry.visibility = View.VISIBLE
                itemLoadStateBindingUtil.btnRetry.setOnClickListener {
                    retry()
                }
                Log.d("MainActivity", "error了吧")
            }
            is LoadState.Loading -> {
                itemLoadStateBindingUtil.llLoading.visibility = View.VISIBLE
            }
            else -> {
                Log.d("MainActivity", "--其他的错误")
            }
        }

    }

}