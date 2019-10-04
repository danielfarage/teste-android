package com.example.teste_android.presentation.common

import android.app.Dialog
import android.content.Context
import com.example.teste_android.R

object DialogLoading {

    fun createLoading(context: Context): Dialog = Dialog(context).apply {
            setContentView(R.layout.loading_component)
            setCancelable(false)
        }


}