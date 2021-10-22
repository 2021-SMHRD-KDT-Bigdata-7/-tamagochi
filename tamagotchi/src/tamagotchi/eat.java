package tamagotchi;

import java.util.Scanner;

public class eat {public static void main(String[] args) {

	

	//먹기
	
	Scanner sc = new Scanner(System.in);

	//현재 HP 표시
    int Hp = 1000;
    
	
	System.out.print("현재 체력은 : " + Hp + "입니다 ");
	// 현재 체력 표시
	
	System.out.println(" 무엇을 드시겠습니까?? ");
	System.out.print("1.독사과 2.사과 3.삼겹살 4.소고기 5.채소 6.다이어트 >> "); 
	
	int food = sc.nextInt();						
	// 먹을거 선택	 
	
	
	if (food == 1) {
		Hp = 0;
		System.out.println( "사망 하셨습니다. ");
	}else if(food == 2) {
		Hp =( Hp+30);
		System.out.println(Hp);
		
	}else if(food == 3) {
		Hp=(Hp + 200);
		System.out.println(Hp);
		
	}else if(food == 4) {
		Hp=(Hp + 150);
		System.out.println(Hp);
											
	}else if(food == 5) {
		Hp=(Hp - 100);
		System.out.println(Hp);
		
	}
	else if(food == 6) {
		Hp=(Hp - 150);
	}
	
	
			
}

}
