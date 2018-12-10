package shareTransactions;

import java.util.LinkedList;
import java.util.List;

public class ShareTransactionsSomeOtherReporter {

    public int report(List<ShareTransactions> shareTransactions) {
        List<ShareTransactions> above1000List = new ShareTransactionFilter(shareTransactions)
                .filterTransfersOnDateNameAndNoOfShares();

        shareTransactions.removeAll(above1000List);

        return shareTransactions.stream()
                .mapToInt(ShareTransactions::getNumberOfShares)
                .sum();
    }

    public static void main(String[] args) {
        List<ShareTransactions> shareTransactions = new LinkedList<>();
        shareTransactions.add(new ShareTransactions("Alex", "Bob",
                TransactionType.Transfer, "01/08/2018", 800));
        shareTransactions.add(new ShareTransactions("Alex", "Bob",
                TransactionType.Transfer, "01/09/2018", 1000));
        shareTransactions.add(new ShareTransactions("Alex", "Bob",
                TransactionType.Transfer, "01/09/2018", 5000));

        int sumOfShares = new ShareTransactionsSomeOtherReporter().report(shareTransactions);

        System.out.println("Sum of shares transferred in financial year = "+sumOfShares);
    }
}
