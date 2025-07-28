package com.example.wimg.controller;

import static com.example.wimg.utils.Constants.PARAM_LOAN_ID;
import static com.example.wimg.utils.Constants.PATH_LOAN_CONTROLLER;

import com.example.wimg.entity.dto.RequestLoanDTO;
import com.example.wimg.service.LoanService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(PATH_LOAN_CONTROLLER)
public class LoanController {
    private static final Logger logger =
            LoggerFactory.getLogger(LoanController.class);
    @Autowired
    private LoanService loanService;

    @PostMapping()
    public ResponseEntity<?> createLoan(@Valid @RequestBody RequestLoanDTO requestLoanDTO){
        logger.info("Create new loan. id: %s, clientId : %s, loanStatus: %s."
                .formatted(requestLoanDTO.id(), requestLoanDTO.clientId(),
                        requestLoanDTO.loanStatus()));
        return new ResponseEntity<>(
                loanService.createLoan(requestLoanDTO), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<?> getAllLoans(){
        logger.info("Get all loans.");
        return new ResponseEntity<>(loanService.getAllLoans(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updateLoan(@Valid @RequestBody RequestLoanDTO requestLoanDTO){
        logger.info("Update loan. id: %s.".formatted(requestLoanDTO.id()));
        return new ResponseEntity<>(loanService.updateLoan(requestLoanDTO), HttpStatus.OK);
    }

    @DeleteMapping(PARAM_LOAN_ID)
    public ResponseEntity<?> deleteLoan(@PathVariable String loanId){
        logger.info("Delete loan. id: %s.".formatted(loanId));
        return ResponseEntity.ok().body(loanService.deleteLoan(loanId));
    }
}
