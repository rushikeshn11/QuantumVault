package com.quantumvault.loans.mapper;

import com.quantumvault.loans.dto.LoansDto;
import com.quantumvault.loans.entity.Loans;

public class LoansMapper {
    public static Loans MapToLoans(LoansDto loansDto, Loans loans) {
        loans.setMobileNumber(loansDto.getMobileNumber());
        loans.setLoanNumber(loansDto.getLoanNumber());
        loans.setLoanType(loansDto.getLoanType());
        loans.setTotalLoan(loansDto.getTotalLoan());
        loans.setAmountPaid(loansDto.getAmountPaid());
        loans.setOutstandingAmount(loansDto.getOutstandingAmount());
        return loans;
    }
    public static LoansDto MapToLoansDto(Loans loans, LoansDto loansDto) {
        loansDto.setMobileNumber(loans.getMobileNumber());
        loansDto.setLoanNumber(loans.getLoanNumber());
        loansDto.setLoanType(loans.getLoanType());
        loansDto.setTotalLoan(loans.getTotalLoan());
        loansDto.setAmountPaid(loans.getAmountPaid());
        loansDto.setOutstandingAmount(loans.getOutstandingAmount());
        return loansDto;
    }
}
