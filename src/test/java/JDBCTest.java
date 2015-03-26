import org.junit.Test;

import java.sql.*;

/**
 * Подключание и работа с PostgeSQL через JDBC
 */
public class JDBCTest {
    @Test
    public void testDatabase() throws SQLException {
        //Driver driver = new Driver();

        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/postgres",
                "postgres", "123");
        // Создаем SQL оператор
        Statement sql = con.createStatement();
        // Создаём таблицу
        sql.execute("CREATE TABLE public.user(\n" +
                "  id bigint NOT NULL,\n" +
                "  email character varying(255),\n" +
                "  middle_name character varying(255),\n" +
                "  name character varying(255),\n" +
                "  password character varying(255),\n" +
                "  role character varying(255),\n" +
                "  sex character varying(255),\n" +
                "  surname character varying(255),\n" +
                "  CONSTRAINT user_pkey PRIMARY KEY (id),\n" +
                "  CONSTRAINT email_unique UNIQUE (email)\n" +
                ")");
        // Выполняем SQL запрос
        ResultSet rs = sql.executeQuery("SELECT * FROM public.user");
        // Получаем результат
        while (rs.next()) {
            System.out.println(rs.getInt("id") + " - " +
                    rs.getString("email"));
        }
    }
}
