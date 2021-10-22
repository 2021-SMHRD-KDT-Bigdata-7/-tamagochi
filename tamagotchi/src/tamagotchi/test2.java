package tamagotchi;

import java.util.Scanner;

public class test2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		tamagotchi tama = new tamagotchi();
		
		int select = 0;
		int coin = 0;
		
		while (true) {
			if (select == 0 ) {
				System.out.print("[1] 로그인 [2] 회원가입 [3] 랭킹확인 [4] 종료 >> ");
				select = sc.nextInt();
			
			if (select == 1) {
				System.out.print("아이디 입력 : ");
				String id = sc.next();

				System.out.print("비밀번호 입력 : ");
				String pw = sc.next();
				
				if (tama.login(id, pw)==1) {				
					System.out.println("환영합니다 "+id+" 님");
					coin = 1;
				}else {
					System.out.println("로그인 실패");
					select = 0;
				}
			} else if (select == 2) {
				System.out.print("로그인 아이디 생성 : ");
				String id = sc.next();

				System.out.print("패스워드 : ");
				String pw = sc.next();

				tama.insert(id, pw);
				
				System.out.println("캐릭터를 선택하세요");
				System.out.print("[1]개복치 [2]개복치 [3]개복치");
				int a = sc.nextInt();
				
				if (a == 1) {
					System.out.println("개복치 생성!!!");
				}else if(a == 2) {
					System.out.println("개복치 생성!!!!!");
				}else if(a == 3) {
					System.out.println("개복치 등장!!!");
				}else {
					System.out.println("그래도 개복치!!!");
				}
				
				
			} else if (select == 3) {

			} else if (select == 4) {
				System.out.println("진짜 갈거야?");
				System.out.print("[1]응 [2]아니 미안 ");
				int a = sc.nextInt();
				if(a == 1) {
					System.out.println("안녕~~~");
					break;
				}else if(a == 2){
					System.out.println("다시 선택해 주세요");
					select = 0;
				}
			} else {
				System.out.println("숫자를 다시 선택해주세요");
				select = 0;
			}
		    
//			System.out.println(" 무엇을 드시겠습니까?? ");
//			System.out.print("1.독사과 2.사과 3.삼겹살 4.소고기 5.채소 6.다이어트 >> "); // 음식 선택지.
//
//			tama.eat(tama.num = sc.nextInt());
//			tama.sleep();
//			tama.adv();
//			System.out.println("어떤운동?");
//			tama.exercise(tama.num = sc.nextInt());
//			tama.print();
		}
	}
//	while (coin == 1) { // 게임실행
//		// rd
//		System.out.println("행동을 선택하세요");
//		System.out.println("");
//		if ()
//		
//	}
	}

}
