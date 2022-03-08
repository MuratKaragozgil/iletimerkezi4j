package com.iletimerkezi4j.request;

import com.iletimerkezi4j.request.model.IletiMerkeziRequest;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GlobalRequestModel {

    private IletiMerkeziRequest request;

    public GlobalRequestModel(IletiMerkeziRequest request) {
        this.request = request;
    }

}
