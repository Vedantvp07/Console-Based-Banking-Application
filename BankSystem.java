import java.util.*;

class BankAccount {
    private String accountHolderName;
    private int accountNumber;
    private double balance;

    public BankAccount (String accountHolderName, int accountNumber, double balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposite(double amount) {
        if(amount>0) {
            balance += amount;
            System.out.println("Rs " + amount+" deposited to your account");
        } else {
            System.out.println("invalid amount");
        }
    }

    public void Withdraw(double amount) {
        if(amount >0 && amount <= balance) {
            balance -= amount;
            System.out.println("Rs "+ amount + "withdrawn from your account");
        }
        else if(amount> balance){
            System.out.println("Insufficient balance ");
        } else {
            System.out.println("invalid amount");
        }
    }

    public void displayDetails() {
        System.out.println("Account Holder: "+ accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: "+ balance);
    }

    public int getAccountNumber() {
        return accountNumber;
    }
}

public class BankSystem {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<BankAccount> accounts = new ArrayList<>();

    public static void createAccount() {
        System.out.println("Enter Account Holder Name: ");
        sc.nextLine();
        String name = sc.nextLine();

        System.out.println("Enter Account Number: ");
        int accNo = sc.nextInt();

        System.out.println("Enter Initial Balance: ");
        double balance = sc.nextDouble();

       BankAccount acc = new BankAccount(name, accNo, balance);
       accounts.add(acc);
       System.out.println("account created successfully");
    }

    public static BankAccount findAccount(int accNo) {
        for(BankAccount acc : accounts) {
            if(acc.getAccountNumber() == accNo) {
                return acc;
            }
        }
        return null;
    }

    public static void depositMoney() {
        System.out.println("Enter Account Number: ");
        int accNo = sc.nextInt();

        BankAccount acc = findAccount(accNo);
        if(acc!=null) {
            System.out.println("Enter amount to deposit: ");
            double amount = sc.nextDouble();
            acc.deposite(amount);
        } else {
            System.out.println("Account not found");
        }
    }

    public static void withdrawMoney() {
        System.out.println("Enter Account Number: ");
        int accNo = sc.nextInt();

        BankAccount acc = findAccount(accNo);

        if(acc!=null) {
            System.out.println("Enter amount to withdraw: ");
            double amount = sc.nextDouble();
            acc.Withdraw(amount);

        } else {
            System.out.println("Account not found");
        }
    }
    public static void viewDetails() {
        System.out.println("Enter account Number: ");
        int accNo = sc.nextInt();

        BankAccount acc = findAccount(accNo);
        if(acc != null) {
            acc.displayDetails();
        }
        else {
            System.out.println("Account not found");
        }
    }


    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("*Welcome to Account Management System*");
            System.out.println("1 = Create Accuont");
            System.out.println("2 = Deposite Money");
            System.out.println("3 = Withdraw Monkey");
            System.out.println("4 = View Account Details");
            System.out.println("5 = Exit");
            System.out.println("Enter your Choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                createAccount();
                break;
                
                case 2:
                depositMoney();
                break;

                case 3:
                withdrawMoney();
                break;

                case 4:
                viewDetails();
                break;

                case 5:
                System.out.println("Thank you for Banking with us!");
                break;

                default:
                System.out.println("invalid choice");
            }
        } while (choice != 5);
    } 
}




