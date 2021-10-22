package tamagotchi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class tamagotchi {
	
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	int result = 0;
	
	//sql문을 저장하는 변수
	String sql;
	
	// 회원 정보 insert 메소드
	public void getconn() {
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
	//2.DB연결
		String url ="jdbc:oracle:thin:@192.168.1.230:1521:xe";
		String user ="sun";
		String password ="12345";
		conn = DriverManager.getConnection(url, user, password);
		
		}catch (Exception e) {
			// Exception 클래스는 어떠한 오류라도 발생했을시 catch해 주는 역할!
			System.out.println("연결 오류 발생");
			e.printStackTrace(); 
		    
		
		}
	}
	// 데이터베이스를 종료하는 메소드
	public void close() {
		try {
			//5.DB연결종료(사용한 객체를 역순으로 종료)
			if(rs != null) { rs.close(); }
			if(psmt != null) {psmt.close(); }
			if(conn != null) {conn.close(); }
			} catch (Exception e) {
				
				e.printStackTrace();
			}
	}
	public int insert(String id, String pw, String nick) {
		// 하나의 기능이 시작되기 전에 꼭! 데이터베이스 연결 메소드 호출하기
		
		getconn();
		
		//3.실행할 SQL문 작성
		sql = "insert into member values(?,?,?)";
		
		try {
		
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, id);
		psmt.setString(2, pw);
		psmt.setString(3, nick);
		result = psmt.executeUpdate();
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return result;
		
	}
	
	public int insert(String id, String pw, String nick) {
		// 하나의 기능이 시작되기 전에 꼭! 데이터베이스 연결 메소드 호출하기
		
		getconn();
		
		//3.실행할 SQL문 작성
		sql = "insert into member values(?,?,?)";
		
		try {
		
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, id);
		psmt.setString(2, pw);
		psmt.setString(3, nick);
		result = psmt.executeUpdate();
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return result;
		
	}
	
	public void eat() { // 먹는기능 구현
		경험치 +, hp+, turn+
	}

	public void sleep() { // 잠자는 기능 구현

	}

	public void exercise() { //운동 기능 구현

	}

	public void adv() { //모험기능 구현

	}

	public void die() { //죽는 기능 구현

	}
	
	public void print() { //출력 기능 구현
		
	}
	public void fail() { //출력 기능 구현
		System.out.println( "돌발상황 발생");
	}

}
