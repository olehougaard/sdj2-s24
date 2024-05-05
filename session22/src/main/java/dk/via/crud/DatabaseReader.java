package dk.via.crud;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseReader<T> {
    private String sql;
    private SqlFunction<ResultSet, T> factory;

    public DatabaseReader(String sql, SqlFunction<ResultSet, T> factory) {
        this.sql = sql;
        this.factory = factory;
    }

    public List<T> readAll() throws SQLException {
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
