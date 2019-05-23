package la.servlet.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Clothes {
    private static int id;
    private String name;
    private int price;
    private String size;
    private String color;
    private Date updated;
    private Date created;
    private Map validation;

    public Clothes() {
        super();
    }

    public Clothes(Map requestParams) {

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Clothes.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
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

    public static List getList(String keyword){
        List<Clothes> itemSet = new ArrayList<Clothes>();
        return itemSet;
    }

    public static List getList(String keyword, int page){
        List<Clothes> itemSet = new ArrayList<Clothes>();
        return itemSet;
    }

    public Clothes getClothes(int id){
        Clothes clothes = new Clothes();
        return clothes;
    }
}
