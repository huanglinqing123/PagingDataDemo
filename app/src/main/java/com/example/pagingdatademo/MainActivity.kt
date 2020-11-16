package com.example.paging3demo

import android.accounts.NetworkErrorException
import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.paging.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.paging3demo.mvvm.ui.adapter.DataRecycleViewAdapter
import com.example.paging3demo.mvvm.viewmodel.MainActivityViewModel
import com.example.pagingdatademo.R
import com.example.pagingdatademo.http.reqdata.DemoReqData
import com.example.pagingdatademo.mvvm.ui.adapter.LoadStateFooterAdapter
import com.example.pagingdatademo.mvvm.ui.adapter.LoadStateViewHolder
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.io.IOException
import java.lang.Exception
import java.net.ConnectException


class MainActivity : AppCompatActivity() {

    var TAG = "MainActivity"
    private var dataRecycleViewAdapter = DataRecycleViewAdapter()

    lateinit var mPagingData: PagingData<DemoReqData.DataBean.DatasBean>

    private val mainActivityViewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val manager = LinearLayoutManager(this)
        rv_data.layoutManager = manager
        rv_data.adapter =
            dataRecycleViewAdapter.withLoadStateFooter(footer = LoadStateFooterAdapter(retry = {
                dataRecycleViewAdapter.retry()
            }))
        btn_get.setOnClickListener {
            Log.d(TAG, "点击了查询按钮")
            lifecycleScope.launch {
                try {
                    mainActivityViewModel.getData().collectLatest {
                        mPagingData = it
                        dataRecycleViewAdapter.submitData(it)
                    }
                } catch (e: Exception) {
                    Log.d("测试错误数据 view层", "---错误了怎么办呢")
                }

            }
        }

        btn_update.setOnClickListener {
        }
        //初始状态添加监听
        dataRecycleViewAdapter.addLoadStateListener {
            when (it.refresh) {

                is LoadState.NotLoading -> {
                    Log.d(TAG, "is NotLoading")
                }
                is LoadState.Loading -> {
                    Log.d(TAG, "is Loading")
                }
                is LoadState.Error -> {
                    Log.d(TAG, "is Error:")
                    when ((it.refresh as LoadState.Error).error) {
                        is IOException -> {
                            Log.d(TAG, "IOException")
                        }
                        else -> {
                            Log.d(TAG, "others exception")
                        }
                    }
                }
            }
        }

    }
}
