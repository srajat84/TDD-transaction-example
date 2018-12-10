package shareTransactions;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class ShareTransactionsSumReporterTest {

    @Test
    public void shouldReturnSumAs10000() throws Exception {
        List<ShareTransactions> shareTransactions = new LinkedList<>();
        shareTransactions.add(new ShareTransactions("Alex", "Bob",
                TransactionType.Transfer, "01/04/2018", 5000));
        shareTransactions.add(new ShareTransactions("Alex", "Bob",
                TransactionType.Transfer, "31/03/2018", 5000));

        List<ShareTransactions> filteredList = new ShareTransactionFilter(shareTransactions).filterTransfersOnDateNameAndNoOfShares();

        assertEquals(1, filteredList.size());
        assertEquals("01/04/2018", filteredList.get(0).getDateOfTransaction());
    }
}