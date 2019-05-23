package la.servlet.model;

import java.sql.SQLException;
import java.util.Date;
import java.util.Map;

public class Order {
    private static int id;
    private Date updated;
    private Date created;
    private Map orderItem;
    private Map validation;
    private Customer customer;

    public Order() {
        super();
    }

    public Order(Map requestParams){

    }

    public Customer getCustomer() {
        return customer;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Order.id = id;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Map getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(Map orderItem) {
        this.orderItem = orderItem;
    }

    public Map getValidation() {
        return validation;
    }

    public int save() throws SQLException {
        if(id == 0 ){
            //Insert
            return getId();
        }else{
            //update
            return getId();
        }
    }
}
