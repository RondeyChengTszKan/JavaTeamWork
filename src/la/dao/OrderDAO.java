package la.dao;

import la.bean.CartBean;
import la.servlet.model.*;

import java.sql.*;
import java.util.Collection;
import java.util.Map;

public class OrderDAO {
    private Connection con;
    public OrderDAO()throws DAOException {
        getConnection();
    }

    public int saveOrder(Customer customer, CartBean cart)throws DAOException {
        if(con==null)
            getConnection();
        PreparedStatement st=null;
        ResultSet rs=null;
        try {

           String sql="SELECT * FROM ";
            st=con.prepareStatement(sql);
            st.setInt(1,customer.getId());
            st.executeUpdate();
            st.close();

            int orderNumber=0;

            String sql2="SELECT last_insert_id()";
            st=con.prepareStatement(sql2);
            rs=st.executeQuery();
            if(rs.next()){
                orderNumber=rs.getInt(1)+1;
            }
            rs.close();
            st.close();

            String sql3="INSERT INTO ordered_detail VALUES(?,?,?)";
            st=con.prepareStatement(sql3);
            Map<Integer,OrderItem>items=cart.getItems();
            Collection<OrderItem>list=items.values();
            for(OrderItem item:list) {
                st.setInt(1, orderNumber);
                st.setInt(2, item.getItemId());
                st.setInt(3, item.getQuantity());
                st.executeUpdate();
            }
            st.close();
            return orderNumber;

        }catch(Exception e){
            e.printStackTrace();
            throw new DAOException("レコードの操作に失敗しました");
        }finally {
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
