package dk.via.crud;

import java.sql.SQLException;

public interface SqlFunction<T, U> {
    U call(T rs) throws SQLException;
}
