package com.example.poul.xianghacaipu10.haview.hafragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.poul.xianghacaipu10.bean.LearnCookHead;
import com.example.poul.xianghacaipu10.haview.haactivie.HAView;
import com.example.poul.xianghacaipu10.R;
import com.example.poul.xianghacaipu10.adapter.BeautyfulAdapter;
import com.example.poul.xianghacaipu10.bean.Bean;
import com.example.poul.xianghacaipu10.bean.LearnCookBean;
import com.example.poul.xianghacaipu10.presentr.XiangHaPresenter;
import com.example.poul.xianghacaipu10.utils.SetHead;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class LearnCook extends Fragment implements HAView {

    private String path = "http://api.xiangha.com/main6/index/getTieList?page=1&pageTime=";
    private String path2 = "http://api.xiangha.com/main6/index/baseData?";
    private ListView listView;
    private View head;

    public LearnCook() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_learn_cook, container, false);
        listView = (ListView)view.findViewById(R.id.fragment_list_id);
        head = inflater.inflate(R.layout.learn_cook_head,null,false);
        listView.addHeaderView(head);
        new XiangHaPresenter(this).laod(path,new LearnCookBean().getClass());
        new XiangHaPresenter(this).laod(path2,new LearnCookHead().getClass());
        return view;
    }

    @Override
    public void show(Bean bean) {
        if(bean instanceof LearnCookBean){
            List<LearnCookBean.DataBean> list = ((LearnCookBean)bean).getData();
            BeautyfulAdapter adapter = new BeautyfulAdapter(list);
            listView.setAdapter(adapter);
        }else if(bean instanceof LearnCookHead){
            LearnCookHead learnCookHead = (LearnCookHead) bean;
            new SetHead(learnCookHead,head).setMessage();
        }

    }
}
