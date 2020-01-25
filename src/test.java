import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.regex.Pattern;

public class test {
	
	/*********************************************
	 * 数据库连接参数
	 *********************************************/
	private String JDBC_DRIVER;
	private String DB_URL;
	private String USER;
	private String PASS;
	Connection conn = null;
	Statement stmt = null;
	public static void main(String args[]) throws IOException {

	}
	/**********************
	 * 连接和关闭数据库
	 **************************/
	public void GetConnection() throws ClassNotFoundException, SQLException {
		/*
		 * 创建文件流将配置文件jdbc.properties的内容读入dbProperties
		 */
		Properties dbProperties = new Properties();
		InputStream PropertiesIn = test.class.getClassLoader()
				.getResourceAsStream("jdbc.properties");
		try {
			dbProperties.load(PropertiesIn);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		// 从dbProperties中读取数据库连接参数
		JDBC_DRIVER = dbProperties.getProperty("DRIVER");
		DB_URL = dbProperties.getProperty("URL");
		USER = dbProperties.getProperty("USER");
		PASS = dbProperties.getProperty("PASS");
		// 注册 JDBC 驱动
		Class.forName(JDBC_DRIVER);
		// 打开链接
		System.out.println("连接数据库...");
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
		stmt = conn.createStatement();
	}
	public void CloseConnection() {
		try { // 尝试关闭连接
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void dataInput() {
		FileInputStream
	}
}
