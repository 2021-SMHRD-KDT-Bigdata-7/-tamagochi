package tamagotchi;

import java.util.Scanner;

public class test2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		 
		tamagotchi tama = new tamagotchi();
//		System.out.print("현재 체력은 : " + vo.getHp() + "입니다 ");
		// 현재 체력 표시
		
		System.out.println(" 무엇을 드시겠습니까?? "); 
		System.out.print("1.독사과 2.사과 3.삼겹살 4.소고기 5.채소 6.다이어트 >> "); //음식 선택지.
		
//		vo.setNum(sc.nextInt());
		
		tama.eat(tama.num=sc.nextInt());
//		System.out.println(vo.getHp()+"+"+vo.getExp()+"+"+vo.getTurn());
//		System.out.println(tama.stat());
		
		
////////////////////////////////////////////////////////////////////////////////////////////////		
		tama.sleep();
		tama.adv();
		System.out.println("어떤운동?");
		tama.exercise(tama.num=sc.nextInt());
		tama.print();
	}

}
