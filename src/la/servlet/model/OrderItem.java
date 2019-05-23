package la.servlet.model;

import java.sql.SQLException;
import java.util.Map;

public class OrderItem {
    private int id;
    private int orderId;
    private int itemId;
    private int price;
    private int quantity;
    private String name;
    private String size;
    private String color;
    private Map validation;

    public OrderItem() {
        super();
    }
    public OrderItem(Map requestParams){

    }
    public OrderItem(int itemId){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Map getValidation() {
        return validation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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

    public int save(int OrderId) throws SQLException {
        if(OrderId == 0 ){
            //Insert
            return getId();
        }else{
            //update
            return getId();
        }
    }

}
