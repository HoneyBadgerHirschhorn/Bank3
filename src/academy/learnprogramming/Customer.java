package academy.learnprogramming;


import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Customer extends Bank{
    private  String name;
    private double balance;
    private  ArrayList<Double> transactions = new ArrayList<Double>(0);


    public Customer(){
    }

    public Customer(String name, ArrayList<Double> list){
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setName() {
        Scanner nameScan = new Scanner(System.in);
        System.out.println("Please enter the name of the customer.");
        String name = nameScan.nextLine();
        this.name = name;
        System.out.println("Name has been set to "+this.name);
        nameScan.nextLine();
    }
    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Double> transactions){
        this.transactions = transactions;
    }
    public void setTransactions() {
        Scanner transScan = new Scanner(System.in);
        System.out.println("Please enter the amount to add or withdraw from the account or hit q to reach the customer menu");
        boolean isDouble = transScan.hasNextDouble();
        if (isDouble){
            double number = transScan.nextDouble();
            this.balance += number;
            System.out.println("Balance has been updated to "+balance);
            transactions.add(number);
            System.out.println(number+" Has been added to the list of transactions");
        }
        if (!isDouble && (!Objects.equals(transScan.nextLine(),"Q") || !Objects.equals(transScan.hasNextLine(),"q"))){
            System.out.println("That was not a valid entry, please try again.");
            setTransactions();
        }
        if (!isDouble && (Objects.equals(transScan.nextLine(),"Q") || Objects.equals(transScan.hasNextLine(),"q"))){
            System.out.println("You've chosen to return to the customer menu");
            transScan.nextLine();
            //customerMenu();
        }
    }

    public void modifyTransactions(){
        Scanner transScan = new Scanner(System.in);
        System.out.println("Would you like to see the list of transactions for "+name);
        boolean isDouble = transScan.hasNextDouble();
        if (isDouble){
            double number = transScan.nextDouble();
            this.balance += number;
            System.out.println("Balance has been updated to "+balance);
            transactions.add(number);
            System.out.println(number+" Has been added to the list of transactions");
        }
        if (!isDouble && (!Objects.equals(transScan.nextLine(),"Q") || !Objects.equals(transScan.hasNextLine(),"q"))){
            System.out.println("That was not a valid entry, please try again.");
            setTransactions();
        }
        if (!isDouble && (Objects.equals(transScan.nextLine(),"Q") || Objects.equals(transScan.hasNextLine(),"q"))){
            System.out.println("You've chosen to return to the customer menu");
            transScan.nextLine();
            //customerMenu();
        }
    }

    public double getBalance() {
        return balance;
    }
    public void setBalance() {
        Scanner scanBalance = new Scanner(System.in);
        boolean isDouble = scanBalance.hasNextInt();
        if (isDouble) {
            System.out.println("What is the initial balance for " + name + " ?");
            double balance = scanBalance.nextDouble();
            this.balance = balance;
            System.out.println("The balance has been set to "+this.balance);
        }
        if (!isDouble){
            System.out.println("That is not a valid number, please try again.");
            scanBalance.nextLine();
            setBalance();
        }
    }
}

