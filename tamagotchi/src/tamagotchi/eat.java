package tamagotchi;

import java.util.Scanner;

public class eat {public static void main(String[] args) {

	

	//�Ա�
	
	Scanner sc = new Scanner(System.in);

	//���� HP ǥ��
    int Hp = 1000;
    
	
	System.out.print("���� ü���� : " + Hp + "�Դϴ� ");
	// ���� ü�� ǥ��
	
	System.out.println(" ������ ��ðڽ��ϱ�?? ");
	System.out.print("1.����� 2.��� 3.���� 4.�Ұ�� 5.ä�� 6.���̾�Ʈ >> "); 
	
	int food = sc.nextInt();						
	// ������ ����	 
	
	
	if (food == 1) {
		Hp = 0;
		System.out.println( "��� �ϼ̽��ϴ�. ");
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
