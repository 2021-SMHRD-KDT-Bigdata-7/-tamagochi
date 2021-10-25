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

	public void select(String id) {

		getconn();

		try {
			sql = "select * from tamagotchi where id=?";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();

			while (rs.next()) {
				vo.setNick(rs.getString(1));
				vo.setEp(rs.getInt(2));
				vo.setLv(rs.getInt(3));
				vo.setHp(rs.getInt(4));
				vo.setDays(rs.getInt(5));
				vo.setTurn(rs.getInt(6));
				vo.setId(rs.getString(7));
				print();

			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			close();

		}

	}

	public String Nick() {
		return vo.getNick();

	}

	public int insert(String id, String pw, String nick) {
		// �ϳ��� ����� ���۵Ǳ� ���� ��! �����ͺ��̽� ���� �޼ҵ� ȣ���ϱ�

		getconn();

		// 3.������ SQL�� �ۼ�
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

	public int insert2(String nick, int ep, int lv, int hp, int days, int turn, String id) {
		// �ϳ��� ����� ���۵Ǳ� ���� ��! �����ͺ��̽� ���� �޼ҵ� ȣ���ϱ�

		vo.setNick(nick);
		vo.setEp(ep);
		vo.setLv(lv);
		vo.setHp(hp);
		vo.setDays(days);
		vo.setTurn(turn);
		vo.setId(id);
		getconn();

		// 3.������ SQL�� �ۼ�
		sql = "insert into tamagotchi values(?,?,?,?,?,?,?)";

		try {

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, nick);
			psmt.setInt(2, ep);
			psmt.setInt(3, lv);
			psmt.setInt(4, hp);
			psmt.setInt(5, days);
			psmt.setInt(6, turn);
			psmt.setString(7, id);

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
		System.out.print("[1] ���, [2] ��ä, [3] ���� ");

		int num3 = sc.nextInt();
		System.out.println();

		if (num == num3) {
			System.out.println("                   .;,                  \r\n"
					+ "             :$$$~$$*$$$$=-             \r\n"
					+ "         ~$$$$. ~$-   =- ;$.            \r\n"
					+ "        *$~~$             :$$=.         \r\n"
					+ "       .$                    =$         \r\n"
					+ "       *$          -!;        =:        \r\n"
					+ "     .$=*          $*=!       *$$.      \r\n"
					+ "     =*              ;=         ;$      \r\n"
					+ "     $                           $~     \r\n"
					+ "     $    ===                    $=     \r\n"
					+ "   :$=    $;:             ~$$~   :*=    \r\n"
					+ "   $.     $=                ~$    -$    \r\n"
					+ "   $.                       !~    !=    \r\n"
					+ "  ,$$:.                         .:$$,   \r\n"
					+ "   $-=$$$=!;;~,.        ,~;;!=$$$=~$    \r\n"
					+ "   $     :***=$$$$$$$$$$$=***;.   :=    \r\n"
					+ "   $.                             !=    \r\n"
					+ "   =;                             $,    \r\n"
					+ "   -$                             $     \r\n"
					+ "    $.                           **     \r\n"
					+ "    =!                           $-     \r\n"
					+ "     $                          ;=      \r\n"
					+ "     !$                         $       \r\n"
					+ "      $*                       $!       \r\n"
					+ "       $*                     *$        \r\n"
					+ "       .$=                   =$         \r\n"
					+ "         *$*-             ,!$!          \r\n"
					+ "           *$$,         .$$$.           \r\n"
					+ "             *!         ,$              \r\n"
					+ "             ;=         -$              \r\n"
					+ "             ;$!!!!!!!!!*$              \r\n"
					+ "              ***********-              \r\n"
					+ "");

			System.out.println("�߸Ծ����ϴ�");

			plusHp(10);
			plusEp(20);
			plusTurn(2);

		} else {

			System.out.println("���������ʾ�");

			plusHp(-5);
			plusEp(0);
			plusTurn(2);

		}
		System.out.println();
		System.out.println(stat());

		return vo;
	}

	public void sleep() { // ���ڴ� ��� ����

		System.out.println(vo.getNick() + "��(��) ���� ��ϴ�.");
		plusHp(30);
		plusEp(10);
		plusTurn(4);
		System.out.println("    .~,                                           \r\n"
				+ "    ;#*.                                          \r\n"
				+ "    *@$,                                          \r\n"
				+ "    *@$,                                          \r\n"
				+ "    *@$,                                          \r\n"
				+ "    *@$,                                          \r\n"
				+ "    *@$,                                          \r\n"
				+ "    *@$,.,----,.                         .;:.     \r\n"
				+ "    *@$~*$$$$$$=:.                       ~#$-     \r\n"
				+ "    *@#$#=*****$$~                       :@#~     \r\n"
				+ "    *@@@#~....,!#;.                      :@@~     \r\n"
				+ "    *@@@#*;;;;;=@=;;;;;;;;;;;;;;;;;;;;:-.:@@~     \r\n"
				+ "    *@@@###$$$####$$$$$$$$$$$$$$$$$$$$$=:;@@~     \r\n"
				+ "    *@#;::::::::::::::::::::::::::::::;$$=@@~     \r\n"
				+ "    *@#-.............................,,!@#@@~     \r\n"
				+ "    *@@=*******************************=@@@@~     \r\n"
				+ "    *@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@~     \r\n"
				+ "    *@@$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$#@@~     \r\n"
				+ "    *@#-,...............................,;@@~     \r\n"
				+ "    *@$,                                 :@@~     \r\n"
				+ "    *@$,                                 :@@~     \r\n"
				+ "    *@$.                                 :@#~     \r\n"
				+ "    :!;.                                 -!!- ");
		System.out.println(stat());
	}

	public VO exercise(int num) { // � ��� ����

		System.out.println("�޴��� ���ÿ�");
		System.out.print("[1] ������, [2] ����, [3] �迵 ");

		int num3 = sc.nextInt();
		System.out.println();

		if (num == num3) {
			System.out.println("       ,~            :        \r\n"
					+ "      ,@@:          *@@,      \r\n"
					+ "      ,@@;          #@@,      \r\n"
					+ "   ~*-,@@;          #@@,-*-   \r\n"
					+ "   $@@,@@;          #@@,@@$   \r\n"
					+ "   $@@,@@;          #@@,@@$   \r\n"
					+ "   $@@,@@@##########@@@,@@$   \r\n"
					+ " !!$@@,@@@@@@@@@@@@@@@@,@@$#: \r\n"
					+ " !!$@@,@@@@@@@@@@@@@@@@,@@$#~ \r\n"
					+ "   $@@,@@#$$$$$$$$$$@@@,@@$   \r\n"
					+ "   $@@,@@;          #@@,@@$   \r\n"
					+ "   $@@,@@;          #@@,@@$   \r\n"
					+ "   ~:-,@@;          #@@,-:-   \r\n"
					+ "      ,@@;          #@@,      \r\n"
					+ "      ,@@:          *@@,      \r\n"
					+ "");
			System.out.println("��ſ� �~");

			plusHp(10);
			plusEp(20);
			plusTurn(2);

		} else {

			System.out.println("���������ʾ�");

			plusHp(-5);
			plusEp(0);
			plusTurn(2);

		}
		System.out.println();
		System.out.println(stat());

		return vo;
	}

	public void adv() { // ������ ����
		int ran = rd.nextInt(5) + 1;

		if (ran == 1) {// hp -30 Ep +40
			System.out.println("�������� ������ Ž���غ���");
			plusHp(-40);
			plusEp(50);
			plusTurn(6);

		} else if (ran == 2) {
			System.out.println("������ ���� �и�!!!");
			plusHp(-30);
			plusEp(40);
			plusTurn(6);

		} else if (ran == 3) {
			System.out.println("�巡�� ��� �о��");
			plusHp(-50);
			plusEp(60);
			plusTurn(6);
		} else if (ran == 4) {
			System.out.println("���������� ������");
			plusHp(-55);
			plusTurn(6);
			System.out.println("                                   \r\n"
					+ "               !-                       \r\n" + "               ,#.                      \r\n"
					+ "                :;            ,*        \r\n" + "                .*            !@        \r\n"
					+ "                ,@:    .!@;   ~=        \r\n" + "                .#=,   *@@@.  ;,        \r\n"
					+ "                 :@#$; #@@$.  *.        \r\n" + "      .=         .=@@@$@@@~  ~@.        \r\n"
					+ "       #-    .    .#@@@@@#;- !;         \r\n" + "       ##!*!*=:    #@@@@@@@#*@~         \r\n"
					+ "       #@@@@@@@$   #@@@@@@@@@*.         \r\n" + "       :~,=##@@@# ;@@@@@@=;,            \r\n"
					+ "             :#@@!=@@@@@!               \r\n" + "              -#@@@@@@@@                \r\n"
					+ "            -=#@@@@@@@@,                \r\n" + "           #@@@@@@@@@@#.                \r\n"
					+ "          :@@@@@@@@@@@:                 \r\n" + "          *@$--=@@@@#;~                 \r\n"
					+ "         -@@    .$@@:                   \r\n" + "         ~@=                            \r\n"
					+ "         ;$.                            \r\n" + "       :$#:                             \r\n"
					+ "      !@##-                    ");
		} else if (ran == 5) {
			System.out.println("�������� ����");
			plusHp(-30);
			plusTurn(3);
			System.out.println("                         ,-!!!!~-    \r\n"
					+ "                    ,~,             ,*.      .*-  \r\n"
					+ "                  .:.  ,~,         ~-          ~~ \r\n"
					+ "           ~:     ,       :       ;             ,,\r\n"
					+ "     ,.   :  .    .       ..    .~.             .,\r\n"
					+ "     ,.  . ,.     .        -   .:               .,\r\n"
					+ "    .   .         -.       ,   -                ;.\r\n"
					+ "    ,  -          ..       .  ~,               ~- \r\n"
					+ "                   !         -                :-  \r\n"
					+ "      ;,:.         ..     .  ~              .:.   \r\n"
					+ "    ,:   ,,.,,.     -     . ~             .~~     \r\n"
					+ "  - :     : ..-*.   -     .,.            --.      \r\n"
					+ " . ,       ,    ~:.  -. . .,  .        ~~         \r\n"
					+ ",  ;  **   :      *   . - ,  ,   .   ~-           \r\n"
					+ ".:=- -$;.  -      .!  ,~!:, ,. ., ,~-             \r\n"
					+ " =$! ~$$; .        .::  !!..,,...,****-.          \r\n"
					+ ",!$$ .$$- ,         :   !*,:..    ===**~-         \r\n"
					+ "  ~ , ,- .          :   !===*,    =====; .,       \r\n"
					+ "  ,.  ;:.           :   !====-    =====!   .      \r\n"
					+ "         ,.         :   !====-    =====!    -     \r\n"
					+ "        ,~.         ~   !====-    =====!    ;.    \r\n"
					+ " ,  ~..;-          .~   !====,    =====:    *:    \r\n"
					+ "  .               .$    *====.    ==$==-    *!,,. \r\n"
					+ "   .              ==    =$$$=     $=$$=.    =$$,  \r\n"
					+ "    ,.          :==-   .$=$$=    .==$$=     =:    \r\n"
					+ "      :... ...~$$$$    -=$$=:    :$$$$$     =.    \r\n"
					+ "        ,,..,, *$$!-   *$$=$     !$$$=*    -,     \r\n"
					+ "             ..-*$;,. .$$$==     *$$$$:   ..      \r\n"
					+ "                 *,   :$$$$;    ,$$$$$~  ,.       \r\n"
					+ "             ,,,..,.. *$$$$~    -$$$$$,,,         \r\n"
					+ "              ,~     ~==$$=     =$$$=*.           \r\n"
					+ "                       .,--,,--,~--,              ");
		} else if (ran == 6) {
			System.out.println("�ٸ� ��ħ");
			plusHp(-40);
			plusTurn(4);
			System.out.println("                 .######=!!    ~#:   #            \r\n"
					+ "                 ;###########:~ =#~!*;            \r\n"
					+ "                :#################$$~             \r\n"
					+ "                $################$=#              \r\n"
					+ "        ~~    .$#################$=#              \r\n"
					+ "       ;=!$,.-!*,**$#############$=#              \r\n"
					+ "       *  *,#;,- ,, ,############$=#              \r\n"
					+ "       $ :- !- = .$   $~:########$=#              \r\n"
					+ "       ! ;  *  =  $,.=,   ;!!###$$=#              \r\n"
					+ "       ,#,  =  =  ~~$,    ;.  =$=$=$              \r\n"
					+ "        ;-  -  =   #.     ;   $,!$=#              \r\n"
					+ "         =-$.  = ;!,      ;   ! !$=$              \r\n"
					+ "          =#   =!;        ;  !; !$=$              \r\n"
					+ "           .$$$#          !  !  *$=#              \r\n"
					+ "             .            =  $  *$$#              \r\n"
					+ "                          $=$*  !###              \r\n"
					+ "                         =$$:-  ;##$              \r\n"
					+ "                         ,.     .,,          ");
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
		save();

	}

	public boolean gg() {
		if (vo.getHp() <= 0) {
			die();
			return false;
		}
		return true;
	}

	public void print() { // ��� ��� ����
		System.out.println("���� ���´� " + all());
//		if (vo.getHp() <= 0) {
//			gg();
//		}

	}
	public void print2() {
		if (vo.getLv() < 5) {
			System.out.println("         ,,!        \r\n"
					+ "         .. ;       \r\n"
					+ "         -@$        \r\n"
					+ "         -@*        \r\n"
					+ "         -@*        \r\n"
					+ "         ,@*        \r\n"
					+ "     ~*@@@@@@~      \r\n"
					+ "    ,--=@@@@@@@,,   \r\n"
					+ "   ;@#:.:@@@@:.-    \r\n"
					+ "  ~@@=~.~@@@#; :$   \r\n"
					+ "  $@#=*;*#@-  .!#-  \r\n"
					+ "  @@@$==$@#==$#@;:  \r\n"
					+ " *@@@@@@@#.*==$@@@  \r\n"
					+ " $@@@@@@@@,    @@@  \r\n"
					+ " $@@@@@@@@@   !@@@  \r\n"
					+ " *@@@@@@@@@#*$@@@@  \r\n"
					+ "  @@@@@@@@@@@@@@@#  \r\n"
					+ "  *@@@@@$=====$@@~  \r\n"
					+ "  -@@@@========$@-  \r\n"
					+ "    @#==========-   \r\n"
					+ "    ,$=========~    \r\n"
					+ "      -$*****;");

		} else if (vo.getLv() >= 5 && vo.getLv() < 10) {
			System.out.println("   !* ");
			System.out.println("   #@ ");
			System.out.println("   ..                         ~##  ");
			System.out.println("              -;$@@@@#!:.   .=@@*");
			System.out.println("             $@@=-..-!@@@;  $@-@: ");
			System.out.println("    -$~    ~#$~        ,;@$!#.:@.");
			System.out.println("    ~@;   :@* ,-         .#@! !# ");
			System.out.println("     ,   ,@;  #@.         ~@- $:");
			System.out.println("         ~@-  ;;          -@- #~");
			System.out.println("          =@,             =@; *= ");
			System.out.println("           *@;          ,=#$$ ;@ ");
			System.out.println("            ;@@;      -#@#. @=-@-");
			System.out.println("             .:#@@$#@@@*~   -@$@; ");
			System.out.println("                 -::-        .=##  ");
			System.out.println("                               .,     ");

		} else if (vo.getLv() >= 10) {
			System.out.println("                      ~,      ");
			System.out.println("                     - -");
			System.out.println("                    ,  ;      ");
			System.out.println("                   :  ,;");
			System.out.println("                  :  .-;");
			System.out.println("                 !,--~;;");
			System.out.println("            !!!!    ;;;!");
			System.out.println("         .;.            ..; ");
			System.out.println("         .;.            ..; ");
			System.out.println("     ~.      ,~~          .-;");
			System.out.println("    -        ---;-        .,,,");
			System.out.println(" !. .   @#  ! ~ ;!         ,--");
			System.out.println("..!!    $=  ! ,.~;        ,,~-");
			System.out.println(".,          ! ,-;;       ,--;,");
			System.out.println(" :            --;! .. . .-,,-:");
			System.out.println(" , ..    ... .!;      ..,,-,-;");
			System.out.println(" -   .         ..   ...-,,,-~~");
			System.out.println(" ;,.      ...........,,----,~,");
			System.out.println(" ;;!.           ,.----,,,--.--");
			System.out.println(" :!~-.          ...........,:,");
			System.out.println("    !......................~!");
			System.out.println("     ;~.................~~~~:");
			System.out.println("       ~~~.........~~~~~~~~~~");
			System.out.println("        ..!:~:~~~~~~~~~~~~;.");
			System.out.println("           ,-~;;;;;;;;;;;, ");
			System.out.println("                  ~~~~;;; ");
			System.out.println("                   :. ~;;");
			System.out.println("                    ; .;:");
			System.out.println("                     -.;");
			System.out.println("                      ~!");

		}
		
	}

	public String all() {
		
		return " [nick=" + vo.getNick() + ", lv=" + vo.getLv() + ", hp=" + vo.getHp() + ", ep=" + vo.getEp() + ", turn="
				+ vo.getTurn() + ", days=" + vo.getDays() + "]";
	}

	public String stat() {
		return "[hp=" + vo.getHp() + ", Ep=" + vo.getEp() + ", turn=" + vo.getTurn() + "]";
	}

	public VO plusEp(int num) { // �߰� ����ġ �ο�

		vo.setEp(vo.getEp() + num);
		if (vo.getEp() >= 100) {
			vo.setLv(vo.getLv() + 1);
			vo.setEp(vo.getEp() % 100);
		}

		return vo;
	}

	public VO plusHp(int num) { // �߰� ü�� �ο�

		vo.setHp(vo.getHp() + num);

		if (vo.getHp() > 100) {
			vo.setHp(100);
		}
		return vo;

	}

	public VO plusTurn(int num) { // �߰� �� ����

		vo.setTurn(vo.getTurn() + num);

		if (vo.getTurn() > 20) {
			vo.setDays(vo.getDays() + 1);
			vo.setTurn(vo.getTurn() - 20);
		}
		return vo;
	}

	public VO save() {

		getconn();

		sql = "Update tamagotchi set ep = ? ,lv = ? ,hp = ?, days = ?, turn = ?, id=? where nick = ? ";

		String nick = vo.getNick();
		int ep = vo.getEp();
		int lv = vo.getLv();
		int hp = vo.getHp();
		int days = vo.getDays();
		int turn = vo.getTurn();
		String id = vo.getId();

		try {

			psmt = conn.prepareStatement(sql);

			psmt.setInt(1, ep);
			psmt.setInt(2, lv);
			psmt.setInt(3, hp);
			psmt.setInt(4, days);
			psmt.setInt(5, turn);
			psmt.setString(6, id);
			psmt.setString(7, nick);

			result = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;

	}
}
