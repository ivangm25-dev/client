package com.example.wimg.mock;

import com.example.wimg.entity.dto.RequestClientDTO;
import com.example.wimg.entity.enums.CustomerType;
import com.example.wimg.entity.repository.ClientEntity;
import com.example.wimg.utils.BuilderUtil;

public class ClientBuilderMock {

    public static RequestClientDTO createNewClient(CustomerType customerType){
        return new RequestClientDTO("1", "ivan",
                "ivangm2511@test.com", 31, customerType);
    }


}
