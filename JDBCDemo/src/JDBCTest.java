import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {

	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/JDBCDemo";
		Connection con = null;
//		String name ="Sumit";
//		String std = "14th";
//		String city = "Patna";
		
		//String sql = "insert into student(name,class,city) values(" + "'" + name+ "'" + "," + "'" + std + "'" + ","  + "'" + city + "'" +")";
		
		String fetchData= "select * from student";
		
		
		try {
			con = DriverManager.getConnection(url,"root","root");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(fetchData);
			System.out.println("Loading Data....");
			Thread.sleep(800);
			while (rs.next()) {
				
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));		
				Thread.sleep(600);
			}
			
		}catch (Exception e) {
			System.out.println(e);
			}finally {
				con.close();
			}
		

	}

}
