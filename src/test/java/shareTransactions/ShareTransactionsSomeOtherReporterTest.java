package shareTransactions;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class ShareTransactionsSomeOtherReporterTest {

    @Test
    public void shouldReturnSumAs2000() throws Exception {
        List<ShareTransactions> shareTransactions = new LinkedList<>();
        shareTransactions.add(new ShareTransactions("Alex", "Bob",
                TransactionType.Transfer, "01/08/2017", 1000));
        shareTransactions.add(new ShareTransactions("Alex", "Bob",
                TransactionType.Transfer, "01/09/2017", 1000));
        shareTransactions.add(new ShareTransactions("Alex", "Bob",
                TransactionType.Transfer, "01/09/2017", 5000));

        int sumOfShares = new ShareTransactionsSomeOtherReporter().report(shareTransactions);

        assertEquals(0, sumOfShares);
    }
}