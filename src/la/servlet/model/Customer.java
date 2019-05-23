package la.servlet.model;

import la.bean.PasswordUtil;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Random;


public class Customer {


    private static int id;
    private String name;
    private String postal;
    private String address;
    private String phone;
    private String password;
    private String hash;
    private String salt;
    private PasswordUtil passwordUtil;

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

    public void generateSalt(){
        Random random = new Random();
        int salt_prima = random.nextInt(100000) + 1;
        //Store to data
    }


    public String getSalt() {
        return salt;
    }

    public String getHash(){
        return hash;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    // ハッシュ化パスワード取得
    public String setHash(String password, String salt){
        PasswordUtil passwordUtil = new PasswordUtil();
        hash= passwordUtil.getSafetyPassword(password, salt);
        return hash;
    }


}
