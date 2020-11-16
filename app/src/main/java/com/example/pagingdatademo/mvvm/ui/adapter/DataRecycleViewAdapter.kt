package com.example.paging3demo.mvvm.ui.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.pagingdatademo.R
import com.example.pagingdatademo.databinding.ItemDataBinding
import com.example.pagingdatademo.http.reqdata.DemoReqData


/**
 * @author huanglinqing
 * @project Paging3Demo
 * @date 2020/11/7
 * @desc
 */
class DataRecycleViewAdapter :
    PagingDataAdapter<DemoReqData.DataBean.DatasBean, RecyclerView.ViewHolder>(object :
        DiffUtil.ItemCallback<DemoReqData.DataBean.DatasBean>() {

        override fun areItemsTheSame(
            oldItem: DemoReqData.DataBean.DatasBean,
            newItem: DemoReqData.DataBean.DatasBean
        ): Boolean {
            return oldItem.id == newItem.id
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(
            oldItem: DemoReqData.DataBean.DatasBean,
            newItem: DemoReqData.DataBean.DatasBean
        ): Boolean {
            return oldItem == newItem
        }
    }) {
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var dataBean = getItem(position)
        Log.d("砂蜜豆玛寺庙的撒","[---------")
        (holder as DataViewHolder).binding.demoReaData = dataBean
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding: ItemDataBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_data,
                parent,
                false
            )
        return DataViewHolder(binding)
    }


    inner class DataViewHolder(private val dataBindingUtil: ItemDataBinding) :
        RecyclerView.ViewHolder(dataBindingUtil.root) {
        var binding = dataBindingUtil
    }


}