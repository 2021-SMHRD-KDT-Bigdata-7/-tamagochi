package tamagotchi;

import java.util.Random;
import java.util.Scanner;

public class exercise {
	
	public static void main(String[] args) {


	Random rd = new Random(); // ������ �ҷ����� ��� ����
	Scanner sc = new Scanner(System.in);
	
	System.out.println("��? >> ");
	int select = sc.nextInt();


	if(select == 1) {
		System.out.println("�ｺ�� �մϴ�. ���X�����X");
	} else if(select == 2) {
		System.out.println("�޸��⸦ �մϴ�. ���X�����X");
	} else if(select == 3) {
		System.out.println("�����̸� �մϴ�. ��!!! ��~��!");
	}
	exp += 30;
	hp -= 20;
	System.out.println("����ġ�� 30��ŭ ����߽��ϴ�. ü���� 20��ũ �����߽��ϴ�.");
	
	
	}	
	
}


