package com.iletimerkezi4j.request.model;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;

@Data
@Builder
public final class OrderModel {

    private final String sender;
    private final ArrayList<String> sendDateTime = new ArrayList<>(0);
//    @Builder.Default
//    private final String iys = "1";
//    @Builder.Default
//    private final String iysList = "BIREYSEL";
    private final MessageModel message;

}
