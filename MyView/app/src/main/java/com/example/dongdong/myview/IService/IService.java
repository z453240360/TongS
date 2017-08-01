package com.example.dongdong.myview.IService;

import com.example.dongdong.myview.constant.Constant;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Administrator on 2017/7/31.
 */

public interface IService {


    //查询进件状态
    @FormUrlEncoded
    @POST(Constant.registApply)
    Call<ResponseBody> getRegistApply(@Field("userName")String userName,@Field("idCard")String idCard);


    //根据userCode查询用户基本信息
    @FormUrlEncoded
    @POST(Constant.findUserBaseInfoByCode)
    Call<ResponseBody> getFindUserBaseInfoByCode(@Field("userCode")String userCode);



    //根据userCode查询用户认证进度
    @FormUrlEncoded
    @POST(Constant.findScheduleByCode)
    Call<ResponseBody> getFindScheduleByCode(@Field("userName")String userName);


    //根据用户状态查询客户
    @FormUrlEncoded
    @POST(Constant.findApplyInfoByStatus)
    Call<ResponseBody> getFindApplyInfoByStatus(@Field("status")int status);

    //发送验证码
    @FormUrlEncoded
    @POST(Constant.sendVerifyCode)
    Call<ResponseBody> getSendVerifyCode(@Field("phoneNumber")String phoneNumber);


    // 登陆
    @FormUrlEncoded
    @POST(Constant.sendVerifyCode)
    Call<ResponseBody> getCheckVerifyCode(@Field("verifyCode")String verifyCode);
}
