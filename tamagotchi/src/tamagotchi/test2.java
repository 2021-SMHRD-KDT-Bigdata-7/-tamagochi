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
				System.out.print("[1] �α��� [2] ȸ������ [3] ��ŷȮ�� [4] ���� >> ");
				select = sc.nextInt();
			
			if (select == 1) {
				System.out.print("���̵� �Է� : ");
				String id = sc.next();

				System.out.print("��й�ȣ �Է� : ");
				String pw = sc.next();
				
				if (tama.login(id, pw)==1) {				
					System.out.println("ȯ���մϴ� "+id+" ��");
					coin = 1;
				}else {
					System.out.println("�α��� ����");
					select = 0;
				}
			} else if (select == 2) {
				System.out.print("�α��� ���̵� ���� : ");
				String id = sc.next();

				System.out.print("�н����� : ");
				String pw = sc.next();

				tama.insert(id, pw);
				
				System.out.println("ĳ���͸� �����ϼ���");
				System.out.print("[1]����ġ [2]����ġ [3]����ġ");
				int a = sc.nextInt();
				
				if (a == 1) {
					System.out.println("����ġ ����!!!");
				}else if(a == 2) {
					System.out.println("����ġ ����!!!!!");
				}else if(a == 3) {
					System.out.println("����ġ ����!!!");
				}else {
					System.out.println("�׷��� ����ġ!!!");
				}
				
				
			} else if (select == 3) {

			} else if (select == 4) {
				System.out.println("��¥ ���ž�?");
				System.out.print("[1]�� [2]�ƴ� �̾� ");
				int a = sc.nextInt();
				if(a == 1) {
					System.out.println("�ȳ�~~~");
					break;
				}else if(a == 2){
					System.out.println("�ٽ� ������ �ּ���");
					select = 0;
				}
			} else {
				System.out.println("���ڸ� �ٽ� �������ּ���");
				select = 0;
			}
		    
//			System.out.println(" ������ ��ðڽ��ϱ�?? ");
//			System.out.print("1.����� 2.��� 3.���� 4.�Ұ�� 5.ä�� 6.���̾�Ʈ >> "); // ���� ������.
//
//			tama.eat(tama.num = sc.nextInt());
//			tama.sleep();
//			tama.adv();
//			System.out.println("��?");
//			tama.exercise(tama.num = sc.nextInt());
//			tama.print();
		}
	}
//	while (coin == 1) { // ���ӽ���
//		// rd
//		System.out.println("�ൿ�� �����ϼ���");
//		System.out.println("");
//		if ()
//		
//	}
	}

}
