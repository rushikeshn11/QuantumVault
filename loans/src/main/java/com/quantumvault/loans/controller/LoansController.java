package com.quantumvault.loans.controller;

import com.quantumvault.loans.contants.LoansConstants;
import com.quantumvault.loans.dto.ErrorResponseDto;
import com.quantumvault.loans.dto.LoansDto;
import com.quantumvault.loans.dto.ResponseDto;
import com.quantumvault.loans.service.ILoansService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@Tag(
        name = "Loans"
)
public class LoansController {

    private ILoansService loansService;

   @PostMapping("/create")
   @Operation(
           summary = "Create Loan REST API",
           description = "Rest API to create new loan inside Quantum Vault"
   )
   @ApiResponses({
           @ApiResponse(
                   responseCode = "201",
                   description = "HTTP Status CREATED"
           ),
           @ApiResponse(
                   responseCode = "500",
                   description = "HTTP Status Internal Server Error",
                   content = @Content(
                           schema = @Schema(implementation = ErrorResponseDto.class)
                   )
           )
   }
   )
   public ResponseEntity<ResponseDto> create(String mobileNumber) {
       loansService.createLoan(mobileNumber);
       return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(LoansConstants.STATUS_201, LoansConstants.MESSAGE_201));
   }

   @GetMapping("/fetch")
   @Operation(
           summary = "Fetch Loan Details REST API",
           description = "REST API to fetch Loan details based on a mobile number"
   )
   @ApiResponses({
           @ApiResponse(
                   responseCode = "200",
                   description = "HTTP Status OK"
           ),
           @ApiResponse(
                   responseCode = "500",
                   description = "HTTP Status Internal Server Error",
                   content = @Content(
                           schema = @Schema(implementation = ErrorResponseDto.class)
                   )
           )
   }
   )
    public ResponseEntity<LoansDto> fetch(String mobileNumber) {
       LoansDto LoansDto = loansService.fetchLoan(mobileNumber);
       return ResponseEntity.status(HttpStatus.OK).body(LoansDto);
   }

   @DeleteMapping("/delete")
   @Operation(
           summary = "Delete Loan REST API",
           description = "REST API to delete Loan details based on a mobile number"
   )
   @ApiResponses({
           @ApiResponse(
                   responseCode = "200",
                   description = "HTTP Status OK"
           ),
           @ApiResponse(
                   responseCode = "417",
                   description = "Expectation Failed"
           ),
           @ApiResponse(
                   responseCode = "500",
                   description = "HTTP Status Internal Server Error",
                   content = @Content(
                           schema = @Schema(implementation = ErrorResponseDto.class)
                   )
           )
   }
   )
   public ResponseEntity<ResponseDto> delete(String mobileNumber) {
       boolean isDeleted = loansService.deleteLoan(mobileNumber);
       if(!isDeleted){
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto(LoansConstants.STATUS_417, LoansConstants.MESSAGE_417_DELETE));
       }else{
           return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(LoansConstants.STATUS_200, LoansConstants.MESSAGE_200));
       }
   }

   @PutMapping("/update")
   @Operation(
           summary = "Update Loan REST API",
           description = "REST API to update Loan details based on a mobile number"
   )
   @ApiResponses({
           @ApiResponse(
                   responseCode = "200",
                   description = "HTTP Status OK"
           ),
           @ApiResponse(
                   responseCode = "417",
                   description = "Expectation Failed"
           ),
           @ApiResponse(
                   responseCode = "500",
                   description = "HTTP Status Internal Server Error",
                   content = @Content(
                           schema = @Schema(implementation = ErrorResponseDto.class)
                   )
           )
   }
   )
   public ResponseEntity<ResponseDto> update(@RequestBody LoansDto loansDto) {
       boolean isUpdated = loansService.updateLoan(loansDto);
       if(!isUpdated){
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto(LoansConstants.STATUS_417, LoansConstants.MESSAGE_417_UPDATE));
       }else{
           return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(LoansConstants.STATUS_200, LoansConstants.MESSAGE_200));
       }
   }

}
