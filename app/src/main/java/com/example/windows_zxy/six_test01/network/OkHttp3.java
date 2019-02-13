package com.example.windows_zxy.six_test01.network;

import android.os.Handler;
import android.util.Log;

import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttp3 {
    private static OkHttp3 okHttp3;
    private Handler handler = new Handler();
    private Interceptor getInterceptor(){
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Log.i("OkHttp3", "intercept: 拦截前");
                Response response = chain.proceed(request);
                Log.i("OkHttp3", "intercept: 拦截后");
                return response;
            }
        };
        return interceptor;
    };
    private static OkHttp3 Instance(){
        if(okHttp3==null){
            synchronized (OkHttp3.class){
                if (okHttp3==null){
                    okHttp3 = new OkHttp3();
                }
            }
        }
        return okHttp3;
    }
    public void getData(String url, final GetDataCall getDataCall){
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(getInterceptor()).build();
        Request request = new Request.Builder().url(url).get().build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                getDataCall.getDataFalse(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        getDataCall.getDataTrue(string);
                    }
                });
            }
        });
    }
    public interface GetDataCall{
        public void getDataTrue(String data);
        public void getDataFalse(IOException e);
    }
}
