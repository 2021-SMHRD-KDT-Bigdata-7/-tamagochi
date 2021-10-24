package tamagotchi;

import java.util.Random;
import java.util.Scanner;

public class test2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		
		tamagotchi tama = new tamagotchi();
		
		String nick = null;
		
		int select = 0;
		int coin = 0;
		int eventNum = 0;
		
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
				System.out.println("개복치의 이름을 내놔라");
				nick = sc.next();
				
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
	while (coin == 1) { // 게임실행
		 // 랜덤수 생성해서 개복치모드 만들어야함
		
		eventNum = rd.nextInt(100) + 1; // 개복치 사망 담당할 랜덤수 지정
		
		if(eventNum <= 10) {
			
			while(true) {
				System.out.println(nick + "은 배가 고픔");
				System.out.println("[1] 상태확인 [2] 식사 주기 [3]운동하기 [4]잠자기 [5] 모험하기 ");
			
				select = sc.nextInt();
			
				if(select == 2) {
					System.out.println("배고픔 해결");
					tama.plusExp(10);
					tama.plusHp(10);
					break;
				} else {
					System.out.println("욕구해결 안됨");
					tama.plusHp(-5);
				}
			}
			
		} else if(eventNum >= 11 && eventNum <= 20) {
			
			while(true) {
				System.out.println(nick + "은 심심함");
				System.out.println("[1] 상태확인 [2] 식사 주기 [3]운동하기 [4]잠자기 [5] 모험하기 ");
			
				select = sc.nextInt();
			
				if(select == 3) {
					System.out.println("심심함 해결");
					tama.plusExp(15);
					
					break;
				} else {
					System.out.println("욕구해결 안됨");
					tama.plusHp(-5);
				}
			
			
		} else if(eventNum >= 21 && eventNum <= 30) {
			
			while(true) {
				System.out.println(nick + "졸림");
				System.out.println("[1] 상태확인 [2] 식사 주기 [3]운동하기 [4]잠자기 [5] 모험하기 ");
			
				select = sc.nextInt();
			
				if(select == 4) {
					System.out.println("졸림 해결");
					tama.plusExp(5);
					tama.plusHp(20);
					break;
				} else {
					System.out.println("욕구해결 안됨");
					tama.plusHp(-5);
				}
			
		} else if(eventNum >= 21 && eventNum <= 30) {
			
		} else if(eventNum >= 21 && eventNum <= 30) {
			
		} else if(eventNum >= 21 && eventNum <= 30) {
			 
		} else if(eventNum >= 21 && eventNum <= 30) {
			
		} else if(eventNum >= 21 && eventNum <= 30) {
			
		} else if(eventNum >= 21 && eventNum <= 30) {
			
		} else if(eventNum >= 21 && eventNum <= 30) {
			
		} else if(eventNum >= 21 && eventNum <= 30) {
			
		} else if(eventNum >= 21 && eventNum <= 30) {
	
		} else{
			System.out.println("[1] 상태확인 [2] 식사 주기 [3]운동하기 [4]잠자기 [5] 모험하기 [6] 종료하기 ");
			select = sc.nextInt();
			
			if(select == 6) {
				break;
			}
			
			
		}
		}
		
//		
//		
//		System.out.println("행동을 선택하세요");
//		System.out.println("[1] 상태확인 [2] 식사 주기 [3]운동하기 [4]잠자기 [5] 모험하기 [6] 종료하기 ");
//		
//		if (select == 1) {
//		tama.print();
//	
//      랜덤변수지정은 위치 지정 필요		
		
	}else if(select == 2) { //음식고르는 곳
  
  System.out.println("어떤 음식을 주시겠습니까.");
  select = sc.nextInt();
  
  tama.eat();
  
  
  
	if(eventNum = 35){
	System.out.println("가 독이 든 식사를 먹어버렸습니다.");
  tama.fail();
  tama.die();
 }else if(eventNum == 77){
 System.out.println("가 정말 먹고싶은 음식을 먹었습니다");
// * 경험치 추가부분 구현..
  }
  
   
  
  }else if (select == 3){
   System.out.println("어떤 운동을 하겠습니까? ");
   select = sc.nextInt();
   
   tama.exercise();
   
   if(eventNum = 35){
 	System.out.println("가 운동을 하다가 치명상을 입었습니다.");
   tama.fail();
   tama.die();
  }else if(eventNum == 77){
  System.out.println("오늘따라 운동이 재밌었음.");
 //*  경험치 추가부분 구현..
   
   } 
  
  }else if (select == 4){
  
  tama.sleep();
  
  }
  
  }else if(select==5)

	{
		select = sc.nextInt();
		System.out.println("어떤 모험을 할지 모르겠지만 두근두근함");

		tama.adv();

	}else
	{
		System.out.println("안녕~~~");
		break;
	}

}

}
