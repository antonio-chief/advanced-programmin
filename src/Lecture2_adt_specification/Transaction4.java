package Lecture2_adt_specification;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

/**
 * The Transaction4 class represents a financial transaction with an amount and a date.
 * It is part of the Lecture1_adt package and implements the TransactionInterface.
 * This class provides methods to access the transaction's amount and date while ensuring
 * encapsulation and immutability of its fields.
 * 
 * <p>Design Considerations:
 * - The amount is a positive integer representing the transaction value.
 * - The date is a Calendar object that indicates when the transaction occurred.
 * - Defensive copying is used to protect the internal state of the object.
 * 
 * <p>Specifications:
 * - Requires:
 *   - amount: a non-negative integer.
 *   - date: must not be null and must be a valid Calendar object.
 * 
 * - Produces:
 *   - An instance of Transaction4 that encapsulates the provided amount and date.
 */
public class Transaction4 {
    private final int amount;  // Amount of the transaction (non-negative)
    private final Calendar date; // Date of the transaction (not null)

    /**
     * Constructs a Transaction4 object with the specified amount and date.
     *
     * @param amount the amount of the transaction (must be non-negative)
     * @param date   the date of the transaction (must not be null)
     * @throws IllegalArgumentException if amount is negative or date is null
     */
    public Transaction4(int amount, @NotNull Calendar date) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount must be non-negative.");
        }
        if (date == null) {
            throw new IllegalArgumentException("Date must not be null.");
        }
        this.amount = amount;
        this.date = (Calendar) date.clone(); // Defensive copy to prevent external modifications
    }

    /**
     * Returns the amount of the transaction.
     *
     * @return the amount as an integer
     */
    public int getAmount() {
        return amount; // Returns the transaction amount
    }

    /**
     * Returns the date of the transaction.
     *
     * @return a Calendar object representing the transaction date
     *         (returns a cloned object to ensure the original date is not modified)
     */
    public Calendar getDate() {
        return (Calendar) date.clone(); // Defensive copy to prevent external modifications
    }
}