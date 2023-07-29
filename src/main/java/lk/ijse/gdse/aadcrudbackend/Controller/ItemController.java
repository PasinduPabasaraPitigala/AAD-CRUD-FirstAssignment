package lk.ijse.gdse.aadcrudbackend.Controller;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import lk.ijse.gdse.aadcrudbackend.DTO.Item;
import lk.ijse.gdse.aadcrudbackend.Model.ItemModel;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/item")
public class ItemController extends HttpServlet{

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getContentType() == null || !req.getContentType().toLowerCase().startsWith("application/json")){
            resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
        }
        Jsonb jsonb = JsonbBuilder.create();
        Item item = jsonb.fromJson(req.getReader(),Item.class);
        System.out.println(item);

        try {
            int i = ItemModel.saveItem(item);
            if (i>0){
                System.out.println("Stem save");
            }else {
                System.out.println("Something went wrong");
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }



    protected void doPut(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        if (req.getContentType() == null || !req.getContentType().toLowerCase().startsWith("application/json")) {
            resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
        }

        Jsonb json = JsonbBuilder.create();
        Item item = json.fromJson(req.getReader(),Item.class);
        System.out.println(item);
        try {
            int i = ItemModel.updateItem(item);
            if (i>0){
                System.out.println("Item update");
            }else {
                System.out.println("Something went wrong");
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }


    protected void doDelete(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
        if (req.getContentType() == null || !req.getContentType().toLowerCase().startsWith("application/json")) {
            resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
        }

        Jsonb jsonb = JsonbBuilder.create();
        Item item = jsonb.fromJson(req.getReader(), Item.class);
        System.out.println(item);

        try {
            int i = ItemModel.deleteItem(item);
            if (i>0){
                System.out.println("Item delete");
            }else {
                System.out.println("Something went wrong");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException,IOException {
        if (req.getContentType() == null || !req.getContentType().toLowerCase().startsWith("application/json")) {
            resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
        }

        Jsonb jsonb = JsonbBuilder.create();
        Item item = jsonb.fromJson(req.getReader(), Item.class);
        System.out.println(item);

        try {
            Item item1 = ItemModel.searchItem(item.getId());
            if (item1 != null) {
                System.out.println(item1);
            } else {
                System.out.println("something went wrong");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
