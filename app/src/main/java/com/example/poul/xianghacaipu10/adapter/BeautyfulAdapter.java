package com.example.poul.xianghacaipu10.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.poul.xianghacaipu10.R;
import com.example.poul.xianghacaipu10.bean.LearnCookBean;
import com.example.poul.xianghacaipu10.utils.HAAsyncTask;
import com.example.poul.xianghacaipu10.utils.ImageCallBack;

import java.util.List;

/**
 * Created by poul on 2016/8/18.
 */
public class BeautyfulAdapter extends BaseAdapter{

    private List<LearnCookBean.DataBean> list;

    public BeautyfulAdapter(List<LearnCookBean.DataBean> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list == null?0:list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LearnCookBean.DataBean dataBean = list.get(i);
        HolderView holderView = null;
        if(view == null){
            holderView = new HolderView();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.beautiful_life_layout, null);
            holderView.name = (TextView) view.findViewById(R.id.name_id);
            holderView.city = (TextView) view.findViewById(R.id.city_id);
            holderView.title = (TextView) view.findViewById(R.id.title_id);
            holderView.time = (TextView) view.findViewById(R.id.timeshow_id);
            holderView.from = (TextView) view.findViewById(R.id.from_id);
            holderView.talk = (TextView) view.findViewById(R.id.viewcount_id);
            holderView.like = (TextView) view.findViewById(R.id.likecount_id);
            holderView.touXiang = (ImageView)view.findViewById(R.id.tou_xiang_id);
            holderView.img0 = (ImageView)view.findViewById(R.id.imgs0_id);
            holderView.img1 = (ImageView)view.findViewById(R.id.imgs1_id);
            holderView.img2 = (ImageView)view.findViewById(R.id.imgs2_id);

            view.setTag(holderView);
        }
        holderView = (HolderView) view.getTag();
        holderView.name.setText(dataBean.getCustomer().getNickName());
        holderView.city.setText(dataBean.getCity());
        holderView.title.setText(dataBean.getTitle());
        holderView.time.setText(dataBean.getTimeShow());
        holderView.from.setText(dataBean.getCName());
        holderView.talk.setText(dataBean.getCommentNum());
        holderView.like.setText(dataBean.getLikeNum());

        holderView.img0.setTag(dataBean.getImgs().get(0));
        holderView.img1.setTag(dataBean.getImgs().get(1));
        int j = dataBean.getImgs().size()>2?2:1;
        holderView.img2.setTag(dataBean.getImgs().get(j));
        holderView.touXiang.setTag(dataBean.getCustomer().getImg());

        holderView.img0.setImageBitmap(null);
        holderView.img1.setImageBitmap(null);
        holderView.img2.setImageBitmap(null);
        holderView.touXiang.setImageBitmap(null);

        new HAAsyncTask(new ImageCallBack(holderView.img0)).execute(dataBean.getImgs().get(0));
        new HAAsyncTask(new ImageCallBack(holderView.img1)).execute(dataBean.getImgs().get(1));
        new HAAsyncTask(new ImageCallBack(holderView.img2)).execute(dataBean.getImgs().get(j));
        new HAAsyncTask(new ImageCallBack(holderView.touXiang)).execute(dataBean.getCustomer().getImg());

        return view;
    }

    private static class HolderView{
        TextView name,city,title,time,from,like,talk;
        ImageView img0,img1,img2,touXiang;
    }
}
