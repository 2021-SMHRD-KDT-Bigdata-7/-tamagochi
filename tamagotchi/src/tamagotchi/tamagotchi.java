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
	
	//sql���� �����ϴ� ����
	String sql;
	
	// ȸ�� ���� insert �޼ҵ�
	public void getconn() {
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
	//2.DB����
		String url ="jdbc:oracle:thin:@192.168.1.230:1521:xe";
		String user ="sun";
		String password ="12345";
		conn = DriverManager.getConnection(url, user, password);
		
		}catch (Exception e) {
			// Exception Ŭ������ ��� ������ �߻������� catch�� �ִ� ����!
			System.out.println("���� ���� �߻�");
			e.printStackTrace(); 
		    
		
		}
	}
	// �����ͺ��̽��� �����ϴ� �޼ҵ�
	public void close() {
		try {
			//5.DB��������(����� ��ü�� �������� ����)
			if(rs != null) { rs.close(); }
			if(psmt != null) {psmt.close(); }
			if(conn != null) {conn.close(); }
			} catch (Exception e) {
				
				e.printStackTrace();
			}
	}
	public int insert(String id, String pw, String nick) {
		// �ϳ��� ����� ���۵Ǳ� ���� ��! �����ͺ��̽� ���� �޼ҵ� ȣ���ϱ�
		
		getconn();
		
		//3.������ SQL�� �ۼ�
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
		// �ϳ��� ����� ���۵Ǳ� ���� ��! �����ͺ��̽� ���� �޼ҵ� ȣ���ϱ�
		
		getconn();
		
		//3.������ SQL�� �ۼ�
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
	
	public void eat() { // �Դ±�� ����
		����ġ +, hp+, turn+
	}

	public void sleep() { // ���ڴ� ��� ����

	}

	public void exercise() { //� ��� ����

	}

	public void adv() { //������ ����

	}

	public void die() { //�״� ��� ����

	}
	
	public void print() { //��� ��� ����
		
	}
	public void fail() { //��� ��� ����
		System.out.println( "���߻�Ȳ �߻�");
	}

}
