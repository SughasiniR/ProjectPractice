package maven_project.res_project;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	
	
	static Connection con;
	
		public static Connection createDbConnection() {
			
			try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/resproject","root","root");
			}
			catch(Exception e) {
				e.printStackTrace();
	        }

			return con;
	}
}

