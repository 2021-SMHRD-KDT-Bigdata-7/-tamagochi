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

	public int insert(String id, String pw) {
		// �ϳ��� ����� ���۵Ǳ� ���� ��! �����ͺ��̽� ���� �޼ҵ� ȣ���ϱ�

		getconn();

		// 3.������ SQL�� �ۼ�
		sql = "insert into user1 values(?,?)";

		try {

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);

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

		System.out.println("�޴��� ���ÿ�");
		System.out.println("[1],[2],[3]");
		
		int num3 = sc.nextInt();

		if (num == num3) {
			
				System.out.println("�߸Ծ����ϴ�");
				
				vo.setHp(vo.getHp() + 10);
				vo.setExp(vo.getExp() + 20);
				vo.setTurn(vo.getTurn() + 2);
				
		} else {
				System.out.println("���������ʾ�");
				
				vo.setHp(vo.getHp() - 5);
				vo.setExp(vo.getExp() + 0);
				vo.setTurn(vo.getTurn() + 2);
				
		}
		System.out.println(stat());

		return vo;
	}

	public void sleep() { // ���ڴ� ��� ����

		System.out.println(vo.getNick() + "��(��) ���� ��ϴ�.");
		plusHp(30);
		plusExp(10);
		plusTurn(4);
		System.out.println(stat());
	}

	public VO exercise(int num) { // � ��� ����


		System.out.println("�޴��� ���ÿ�");
		System.out.println("[1],[2],[3]");
		
		int num3 = sc.nextInt();

		if (num == num3) {
			
				System.out.println("�߸Ծ����ϴ�");
				
				vo.setHp(vo.getHp() + 10);
				vo.setExp(vo.getExp() + 20);
				vo.setTurn(vo.getTurn() + 2);
				
		} else {
				System.out.println("���������ʾ�");
				
				vo.setHp(vo.getHp() - 5);
				vo.setExp(vo.getExp() + 0);
				vo.setTurn(vo.getTurn() + 2);
				
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
		System.out.println(vo.getNick() + "��(��) �׾����ϴ�.");
		}
	public void gg() {
				
	}

	public void print() { // ��� ��� ����
		System.out.println("���� ���´� " + all());
		if (vo.getHp() == 0) {
			die();
		}
		
		
	}

	public String all() {
		if(vo.getLv() < 5) {
			
		}else if(vo.getLv() >= 5 && vo.getLv() < 10) {
			
		}else if(vo.getLv() >= 10) {
			
		}
		return " [nick=" + vo.getNick() + ", lv=" + vo.getLv() + ", hp=" + vo.getHp() + ", exp=" + vo.getExp()
		+ ", turn=" + vo.getTurn() + ", Day=" + vo.getDay() +"]";
	}
	public String stat() {
		return "[hp=" + vo.getHp() + ", exp=" + vo.getExp() + ", turn=" + vo.getTurn() + "]";
	}

	public VO plusExp(int num) { //�߰� ����ġ �ο�

		vo.setExp(vo.getExp() + num);
		if(vo.getExp() >= 100) {
			vo.setLv(vo.getLv() +1);
			vo.setExp(vo.getExp()%100);
		}
		
		return vo;
	}
	public VO plusHp(int num) { //�߰� ü�� �ο�
		
		vo.setHp(vo.getHp() + num);
		
		if(vo.getHp() > 100) {
			vo.setHp(100);
		}
		return vo;

	}
	public VO plusTurn(int num) { // �߰� �� ����

		vo.setTurn(vo.getTurn() + num);
		
		if(vo.getTurn() > 20) {
			vo.setDay(vo.getDay() + 1 );
			vo.setTurn(vo.getTurn() - 20);
		}
		return vo;
	}
}
