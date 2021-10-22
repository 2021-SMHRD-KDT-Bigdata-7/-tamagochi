package tamagotchi;

import java.util.Random;
import java.util.Scanner;

public class exercise {
	
	public static void main(String[] args) {


	Random rd = new Random(); // 랜덤값 불러오는 기능 생성
	Scanner sc = new Scanner(System.in);
	
	System.out.println("어떤운동? >> ");
	int select = sc.nextInt();


	if(select == 1) {
		System.out.println("헬스를 합니다. 으쌰라으쌰");
	} else if(select == 2) {
		System.out.println("달리기를 합니다. 으쌰라으쌰");
	} else if(select == 3) {
		System.out.println("공놀이를 합니다. 슛!!! 골~인!");
	}
	exp += 30;
	hp -= 20;
	System.out.println("경험치가 30만큼 상승했습니다. 체력이 20만크 감소했습니다.");
	
	
	}	
	
}


