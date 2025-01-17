import Lecture1_adt.*; // Import all classes from Lecture1_adt package to be used in this client code
import Lecture4_interfaces_abstract_classes.*;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void testTransaction1() {
        try {
            Calendar d1 = new GregorianCalendar();
            Lecture1_adt.Transaction1 t1 = new Lecture1_adt.Transaction1(1000, d1);

            System.out.println(t1.toString());
            System.out.println("Lecture1_adt.TransactionInterface Amount: \t " + t1.amount);
            System.out.println("Lecture1_adt.TransactionInterface Date: \t " + t1.date);
        } catch (Exception e) {
            System.err.println("Error in testTransaction1: " + e.getMessage());
        }
    }

    public static Transaction2 makeNextPayment(Transaction2 t) {
        try {
            if (t == null) {
                throw new NullPointerException("Transaction2 object cannot be null.");
            }
            Calendar d = t.getDate();
            d.add(Calendar.MONTH, 1);
            return new Transaction2(t.getAmount(), d);
        } catch (NullPointerException e) {
            System.err.println("Error in makeNextPayment: " + e.getMessage());
            return null; // or handle as appropriate
        }
    }

    public static void testTransaction2() {
        try {
            Calendar d1 = new GregorianCalendar();
            Lecture1_adt.Transaction2 t = new Lecture1_adt.Transaction2(1000, d1);
            Lecture1_adt.Transaction2 modified_t = makeNextPayment(t);

            System.out.println("\n\nState of the Object T1 After Client Code Tried to Change the Amount");
            System.out.println("Lecture1_adt.TransactionInterface Amount: \t " + modified_t.getAmount());
            System.out.println("Lecture1_adt.TransactionInterface Date: \t " + modified_t.getDate().getTime());
        } catch (Exception e) {
            System.err.println("Error in testTransaction2: " + e.getMessage());
        }
    }

    public static List<Transaction3> makeYearOfPayments(int amount) {
        try {
            List<Transaction3> listOfTransaction3s = new ArrayList<>();
            Calendar date = new GregorianCalendar(2024, Calendar.JANUARY, 3);
            for (int i = 0; i < 12; i++) {
                listOfTransaction3s.add(new Transaction3(amount, date));
                date.add(Calendar.MONTH, 1);
            }
            return listOfTransaction3s;
        } catch (NullPointerException e) {
            System.err.println("Error in makeYearOfPayments: " + e.getMessage());
            return new ArrayList<>(); // Return an empty list on error
        }
    }

    public static void testTransaction3() {
        try {
            List<Transaction3> allPaymentsIn2024 = makeYearOfPayments(1000);
            for (Transaction3 t3 : allPaymentsIn2024) {
                System.out.println("\n\n  ::::::::::::::::::::::::::::::::::::::::::::\n");
                System.out.println("Lecture1_adt.TransactionInterface Amount: \t " + t3.getAmount());
                System.out.println("Lecture1_adt.TransactionInterface Date: \t " + t3.getDate().getTime());
            }
        } catch (Exception e) {
            System.err.println("Error in testTransaction3: " + e.getMessage());
        }
    }

    public static List<Transaction4> makeYearOfPaymentsFinal(int amount) {
        try {
            List<Transaction4> listOfTransaction4s = new ArrayList<>();
            Calendar date = new GregorianCalendar(2024, Calendar.JANUARY, 3);
            for (int i = 0; i < 12; i++) {
                listOfTransaction4s.add(new Transaction4(amount, date));
                date.add(Calendar.MONTH, 1);
            }
            return listOfTransaction4s;
        } catch (NullPointerException e) {
            System.err.println("Error in makeYearOfPaymentsFinal: " + e.getMessage());
            return new ArrayList<>(); // Return an empty list on error
        }
    }

    public static void testTransaction4() {
        try {
            List<Transaction4> transactionsIn2024 = makeYearOfPaymentsFinal(1200);
            for (Transaction4 transact : transactionsIn2024) {
                System.out.println("\n\n  ::::::::::::::::::::::::::::::::::::::::::::\n");
                System.out.println("Lecture1_adt.TransactionInterface Amount: \t " + transact.getAmount());
                System.out.println("Lecture1_adt.TransactionInterface Date: \t " + transact.getDate().getTime());
            }
        } catch (Exception e) {
            System.err.println("Error in testTransaction4: " + e.getMessage());
        }
    }

    public static void testWithdrawalAndReversal() {
        try {
            BankAccount bankAccount = new BankAccount(5000);
            bankAccount.printBalance();

            Calendar d1 = new GregorianCalendar();
            WithdrawalTransaction standardWithdrawal = new WithdrawalTransaction(1000, d1);
            standardWithdrawal.apply(bankAccount, "Standard Withdrawal");
            System.out.println("\nAfter Standard Withdrawal:");
            bankAccount.printBalance();

            WithdrawalTransaction atmWithdrawal = new WithdrawalTransaction(500, d1);
            atmWithdrawal.apply(bankAccount, "ATM Withdrawal");
            System.out.println("\nAfter ATM Withdrawal:");
            bankAccount.printBalance();

            WithdrawalTransaction onlineWithdrawal = new WithdrawalTransaction(200, d1);
            onlineWithdrawal.apply(bankAccount, "Online Withdrawal");
            System.out.println("\nAfter Online Withdrawal:");
            bankAccount.printBalance();

            ReversalTransaction reversal = standardWithdrawal.reverse(bankAccount);
            bankAccount.applyTransaction(reversal);
            System.out.println("\nAfter Reversal:");
            bankAccount.printBalance();
        } catch (Exception e) {
            System.err.println("Error in testWithdrawalAndReversal: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Uncomment the following lines to test the class which you would like to test

        // testTransaction1();
        // testTransaction2();
        // testTransaction3();
        // testTransaction4();
        testWithdrawalAndReversal();
    }
}