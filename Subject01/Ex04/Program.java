import java.util.Arrays;
import java.util.UUID;

public class Program {
    public static void main(String[] args) {
        TransactionsService transactionsService = new TransactionsService();

        transactionsService.addUser("user1", 1000.0);
        transactionsService.addUser("user2", 500.0);
        transactionsService.addUser("user3", 750.0);

        try {
            System.out.println("User1 balance: " + transactionsService.getUserBalance("user1"));
            System.out.println("User2 balance: " + transactionsService.getUserBalance("user2"));
            System.out.println("User3 balance: " + transactionsService.getUserBalance("user3"));

            User user1 = transactionsService.getUserByName("user1");
            User user2 = transactionsService.getUserByName("user2");
            User user3 = transactionsService.getUserByName("user3");

            transactionsService.performTransfer(user1.getId(), user2.getId(), 200.0);

            Transaction[] user1Transfers = transactionsService.getUserTransfers(user1.getId());
            System.out.println("User1 transfers: " + Arrays.toString(user1Transfers));

            Transaction[] user2Transfers = transactionsService.getUserTransfers(user2.getId());
            System.out.println("User2 transfers: " + Arrays.toString(user2Transfers));

            Transaction[] user3Transfers = transactionsService.getUserTransfers(user3.getId());
            System.out.println("User3 transfers: " + Arrays.toString(user3Transfers));

            UUID transactionId = user1Transfers[0].getId();
            transactionsService.removeTransaction(user1.getId(), transactionId);
            System.out.println("User1 transfers after removal: " + Arrays.toString(transactionsService.getUserTransfers(user1.getId())));

            Transaction[] unpairedTransactions = transactionsService.getUnpairedTransactions();
            System.out.println("Unpaired transactions: " + Arrays.toString(unpairedTransactions));
        } catch (UserNotFoundException e) {
            System.out.println("User not found: " + e.getMessage());
        } catch (TransactionNotFoundException e) {
            System.out.println("Transaction not found: " + e.getMessage());
        } catch (IllegalTransactionException e) {
            System.out.println("Illegal Transaction: " + e.getMessage());
        }
    }
}
