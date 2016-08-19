package com.example.poul.xianghacaipu10.model;

import android.app.ProgressDialog;

import com.example.poul.xianghacaipu10.ext.MyApp;
import com.example.poul.xianghacaipu10.utils.HAAsyncTask;

/**
 * Created by poul on 2016/8/18.
 */
public class XiangHaModel implements HAModel {
    @Override
    public void getData(Qiao qiao,String path) {
        ProgressDialog progressDialog = new ProgressDialog(MyApp.context);
        progressDialog.setTitle("加载中......");
        progressDialog.setMessage("页面正在加载中");
        progressDialog.setCancelable(false);
        new HAAsyncTask(qiao).execute(path);
    }
}
