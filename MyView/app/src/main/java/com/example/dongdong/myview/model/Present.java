package com.example.dongdong.myview.model;

import com.example.dongdong.myview.constant.Constant;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;


/**
 * Created by Administrator on 2017/7/31.
 */

public class Present {


    public Retrofit  getModel(){

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        Request.Builder builder1 = request.newBuilder();
                        Request build = builder1.addHeader("X-SignInfo", "") //验签信息
                                .addHeader("X-Version","1.0")  //App版本号
                                .addHeader("X-OSVersion",android.os.Build.VERSION.SDK) //移动系统的版本号
                                .addHeader("X-Platform","Android")     // 移动平台
                                .addHeader("X-PackageName","com.example.dongdong.myview")  // 应用的包名
                                .addHeader("X-Channel","")//  渠道名称
                                .addHeader("X-Longitude","")//客户目前位置经度
                                .addHeader("X-Latitude","")//位置维度
                                .addHeader("X-Token","")// 登陆或者注册后获取到的token数据
                                .addHeader("X-DeviceModel",android.os.Build.MODEL)// 手机型号
                                .addHeader("X-APIVersion",android.os.Build.VERSION.RELEASE)// API版本号
                                .addHeader("X-Address","")//客户地址
                                .addHeader("X-Timestamp", String.valueOf(System.currentTimeMillis()))// 时间戳
                                .addHeader("X-Build","100")// 内部版本
                                .build();
                        return chain.proceed(build);
                    }
                }).retryOnConnectionFailure(true)
                .build();


        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(Constant.BASEURL)
                .build();

        return retrofit;
    }

}
