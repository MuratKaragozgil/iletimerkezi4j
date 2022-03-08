package com.iletimerkezi4j.service;

import com.iletimerkezi4j.request.GlobalRequestModel;
import com.iletimerkezi4j.request.GlobalResponseModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface IletiMerkeziSendSmsService {

    @POST("/v1/send-sms/json")
    Call<GlobalResponseModel> sendSms(@Body GlobalRequestModel request);

}
