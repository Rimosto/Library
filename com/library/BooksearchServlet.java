package com.library;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.ArrayList;

@WebServlet("/searchBooks")
public class BookSearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword = request.getParameter("keyword");
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Book> books = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "password");

            String query = "SELECT * FROM books WHERE title LIKE ? OR author LIKE ? OR genre LIKE ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword + "%");
            ps.setString(3, "%" + keyword + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                books.add(new Book(rs.getInt("book_id"), rs.getString("title"), rs.getString("author"), rs.getString("genre"), rs.getBoolean("availability")));
            }

            request.setAttribute("books", books);
            request.getRequestDispatcher("searchResults.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); if (ps != null) ps.close(); if (conn != null) conn.close(); } catch (SQLException e) { }
        }
    }
}
