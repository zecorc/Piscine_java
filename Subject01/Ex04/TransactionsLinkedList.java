import java.util.UUID;

public class TransactionsLinkedList implements TransactionsList {
    private TransactionNode head;

    private static class TransactionNode {
        private Transaction transaction;
        private TransactionNode next;

        public TransactionNode(Transaction transaction) {
            this.transaction = transaction;
            this.next = null;
        }
    }

    public void addTransaction(Transaction transaction) {
        TransactionNode newNode = new TransactionNode(transaction);

        if (head == null) {
            head = newNode;
        } else {
            TransactionNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void removeTransaction(UUID transactionId) throws TransactionNotFoundException {
        if (head == null) {
            throw new TransactionNotFoundException("Transaction not found");
        }

        if (head.transaction.getId().toString().equals(transactionId.toString())) {
            head = head.next;
            return;
        }

        TransactionNode prev = head;
        TransactionNode current = head.next;

        while (current != null) {
            if (current.transaction.getId().toString().equals(transactionId)) {
                prev.next = current.next;
                return;
            }

            prev = current;
            current = current.next;
        }

        throw new TransactionNotFoundException("Transaction not found");
    }

    public Transaction[] toArray() {
        int size = countTransactions();
        Transaction[] transactionArray = new Transaction[size];

        TransactionNode current = head;
        int index = 0;

        while (current != null) {
            transactionArray[index++] = current.transaction;
            current = current.next;
        }

        return transactionArray;
    }

    private int countTransactions() {
        int count = 0;
        TransactionNode current = head;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }
}
