package com.example.wimg.config;

import com.example.wimg.entity.dto.ResponseClientDTO;
import com.example.wimg.entity.dto.ResponseLoanDTO;
import com.example.wimg.entity.repository.ClientEntity;
import com.example.wimg.entity.repository.LoanEntity;
import com.example.wimg.utils.BuilderUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuilderConfiguration {

    @Bean
    public BuilderUtil<ClientEntity> clientEntityBuilder(){
        BuilderUtil<ClientEntity> clientEntityBuilder = new BuilderUtil<>();
        clientEntityBuilder.setClass(ClientEntity.class);
        return clientEntityBuilder;
    }

    @Bean
    public BuilderUtil<ResponseClientDTO> responseClientDTOBuilder(){
        BuilderUtil<ResponseClientDTO> responseClientDTOBuilder = new BuilderUtil<>();
        responseClientDTOBuilder.setClass(ResponseClientDTO.class);
        return responseClientDTOBuilder;
    }

    @Bean
    public BuilderUtil<LoanEntity> loanEntityBuilder(){
        BuilderUtil<LoanEntity> loanEntityBuilder = new BuilderUtil<>();
        loanEntityBuilder.setClass(LoanEntity.class);
        return loanEntityBuilder;
    }

    @Bean
    public BuilderUtil<ResponseLoanDTO> responseLoanDTOBuilder(){
        BuilderUtil<ResponseLoanDTO> responseLoanDTOBuilder = new BuilderUtil<>();
        responseLoanDTOBuilder.setClass(ResponseLoanDTO.class);
        return responseLoanDTOBuilder;
    }

    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }
}
