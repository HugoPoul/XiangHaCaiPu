package com.example.poul.xianghacaipu10.utils;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.poul.xianghacaipu10.R;
import com.example.poul.xianghacaipu10.bean.LearnCookHead;

/**
 * Created by poul on 2016/8/13.
 */
public class SetHead {
    private LearnCookHead learnCookHead;
    private View view;

    public SetHead(LearnCookHead learnCookHead, View view) {
        this.learnCookHead = learnCookHead;
        this.view = view;
    }

    public void setMessage(){
        LearnCookHead.DataBean headData = learnCookHead.getData();
        Holder holder = new Holder();

        View touTiao1 = view.findViewById(R.id.toutiao1);
        holder.touTiao1Title = (TextView)touTiao1.findViewById(R.id.head_title);
        holder.touTiao1From = (TextView)touTiao1.findViewById(R.id.head_from);
        holder.touTiao1PingLun = (TextView)touTiao1.findViewById(R.id.head_pinglun);
        holder.touTiao1ViewCount = (TextView)touTiao1.findViewById(R.id.head_viewcount);
        holder.touTiao1Img = (ImageView)touTiao1.findViewById(R.id.head_image);

        View touTiao2 = view.findViewById(R.id.toutiao2);
        holder.touTiao2Title = (TextView)touTiao2.findViewById(R.id.head_title);
        holder.touTiao2From = (TextView)touTiao2.findViewById(R.id.head_from);
        holder.touTiao2PingLun = (TextView)touTiao2.findViewById(R.id.head_pinglun);
        holder.touTiao2ViewCount = (TextView)touTiao2.findViewById(R.id.head_viewcount);
        holder.touTiao2Img = (ImageView)touTiao2.findViewById(R.id.head_image);


        holder.touTiao1Title.setText(headData.getNous().get(0).getTitle());
        holder.touTiao1From.setText(headData.getNous().get(0).getClassifyname());
        holder.touTiao1PingLun.setText(headData.getNous().get(0).getCommentCount());
        holder.touTiao1ViewCount.setText(headData.getNous().get(0).getAllClick());
        //处理图片
        holder.touTiao1Img.setTag(headData.getNous().get(0).getImg());
        holder.touTiao1Img.setImageBitmap(null);
        new HAAsyncTask(new ImageCallBack(holder.touTiao1Img)).execute(headData.getNous().get(0).getImg());

        holder.touTiao2Title.setText(headData.getNous().get(1).getTitle());
        holder.touTiao2From.setText(headData.getNous().get(1).getClassifyname());
        holder.touTiao2PingLun.setText(headData.getNous().get(1).getCommentCount());
        holder.touTiao2ViewCount.setText(headData.getNous().get(1).getAllClick());
        //处理图片
        holder.touTiao2Img.setTag(headData.getNous().get(1).getImg());
        holder.touTiao2Img.setImageBitmap(null);
        new HAAsyncTask(new ImageCallBack(holder.touTiao2Img)).execute(headData.getNous().get(1).getImg());


        View active1 = view.findViewById(R.id.activ1);
        holder.active1Title = (TextView)active1.findViewById(R.id.active_title);
        holder.active1SubTitle = (TextView)active1.findViewById(R.id.active_subtitle);
        holder.active1Bg = (ImageView)active1.findViewById(R.id.active_bg);
        holder.active1Title.setText(headData.getTopic().get(0).getTitle());
        holder.active1SubTitle.setText(headData.getTopic().get(0).getTitle());
        holder.active1Bg.setTag(headData.getTopic().get(0).getImgs());
        holder.active1Bg.setImageBitmap(null);
        new HAAsyncTask(new ImageCallBack(holder.active1Bg)).execute(headData.getTopic().get(0).getImgs());

        View active2 = view.findViewById(R.id.activ2);
        holder.active2Title = (TextView)active2.findViewById(R.id.active_title);
        holder.active2SubTitle = (TextView)active2.findViewById(R.id.active_subtitle);
        holder.active2Bg = (ImageView)active2.findViewById(R.id.active_bg);
        holder.active2Title.setText(headData.getTopic().get(1).getTitle());
        holder.active2SubTitle.setText(headData.getTopic().get(1).getTitle());
        holder.active2Bg.setTag(headData.getTopic().get(1).getImgs());
        holder.active2Bg.setImageBitmap(null);
        new HAAsyncTask(new ImageCallBack(holder.active2Bg)).execute(headData.getTopic().get(1).getImgs());

        View active3 = view.findViewById(R.id.activ3);
        holder.active3Title = (TextView)active3.findViewById(R.id.active_title);
        holder.active3SubTitle = (TextView)active3.findViewById(R.id.active_subtitle);
        holder.active3Bg = (ImageView)active3.findViewById(R.id.active_bg);
        holder.active3Title.setText(headData.getTopic().get(2).getTitle());
        holder.active3SubTitle.setText(headData.getTopic().get(2).getTitle());
        holder.active3Bg.setTag(headData.getTopic().get(2).getImgs());
        holder.active3Bg.setImageBitmap(null);
        new HAAsyncTask(new ImageCallBack(holder.active3Bg)).execute(headData.getTopic().get(2).getImgs());



        for (int i = 0; i < 10; i++) {
            View view2 = LayoutInflater.from(view.getContext()).inflate(R.layout.pai_hang_bang,null);
            TextView name = (TextView)view2.findViewById(R.id.meishijia_name);
            ImageView touXiangImg = (ImageView)view2.findViewById(R.id.meishijia_img);
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.toixianglin);
            name.setText(headData.getActiveUser().get(i).getNickName());
            touXiangImg.setTag(headData.getActiveUser().get(i).getImg());
            touXiangImg.setImageBitmap(null);
            new HAAsyncTask(new ImageCallBack(touXiangImg)).execute(headData.getActiveUser().get(i).getImg());
            linearLayout.addView(view2);

        }


    }

    static class Holder{
        //头条控价
        TextView touTiao1Title,touTiao1From,touTiao1PingLun,touTiao1ViewCount;
        TextView touTiao2Title,touTiao2From,touTiao2PingLun,touTiao2ViewCount;
        ImageView touTiao1Img,touTiao2Img;
        //精选专题控件
        TextView active1Title,active1SubTitle;
        ImageView active1Bg;
        TextView active2Title,active2SubTitle;
        ImageView active2Bg;
        TextView active3Title,active3SubTitle;
        ImageView active3Bg;
    }
}
