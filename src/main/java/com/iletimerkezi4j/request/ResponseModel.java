package com.iletimerkezi4j.request;

import com.iletimerkezi4j.request.model.OrderResponseModel;
import com.iletimerkezi4j.request.model.StatusModel;
import lombok.Data;

@Data
public class ResponseModel {

    private StatusModel status;
    private OrderResponseModel order;

}
