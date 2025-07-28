package com.example.wimg.service;

import com.example.wimg.entity.dto.MessageDTO;
import com.example.wimg.entity.dto.RequestLoanDTO;
import com.example.wimg.entity.dto.ResponseLoanDTO;
import java.util.List;

public interface LoanService {

    /**
     * Create new loan.
     * @param requestLoanDTO
     * @return ResponseLoanDTO.
     */
    ResponseLoanDTO createLoan(RequestLoanDTO requestLoanDTO);

    /**
     * Get all loans.
     * @return List<ResponseLoanDTO>
     */
    List<ResponseLoanDTO> getAllLoans();

    /**
     * Update Loan.
     * @param requestLoanDTO
     * @return ResponseLoanDTO.
     */
    ResponseLoanDTO updateLoan(RequestLoanDTO requestLoanDTO);

    /**
     * Delete loan by Id.
     * @param loanId
     * @return MessageDTO.
     */
    MessageDTO deleteLoan(String loanId);
}
