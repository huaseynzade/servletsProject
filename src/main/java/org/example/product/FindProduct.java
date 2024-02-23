package org.example.product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "TestServlet", value = "/TestServlet")
public class FindProduct extends HttpServlet {
    DbProgresses dbProgresses = new DbProgresses();


    @Override
    public void init() throws ServletException {
        try {
            dbProgresses.checkDriver();
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productName = req.getParameter("name");
        System.out.println("ProductName: " + productName);
        PrintWriter out = resp.getWriter();
        out.println("<html><head><title>Title Name</title><style>" + CssCode.cssCode + "</style></head><body>");
        out.println("<div class=\"filter\">");
        out.println("</div>");

        out.println("<table>");

        out.println("<tr>");
        out.println("<th>#</th>");
        out.println("<th>Product</th>");
        out.println("<th>Category</th>");
        out.println("<th>Price</th>");
        out.println("<th>More</th>");
        out.println("<th>Delete</th>");


        out.println("</tr>");
        try {
            PreparedStatement preparedStatement = dbProgresses.createConnection().prepareStatement("select * from products where name like ?");
            preparedStatement.setString(1, req.getParameter("name") + "%");
            ResultSet rs = preparedStatement.executeQuery();
            int rowCount = 0;
            while (rs.next()) {
                rowCount++;
                String name = rs.getString("name");
                String category = rs.getString("category");
                int price = rs.getInt("price");
                out.println("<tr>");
                out.println("<td>" + rs.getInt("id") + "</td>");
                out.println("<td>" + name + "</td>");
                out.println("<td>" + category + "</td>");
                out.println("<td>" + price + "</td>");
                out.println("  \t<td>" + "<a href=ShowMoreServlet?id="+rs.getInt("id") +">See Details</a>" + "</td>\n");
                out.println(" \t<td>" + "<a href=DeleteServlet?id="+rs.getInt("id") +">Delete</a>" + "</td>\n");
                out.println("</tr>");
            }
            if (rowCount == 0) {
                out.println("<tr><td colspan='6'>No products found</td></tr>");
            }

        }catch(SQLException e) {
            throw new RuntimeException(e);
        }

        out.println("</body></html>");
    }
    @Override
    public void destroy() {
        dbProgresses.stopConnection();
        System.out.println("Destroyed");
    }

}
