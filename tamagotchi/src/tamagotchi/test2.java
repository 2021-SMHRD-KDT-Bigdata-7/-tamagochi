package tamagotchi;

import java.util.Scanner;

public class test2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		tamagotchi tama = new tamagotchi();

		System.out.print("[1] �α��� [2] ȸ������ [3] ��ŷȮ�� [4] ����");
			int select = sc.nextInt();
			
			if (select == 1) {
				System.out.print("���̵� �Է� : ");
				String id = sc.next();
				
				System.out.println("��й�ȣ �Է�");
				String pw = sc.next();
				
				tama.login(id, pw);
				
				
			
			}else if (select == 2 ) {
				System.out.print("�α��� ���̵� ���� : ");
				String id = sc.next();
				
				System.out.print("�н����� : ");
				String pw = sc.next();
				
				System.out.print("ĳ���� �̸� : ");
				String nick = sc.next();
				
				tama.insert(id, pw, nick);
			}

		System.out.println("�Է� 1 : ");
		String id = sc.next();

		System.out.println("�Է� 2 : ");
		String pw = sc.next();

		System.out.println("�Է� 3 : ");
		String nick = sc.next();

		System.out.println(" ������ ��ðڽ��ϱ�?? ");
		System.out.print("1.����� 2.��� 3.���� 4.�Ұ�� 5.ä�� 6.���̾�Ʈ >> "); // ���� ������.

//		vo.setNum(sc.nextInt());

		tama.eat(tama.num = sc.nextInt());
//		System.out.println(vo.getHp()+"+"+vo.getExp()+"+"+vo.getTurn());
//		System.out.println(tama.stat());

////////////////////////////////////////////////////////////////////////////////////////////////		
		tama.sleep();
		tama.adv();
		System.out.println("��?");
		tama.exercise(tama.num = sc.nextInt());
		tama.print();
	}

}
