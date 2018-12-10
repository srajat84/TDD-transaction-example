package shareTransactions;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;

public class ShareTransactionFilter {

    private List<ShareTransactions> shareTransactions;

    public ShareTransactionFilter(List<ShareTransactions> shareTransactions) {
        this.shareTransactions = shareTransactions;
    }

    public List<ShareTransactions> filterTransfersOnDateNameAndNoOfShares() {
        return shareTransactions.stream().filter((txn) ->
                txn.getFirstParty().matches("A.*") &&
                txn.getSecondParty().matches("B.*") &&
                doDatesFallUnderTheCurrentFinancialYear(txn) &&
                txn.getNumberOfShares() >= 1000)
          .collect(Collectors.toList());
    }

    private boolean doDatesFallUnderTheCurrentFinancialYear(ShareTransactions txn) {
        LocalDate now = LocalDate.now();
        Month month = now.getMonth();
        int year = now.getYear();

        LocalDate financialYearStartDate = month.getValue() >= 4 ?
                now.withDayOfMonth(1).withMonth(4) :
                now.withDayOfMonth(1).withMonth(4).withYear(year - 1);

        LocalDate financialYearEndDate = month.getValue() >= 4 ?
                now.withMonth(3).withDayOfMonth(31).withYear(year + 1):
                now.withMonth(3).withDayOfMonth(31);

        return (txn.getDateOfTransaction().isAfter(financialYearStartDate)) &&
                (txn.getDateOfTransaction().isBefore(financialYearEndDate));
    }

}
