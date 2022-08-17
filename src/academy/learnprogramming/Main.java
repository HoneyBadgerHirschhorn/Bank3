package academy.learnprogramming;

import java.util.ArrayList;

public class Main {



    public static void main(String[] args) {
        Customer customer = new Customer("Denis",new ArrayList<Double>());
        Branch branch = new Branch("mine",new ArrayList<Customer>());
        Bank bank = new Bank();

        bank.bankMenu();








    }
}
