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
	Random rd = new Random(); // 랜덤값 불러오는 기능 생성
	Scanner sc = new Scanner(System.in);

	VO vo = new VO();

	// sql문을 저장하는 변수
	String sql;

	// 회원 정보 insert 메소드
	public void getconn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2.DB연결
			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String user = "cgi_2_1_1022";
			String password = "smhrd1";
			conn = DriverManager.getConnection(url, user, password);

		} catch (Exception e) {
			// Exception 클래스는 어떠한 오류라도 발생했을시 catch해 주는 역할!
			System.out.println("연결 오류 발생");
			e.printStackTrace();

		}
	}

	// 데이터베이스를 종료하는 메소드
	public void close() {
		try {
			// 5.DB연결종료(사용한 객체를 역순으로 종료)
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
		// 하나의 기능이 시작되기 전에 꼭! 데이터베이스 연결 메소드 호출하기

		getconn();

		// 3.실행할 SQL문 작성
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

	public VO eat(int num) { // 먹는기능 구현
		// 먹기

//		System.out.print("현재 체력은 : " + vo.getHp() + "입니다 ");
//		// 현재 체력 표시
//
//		System.out.println(" 무엇을 드시겠습니까?? ");
//		System.out.print("1.독사과 2.사과 3.삼겹살 4.소고기 5.채소 6.다이어트 >> ");

		if (num == 1) {
			vo.setHp(0);
			System.out.println("사망 하셨습니다. ");
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

	public void sleep() { // 잠자는 기능 구현

		vo.setHp(vo.getHp() + 60);
		vo.setExp(vo.getExp() + 60);
		vo.setTurn(vo.getTurn() + 2);
		System.out.println(vo.getNick() + "이(가) 잠을 잡니다.");
		System.out.println(stat());
	}

	public VO exercise(int num) { // 운동 기능 구현

		if (num == 1) {
			System.out.println("헬스를 합니다. 으쌰라으쌰");
			vo.setHp(vo.getHp() + 60);
			vo.setExp(vo.getExp() + 60);
			vo.setTurn(vo.getTurn() + 2);
			System.out.println(vo.getHp());

		} else if (num == 2) {
			System.out.println("달리기를 합니다. 으쌰라으쌰");
			vo.setHp(vo.getHp() + 60);
			vo.setExp(vo.getExp() + 60);
			vo.setTurn(vo.getTurn() + 2);
			System.out.println(vo.getHp());
		} else if (num == 3) {
			System.out.println("공놀이를 합니다. 슛!!! 골~인!");
			vo.setHp(vo.getHp() + 60);
			vo.setExp(vo.getExp() + 60);
			vo.setTurn(vo.getTurn() + 2);
			System.out.println(vo.getHp());
		}

		System.out.println(stat());
		return vo;
	}

	public void adv() { // 모험기능 구현
		int ran = rd.nextInt(3) + 1;

		if (ran == 1) {// hp -30 exp +40
			System.out.println("으스스한 동굴을 탐험해보자");
			vo.setHp(vo.getHp() + 60);
			vo.setExp(vo.getExp() + 60);
			vo.setTurn(vo.getTurn() + 2);

		} else if (ran == 2) {
			System.out.println("벌레가 많은 밀림!!!");
			vo.setHp(vo.getHp() + 60);
			vo.setExp(vo.getExp() + 60);
			vo.setTurn(vo.getTurn() + 2);
		} else if (ran == 3) {
			System.out.println("드래곤 레어를 털어보자");
			vo.setHp(vo.getHp() + 60);
			vo.setExp(vo.getExp() + 60);
			vo.setTurn(vo.getTurn() + 2);
		}
		System.out.println(stat());
	}

	public void die() { // 죽는 기능 구현
		System.out.println(vo.getNick() + "이(가) 죽었습니다.");
	}

	public void print() { // 출력 기능 구현
		System.out.println("현재 상태는 " + all());
	}

	public String all() {
		return " [nick=" + vo.getNick() + ", lv=" + vo.getLv() + ", hp=" + vo.getHp() + ", exp=" + vo.getExp()
				+ ", turn=" + vo.getTurn() + "]";
	}

	public void fail() { // 출력 기능 구현
		System.out.println("돌발상황 발생");
	}

	public String stat() {
		return "[hp=" + vo.getHp() + ", exp=" + vo.getExp() + ", turn=" + vo.getTurn() + "]";
	}
}
