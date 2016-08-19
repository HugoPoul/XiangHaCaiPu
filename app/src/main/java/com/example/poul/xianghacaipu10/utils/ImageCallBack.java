package com.example.poul.xianghacaipu10.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.widget.ImageView;

import com.example.poul.xianghacaipu10.model.HAModel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by poul on 2016/8/18.
 */
public class ImageCallBack implements HAModel.Qiao {

    private ImageView imageView;

    public ImageCallBack(ImageView imageView) {
        this.imageView = imageView;
    }

    @Override
    public void qiao(byte[] bytes, String path) {
        if(bytes == null){
            return;
        }
        Bitmap bitmap = null;
        String img = (String) imageView.getTag();
        File directory = Environment.getExternalStorageDirectory();
        String imgName = img.replace("/","");
        File file = new File(directory, imgName + ".jpg");
        if (img != null && img.equals(path)) {
            bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(bytes,0,bytes.length);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                bitmap = BitmapFactory.decodeStream(fileInputStream);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        imageView.setImageBitmap(bitmap);
    }
}
