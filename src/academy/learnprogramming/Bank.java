package academy.learnprogramming;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.SortedMap;

public class Bank {
Branch branch = new Branch();
Customer customer = new Customer();
private ArrayList<Branch> branchList = new ArrayList<Branch>();
private String branchName;
private int element = branchList.size();

    public Bank() {
    }

    public void bankMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please pick on of the four options available\n" +
                "(1) Create a bank branch\n" +
                "(2) Select an existing bank branch.\n" +
                "(3) Print a list of existing branches\n" +
                "(4) Quit this program.");
        boolean isInt = scanner.hasNextInt();
        if (!isInt) {
            System.out.println("You did not enter a valid number, please try again.");
            scanner.nextLine();
            bankMenu();
        }
        if (isInt) {
            int choice = scanner.nextInt();
            if (choice < 1 || choice > 4) {
                System.out.println("You did not enter a valid number, please try again.");
                scanner.nextLine();
                bankMenu();
            } else {
                switch (choice) {
                    case 1:
                        createBranch();
                        createbranchName();
                        createBranchCustomerList();
                        scanner.nextLine();
                        bankMenu();
                        break;
                    case 2:
                        selectBranch();
                        scanner.nextLine();
                        break;
                    case 3:
                        printBranches();
                        scanner.nextLine();
                        break;
                    case 4:
                        System.exit(0);
                }
            }
        }
    }

    public void createBranch() {
        Scanner branchScanner = new Scanner(System.in);
        System.out.println("Would you like to create a new bank branch file?    Y or N");
        String choice = branchScanner.nextLine();
        if (Objects.equals(choice, "y") || Objects.equals(choice, "Y")) {
            if (branchList.size() == 0) {
                branchList.add(element, new Branch(branch.getBranchName(), branch.getCustomers()));
            } else {
                branch.setBranchName("Default");
                ArrayList<Customer> customers2 = new ArrayList<Customer>();
                Branch branch1 = new Branch(branch.getBranchName(), customers2);
                branchList.add(element, branch1);
                }
        }
            if (!Objects.equals(choice, "y") && !Objects.equals(choice, "Y")) {
                System.out.println("You made an invalid entry, or chose not create a customer file.");
                bankMenu();
           }
    }

    public void createbranchName(){
        Scanner branchScanner2 = new Scanner(System.in);
        System.out.println("You've created a blank branch file, please enter this branch's name");
        branchName = branchScanner2.nextLine();
        branchList.get(element).setBranchName(branchName);
    }

    public void createBranchCustomerList(){
    Scanner branchScanner3 = new Scanner(System.in);
    System.out.println("It is now time to create a customer list for bank branch "+branchName);
        System.out.println("Please enter the customer name");
        String name = branchScanner3.nextLine();
        branch.getCustomers().get(element).setName(name);
        System.out.println("You've chosen "+name+ "as the customer name.");
        System.out.println("Please enter a list of transactions for the customer");
        customer.enterTransactions();
        branch.getCustomers().get(element).setTransactions(customer.getTransactions());
        System.out.println(branch.getCustomers().get(element).getName());
    }

public void selectBranch() {
    Scanner selectScanner = new Scanner(System.in);
    if (branchList.size() == 0) {
        System.out.println("There aren't any branches to list right now! Returning to customer menu.");
        bankMenu();
    }
    if (branchList.size() > 0) {
        System.out.println("What branch file do you wish to work with?");
        String name = selectScanner.nextLine();
        boolean flag = false;
        for (Branch branch : branchList) {
            if (Objects.equals(branch.getBranchName(), name)) {
                flag = true;
                System.out.println("You've chosen to work with " + name + "'s file.");
                System.out.println("Do you wish to alter the name (1) or the customer list details (2) for this file.");
                boolean isInt = selectScanner.hasNextInt();
                if (!isInt) {
                    System.out.println("Please enter a valid number");
                    selectBranch();
                }
                if (isInt) {
                    int choice = selectScanner.nextInt();
                    if (choice < 1 || choice > 2) {
                        System.out.println("Please enter a valid number.");
                        selectBranch();
                    }
                    switch (choice) {
                        case 1:
                            for (Branch branch1 : branchList){
                            if (Objects.equals(branch1.getBranchName(),name)) {
                                Scanner scanner5 = new Scanner(System.in);
                                System.out.println("Please enter the new name for "+name+"'s branch account.");
                                String newName = scanner5.nextLine();
                                branch1.setBranchName(newName);
                                System.out.println(name+"'s account has been changed to "+newName);
                                }
                            }
                            bankMenu();
                        case 2:
                            for (Branch branch1 : branchList) {
                                if (Objects.equals(branch1.getBranchName(), name)) {
                                    String name2 = branch1.getBranchName();
                                    ArrayList<Customer> customers2 = branch1.getCustomers();
                                    branch1.customerMenu();
                                    Branch branch2 = new Branch(name2,customers2);
                                    branchList.set(branchList.indexOf(branch1),branch2);
                                    bankMenu();
                                }
                            }
                            bankMenu();
                    }
                }
            }
        }
        if (flag = false) {
            System.out.println("It looks like " + name + " does not exist yet. Please press 1 to try again (check spelling)," +
                    " or press (1) for customer menu.");
            boolean isInt = selectScanner.hasNextInt();
            if (!isInt) {
                System.out.println("You did not enter a valid number, returning to customer menu.");
                bankMenu();
            }
            if (isInt) {
                int choice = selectScanner.nextInt();
                if (choice == 1) {
                    selectBranch();
                } else {
                    System.out.println("You did not enter a valid number, returning to customer menu.");
                    bankMenu();
                }
            }
        }
    }
}

    public void printBranches(){
        System.out.println("there are "+branchList.size()+" branches");
        int ct = 1;
//        if (branchList.size() > 0)
//            for (Branch branch : branchList){
//            System.out.println(branch.getBranchName()+"     ");
//        }
        if (branchList.size() > 0)
            for (int i = 0; i < branchList.size(); i ++){
                System.out.println(branchList.get(i).getBranchName()+"     ");
            }

        if (branchList.size() == 0){
            System.out.println("There are no bank branches to list right now! You can create one from the bank menu.");
            bankMenu();
        }
        bankMenu();
}

    public ArrayList<Branch> getBranchList(){
    return branchList;
    }

    public String getBranchName(){
        return this.branchName;
    }


}
