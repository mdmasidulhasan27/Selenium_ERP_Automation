package main.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PostgresqlJdbcConnection {
    //private static String dbUrl = "jdbc:postgresql://35.229.220.168:4550/sbicloud_bd";
    private static String dbUrl = "jdbc:postgresql://34.80.72.151:4560/sbicloud_bd"; //staging
    //private static String dbUrl = "jdbc:postgresql://10.42.53.111:4560/sbicloud_bd"; //8099


    public static Connection getPostgresqlConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager
                    .getConnection(dbUrl,
                            "bits", "biTS@#123");
            connection.setAutoCommit(false);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return connection;
    }

    public static void main(String[] args) {
        Statement stmt = null;
        try {
            stmt = getPostgresqlConnection().createStatement();
            ResultSet rs = stmt.executeQuery("select id from member_info where branch_info_id=43 and project_info_id=2 and domain_status_id=1 and member_status_id=1 order by id desc limit 10 offset 0;");
            //ResultSet rs = stmt.executeQuery("select id from office_info order by id desc limit 20");


            List<Long> memberIds = new ArrayList<>();
            while (rs.next()) {
                Long memberId = rs.getLong("id");
                System.out.println(memberId);
                memberIds.add(memberId);
            }
            rs.close();
            stmt.close();
            getPostgresqlConnection().close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

    }

    public static ResultSet getResultSet(String sqlQuery) {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = getPostgresqlConnection().createStatement();
            rs = stmt.executeQuery(sqlQuery);
            getPostgresqlConnection().close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Operation done successfully");

        return rs;
    }
}
