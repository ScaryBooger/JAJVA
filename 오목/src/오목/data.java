package 오목;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class data {
	Connection con=null;
	String url="jdbc:mysql://localhost:3306/5mok?useUnicode=true&characterEncoding=utf8";
	String id="root";
	String pw="1234";
	data(){	
		
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			con=DriverManager.getConnection(url,id,pw);
			System.out.println("연결성공");
		} catch (Exception e) {
			System.out.println("연결x");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	void addPlayer(String name) {
		String sql="insert into player values(null,?,?,?,?,?)";
		System.out.println(2);
		PreparedStatement ps = null;
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, 0);
			ps.setInt(3, 0);
			ps.setInt(4, 0);
			ps.setInt(5,0);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try{
				if(ps!=null&&!ps.isClosed())
					ps.close();			
			}catch(SQLException e){
				e.printStackTrace();
			}
		}				
	}
	void updatewincombo(String name,int wincombo) {
		String sql="update player set WINCOMBO=? WHERE NAME=?";
		System.out.println(2);
		PreparedStatement ps = null;
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, wincombo);
			ps.setString(2, name);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try{
				if(ps!=null&&!ps.isClosed())
					ps.close();
				
			}catch(SQLException e){
				e.printStackTrace();
			}
		}				
	}
	void updatewin(String name,int win) {
		String sql="update player set WIN=? WHERE NAME=?";
		System.out.println(2);
		PreparedStatement ps = null;
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, win);
			
			ps.setString(2,name);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try{
				if(ps!=null&&!ps.isClosed())
					ps.close();			
			}catch(SQLException e){
				e.printStackTrace();
			}
		}				
	}
	void updatedefult(String name,int defult) {
		String sql="update player set DEFEAT=? WHERE NAME=?";
		System.out.println(2);
		PreparedStatement ps = null;
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, defult);
			
			ps.setString(2,name);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try{
				if(ps!=null&&!ps.isClosed())
					ps.close();			
			}catch(SQLException e){
				e.printStackTrace();
			}
		}				
	}
	
	
	void updatedefultcombo(String name,int defultcombo) {
		String sql="update player set DEFEATCOMBO=? WHERE NAME=?";
		System.out.println(2);
		PreparedStatement ps = null;
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, defultcombo);
			ps.setString(2, name);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try{
				if(ps!=null&&!ps.isClosed())
					ps.close();			
			}catch(SQLException e){
				e.printStackTrace();
			}
		}				
	}
	Set getName() {
		String sql="select * from player";
		Set x=new HashSet();
		PreparedStatement ps;
	
		try {
			ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				x.add(rs.getString("NAME"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;						
	}
	int[] getWin() {
		String sql="select * from player";
		int win[]=new int[100];
		PreparedStatement ps;
		int i=0;
		try {
			ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				win[i]=rs.getInt("WIN");
				i++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return win;						
	}
	ArrayList<String> winrate() {// NVL(분자 / DECODE(분모, 0, NULL, 분모), 0)FROM 테이블;

		String sql="SELECT * FROM player WHERE WIN>0||DEFEAT>0 ORDER BY WIN*100/(WIN+DEFEAT) DESC ;";
		ArrayList<String>data=new ArrayList();
		PreparedStatement ps;
		double rate=0;
		try {
			ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				String total="";
				total+="이름:"+rs.getString("NAME");
				rate=rs.getInt("WIN")*100/(rs.getInt("WIN")+rs.getInt("DEFEAT"));
				total+="승률"+Double.toString(rate);
				data.add(total);		
		}
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return data;
		
	}

		
	
	ArrayList<String> win() {
		String sql="SELECT * FROM player ORDER BY WIN DESC;";
		ArrayList<String>data=new ArrayList();
		PreparedStatement ps;
		try {
			ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				String total="";
				total+="이름:"+rs.getString("NAME");
				total+="승:"+rs.getString("WIN");
				data.add(total);		
		}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return data;
		
	}
	ArrayList<String> wincombo() {
		String sql="SELECT * FROM player ORDER BY WINCOMBO DESC;";
		ArrayList<String>data=new ArrayList();
		PreparedStatement ps;
		double rate=0;
		try {
			ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				String total="";
				total+="이름:"+rs.getString("NAME");
				total+="연승:"+Integer.toString(rs.getInt("WINCOMBO"));
				data.add(total);		
		}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return data;
		
	}
	ArrayList<String> defultcombo() {
		String sql="SELECT * FROM player ORDER BY DEFEATCOMBO DESC;";
		ArrayList<String>data=new ArrayList();
		PreparedStatement ps;
		try {
			ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				String total="";
				total+="이름:"+rs.getString("NAME");
				total+="연패:"+Integer.toString(rs.getInt("DEFEATCOMBO"));
				data.add(total);		
		}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return data;
		
	}
	ArrayList<String>all(){
		String sql="select * from player";
		ArrayList<String> data=new ArrayList();
		PreparedStatement ps;
	
		try {
			ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				String total="";
				total+="이름:"+rs.getString("NAME");
				total+="승:"+Integer.toString(rs.getInt("WIN"));
				total+="패:"+Integer.toString(rs.getInt("DEFEAT"));
				total+="연승:"+Integer.toString(rs.getInt("WINCOMBO"));
				total+="연패:"+Integer.toString(rs.getInt("DEFEATCOMBO"));
				data.add(total);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;			
			
		
	}
	int getwincombo(String name) {
		String sql="select *from player where NAME=?";
		PreparedStatement ps;
		int wincombo=0;
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1,name);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				wincombo=rs.getInt("WINCOMBO");
			
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return wincombo;				
	}
	int getdefultcombo(String name) {
		String sql="select *from player where NAME=?";
		PreparedStatement ps;
		int defultcombo=0;
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1,name);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				defultcombo=rs.getInt("DEFEATCOMBO");
	
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return defultcombo;				
	}
	int getwin(String name) {
		String sql="select *from player where NAME=?";
		PreparedStatement ps;
		int win=0;
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1,name);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				win=rs.getInt("WIN");
			
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return win;				
	}
	int getdefult(String name) {
		String sql="select *from player where NAME=?";
		PreparedStatement ps;
		int defult=0;
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1,name);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				defult=rs.getInt("DEFEAT");
			
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return defult;				
	}
		

	
	public static void main(String[] args) {
		
	}

	
}
