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
            String sql="Select * From tshirt_master";
            st=con.prepareStatement(sql);
            rs=st.executeQuery();
            List<Clothes>list=new ArrayList<Clothes>();
            while(rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");
                int price=rs.getInt("price");
                Clothes bean=new Clothes();
                bean.setName(name);
                bean.setPrice(price);
                bean.setSizelist(findsize(id));
                bean.setColorlist(findcolor(id));
                bean.setImagelist(findimage(id));
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

    public List<String>findsize(int id) throws DAOException {
        if(con==null)
            getConnection();
        PreparedStatement st=null;
        ResultSet rs=null;
        try{
            String sql="Select size_master.name From product left join size_master on (product.size_id=size_master.id) where product.tshirt_id=?";
            st=con.prepareStatement(sql);
            st.setInt(1,id);
            rs=st.executeQuery();
            List<String>list=new ArrayList<String>();
            while(rs.next()){
            String sizeName = rs.getString("name");
                list.add(sizeName);
            }
            return list;
        }catch(Exception e){
            e.printStackTrace();
            throw new DAOException("レコードの取得に失敗しました");
        }finally{
            try{
            //    if(rs!=null)rs.close();
            //    if(st!=null)st.close();
            //    close();
            }catch(Exception e){
                throw new DAOException("リソースの解放に失敗しました");
            }
        }
    }

    public List<String>findcolor(int id) throws DAOException {
        if(con==null)
            getConnection();
        PreparedStatement st=null;
        ResultSet rs=null;
        try{
            String sql="Select color_master.name From product left join color_master " +
                    "on (product.color_id=color_master.id) where product.tshirt_id="+id;
            st=con.prepareStatement(sql);
            rs=st.executeQuery();
            List<String>list=new ArrayList<String>();
            while(rs.next()){
                String color_name=rs.getString("name");
                list.add(color_name);
            }
            return list;
        }catch(Exception e){
            e.printStackTrace();
            throw new DAOException("レコードの取得に失敗しました");
        }finally{
            try{
                //if(rs!=null)rs.close();
                //if(st!=null)st.close();
                //close();
            }catch(Exception e){
                throw new DAOException("リソースの解放に失敗しました");
            }
        }
    }

    public List<String>findimage(int id) throws DAOException {
        if(con==null)
            getConnection();
        PreparedStatement st=null;
        ResultSet rs=null;
        try{
            String sql="Select image_url From product where product.tshirt_id="+id;
            st=con.prepareStatement(sql);
            rs=st.executeQuery();
            List<String>list=new ArrayList<String>();
            while(rs.next()){
                String imageUrl=rs.getString("image_url");
                list.add(imageUrl);
            }
            return list;
        }catch(Exception e){
            e.printStackTrace();
            throw new DAOException("レコードの取得に失敗しました");
        }finally{
            try{
                //if(rs!=null)rs.close();
                //if(st!=null)st.close();
                //close();
            }catch(Exception e){
                throw new DAOException("リソースの解放に失敗しました");
            }
        }
    }



    private void getConnection()throws DAOException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/Clothes?user=student&password=himitu");
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
