package la.servlet.model;

import java.util.Random;

public class Customer {
    private static int id;
    private String name;
    private String postal;
    private String address;
    private String phone;
    private String hash;
    private String salt;

    public Customer() {
        super();
    }

    public String getName() {
        return name;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Customer.id = id;
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

    public String generateSalt(){
        Random random = new Random();
        int salt_prima = random.nextInt(100000) + 1;
        return salt;
    }

    public String getHash(String hash){
        return hash;
    }

}
