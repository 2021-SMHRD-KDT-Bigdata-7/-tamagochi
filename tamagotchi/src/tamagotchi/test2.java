-package tamagotchi;

import java.util.Random;
import java.util.Scanner;

public class test2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		
		tamagotchi tama = new tamagotchi();
		
		String nick = null;
		
		int select = 0;
		int coin = 0;
		int eventNum = 0;
		
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
				System.out.println("����ġ�� �̸��� ������");
				nick = sc.next();
				
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
//			System.out.print("1.����� 2.��� 3.���� 4.�Ұ��� 5.ä�� 6.���̾�Ʈ >> "); // ���� ������.
//
//			tama.eat(tama.num = sc.nextInt());
//			tama.sleep();
//			tama.adv();
//			System.out.println("��?");
//			tama.exercise(tama.num = sc.nextInt());
//			tama.print();
		}
	}
	while (coin == 1) { // ���ӽ���
		 // ������ �����ؼ� ����ġ��� ��������
		
		eventNum = rd.nextInt(100) + 1; // ����ġ ��� ����� ������ ����
		
		if(eventNum <= 10) {
			
			while(true) {
				System.out.println(nick + "�� �谡 ����");
				System.out.println("[1] ����Ȯ�� [2] �Ļ� �ֱ� [3]��ϱ� [4]���ڱ� [5] �����ϱ� ");
			
				select = sc.nextInt();
			
				if(select == 2) {
					System.out.println("����� �ذ�");
					tama.plusExp(10);
					tama.plusHp(10);
					break;
				} else {
					System.out.println("�屸�ذ� �ȵ�");
					tama.plusHp(-5);
				}
			}
			
		} else if(eventNum >= 11 && eventNum <= 20) {
			
			while(true) {
				System.out.println(nick + "�� �ɽ���");
				System.out.println("[1] ����Ȯ�� [2] �Ļ� �ֱ� [3]��ϱ� [4]���ڱ� [5] �����ϱ� ");
			
				select = sc.nextInt();
			
				if(select == 3) {
					System.out.println("�ɽ��� �ذ�");
					tama.plusExp(15);
					
					break;
				} else {
					System.out.println("�屸�ذ� �ȵ�");
					tama.plusHp(-5);
				}
			}
			
		} else if(eventNum >= 21 && eventNum <= 30) {
			
			while(true) {
				System.out.println(nick + "����");
				System.out.println("[1] ����Ȯ�� [2] �Ļ� �ֱ� [3]��ϱ� [4]���ڱ� [5] �����ϱ� ");
			
				select = sc.nextInt();
			
				if(select == 4) {
					System.out.println("���� �ذ�");
					tama.plusExp(5);
					tama.plusHp(20);
					break;
				} else {
					System.out.println("�屸�ذ� �ȵ�");
					tama.plusHp(-5);
				}
			}
		} // else if(eventNum >= 21 && eventNum <= 30) {
//			
//		} else if(eventNum >= 21 && eventNum <= 30) {
//			
//		} else if(eventNum >= 21 && eventNum <= 30) {
//			 
//		} else if(eventNum >= 21 && eventNum <= 30) {
//			
//		} else if(eventNum >= 21 && eventNum <= 30) {
//			
//		} else if(eventNum >= 21 && eventNum <= 30) {
//			
//		} else if(eventNum >= 21 && eventNum <= 30) {
//			
//		} else if(eventNum >= 21 && eventNum <= 30) {
//			
//		} else if(eventNum >= 21 && eventNum <= 30) {
//	
		else{
			break;
		}
		
//		
//		
//		System.out.println("�ൿ�� �����ϼ���");
//		System.out.println("[1] ����Ȯ�� [2] �Ļ� �ֱ� [3]��ϱ� [4]���ڱ� [5] �����ϱ� [6] �����ϱ� ");
//		
//		if (select == 1) {
//		tama.print();
//	
//      �������������� ��ġ ���� �ʿ�		
		
/*	}else if(select == 2) { //���İ����� ��
 *  
 *  System.out.println("� ������ �ֽðڽ��ϱ�.");
 *  select = sc.nextInt();
 *  
 *  tama.eat();
 *  
 *  
 *  
 *	if(eventNum = 35){
 *	System.out.println("�� ���� �� �Ļ縦 �Ծ���Ƚ��ϴ�.");
 *  tama.fail();
 *  tama.die();
 * }else if(eventNum == 77){
 * System.out.println("�� ���� �԰����� ������ �Ծ����ϴ�");
 * ����ġ �߰��κ� ����..
 * }
 * 
 *  
 * 
 * }else if (select == 3){
 *  System.out.println("� ��� �ϰڽ��ϱ�? ");
 *  select = sc.nextInt();
 *  
 *  tama.exercise();
 *  
 *  if(eventNum = 35){
 *	System.out.println("�� ��� �ϴٰ� ġ������ �Ծ����ϴ�.");
 *  tama.fail();
 *  tama.die();
 * }else if(eventNum == 77){
 * System.out.println("���õ��� ��� ��վ���.");
 *  ����ġ �߰��κ� ����..
 *  
 *  } 
 * 
 * }else if (select == 4){
 * 
 * tama.sleep();
 * 
 * }
 * 
 * }else if (select == 5){
 * select = sc.nextInt();
 * System.out.println("� ������ ���� �𸣰����� �αٵα���");
 *
 * tama.adv();
 * 
 * 
 * }else {
 *  System.out.println("�ȳ�~~~");
 *  break;
 * }
 * 
 * 
 * 
 * 
 */
		
		
	}

}