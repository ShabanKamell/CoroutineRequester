package com.coroutinerequester.app.presentation.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T>(viewGroup: ViewGroup, @LayoutRes layoutRes: Int)
    : RecyclerView.ViewHolder(LayoutInflater.from(viewGroup.context).inflate(layoutRes, viewGroup, false)) {

    var item: T? = null

    abstract fun bindView(item: T)


}
