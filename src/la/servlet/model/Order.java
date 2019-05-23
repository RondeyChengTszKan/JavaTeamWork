package la.servlet.model;

import java.sql.SQLException;
import java.util.Date;
import java.util.Map;

public class Order {
    private static int id;
    private String name;
    private String postal;
    private String address;
    private String phone;
    private Date updated;
    private Date created;
    private Map orderItem;
    private Map validation;

    public Order() {
        super();
    }

    public Order(Map requestParams){

    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Order.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
