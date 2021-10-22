package tamagotchi;

import java.util.Scanner;

public class test2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		tamagotchi tama = new tamagotchi();

		System.out.print("[1] 로그인 [2] 회원가입 [3] 랭킹확인 [4] 종료");
			int select = sc.nextInt();
			
			if (select == 1) {
				System.out.print("아이디 입력 : ");
				String id = sc.next();
				
				System.out.println("비밀번호 입력");
				String pw = sc.next();
				
				tama.login(id, pw);
				
				
			
			}else if (select == 2 ) {
				System.out.print("로그인 아이디 생성 : ");
				String id = sc.next();
				
				System.out.print("패스워드 : ");
				String pw = sc.next();
				
				System.out.print("캐릭터 이름 : ");
				String nick = sc.next();
				
				tama.insert(id, pw, nick);
			}

		System.out.println("입력 1 : ");
		String id = sc.next();

		System.out.println("입력 2 : ");
		String pw = sc.next();

		System.out.println("입력 3 : ");
		String nick = sc.next();

		System.out.println(" 무엇을 드시겠습니까?? ");
		System.out.print("1.독사과 2.사과 3.삼겹살 4.소고기 5.채소 6.다이어트 >> "); // 음식 선택지.

//		vo.setNum(sc.nextInt());

		tama.eat(tama.num = sc.nextInt());
//		System.out.println(vo.getHp()+"+"+vo.getExp()+"+"+vo.getTurn());
//		System.out.println(tama.stat());

////////////////////////////////////////////////////////////////////////////////////////////////		
		tama.sleep();
		tama.adv();
		System.out.println("어떤운동?");
		tama.exercise(tama.num = sc.nextInt());
		tama.print();
	}

}
