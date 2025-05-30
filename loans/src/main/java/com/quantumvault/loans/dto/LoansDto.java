package com.quantumvault.loans.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(
        name = "Loans",
        description = "Loans details"
)
public class LoansDto {
    @NotEmpty(message = "Mobile number can not be a null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    @Schema(
            description = "Mobile number of the customer",
            example = "8765342378"
    )
    private String mobileNumber;

    @NotEmpty(message = "Loan number can not be a null or empty")
    @Schema(
            description = "Loan number of the customer",
            example = "1234567890"
    )
    private String loanNumber;

    @NotEmpty(message = "Loan type can not be a null or empty")
    @Schema(
            description = "Loan type of the customer",
            example = "Home Loan"
    )
    private String loanType;

    @NotEmpty(message = "Total loan can not be a null or empty")
    @Schema(
            description = "Total loan of the customer",
            example = "1000000"
    )
    private int totalLoan;

    @NotEmpty(message = "Amount paid can not be a null or empty")
    @Schema(
            description = "Amount paid by the customer",
            example = "500000"
    )
    private int amountPaid;

    @NotEmpty(message = "Outstanding amount can not be a null or empty")
    @Schema(
            description = "Outstanding amount of the customer",
            example = "500000"
    )
    private int outstandingAmount;
}
