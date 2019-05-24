package la.servlet.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Clothes {
    private int id;
    private String name;
    private int price;
    private String size;
    private String color;
    private List<String> sizelist;
    private List<String> colorlist;
    private Date updated;
    private Date created;
    private Map validation;
    private String image;
    private List<String> imagelist;

    public Clothes() {
        super();
    }

    public Clothes(int id, String name, int price, String size, String color, String image) {
        this.id=id;
        this.name=name;
        this.price=price;
        this.size=size;
        this.color=color;
        this.image=image;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Map getValidation() {
        return validation;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public void setSizelist(List<String> sizelist) {
        this.sizelist = sizelist;
    }

    public List<String> getSizelist() {
        return sizelist;
    }

    public void setColorlist(List<String> colorlist) {
        this.colorlist = colorlist;
    }

    public List<String> getColorlist() {
        return colorlist;
    }

    public void setImagelist(List<String> imagelist) {
        this.imagelist = imagelist;
    }

    public List<String> getImagelist() {
        return imagelist;
    }
}
