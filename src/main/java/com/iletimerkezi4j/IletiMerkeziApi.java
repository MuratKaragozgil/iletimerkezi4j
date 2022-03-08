package com.iletimerkezi4j;

import com.google.common.collect.Sets;
import com.iletimerkezi4j.request.GlobalRequestModel;
import com.iletimerkezi4j.request.GlobalResponseModel;
import com.iletimerkezi4j.request.SendSmsRequest;
import com.iletimerkezi4j.request.model.AuthenticationModel;
import com.iletimerkezi4j.request.model.MessageModel;
import com.iletimerkezi4j.request.model.OrderModel;
import com.iletimerkezi4j.request.model.ReceipentsModel;
import com.iletimerkezi4j.service.IletiMerkeziSendSmsService;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.logging.Logger;

public class IletiMerkeziApi {

    private final static Logger logger = Logger.getLogger(IletiMerkeziApi.class.getName());

    private final IletiMerkeziSendSmsService sendSmsService;

    private final AuthenticationModel authentication;

    public IletiMerkeziApi(String host, String key, String hash) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(host).addConverterFactory(GsonConverterFactory.create()).build();
        authentication = new AuthenticationModel(key, hash);
        sendSmsService = retrofit.create(IletiMerkeziSendSmsService.class);
    }

    public Call<GlobalResponseModel> sendSingleSms(String gsmNumber, String messageText) {
        OrderModel orderModel = OrderModel.builder().sender("APITEST").message(new MessageModel(messageText, new ReceipentsModel(Sets.newHashSet(gsmNumber)))).build();
        SendSmsRequest request = SendSmsRequest.builder().authentication(authentication).order(orderModel).build();
        logger.info(request.toString());
        return sendSmsService.sendSms(new GlobalRequestModel(request));
    }

    public Response<GlobalResponseModel> sendSms(SendSmsRequest request) throws IOException {
        return sendSmsService.sendSms(new GlobalRequestModel(request)).execute();
    }

}
