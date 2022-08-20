package academy.learnprogramming;
import academy.learnprogramming.Bank;
import academy.learnprogramming.Customer;

import java.net.PortUnreachableException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Objects;
public class Branch {
    Customer customer = new Customer();
    Scanner scanner = new Scanner(System.in);
    public String branchName;
    private ArrayList<Customer> customers = new ArrayList<Customer>(0);


    public Branch (){
    this.branchName = "default";
    customers.add(customer);
    }

    public Branch(String name, ArrayList<Customer> customerList){
    this.branchName = name;
    this.customers = customerList;
    }
    public void customerMenu(){
        System.out.println("Please pick on of the three options available\n" +
                "(1) Create a new customer file\n"+
                "(2) Select an existing customer file.\n"+
                "(3) Print a list of existing customers.\n"+
                "(4) Return to the master menu.");
        boolean isInt = scanner.hasNextInt();
        if (!isInt){
            System.out.println("You did not enter a valid number, please try again.");
            scanner.nextLine();
            customerMenu();
        }
        if (isInt) {
            int choice = scanner.nextInt();
            if (choice <1 || choice > 4){
                System.out.println("You did not enter a valid number, please try again.");
                scanner.nextLine();
                customerMenu();
            }
            else {
                switch (choice){
                    case 1:
                        createCustomer();
                        scanner.nextLine();
                        break;
                    case 2:
                        selectFile();
                        scanner.nextLine();
                        break;
                    case 3:
                        printCustomers();
                        scanner.nextLine();
                        break;
                    case 4:
                        new Bank().bankMenu();
                        break;
                }
            }
        }
    }

    public void createCustomer() {
        Scanner createScanner = new Scanner(System.in);
        System.out.println("Please press Y to continue creating a customer file, or any other key to abort customer creation.");
        String choice = createScanner.nextLine();
        if (Objects.equals(choice, "y") || Objects.equals(choice, "Y")) {
            customer.setName(customer.enterName());
            customer.setTransactions(customer.enterTransactions());
            customers.add(new Customer(customer.getName(), customer.getTransactions()));
            System.out.println("You've added an account file for " + customer.getName() + ".");
            customerMenu();
        }
        if (!Objects.equals(choice, "y") && !Objects.equals(choice, "Y")) {
            System.out.println("You chose not create a customer file.");
            customerMenu();
        }
        customerMenu();
    }

    public void selectFile(){
        Scanner selectScanner = new Scanner(System.in);
        if (customers.size()==0){
            System.out.println("There aren't any customers right now! Returning to customer menu.");
            customerMenu();
        }
        System.out.println("What customer file do you wish to work with?");
        String name = selectScanner.nextLine();
        boolean flag = false;
        for (Customer  customer : customers){
            if (Objects.equals(customer.getName(),name)){
                flag = true;
                System.out.println("You've chosen to work with "+name+"s file.");
                System.out.println("Do you wish to alter the name (1) or the transaction list (2) for this file.");
                boolean isInt = selectScanner.hasNextInt();
                if (!isInt){
                    System.out.println("Please enter a valid number");
                }
                if (isInt){
                    int choice = selectScanner.nextInt();
                    if (choice <1 || choice > 2){
                        System.out.println("Please enter a valid number.");
                        selectFile();
                    }
                    switch (choice){
                        case 1:
                            customer.setName(customer.enterName());
                            customers.set(customers.indexOf(customer),customer);
                            customerMenu();
                        case 2:
                            customer.setTransactions(customer.enterTransactions());
                            customers.add(customers.indexOf(customer),customer);
                            customerMenu();
                    }
                }
            }
            if (flag = false){
                System.out.println("It looks like "+name+" is not a customer here. Please press 1 to try again (check spelling)," +
                        " or press (1) for customer menu.");
                boolean isInt = selectScanner.hasNextInt();
                if (!isInt){
                    System.out.println("You did not enter a valid number, returning to customer menu.");
                    customerMenu();
                }
                if (isInt){
                    int choice = selectScanner.nextInt();
                    if (choice == 1){
                        selectFile();
                    }
                    else {
                        System.out.println("You did not enter a valid number, returning to customer menu.");
                        customerMenu();
                    }
                }
            }
        }
    }

    public void printCustomers(){
        if (customers.size()==0){
            System.out.println("There aren't any customers right now, returning to menu.");
            customerMenu();
        }
        if (customers.size() > 0) {
            for (Customer customer : customers){
                System.out.println(customers.indexOf(customer)+"     "+customer.getName());
            }
        }
        customerMenu();
    }

    public ArrayList<Customer> getCustomers(){
        return customers;
    }
    public void setCustomersList(){
        customers = new ArrayList<Customer>(0);
        //customers.add(0,new Customer("Default",new ArrayList<Double>()));
    }


    public String getBranchName(){
        return branchName;
    }

    public void setBranchName(String name){
        this.branchName = name;
    }

    public void setBranchName(){
        Scanner setName = new Scanner(System.in);
        System.out.println("What is the name of the new Bank branch?");
        String newName = setName.nextLine();
        this.branchName = newName;
    }
}



