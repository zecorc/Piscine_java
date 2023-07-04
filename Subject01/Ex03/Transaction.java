import java.util.UUID;

public class Transaction {
    private UUID identifier;
    private User recipient;
    private User sender;
    private String transferCategory;
    private double transferAmount;

    public Transaction(User recipient, User sender, String transferCategory, double transferAmount) {
        this.identifier = UUID.randomUUID();
        this.recipient = recipient;
        this.sender = sender;
        setTransferAmount(transferAmount);
        this.transferCategory = transferCategory;
        sender.setBalance(sender.getBalance() - transferAmount);
        recipient.setBalance(recipient.getBalance() + transferAmount);
    }

    public UUID getIdentifier() {
        return identifier;
    }

    public User getRecipient() {
        return recipient;
    }

    public User getSender() {
        return sender;
    }

    public String getTransferCategory() {
        return transferCategory;
    }

    public double getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(double transferAmount) {
        if (transferAmount < 0 || transferAmount > sender.getBalance()) {
            System.out.println("Error: Insufficient balance for the transaction.");
        } else {
            this.transferAmount = transferAmount;
        }
    }

    @Override
    public String toString() {
        return "Transaction [identifier=" + identifier + ", recipient=" + recipient + ", sender=" + sender
                + ", transferCategory=" + transferCategory + ", transferAmount=" + transferAmount + "]";
    }
}
