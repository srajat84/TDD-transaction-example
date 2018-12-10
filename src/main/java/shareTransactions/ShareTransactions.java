package shareTransactions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ShareTransactions {
    public static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private String firstParty;
    private String secondParty;
    private TransactionType transactionType;
    private LocalDate dateOfTransaction;
    private int numberOfShares;

    public ShareTransactions(String firstParty, String secondParty, TransactionType transactionType,
                             String dateOfTransaction, int numberOfShares) {
        this.firstParty = firstParty;
        this.secondParty = secondParty;
        this.transactionType = transactionType;
        this.dateOfTransaction = LocalDate.parse(dateOfTransaction, FORMAT);
        this.numberOfShares = numberOfShares;
    }

    public String getFirstParty() {
        return firstParty;
    }

    public void setFirstParty(String firstParty) {
        this.firstParty = firstParty;
    }

    public String getSecondParty() {
        return secondParty;
    }

    public void setSecondParty(String secondParty) {
        this.secondParty = secondParty;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public LocalDate getDateOfTransaction() {
        return dateOfTransaction;
    }

    public void setDateOfTransaction(LocalDate dateOfTransaction) {
        this.dateOfTransaction = dateOfTransaction;
    }

    public int getNumberOfShares() {
        return numberOfShares;
    }

    public void setNumberOfShares(int numberOfShares) {
        this.numberOfShares = numberOfShares;
    }
}
