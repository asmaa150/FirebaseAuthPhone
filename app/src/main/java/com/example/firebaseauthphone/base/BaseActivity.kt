package com.example.firebaseauthphone.base

import android.content.DialogInterface
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.snapshots.Snapshot.Companion.observe
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding


open abstract class BaseActivity<DB:ViewDataBinding,VM:BaseViewModel<*>>:AppCompatActivity() {
    lateinit var viewmodel:VM;
    lateinit var viewdatabinding:DB;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewdatabinding= DataBindingUtil.setContentView(this,getlayout())
        viewmodel=initviewmodel();
        viewmodel.messageLiveData?.observe(this,{
            showDialog(message = it, poaActionName = "OK", iscancelable = false)
        })

    }

    fun showDialog(message:String,poaActionName:String?=null,
                   posAction:DialogInterface.OnClickListener?=null,negActioName:String?=null,
                   negAction:DialogInterface.OnClickListener?=null,iscancelable:Boolean){
        val dialog=AlertDialog.Builder(this)
        dialog.setMessage(message)
        dialog.setPositiveButton(poaActionName,posAction)
        dialog.setNegativeButton(negActioName,negAction)
        dialog.setCancelable(iscancelable)
    }

    abstract fun initviewmodel():VM
    abstract fun getlayout():Int

}
