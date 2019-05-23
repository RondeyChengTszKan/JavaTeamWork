package la.bean;

import la.dao.CustomerDAO;
import la.servlet.model.Customer;
import la.bean.CustomerListBean;


import java.util.ArrayList;

public class LoginCheckBean {
    public Customer getCustomer(Customer bean, String inputPassword) {
        try{
            CustomerDAO dao=new CustomerDAO();
            ArrayList<Customer> list = dao.findall();
            for (Customer customer : list) {
                if (customer.getName().equals(bean.getName())){
                return customer;
            }
        }
        }
        catch(Exception e){

        }
        return null;
    }
}
