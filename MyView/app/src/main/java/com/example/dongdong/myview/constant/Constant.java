package com.example.dongdong.myview.constant;

/**
 * Created by Administrator on 2017/7/31.
 */

public interface Constant {

    String BASEURL = "https://appsales-uat.tsjinrong.cn/";

    //发送验证码
    String sendVerifyCode = "appsales-entry/login/sendVerifyCode";

    //登陆
    String checkVerifyCode = "appsales-entry/login/checkVerifyCode";

    //根据身份证和姓名查询进件状态
    String registApply = "appsales-entry/applyInfo/registApply";

    //根据userCode查询用户基本信息
    String findUserBaseInfoByCode = "appsales-entry/applyInfo/findUserBaseInfoByCode";

    //根据userCode查询用户认证进度
    String findScheduleByCode = "appsales-entry/applyInfo/findScheduleByCode";

    // 根据用户状态查询客户
    String findApplyInfoByStatus = "appsales-entry/applyInfo/findApplyInfoByStatus";

    //APK更新
    String apkUpdate = "appsales-entry/apk/apkUpdate";

    //上传apk
    String apkInfo = "appsales-entry/appcredit-admin/apk/apkInfo";

}
