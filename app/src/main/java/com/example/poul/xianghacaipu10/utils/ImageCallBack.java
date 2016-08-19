package com.example.poul.xianghacaipu10.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import com.example.poul.xianghacaipu10.model.HAModel;

/**
 * Created by poul on 2016/8/18.
 */
public class ImageCallBack implements HAModel.Qiao{

    private ImageView imageView;

    public ImageCallBack(ImageView imageView) {
        this.imageView = imageView;
    }

    @Override
    public void qiao(byte[] bytes,String path) {
        String img = (String) imageView.getTag();
        if(img != null && img.equals(path)){
            Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
            imageView.setImageBitmap(bitmap);
        }

    }
}
