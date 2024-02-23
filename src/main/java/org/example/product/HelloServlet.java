package org.example.product;

import java.io.*;
import java.sql.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "products", value = "/products")
public class HelloServlet extends HttpServlet {

    DbProgresses dbProgresses = new DbProgresses();

    public void init() {
        try {
            dbProgresses.checkDriver();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        checkDriver();
//        String cssCode = "table, th, td { border: 1px solid black; border-collapse: collapse;}th, td { padding: 10px;} th { background-color: #FDDF95;}table{width:100%;}";


        PrintWriter out = response.getWriter();
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
            Statement st = dbProgresses.createConnection().createStatement();
            ResultSet resultSet = st.executeQuery("select * from products");

            while (resultSet.next()){
                out.println("<tr>\n" +
                        "  \t<td>"+ resultSet.getInt("id")+"</td>\n" +
                        "  \t<td>"+ resultSet.getString("name")+"</td>\n" +
                        "  \t<td>" + resultSet.getString("category") +"</td>\n" +
                        "  \t<td>" + resultSet.getInt("price") + "₼ </td>\n" +
                        "  \t<td>" + "<a href=ShowMoreServlet?id="+resultSet.getInt("id") +">See Details</a>" + "</td>\n"  +
                        "  \t<td>" + "<a href=DeleteServlet?id="+resultSet.getInt("id") +">Delete</a>" + "</td>\n"  +
                        "  </tr>");
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        response.setContentType("text/html");
        out.println("</body></html>");
    }

    public void destroy() {
        dbProgresses.stopConnection();
    }




}