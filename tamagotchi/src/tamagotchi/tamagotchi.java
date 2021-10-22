package tamagotchi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;
import java.util.Scanner;

public class tamagotchi {

	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	int result = 0;
	int num = 0;
	Random rd = new Random(); // ������ �ҷ����� ��� ����
	Scanner sc = new Scanner(System.in);

	VO vo = new VO();

	// sql���� �����ϴ� ����
	String sql;

	// ȸ�� ���� insert �޼ҵ�
	public void getconn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2.DB����
			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String user = "cgi_2_1_1022";
			String password = "smhrd1";
			conn = DriverManager.getConnection(url, user, password);

		} catch (Exception e) {
			// Exception Ŭ������ ��� ������ �߻������� catch�� �ִ� ����!
			System.out.println("���� ���� �߻�");
			e.printStackTrace();

		}
	}

	// �����ͺ��̽��� �����ϴ� �޼ҵ�
	public void close() {
		try {
			// 5.DB��������(����� ��ü�� �������� ����)
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public int insert(String id, String pw, String nick) {
		// �ϳ��� ����� ���۵Ǳ� ���� ��! �����ͺ��̽� ���� �޼ҵ� ȣ���ϱ�

		getconn();

		// 3.������ SQL�� �ۼ�
		sql = "insert into member values(?,?,?)";

		try {

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			psmt.setString(3, nick);
			result = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return result;

	}

	public VO eat(int num) { // �Դ±�� ����
		// �Ա�

//		System.out.print("���� ü���� : " + vo.getHp() + "�Դϴ� ");
//		// ���� ü�� ǥ��
//
//		System.out.println(" ������ ��ðڽ��ϱ�?? ");
//		System.out.print("1.����� 2.��� 3.���� 4.�Ұ�� 5.ä�� 6.���̾�Ʈ >> ");

		if (num == 1) {
			vo.setHp(0);
			System.out.println("��� �ϼ̽��ϴ�. ");
		} else if (num == 2) {
			vo.setHp(vo.getHp() + 30);
			vo.setExp(vo.getExp() + 60);
			vo.setTurn(vo.getTurn() + 2);

			System.out.println(vo.getHp());

		} else if (num == 3) {
			vo.setHp(vo.getHp() + 50);
			System.out.println(vo.getHp());

		} else if (num == 4) {
			vo.setHp(vo.getHp() + 60);
			System.out.println(vo.getHp());
		} else if (num == 5) {
			vo.setHp(vo.getHp() + 80);
			System.out.println(vo.getHp());

		} else if (num == 6) {
			vo.setHp(vo.getHp() - 50);
			System.out.println(vo.getHp());
		}
		System.out.println(stat());

		return vo;
	}

	public void sleep() { // ���ڴ� ��� ����

		vo.setHp(vo.getHp() + 60);
		vo.setExp(vo.getExp() + 60);
		vo.setTurn(vo.getTurn() + 2);
		System.out.println(vo.getNick() + "��(��) ���� ��ϴ�.");
		System.out.println(stat());
	}

	public VO exercise(int num) { // � ��� ����

		if (num == 1) {
			System.out.println("�ｺ�� �մϴ�. ���X�����X");
			vo.setHp(vo.getHp() + 60);
			vo.setExp(vo.getExp() + 60);
			vo.setTurn(vo.getTurn() + 2);
			System.out.println(vo.getHp());

		} else if (num == 2) {
			System.out.println("�޸��⸦ �մϴ�. ���X�����X");
			vo.setHp(vo.getHp() + 60);
			vo.setExp(vo.getExp() + 60);
			vo.setTurn(vo.getTurn() + 2);
			System.out.println(vo.getHp());
		} else if (num == 3) {
			System.out.println("�����̸� �մϴ�. ��!!! ��~��!");
			vo.setHp(vo.getHp() + 60);
			vo.setExp(vo.getExp() + 60);
			vo.setTurn(vo.getTurn() + 2);
			System.out.println(vo.getHp());
		}

		System.out.println(stat());
		return vo;
	}

	public void adv() { // ������ ����
		int ran = rd.nextInt(3) + 1;

		if (ran == 1) {// hp -30 exp +40
			System.out.println("�������� ������ Ž���غ���");
			vo.setHp(vo.getHp() + 60);
			vo.setExp(vo.getExp() + 60);
			vo.setTurn(vo.getTurn() + 2);

		} else if (ran == 2) {
			System.out.println("������ ���� �и�!!!");
			vo.setHp(vo.getHp() + 60);
			vo.setExp(vo.getExp() + 60);
			vo.setTurn(vo.getTurn() + 2);
		} else if (ran == 3) {
			System.out.println("�巡�� ��� �о��");
			vo.setHp(vo.getHp() + 60);
			vo.setExp(vo.getExp() + 60);
			vo.setTurn(vo.getTurn() + 2);
		}
		System.out.println(stat());
	}

	public void die() { // �״� ��� ����
		System.out.println(vo.getNick() + "��(��) �׾����ϴ�.");
	}

	public void print() { // ��� ��� ����
		System.out.println("���� ���´� " + all());
	}

	public String all() {
		return " [nick=" + vo.getNick() + ", lv=" + vo.getLv() + ", hp=" + vo.getHp() + ", exp=" + vo.getExp()
				+ ", turn=" + vo.getTurn() + "]";
	}

	public void fail() { // ��� ��� ����
		System.out.println("���߻�Ȳ �߻�");
	}

	public String stat() {
		return "[hp=" + vo.getHp() + ", exp=" + vo.getExp() + ", turn=" + vo.getTurn() + "]";
	}
}
