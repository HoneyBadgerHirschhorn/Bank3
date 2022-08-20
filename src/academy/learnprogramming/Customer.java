package academy.learnprogramming;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Customer {
    Scanner scanner = new Scanner(System.in);
    private String name;

    private ArrayList<Double> transactions = new ArrayList<Double>();


    public Customer(){
        this.name = "default";
        this.transactions.add(0,0.0);
    }

    public Customer(String name, ArrayList<Double> list) {
        this.name = name;
        this.transactions = list;
    }

    public String getName() {
        return name;
    }

    public String enterName() {
        Scanner nameScanner = new Scanner(System.in);
        System.out.println("Do you wish to enter a name for this account?  Y or N");
        String choice = scanner.nextLine();
        if (!Objects.equals(choice, "y") && !Objects.equals(choice, "Y")) {
            System.out.println("You chose not to enter a name for this account.");
            //customerMenu;
        }
        if (Objects.equals(choice, "y") || Objects.equals(choice, "Y")) {
            System.out.println("Please enter the customer's name.");
            String name = scanner.nextLine();
            setName(name);
            return name;
        }
        return null;
    }
    public void setName(String name){
        this.name = name;
    }


    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public ArrayList<Double> enterTransactions() {
        Scanner transScanner = new Scanner(System.in);
        System.out.println("Do you wish to enter a transaction for this account?  Y or N");
        String choice = transScanner.nextLine();
        if (!Objects.equals(choice, "y") && !Objects.equals(choice, "Y")){
            System.out.println("You chose not to enter any more transactions for this account.");
            //customerMenu;
        }
        if (Objects.equals(choice, "y") || Objects.equals(choice, "Y")) {
            System.out.println("Please enter the transaction now.");
            boolean isDouble = transScanner.hasNextDouble();
            if (isDouble) {
                double transaction = transScanner.nextDouble();
                System.out.println("You entered " + transaction + ".");
                transactions.add(transaction);
                enterTransactions();
            }
            if (!isDouble) {
                System.out.println("Please enter a valid positive or negative number. Ex. 235.54 or -235.54");
                enterTransactions();
            }
        }
        return transactions;
    }

    public void setTransactions(ArrayList<Double> transactions) {
        this.transactions = transactions;
    }
}