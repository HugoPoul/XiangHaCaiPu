package com.example.poul.xianghacaipu10.utils;

import android.app.ProgressDialog;
import android.os.AsyncTask;

import com.example.poul.xianghacaipu10.model.HAModel;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by poul on 2016/8/18.
 */
public class HAAsyncTask extends AsyncTask<String, Integer, byte[]> {

    private HAModel.Qiao qiao;
    private String path;
    private ProgressDialog progressDialog;
    private int maxLength;

    public HAAsyncTask(HAModel.Qiao qiao) {
        this.qiao = qiao;
    }

    public HAAsyncTask(HAModel.Qiao qiao, ProgressDialog progressDialog) {
        this.qiao = qiao;
        this.progressDialog = progressDialog;
    }

    @Override
    protected void onPreExecute() {
        if (progressDialog != null) {
            progressDialog.show();
        }
//        super.onPreExecute();
    }

    @Override
    protected byte[] doInBackground(String... strings) {
        path = strings[0];
        try {
            URL url = new URL(path);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(5000);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == httpURLConnection.HTTP_OK) {
                maxLength = httpURLConnection.getContentLength();
                InputStream inputStream = httpURLConnection.getInputStream();
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                int len = 0;
                byte[] b = new byte[1024 * 8];
                while ((len = inputStream.read(b)) != -1) {
                    bos.write(b, 0, len);
                }
                return bos.toByteArray();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        if (progressDialog != null) {
            if (progressDialog.getMax() == 0) {
                progressDialog.setMax(maxLength);
            }
            progressDialog.setProgress(values[0]);
        }
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(byte[] bytes) {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
        if (qiao != null) {
            qiao.qiao(bytes, path);
        }
    }
}
