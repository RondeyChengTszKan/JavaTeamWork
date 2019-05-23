package la.bean;

import la.servlet.model.Customer;
import la.bean.CustomerListBean;


import java.util.ArrayList;

public class LoginCheckBean {
    public Customer getCustomer(Customer bean, String inputPassword) {

        ArrayList<Customer> list = CustomerListBean.getCustomerList();
        for (Customer customer : list) {
            if (customer.getName().equals(bean.getName())
                    //&&customer.getHash().equals(customer.setHash(inputPassword,customer.getSalt()))
            ){
                return customer;

            }
        }
        return null;
    }
}
