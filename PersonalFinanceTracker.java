import java.util.*;

class Transaction {
    private String date;
    private String description;
    private double amount;
    private String type;

    public Transaction(String date, String description, double amount, String type) {
        this.date = date;
        this.description = description;
        this.amount = amount;
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "[" + date + "] " + type + ": " + description + " - $" + String.format("%.2f", amount);
    }
}

class Budget {
    private double limit;

    public Budget(double limit) {
        this.limit = limit;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return "Budget Limit: $" + String.format("%.2f", limit);
    }
}

public class PersonalFinanceTracker {

    private List<Transaction> transactions = new ArrayList<>();
    private double balance = 0.0;
    private Budget budget = new Budget(0.0);

    public void addTransaction(String date, String description, double amount, String type) {
        if (type.equalsIgnoreCase("Expense") && amount > balance) {
            System.out.println("Insufficient balance for this transaction.");
            return;
        }

        transactions.add(new Transaction(date, description, amount, type));

        if (type.equalsIgnoreCase("Income")) {
            balance += amount;
        } else if (type.equalsIgnoreCase("Expense")) {
            balance -= amount;
        }

        System.out.println("Transaction added successfully.");
    }

    public void viewTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions recorded.");
        } else {
            System.out.println("Transaction History:");
            for (Transaction transaction : transactions) {
                System.out.println(transaction);
            }
        }
    }

    public void viewBalance() {
        System.out.println("Current Balance: $" + String.format("%.2f", balance));
    }

    public void setBudget(double limit) {
        budget.setLimit(limit);
        System.out.println("Budget limit set to $" + String.format("%.2f", limit));
    }

    public void viewBudget() {
        System.out.println(budget);
        double totalExpenses = transactions.stream()
                                           .filter(t -> t.getType().equalsIgnoreCase("Expense"))
                                           .mapToDouble(Transaction::getAmount)
                                           .sum();
        System.out.println("Total Expenses: $" + String.format("%.2f", totalExpenses));
        if (totalExpenses > budget.getLimit()) {
            System.out.println("Warning: Expenses exceed the budget limit by $" + String.format("%.2f", totalExpenses - budget.getLimit()));
        }
    }

    public void filterTransactionsByType(String type) {
        List<Transaction> filteredTransactions = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (transaction.getType().equalsIgnoreCase(type)) {
                filteredTransactions.add(transaction);
            }
        }

        if (filteredTransactions.isEmpty()) {
            System.out.println("No " + type + " transactions found.");
        } else {
            System.out.println(type + " Transactions:");
            for (Transaction transaction : filteredTransactions) {
                System.out.println(transaction);
            }
        }
    }

    public static void main(String[] args) {
        PersonalFinanceTracker tracker = new PersonalFinanceTracker();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Personal Finance Tracker ---");
            System.out.println("1. Add Transaction");
            System.out.println("2. View Transactions");
            System.out.println("3. View Balance");
            System.out.println("4. Set Budget");
            System.out.println("5. View Budget");
            System.out.println("6. Filter Transactions by Type");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter date (YYYY-MM-DD): ");
                    String date = scanner.nextLine();
                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter type (Income/Expense): ");
                    String type = scanner.nextLine();
                    tracker.addTransaction(date, description, amount, type);
                    break;
                case 2:
                    tracker.viewTransactions();
                    break;
                case 3:
                    tracker.viewBalance();
                    break;
                case 4:
                    System.out.print("Enter budget limit: ");
                    double limit = scanner.nextDouble();
                    scanner.nextLine();
                    tracker.setBudget(limit);
                    break;
                case 5:
                    tracker.viewBudget();
                    break;
                case 6:
                    System.out.print("Enter transaction type to filter (Income/Expense): ");
                    String filterType = scanner.nextLine();
                    tracker.filterTransactionsByType(filterType);
                    break;
                case 7:
                    System.out.println("Exiting Personal Finance Tracker. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 7);

        scanner.close();
    }
}
