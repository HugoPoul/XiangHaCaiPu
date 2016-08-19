package com.example.poul.xianghacaipu10.presentr;

import com.example.poul.xianghacaipu10.bean.Bean;
import com.example.poul.xianghacaipu10.bean.LearnCookBean;
import com.example.poul.xianghacaipu10.model.HAModel;
import com.example.poul.xianghacaipu10.model.XiangHaModel;
import com.example.poul.xianghacaipu10.haview.haactivie.HAView;
import com.google.gson.Gson;

/**
 * Created by poul on 2016/8/18.
 */
public class XiangHaPresenter {
    private HAView haView;
    private HAModel haModel;

    public XiangHaPresenter(HAView haView) {
        this.haView = haView;
        haModel = new XiangHaModel();
    }

    public void laod(String path, final Class clas){
        haModel.getData(new HAModel.Qiao() {
            @Override
            public void qiao(byte[] bytes,String path) {
                String json = new String(bytes);
                Bean bean = (Bean) new Gson().fromJson(json,clas);
                haView.show(bean);
            }
        },path);
    }
}
