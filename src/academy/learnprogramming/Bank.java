package academy.learnprogramming;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Bank {


private String branchName;
private ArrayList<Branch> branchList = new ArrayList<Branch>();
private ArrayList<Customer> cList;


public Bank(){}

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
                    scanner.nextLine();
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

public void createBranch(){
    Scanner scanBranch = new Scanner(System.in);
    System.out.println("Would you like to create a new branch? Y or N");
    String choice = scanBranch.nextLine();
    if (Objects.equals(choice, "y") || Objects.equals(choice, "Y")) {
        System.out.println("What would you like to name this new branch?");
        String branchName = scanBranch.nextLine();
        Branch newBranch = new Branch(branchName, new ArrayList<Customer>());
        branchList.add(newBranch);
        System.out.println("You've added a branch file for " + branchName + ".");
        System.out.println("Do you want to edit the customer list for branch "+branchName+" ?   Y or N");
        String choice2 = scanBranch.nextLine();
        if (Objects.equals(choice2, "y") || Objects.equals(choice2, "Y")) {
            newBranch.setCustomers();
            bankMenu();
        }


        bankMenu();
    }
    if (!Objects.equals(choice, "y") && !Objects.equals(choice, "Y")) {
        System.out.println("You chose not create a branch file.");
        bankMenu();
    }
    bankMenu();
}

public void selectBranch() {
    Scanner selectScanner = new Scanner(System.in);
    if (branchList.size() == 0) {
        System.out.println("There aren't any branchList right now! Returning to customer menu.");
        bankMenu();
    }
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
            }
            if (isInt) {
                int choice = selectScanner.nextInt();
                if (choice < 1 || choice > 2) {
                    System.out.println("Please enter a valid number.");
                    selectBranch();
                }
                switch (choice) {
                    case 1:
                        branch.setBranchName(name);
                        branchList.set(branchList.indexOf(branch), branch);
                        bankMenu();
                    case 2:
                        branch.selectFile();
                        branchList.set(branchList.indexOf(branch), branch);
                        bankMenu();
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
        for (Branch branch : branchList){
            System.out.println(branch.branchName+"      "+branch.getCustomers());

        }
}

    public void setCustomers(){
        new Branch().createCustomer();
    }

    public ArrayList<Customer> getCustomers(){
    return cList;
    }

    public ArrayList<Branch> getBranchList(){
    return branchList;

    }



}
