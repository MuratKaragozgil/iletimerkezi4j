package com.iletimerkezi4j.request;

import com.iletimerkezi4j.request.model.AuthenticationModel;
import com.iletimerkezi4j.request.model.IletiMerkeziRequest;
import com.iletimerkezi4j.request.model.OrderModel;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class SendSmsRequest extends IletiMerkeziRequest {

    private AuthenticationModel authentication;
    private OrderModel order;

}
