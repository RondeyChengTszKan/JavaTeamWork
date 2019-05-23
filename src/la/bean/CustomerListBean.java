package la.bean;

import java.util.ArrayList;
import la.servlet.model.*;

public class CustomerListBean {

    public static ArrayList<Customer> getCustomerList() {
        ArrayList<Customer> customerList=new ArrayList<Customer>();
        Customer customer=new Customer();
        customer.setName("okuda");
        customer.setHash("aaa","ccc");
        customerList.add(customer);
        customer=new Customer();
        customer.setName("rondy");
        customer.setHash("bbb","ccc");
        customerList.add(customer);
        return customerList;
    }
}
