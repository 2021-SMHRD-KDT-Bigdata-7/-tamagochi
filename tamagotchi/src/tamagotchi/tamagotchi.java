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

	public int login(String id, String pw) {
		getconn();

		sql = "select * from user1 where id = ? and pw = ?";

		try {

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			rs = psmt.executeQuery();
			if (rs.next()) {
				result = 1;

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}

	public int insert(String id, String pw, String nick) {
		// 하나의 기능이 시작되기 전에 꼭! 데이터베이스 연결 메소드 호출하기

		getconn();

		// 3.실행할 SQL문 작성
		sql = "insert into user1 values(?,?,?)";

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

		System.out.println("메뉴를 고르시오");
		System.out.println("[1],[2],[3]");
		
		int num3 = sc.nextInt();

		if (num == num3) {
			
				System.out.println("잘먹었습니다");
				
				vo.setHp(vo.getHp() + 10);
				vo.setEp(vo.getEp() + 20);
				vo.setTurn(vo.getTurn() + 2);
				
		} else {
				System.out.println("맘에들지않아");
				
				vo.setHp(vo.getHp() - 5);
				vo.setEp(vo.getEp() + 0);
				vo.setTurn(vo.getTurn() + 2);
				
		}
		System.out.println(stat());

		return vo;
	}

	public void sleep() { // 잠자는 기능 구현

		System.out.println(vo.getNick() + "이(가) 잠을 잡니다.");
		plusHp(30);
		plusEp(10);
		plusTurn(4);
		System.out.println(stat());
	}

	public VO exercise(int num) { // 운동 기능 구현


		System.out.println("메뉴를 고르시오");
		System.out.println("[1],[2],[3]");
		
		int num3 = sc.nextInt();

		if (num == num3) {
			
				System.out.println("잘먹었습니다");
				
				vo.setHp(vo.getHp() + 10);
				vo.setEp(vo.getEp() + 20);
				vo.setTurn(vo.getTurn() + 2);
				
		} else {
				System.out.println("맘에들지않아");
				
				vo.setHp(vo.getHp() - 5);
				vo.setEp(vo.getEp() + 0);
				vo.setTurn(vo.getTurn() + 2);
				
		}
		System.out.println(stat());

		return vo;
	}

	public void adv() { // 모험기능 구현
		int ran = rd.nextInt(3) + 1;

		if (ran == 1) {// hp -30 Ep +40
			System.out.println("으스스한 동굴을 탐험해보자");
			vo.setHp(vo.getHp() + 60);
			vo.setEp(vo.getEp() + 60);
			vo.setTurn(vo.getTurn() + 2);

		} else if (ran == 2) {
			System.out.println("벌레가 많은 밀림!!!");
			vo.setHp(vo.getHp() + 60);
			vo.setEp(vo.getEp() + 60);
			vo.setTurn(vo.getTurn() + 2);
			
		} else if (ran == 3) {
			System.out.println("드래곤 레어를 털어보자");
			vo.setHp(vo.getHp() + 60);
			vo.setEp(vo.getEp() + 60);
			vo.setTurn(vo.getTurn() + 2);
		}
		System.out.println(stat());
	}

	public void die() { // 죽는 기능 구현
		
		System.out.println("                         .");
		System.out.println("                   .$@######@$.");
		System.out.println("                .,=#=.      .##=,. ");
		System.out.println("               .=#-            -#=.");
		System.out.println("              .=$-              ,$*.");
		System.out.println("              !$-                ,==,");
		System.out.println("             ,=~                  -$*.");
		System.out.println("             !=,                   -*~  ");
		System.out.println("            -=:                     ;; ");
		System.out.println("            ;=,                     ;=- ");
		System.out.println("            ;;   :!!!!      !!!!:   -=;~!!!!. ");
		System.out.println("    .!!!!~  ;;  :#@@@@*    *@@@@#:   ;**!~~$*.");
		System.out.println("   .=$~~!#~ ;;  *@@@@@@*  *@@@@@@#:  ;#;.  -$,");
		System.out.println("   .#,  .;! ;; :#@@@@@@@  @@@@@@@@!  ;@:    =,");
		System.out.println("   .$    ~! ;; !@@@@@@@@  @@@@@@@@!  ;@!.   =$=.");
		System.out.println("   .$   -#! ;; .=@@@@@@@  @@@@@@@@! ~#@#~   .,#$");
		System.out.println("   .@*  ~@@$#;  *@@@@@@,  ,@@@@@@*  :@;.      .# ");
		System.out.println("  .@$      ;@@:  =@@@@,    .@@@@=   :;         # ");
		System.out.println("  .$         !:                    :@;  !@~   $@ ");
		System.out.println("  .$    ~=,  ;@~                   :!~$#$-*@-$@.");
		System.out.println("  .$..  ~###!.*:        @@@       :@@#:    *##.  ");
		System.out.println("   =$=,;!. ~$$#@:       @@#      :@$: ");
		System.out.println("    .==;      :$@:      ===     :@;");
		System.out.println("                ;#~            -#; ");
		System.out.println("               ,~$!.           -$~~,       -~.");
		System.out.println("     ~~-     ,~==#!.-. ~  ~  ~ -#!==~,   -:=$!~");
		System.out.println("   :;$*$-  ,:==!,=!.$, @  @ .$ -= ,!=*::,**~~;#.");
		System.out.println("  .#;-.*$:;;;;,  =!.$, @  @ .$ -=   ,;;$=!,   $; ");
		System.out.println("  !*   -@=:-   ~;#*.$, @  @ .$ -#;~    -:,    $@");
		System.out.println("  #,   .:-   ~!$!$#,$, @  @ .$ -$:;!!-        $: ");
		System.out.println(" *!      ,;*=!~.-$=@, @  @ .$.== ,~*$*!,    !: ");
		System.out.println("  ,$*!.  .;*--.   ,$@==@==@==@=$,   .--*$-   :* ");
		System.out.println("   ,~$    ;;       ,-----------,       .=~    #.");
		System.out.println("    ,=    :;                            !~   *@.");
		System.out.println("    ,@*   :;                            !#- ,$- ");
		System.out.println("     -@$=#!                              *###- ");
		System.out.println("      -@#;     ");										
		System.out.println(vo.getNick() + "이(가) 죽었습니다.");
		}
	public void gg() {
				
	}

	public void print() { // 출력 기능 구현
		System.out.println("현재 상태는 " + all());
		if (vo.getHp() == 0) {
			die();
		}
		
		
	}

	public String all() {
		if(vo.getLv() < 5) {
			
		}else if(vo.getLv() >= 5 && vo.getLv() < 10) {
			
		}else if(vo.getLv() >= 10) {
			
		}
		return " [nick=" + vo.getNick() + ", lv=" + vo.getLv() + ", hp=" + vo.getHp() + ", ep=" + vo.getEp()
		+ ", turn=" + vo.getTurn() + ", days=" + vo.getDays() +"]";
	}
	public String stat() {
		return "[hp=" + vo.getHp() + ", Ep=" + vo.getEp() + ", turn=" + vo.getTurn() + "]";
	}

	public VO plusEp(int num) { //추가 경험치 부여

		vo.setEp(vo.getEp() + num);
		if(vo.getEp() >= 100) {
			vo.setLv(vo.getLv() +1);
			vo.setEp(vo.getEp()%100);
		}
		
		return vo;
	}
	public VO plusHp(int num) { //추가 체력 부여
		
		vo.setHp(vo.getHp() + num);
		
		if(vo.getHp() > 100) {
			vo.setHp(100);
		}
		return vo;

	}
	public VO plusTurn(int num) { // 추가 턴 구현

		vo.setTurn(vo.getTurn() + num);
		
		if(vo.getTurn() > 20) {
			vo.setDays(vo.getDays() + 1 );
			vo.setTurn(vo.getTurn() - 20);
		}
		return vo;
	}
	
	public VO save() {
		
		getconn();

		sql = "Update tamagotchi set in (ep = ? ,lv = ? ,hp = ?,days = ?) where nick = ? ";
		
		try {

			psmt = conn.prepareStatement(sql);
						
			psmt.setString(1, vo.getNick());
			psmt.setInt(2, vo.getEp());
			psmt.setInt(3, vo.getLv());
			psmt.setInt(4, vo.getHp());
			psmt.setInt(5, vo.getDays());
			

			result = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
		
	}
}
