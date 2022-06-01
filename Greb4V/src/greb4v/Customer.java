package greb4v;

import java.util.ArrayList;

public class Customer {
    ArrayList<CustomerProfile> customer = new ArrayList<CustomerProfile>();

    public void add(CustomerProfile e) {
        customer.add(e);
        
    }

    public void remove(String name) {
        if (customer.size() == 0) {
            System.out.println("List is empty");
        } else {
            for (CustomerProfile customerProfile : customer) {
                int i = 0;
                if (customerProfile.getName().equalsIgnoreCase(name)) {
                    customer.remove(i);
                    break;
                }
                i++;
            }
        }
    }

    public void display() {
        System.out.println("=====================================================================================================================");
        System.out.printf("%-20s %-20s q=======================================================================================");
    }
}
