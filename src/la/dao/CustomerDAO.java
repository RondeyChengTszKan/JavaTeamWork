package la.dao;

import la.bean.CartBean;
import la.servlet.model.Clothes;
import la.servlet.model.Customer;
import la.servlet.model.OrderItem;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class CustomerDAO {
    private Connection con;
    public CustomerDAO()throws DAOException {
        getConnection();
    }

    public ArrayList<Customer> findall() throws DAOException {
        if(con==null)
            getConnection();
        PreparedStatement st=null;
        ResultSet rs=null;
        try{
            String sql="Select * From customer";
            st=con.prepareStatement(sql);
            rs=st.executeQuery();
            ArrayList<Customer>list=new ArrayList<Customer>();
            while(rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");
                String address=rs.getString("address");
                String postal=rs.getString("postal");
                String phone=rs.getString("phone");
                String password=rs.getString("pass");
                Customer bean=new Customer(id,name,postal,address,phone,password);
                list.add(bean);
            }
            return list;
        }catch(Exception e){
            e.printStackTrace();
            throw new DAOException("レコードの取得に失敗しました");
        }finally{
            try{
                if(rs!=null)rs.close();
                if(st!=null)st.close();
                close();
            }catch(Exception e){
                throw new DAOException("リソースの解放に失敗しました");
            }
        }
    }

    private void getConnection()throws DAOException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://10.199.80.45:9997/Clothes?user=root&password=mysql");
        }
        catch(Exception e){
            e.printStackTrace();
            throw new DAOException("接続に失敗しました");
        }
    }

    private void close() throws SQLException{
        if(con!=null){
            con.close();
            con=null;
        }
    }
}
