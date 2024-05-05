package dk.via.crud;

import dk.via.book.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookReader {
    public List<Book> readAll() throws SQLException {
        try(Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/")) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Book");
            ResultSet rs = statement.executeQuery();
            ArrayList<Book> result = new ArrayList<>();
            while(rs.next()) {
                result.add(ObjectFactory.createBook(rs));
            }
            return result;
        }
    }
}
