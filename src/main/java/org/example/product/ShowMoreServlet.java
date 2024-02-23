package org.example.product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "ShowMoreServlet", value = "/ShowMoreServlet")
public class ShowMoreServlet extends HttpServlet {
    DbProgresses dbProgresses = new DbProgresses();

    @Override
    public void init() throws ServletException {
        try {
            dbProgresses.checkDriver();
        }catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();


        try {
            PreparedStatement ps = dbProgresses.createConnection().prepareStatement("select * from (select * from products join public.suppliers s on s.supplier_id = products.supplier_id) where id = ?");
            ps.setInt(1, Integer.parseInt(req.getParameter("id")));
            ResultSet rs = ps.executeQuery();


            out.println("<html><head><title>Title Name</title><style>" + CssCode.cssCode + "</style></head><body>");
            out.println("<div class=\"filter\">");
            out.println("</div>");

            out.println("<table>");

            out.println("<tr>");
            out.println("<th>#</th>");
            out.println("<th>Product</th>");
            out.println("<th>Category</th>");
            out.println("<th>Price</th>");
            out.println("<th>Exp-date</th>");
            out.println("<th>Supplier Name</th>");
            out.println("<th>Supplied Date</th>");
            out.println("<th>Supplier License</th>");
            out.println("</tr>");


            while (rs.next()) {
                out.println("<tr>\n" +
                        "  \t<td>" + rs.getInt("id") + "</td>\n" +
                        "  \t<td>" + rs.getString("name") + "</td>\n" +
                        "  \t<td>" + rs.getString("category") + "</td>\n" +
                        "  \t<td>" + rs.getInt("price") + "</td>\n" +
                        "  \t<td>" + rs.getDate("exp_date") + "</td>\n" +
                        "  \t<td>" + rs.getString("supplier_name") + "</td>\n" +
                        "  \t<td>" + rs.getDate("supplied_date") + "</td>\n" +
                        "  \t<td>" + rs.getBoolean("supply_license") + "</td>\n" +


                        "  </tr>");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

}
