package tamagotchi;

import java.util.Random;
import java.util.Scanner;

import java1020team.Book;

public class adv {
	
	Random rd = new Random();// ���� ����
	Scanner sc = new Scanner();//�Է�
	
	int adv = 0;
	int hp = 0;
	int exp = 0;
	
	int ran = rd.nextInt(3)+1;
	
	if(menu == 1) {// hp -30 exp +40
		System.out.println("�������� ������ Ž���غ���");
		hp -= 30;
		exp += 30;
		
	}else if(menu==2){
		System.out.println("������ ���� �и�!!!");
		hp -= 40;
		exp += 40;
	}else if(menu==3){
		System.out.println("�巡�� ��� �о��");
		hp -= 60;
		exp += 70;
	}

	
	

}
