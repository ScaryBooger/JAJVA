package 오목;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class recorddata {
	Connection con=null;
	String url="jdbc:mysql://localhost:3306/5mok?useUnicode=true&characterEncoding=utf8";
	String id="root";
	String pw="1234";
	
    LocalDateTime now = LocalDateTime.now();
    
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분");

    
    String formatedNow = now.format(formatter);
	recorddata(){
		
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			con=DriverManager.getConnection(url,id,pw);
			System.out.println("연결성공");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	void addrecorddata(String record) {
		String sql="insert into record values(null,?)";
		String y=String.valueOf(record+"/"+formatedNow);
		PreparedStatement ps = null;
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1,y);
			ps.executeUpdate();
		}catch(Exception e) {}finally {
			try{
				if(ps!=null&&!ps.isClosed())
					ps.close();			
			}catch(SQLException e){
				e.printStackTrace();
			}
		}			
	}
	
	ArrayList<String> getrecorddata() {
		ArrayList<String> rdata=new ArrayList();
		String sql="select * from record";
		PreparedStatement ps;
		
		try {
			ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				rdata.add(rs.getString("MATCH"));
		
			}	
		} catch (SQLException e) {
		
			
			e.printStackTrace();
		}
		
		return rdata;
		
	}
	
	
	
	public static void main(String[] args) {
		//recorddata x=new recorddata();
		
		
	}
	
	
}
