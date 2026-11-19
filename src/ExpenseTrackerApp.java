import java.util.ArrayList;
import java.util.Scanner;

public class ExpenseTrackerApp{
    static ArrayList<Expense> expense=new ArrayList<>();
    static Wallet wallet;
    static int newexpenseid = 1;
void main() {
    Scanner in = new Scanner(System.in);
    System.out.println("Welcome to Expense Tracking APP");
    System.out.println("Enter Starting Balance");
    double startingbalance = Double.parseDouble(in.nextLine());
    wallet = new Wallet(startingbalance);
    System.out.println("Starting Balance" + wallet.getBalance());

    boolean isRunning = true;
    while (isRunning) {
        System.out.println("\n--- Main Menu ---");
        System.out.println("1. Add Expense");
        System.out.println("2. Update Expense");
        System.out.println("3. Delete Expense");
        System.out.println("4. View All Expenses");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");

        String choice = in.nextLine();

        switch (choice) {
            case "1":
                System.out.print("Enter expense amount: ");
                double amount = Double.parseDouble(in.nextLine());
                if (wallet.getBalance() >= amount) {
                System.out.print("Enter expense description: ");
                String desc = in.nextLine();
                System.out.print("Enter expense category (e.g., Food, Bills): ");
                String category = in.nextLine();
                Expense newexpense = new Expense(desc, newexpenseid, amount, category);
                expense.add(newexpense);
                System.out.println("Processing");
                wallet.deduction(amount);
                newexpenseid++;
                System.out.println("Expense Added Succesfull");
                    System.out.println("Your Current Balance"+wallet.getBalance());}

                break;
            case "2":
                System.out.println("Enter Id of expense to be upgraded");
                int updateid = Integer.parseInt(in.nextLine());
                boolean foundForUpdate = false;
                for (Expense e : expense) {
                    if (e.getId() == updateid) {
                        System.out.print("Enter new expense description: ");
                        e.setDescription(in.nextLine());
                        System.out.println("Enter new category");
                        e.setCategory(in.nextLine());
                        System.out.println("Enter new amount");
                        double newamount = Double.parseDouble(in.nextLine());
                        wallet.setBalance(wallet.getBalance() + e.getAmount());
                        e.setAmount(newamount);
                        wallet.deduction(newamount);
                        foundForUpdate = true;
                        break;
                    }
                }
                if (!foundForUpdate) {
                    System.out.println("Expense ID not found.");
                }
                break;
            case "3":
                System.out.println("Enter id to be removed ");
                int deleteid = Integer.parseInt(in.nextLine());
                foundForUpdate = false;
                for (int i = 0; i < expense.size(); i++) {
                    Expense e = expense.get(i);
                    if (e.getId() == deleteid) {
                        wallet.setBalance(wallet.getBalance() + e.getAmount());
                        expense.remove(i);
                        System.out.println("Succesfully Removed/nNew Balance=" + wallet.getBalance());
                        foundForUpdate = true;
                        break;
                    }
                }
                if (!foundForUpdate) {
                    System.out.println("value not found");
                }
                break;
            case "4":
                System.out.println("\n--- All Expenses ---");
                if (expense.isEmpty()) {
                    System.out.println("No expenses recorded yet.");
                } else {
                    for (Expense e : expense) {
                        System.out.println("ID: " + e.getId() + "\n" +
                                " Category: " + e.getCategory() + "\n" +
                                " Amount: $" + e.getAmount() + "\n" +
                                " Desc: " + e.getDescription());
                    }
                    System.out.println("-----------------------------------");
                    System.out.println("Current Wallet Balance: $" + wallet.getBalance());
                }
                break;
            case "5":
                System.out.println("The end ");
                isRunning = false;
                break;
            default:
                System.out.println("Enter Valid choice please");
        }
    }
    in.close();
}}