package com.quantumvault.loans.service.impl;

import com.quantumvault.loans.contants.LoansConstants;
import com.quantumvault.loans.dto.LoansDto;
import com.quantumvault.loans.entity.Loans;
import com.quantumvault.loans.exception.LoanAlreadyExists;
import com.quantumvault.loans.exception.ResourceNotFoundException;
import com.quantumvault.loans.mapper.LoansMapper;
import com.quantumvault.loans.repository.LoansRepository;
import com.quantumvault.loans.service.ILoansService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class iLoansServiceImpl implements ILoansService {
    private LoansRepository loansRepository;

    @Override
    public void createLoan(String mobileNumber) {
        Optional<Loans> loans = loansRepository.findByMobileNumber(mobileNumber);
        if (loans.isPresent()) {
            throw new LoanAlreadyExists("Loan already exists for given mobile number");
        }
        Loans newLoan = createNewLoan(mobileNumber);
        loansRepository.save(newLoan);
    }

    @Override
    public LoansDto fetchLoan(String mobileNumber) {
       Loans loans = loansRepository.findByMobileNumber(mobileNumber).orElseThrow(
               () -> new ResourceNotFoundException("Loan", "mobileNumber", mobileNumber)
       );
        return LoansMapper.MapToLoansDto(loans, new LoansDto());
    }

    @Override
    public boolean deleteLoan(String mobileNumber) {
        Loans loans = loansRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Loan", "mobileNumber", mobileNumber)
        );
        loansRepository.deleteById(loans.getLoanId());
        return true;
    }

    @Override
    public boolean updateLoan(LoansDto loansDto) {
        Loans loans = loansRepository.findByMobileNumber(loansDto.getMobileNumber()).orElseThrow(
                () -> new ResourceNotFoundException("Loan", "mobileNumber", loansDto.getMobileNumber())
        );
        LoansMapper.MapToLoans(loansDto, loans);
        loansRepository.save(loans);
        return true;
    }

    private Loans createNewLoan(String mobileNumber) {
        Loans newLoan = new Loans();
        long randomLoanNumber = 100000000000L + new Random().nextInt(900000000);
        newLoan.setMobileNumber(mobileNumber);
        newLoan.setLoanNumber(Long.toString(randomLoanNumber));
        newLoan.setLoanType(LoansConstants.HOME_LOAN);
        newLoan.setTotalLoan(LoansConstants.NEW_LOAN_LIMIT);
        newLoan.setAmountPaid(0);
        newLoan.setOutstandingAmount(LoansConstants.NEW_LOAN_LIMIT);
        newLoan.setCreatedAt(LocalDateTime.now());
        newLoan.setCreatedBy("Rushikesh");
        return newLoan;
    }
}
