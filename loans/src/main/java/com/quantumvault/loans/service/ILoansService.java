package com.quantumvault.loans.service;

import com.quantumvault.loans.dto.LoansDto;

public interface ILoansService {
    void createLoan(String mobileNumber);

    LoansDto fetchLoan(String mobileNumber);

    boolean deleteLoan(String mobileNumber);

    boolean updateLoan(LoansDto loansDto);
}
