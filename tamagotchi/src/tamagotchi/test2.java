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
		boolean run2 = true;

		
		
		while (true) {
			if (select == 0) {
				System.out.print("[1] 로그인 [2] 회원가입 [3] 종료 >> ");
				select = sc.nextInt();

				if (select == 1) {
					System.out.print("아이디 입력 : ");
					String id = sc.next();

					System.out.print("비밀번호 입력 : ");
					String pw = sc.next();

					if (tama.login(id, pw) == 1) {
						System.out.println("환영합니다 " + id + " 님");
						coin = 1;
						tama.select(id);
						break;
					} else {
						System.out.println("로그인 실패");
						select = 0;
					}
				} else if (select == 2) {
					
					System.out.print("로그인 아이디 생성 : ");
					String id = sc.next();

					System.out.print("패스워드 : ");
					String pw = sc.next();

					
					System.out.println("캐릭터를 선택하세요");
					System.out.print("[1]개복치 [2]개복치 [3]개복치");
					int a = sc.nextInt();
					System.out.println("개복치의 이름을 내놔라");
					nick = sc.next();
					
					tama.insert(id, pw, nick);
					tama.insert2(nick, 0, 1, 100, 1, 1,id);
					

					if (a == 1) {
							System.out.println("개복치 생성!!!");
						} else if (a == 2) {
							System.out.println("개복치 생성!!!!!");
						} else if (a == 3) {
							System.out.println("개복치 등장!!!");
						} else {
							System.out.println("그래도 개복치!!!");
						}
						System.out.println("환영합니다 " + id + " 님");
						coin = 1;
						
					
					break;

				}  else if (select == 3) {
					System.out.println("진짜 갈거야?");
					System.out.print("[1]응 [2]아니 미안 ");
					int a = sc.nextInt();
					if (a == 1) {
						System.out.println("안녕~~~");
						break;
					} else if (a == 2) {
						System.out.println("다시 선택해 주세요");
						select = 0;
					}
				} else {
					System.out.println("숫자를 다시 선택해주세요");
					select = 0;
				}
			}
		}
		while (coin == 1) { // 게임실행
		
			// 랜덤수 생성해서 개복치모드 만들어야함

				nick=tama.Nick();		
				run2 = tama.gg();

				if(run2 == false) {
					tama.save();
					System.out.println("저장 완료");
					break;
				} else {
					eventNum = rd.nextInt(100) + 1; // 개복치 사망 담당할 랜덤수 지정
				
					if (eventNum <= 10) {
				
						System.out.println("돌발 상황 발생!!!");

						while (run2) {
							run2 = tama.gg();
							if(run2 == false) {
							break;
								}
						System.out.println(nick + "은 배가 고픔");
						System.out.println();
						System.out.println("첫번째 while");
						System.out.print("[1] 식사주기 [2] 운동하기 [3]잠자기 >> ");
						System.out.println();

						select = sc.nextInt();
	
						if (select == 1) {
							System.out.println("배고픔 해결");
							tama.plusEp(10);
							tama.plusHp(10);
							tama.print();
							break;
						} else {
							System.out.println("욕구해결 안됨");
							tama.plusHp(-50);
							tama.print();
						}
					}System.out.println();
	
				} else if (eventNum >= 11 && eventNum <= 20) {
					
					System.out.println("돌발 상황 발생!!!");
	
					while (run2) {
						run2 = tama.gg();
						if(run2 == false) {
							break;
						}
						System.out.println(nick + "은 심심함");
						System.out.println();
						System.out.println("두번째 while");
						System.out.print("[1] 식사주기 [2] 운동하기 [3]잠자기 >> ");
						System.out.println();
	
						select = sc.nextInt();
	
						if (select == 2) {
							System.out.println("심심함 해결");
							tama.plusEp(15);
							tama.print();
	
							break;
						} else {
							System.out.println("욕구해결 안됨");
							tama.plusHp(-50);
							tama.print();
						}
					}System.out.println();
					
				} else if (eventNum >= 21 && eventNum <= 30) {
					
					System.out.println("돌발 상황 발생!!!");
	
					while (run2) {
						run2 = tama.gg(); // -> false
						
						if(run2 == false) {
							break;
						}
						System.out.println(nick + "졸림");
						System.out.println();
						System.out.println("세번째 while");
						System.out.print("[1] 식사주기 [2] 운동하기 [3]잠자기 >> ");
						System.out.println();
	
						select = sc.nextInt();
	
						if (select == 3) {
							System.out.println("졸림 해결");
							tama.plusEp(5);
							tama.plusHp(20);
							tama.print();
							
							break;
						} else {
							System.out.println("욕구해결 안됨");
							tama.plusHp(-50);
							tama.print();
						}
					}System.out.println();
	
				}else if (eventNum == 31 ) {
	
				}else if(eventNum==100) {
					
				}
					
				if ( run2 == false ) {
					System.out.print("[1] 상태확인 [2] 종료 ");
					select = sc.nextInt();
					
					if (select == 1) {
	
						tama.print();
	
					} else if (select == 2) {
						
						tama.save();
						System.out.println("저장 완료");
						break;
					}	
				} else {
	
				System.out.print("[1] 상태확인 [2] 식사 주기 [3]운동하기 [4]잠자기 [5] 모험하기 [6] 종료하기 ");
				select = sc.nextInt();
	
				if (select == 1) {
	
					tama.print();
	
				} else if (select == 2) {
	
					int num2 = rd.nextInt(3) + 1;
	
					tama.eat(num2);
	
				} else if (select == 3) {
	
					int num2 = rd.nextInt(3) + 1;
	
					tama.exercise(num2);
	
				} else if (select == 4) {
					
					tama.sleep();
				
				} else if (select == 5) {
	
					tama.adv();
	
				} else if (select == 6) {
					tama.save();
					System.out.println("저장 완료");
					break;
			}
		}
			}
		}
	}

}
