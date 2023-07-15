package com.xcode.service;


import com.fasterxml.jackson.databind.util.JSONPObject;
import com.xcode.dto.ResponseResult;
import com.xcode.remote.ServiceVefificationcodeClient;
import com.xcode.responese.NumberCodeResponse;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class VerificationCodeService {

    @Autowired
    private ServiceVefificationcodeClient serviceVefificationcodeClient;



    /**
     * 生成验证码
     * @param passengerPhone 手机号
     * @return
     */
    public String generatorCode(String passengerPhone){
        // 调用验证码服务，获取验证码
        ResponseResult<NumberCodeResponse> numberCodeResponse = serviceVefificationcodeClient.getNumberCode(6);
        int numberCode = numberCodeResponse.getData().getNumberCode();


        System.out.println("remote code"+numberCode);


        // 通过短信服务商，将对应的验证码发送到手机上。阿里短信服务，腾讯短信通，华信，容联

        JSONObject result =new JSONObject();
        result.put("code",1);
        result.put("message","success");

        return result.toString();

    }






}