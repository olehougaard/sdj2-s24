package dk.via.crud;

import dk.via.book.Book;
import dk.via.book.Music;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ObjectFactory {
    public static Book createBook(ResultSet rs) throws SQLException {
        // Placeholder
        return new Book(rs.getString("title"), rs.getDouble("price"));
    }

    public static Music createMusic(ResultSet rs) throws SQLException {
        // Placeholder
        return new Music(rs.getString("id"), new String[]{rs.getString("performer")}, rs.getBigDecimal("price"));
    }
}
