package tamagotchi;

import java.util.Scanner;

public class test2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		 
		tamagotchi tama = new tamagotchi();
//		System.out.print("���� ü���� : " + vo.getHp() + "�Դϴ� ");
		// ���� ü�� ǥ��
		
		System.out.println(" ������ ��ðڽ��ϱ�?? "); 
		System.out.print("1.����� 2.��� 3.���� 4.�Ұ�� 5.ä�� 6.���̾�Ʈ >> "); //���� ������.
		
//		vo.setNum(sc.nextInt());
		
		tama.eat(tama.num=sc.nextInt());
//		System.out.println(vo.getHp()+"+"+vo.getExp()+"+"+vo.getTurn());
//		System.out.println(tama.stat());
		
		
////////////////////////////////////////////////////////////////////////////////////////////////		
		tama.sleep();
		tama.adv();
		System.out.println("��?");
		tama.exercise(tama.num=sc.nextInt());
		tama.print();
	}

}
