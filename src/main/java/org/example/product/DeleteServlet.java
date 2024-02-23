package org.example.product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name="DeleteServlet",value = "/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    DbProgresses dbProgresses = new DbProgresses();

    @Override
    public void init() throws ServletException {
        try {
            dbProgresses.checkDriver();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int deleteId = Integer.parseInt(req.getParameter("id"));
            PreparedStatement ps = dbProgresses.createConnection().prepareStatement("delete from products where id = ?");
            ps.setInt(1,deleteId);
            ps.executeUpdate();


            resp.sendRedirect("products");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }




    }

    @Override
    public void destroy() {
        System.out.println("Connection is destroying..");
        dbProgresses.stopConnection();
    }
}
