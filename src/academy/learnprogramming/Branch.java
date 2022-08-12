package academy.learnprogramming;

import java.util.ArrayList;


import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Branch extends Bank {

    Customer customer = new Customer();
    ArrayList<Customer> customers = new ArrayList<Customer>();

    public Branch(){
    }

    public void customerMenu(){
        Scanner menuScanner = new Scanner(System.in);
        boolean isInt = menuScanner.hasNextInt();
        System.out.println(new Branch().customers.toString());
        System.out.println("Please pick on of the three options available\n" +
                "(0) Create a new customer file\n"+
                "(1) Select an existing customer file.\n"+
                "(2) Set the customer's name.\n" +
                "(3) Set the customer's balance\n" +
                "(4) Add or withdraw from the account (this will add to the list of transactions).\n" +
                "(5) Amend transaction list for this customer.\n+" +
                "(6) Return to the branch menu.");
        if (!isInt){
            System.out.println("You did not enter a valid number, please try again.");
            menuScanner.nextLine();
            customerMenu();
        }
        if (isInt) {
            int choice = menuScanner.nextInt();
            if (choice <0 || choice > 6){
                System.out.println("You did not enter a valid number, please try again.");
                menuScanner.nextLine();
                customerMenu();
            }
            else {
                switch (choice){
                    case 0:

                    case 1:

                    case 2:
                        customer.setName();
                    case 3:
                        customer.setBalance();
                    case 4:
                        // modifyTransactions();
                    case 5:

                    case 6:

                }
            }
        }
    }

        public void selectFile(){
        Scanner fileScanner = new Scanner(System.in);
        System.out.println("What customer file do you wish to work with?");
        String name = fileScanner.nextLine();
        System.out.println("You've chosen to work with file number "+customers.indexOf(name));



//        currentClient(name, customer.transactions);
//        if (Objects.equals(this.name,name)){
//            System.out.println("You've chosen to work with "+name+"s file. You may now work with options 2-5 on the menu.");
//            customerMenu();
//        }
//        if (!Objects.equals(this.name,name)){
//            System.out.println("I'm sorry it does not appear that we have "+name+" on file. Please check spelling and try again");
//            fileScanner.nextLine();
//            customerMenu();
//        }
    }
    public int currentClient(String name) {
        if (customers.contains(name)) {
            System.out.println(customers.indexOf(name));
            return customers.indexOf(name);
        }
        return -1;
    }


        public Customer getCustomersIndex (String name){
        Customer currentCustomer = customers.get(currentClient(name));
        currentCustomer.toString();
        return currentCustomer;
    }

    public void createFile(){
        customer.setName();
        customer.setBalance();
        //setTransactions();

    }


    public void createCustomer(){

        //customers.add(new Customer(customer.getName(),customer.getTransactions()));
        //System.out.println(customers.get(0));
    }




    public void eh(){

    }



}

