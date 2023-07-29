package lk.ijse.gdse.aadcrudbackend.Model;

import lk.ijse.gdse.aadcrudbackend.DB.DBConnection;
import lk.ijse.gdse.aadcrudbackend.DTO.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ItemModel {
    public static int saveItem(Item item) {
        int status = 0;
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO item VALUES(?,?,?,?)");
            ps.setString(1,item.getId());
            ps.setString(2,item.getName());
            ps.setInt(3,item.getQty());
            ps.setDouble(4,item.getPrice());
            status = ps.executeUpdate();
            con.close();
        }
        catch (Exception ex) {
            System.out.println("Message.." + ex.getMessage());
            ex.printStackTrace();
        }
        return status;
    }

    public static int updateItem(Item item) {
        int status = 0;
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("UPDATE item SET name = ? , qty = ? , price = ? WHERE id =?");
            ps.setString(1,item.getName());
            ps.setInt(2,item.getQty());
            ps.setDouble(3,item.getPrice());
            ps.setString(4,item.getId());
            status = ps.executeUpdate();
            con.close();
        }
        catch (Exception ex) {
            System.out.println("Message.." + ex.getMessage());
            ex.printStackTrace();
        }
        return status;
    }

    public static int deleteItem(Item item) {
        int status = 0;
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("DELETE FROM item WHERE id =?");
            ps.setString(1,item.getId());
            status = ps.executeUpdate();
            con.close();
        }
        catch (Exception ex) {
            System.out.println("Message.." + ex.getMessage());
            ex.printStackTrace();
        }
        return status;
    }

    public static Item searchItem(String id) {
        Item item1=null;
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM item WHERE id =?");
            ps.setString(1,id);

            ResultSet rst = ps.executeQuery();
            if(rst.next()){
                item1 = new Item(
                        rst.getString(1),
                        rst.getString(2),
                        rst.getInt(3),
                        rst.getDouble(4));
            }
            con.close();
        }
        catch (Exception ex) {
            System.out.println("Message.." + ex.getMessage());
            ex.printStackTrace();
        }
        return item1;
    }

}
