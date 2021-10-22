package tamagotchi;

import java.util.Random;
import java.util.Scanner;

import java1020team.Book;

public class adv {
	
	Random rd = new Random();// 랜덤 모험
	Scanner sc = new Scanner();//입력
	
	int adv = 0;
	int hp = 0;
	int exp = 0;
	
	int ran = rd.nextInt(3)+1;
	
	if(menu == 1) {// hp -30 exp +40
		System.out.println("으스스한 동굴을 탐험해보자");
		hp -= 30;
		exp += 30;
		
	}else if(menu==2){
		System.out.println("벌레가 많은 밀림!!!");
		hp -= 40;
		exp += 40;
	}else if(menu==3){
		System.out.println("드래곤 레어를 털어보자");
		hp -= 60;
		exp += 70;
	}

	
	

}
