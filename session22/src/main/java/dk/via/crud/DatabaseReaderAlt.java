package dk.via.crud;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseReaderAlt {
    public static <T> List<T> readAll(String sql, SqlFunction<ResultSet, T> factory) throws SQLException {
        try(Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/")) {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            ArrayList<T> result = new ArrayList<>();
            while(rs.next()) {
                result.add(factory.call(rs));
            }
            return result;
        }
    }
}
