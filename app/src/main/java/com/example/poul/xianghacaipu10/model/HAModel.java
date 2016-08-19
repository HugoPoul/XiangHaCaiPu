package com.example.poul.xianghacaipu10.model;

/**
 * Created by poul on 2016/8/18.
 */
public interface HAModel {
    void getData(Qiao qiao, String path);
    public interface Qiao{
        void qiao(byte[] bytes,String path);
    }
}
