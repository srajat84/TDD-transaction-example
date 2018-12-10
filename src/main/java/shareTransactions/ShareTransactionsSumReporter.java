package shareTransactions;

import java.util.LinkedList;
import java.util.List;

public class ShareTransactionsSumReporter {

    public int report(List<ShareTransactions> shareTransactions) {
        return new ShareTransactionFilter(shareTransactions)
                .filterTransfersOnDateNameAndNoOfShares()
                .stream()
                .mapToInt(ShareTransactions::getNumberOfShares)
                .sum();
    }

    public static void main(String[] args) {
        List<ShareTransactions> shareTransactions = new LinkedList<>();
        shareTransactions.add(new ShareTransactions("Alex", "Bob",
                TransactionType.Transfer, "01/04/2018", 1000));
        shareTransactions.add(new ShareTransactions("Alex", "Bob",
                TransactionType.Transfer, "01/06/2018", 5000));

        int sumOfShares = new ShareTransactionsSumReporter().report(shareTransactions);

        System.out.println("Sum of shares transferred in financial year = "+sumOfShares);
    }
}
