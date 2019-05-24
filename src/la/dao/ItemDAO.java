package la.dao;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import la.servlet.model.*;


public class ItemDAO {
    private Connection con;
    public ItemDAO() throws DAOException {
        getConnection();
    }


    public List<Clothes>findall() throws DAOException {
        if(con==null)
            getConnection();
        PreparedStatement st=null;
        ResultSet rs=null;
        try{
            String sql="Select * From product left outer join size_master on product.size_id=size_master.id  left outer join on colour_master on product.color=color_master.id";
            st=con.prepareStatement(sql);
            rs=st.executeQuery();
            List<Clothes>list=new ArrayList<Clothes>();
            while(rs.next()){
                int code=rs.getInt("code");
                String name=rs.getString("name");
                int price=rs.getInt("price");
                Clothes bean=new Clothes();
                bean.setName(name);
                bean.setPrice(price);
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
            con = DriverManager.getConnection("jdbc:mysql://localhost/sample?user=student&password=himitu");
        }
        catch(Exception e){
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
