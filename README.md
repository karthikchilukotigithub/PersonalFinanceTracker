# Personal Finance Tracker

## Overview
The **Personal Finance Tracker** is a Java-based console application designed to help users manage their financial transactions effectively. It offers features for tracking income and expenses, setting budgets, and analyzing financial data to ensure better money management.

---

## Features
1. **Transaction Management**:
   - Add transactions with details such as date, description, amount, and type (Income/Expense).
   - View the complete transaction history.
   - Filter transactions based on type (Income or Expense).
2. **Budget Management**:
   - Set a budget limit.
   - View the budget and track whether expenses exceed the set limit.
3. **Balance Tracking**:
   - View the current balance derived from income and expenses.
4. **Console-Based User Interface**:
   - Easy-to-use interactive menu for navigating through features.

---

## How to Run the Application

### Prerequisites
- **Java Development Kit (JDK)**: Ensure JDK 8 or later is installed.
- **IDE/Text Editor**: Any Java-compatible editor (e.g., IntelliJ IDEA, Eclipse, or VS Code).
- **Git**: (Optional) For version control and GitHub integration.

### Steps
1. **Clone the Repository**:
   ```bash
   git clone <repository_url>
   ```
2. **Open the Project**:
   - Import the project into your preferred IDE.
3. **Compile and Run**:
   - Compile the `PersonalFinanceTracker.java` file.
   - Run the `main()` method.
4. **Interact with the Menu**:
   - Follow the console prompts to add transactions, view balance, set a budget, and more.

---

## Usage Instructions

### Menu Options
1. **Add Transaction**:
   - Input the date, description, amount, and type (Income or Expense) to record a transaction.
2. **View Transactions**:
   - Display a list of all recorded transactions.
3. **View Balance**:
   - Check the current balance based on all transactions.
4. **Set Budget**:
   - Specify a budget limit to track expenses.
5. **View Budget**:
   - View the budget limit and total expenses, with alerts for overspending.
6. **Filter Transactions by Type**:
   - Display only Income or Expense transactions based on user input.
7. **Exit**:
   - Terminate the application.

---

## Example Interaction
### Sample Console Session
```
--- Personal Finance Tracker ---
1. Add Transaction
2. View Transactions
3. View Balance
4. Set Budget
5. View Budget
6. Filter Transactions by Type
7. Exit
Enter your choice: 1
Enter date (YYYY-MM-DD): 2025-01-24
Enter description: Salary
Enter amount: 5000
Enter type (Income/Expense): Income
Transaction added successfully.

Enter your choice: 3
Current Balance: $5000.00
```

---

## File Structure
```
├── src/
│   └── PersonalFinanceTracker.java
├── README.md
└── .gitignore
```

---

## Contributing
Contributions are welcome! Please follow these steps:
1. Fork the repository.
2. Create a new branch: `git checkout -b feature-name`
3. Commit your changes: `git commit -m 'Add feature'`
4. Push the changes: `git push origin feature-name`
5. Submit a pull request.

---
