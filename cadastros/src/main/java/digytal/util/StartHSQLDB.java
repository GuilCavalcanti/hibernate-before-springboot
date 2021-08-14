package digytal.util;

import org.hsqldb.util.DatabaseManagerSwing;

public class StartHSQLDB {
    public static String FILE_URL = "file:/temp/db/cadastros-db";
    public static String JDBC_FILE_URL = "jdbc:hsqldb:" + FILE_URL;
    public static void main(String[] args) {
        System.out.println(JDBC_FILE_URL);
        //local();
        server();
    }
    public static void local() {
        final String[] dbArgs = { "--user", "sa", "--password", "", "--url", JDBC_FILE_URL};
        DatabaseManagerSwing.main(dbArgs);
    }
    public static void server() {
        final String[] dbArgs = { "--database.0", FILE_URL, "--dbname.0", "cadastros-db", "--port", "5454" };
        org.hsqldb.server.Server.main(dbArgs);
    }
}
