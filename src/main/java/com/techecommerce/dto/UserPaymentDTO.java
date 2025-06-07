package com.techecommerce.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UserPaymentDTO {
    @NotNull(message = "User ID is required")
    private Long userId;

    @NotBlank(message = "Payment method is required")
    @Pattern(regexp = "^(CREDIT_CARD|BANK_TRANSFER)$", message = "Invalid payment method")
    private String paymentMethod;

    @NotNull(message = "Is default flag is required")
    private Boolean isDefault;

    @NotNull(message = "Active flag is required")
    private Boolean active;

    // Credit card specific fields
    @Pattern(regexp = "^[0-9]{16}$", message = "Invalid card number", groups = CreditCardValidation.class)
    private String cardNumber;

    @Pattern(regexp = "^(0[1-9]|1[0-2])$", message = "Invalid expiry month", groups = CreditCardValidation.class)
    private String expiryMonth;

    @Pattern(regexp = "^[0-9]{2}$", message = "Invalid expiry year", groups = CreditCardValidation.class)
    private String expiryYear;

    @Pattern(regexp = "^[0-9]{3,4}$", message = "Invalid CVV", groups = CreditCardValidation.class)
    private String cvv;

    @Size(max = 100, message = "Card holder name must not exceed 100 characters", groups = CreditCardValidation.class)
    private String cardHolderName;

    // Bank transfer specific fields
    @Size(max = 100, message = "Bank name must not exceed 100 characters", groups = BankTransferValidation.class)
    private String bankName;

    @Size(max = 50, message = "Account number must not exceed 50 characters", groups = BankTransferValidation.class)
    private String accountNumber;

    @Size(max = 100, message = "Account holder name must not exceed 100 characters", groups = BankTransferValidation.class)
    private String accountHolderName;

    @Size(max = 100, message = "Branch name must not exceed 100 characters", groups = BankTransferValidation.class)
    private String branchName;

    @Size(max = 500, message = "Note must not exceed 500 characters")
    private String note;

    public interface CreditCardValidation {}
    public interface BankTransferValidation {}
} 