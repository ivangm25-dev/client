package com.example.wimg.service;

import com.example.wimg.entity.dto.MessageDTO;
import com.example.wimg.entity.dto.RequestLoanDTO;
import com.example.wimg.entity.dto.ResponseLoanDTO;
import com.example.wimg.entity.repository.ClientEntity;
import com.example.wimg.entity.repository.LoanEntity;
import com.example.wimg.exception.GenericException;
import com.example.wimg.repository.ClientRepository;
import com.example.wimg.repository.LoanRepository;
import com.example.wimg.utils.BuilderUtil;
import com.example.wimg.utils.LoanUtil;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanServiceImpl implements LoanService{

    private static final Logger logger =
            LoggerFactory.getLogger(LoanServiceImpl.class);
    @Autowired
    private LoanRepository loanRepository;
    @Autowired
    private BuilderUtil<LoanEntity> loanEntityBuilder;
    @Autowired
    private BuilderUtil<ResponseLoanDTO> loanDTOBuilder;
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public ResponseLoanDTO createLoan(RequestLoanDTO requestLoanDTO) {
        try {
            LoanEntity loanEntity = loanEntityBuilder.objectBuilder(requestLoanDTO);
            loanEntity.setClientInfo(
                    clientRepository.getClient(
                            requestLoanDTO.clientId()));
            loanEntity.setInterestRate(
                    LoanUtil.getInterestRate(
                            loanEntity.getClientInfo().getCustomerType()));
            loanEntity.setFinalPayment(
                    LoanUtil.calculateFinalPayment(
                            loanEntity.getAmount(),
                            loanEntity.getClientInfo().getCustomerType()));
            loanRepository.insert(loanEntity);
            return loanDTOBuilder.objectBuilder(loanEntity);
        } catch (Exception e){
            throw new GenericException(e.getMessage());
        }
    }

    @Override
    public List<ResponseLoanDTO> getAllLoans() {
        try{
            return loanDTOBuilder.objectListBuilder(loanRepository.findAll());
        } catch (Exception e){
            throw new GenericException("Error: " + e.getMessage());
        }
    }

    @Override
    public ResponseLoanDTO updateLoan(RequestLoanDTO requestLoanDTO) {
        try{
            LoanEntity currentEntity = loanRepository.findById(requestLoanDTO.id()).get();
            BeanUtils.copyProperties(requestLoanDTO, currentEntity);
            ClientEntity clientInfo = null;
            boolean existClient = true;
            try
            {
                clientInfo = clientRepository.getClient(requestLoanDTO.clientId());

            } catch (Exception e){
                logger.warn("Client Not Found.");
                existClient = false;
            }
            if (existClient){
                currentEntity.setInterestRate(
                        LoanUtil.getInterestRate(clientInfo.getCustomerType()));
                currentEntity.setFinalPayment(
                        LoanUtil.calculateFinalPayment(
                                requestLoanDTO.amount(),
                                clientInfo.getCustomerType()));
                currentEntity.setClientInfo(clientInfo);
            }else {
                currentEntity.setInterestRate(
                        LoanUtil.getInterestRate(
                                currentEntity.getClientInfo().getCustomerType()));
                currentEntity.setFinalPayment(
                        LoanUtil.calculateFinalPayment(
                                requestLoanDTO.amount(),
                                currentEntity.getClientInfo().getCustomerType()));
            }
            loanRepository.save(currentEntity);
            return loanDTOBuilder.objectBuilder(currentEntity);
        } catch (Exception e){
            throw new GenericException("Error: " + e.getMessage());
        }
    }

    @Override
    public MessageDTO deleteLoan(String loanId) {
        try{
            loanRepository.deleteById(loanId);
            return new MessageDTO("Delete loan with id: " + loanId);
        } catch (Exception e){
            throw new GenericException("Error: " + e.getMessage());
        }
    }
}
