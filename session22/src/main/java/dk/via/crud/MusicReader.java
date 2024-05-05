package dk.via.crud;

import dk.via.book.Music;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MusicReader {
    public List<Music> readAll() throws SQLException {
        try(Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/");) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Music");
            ResultSet rs = statement.executeQuery();
            ArrayList<Music> result = new ArrayList<>();
            while(rs.next()) {
                result.add(ObjectFactory.createMusic(rs));
            }
            return result;
        }
    }
}
