package tamagotchi;

import java.util.Random;
import java.util.Scanner;

public class test2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();

		tamagotchi tama = new tamagotchi();
		image1 ima = new image1();

		String nick = null;

		int select = 0;
		int coin = 0;
		int eventNum = 0;
		boolean run2 = true;

		while (true) {
			if (select == 0) {
				System.out.println("=============================");
				System.out.println("========= ����ġ Ű��� =========");
				System.out.println("=============================");
				System.out.println();
				System.out.print("[1] �α��� [2] ȸ������ [3] ���� >> ");
				select = sc.nextInt();
				System.out.println();

				if (select == 1) {
					System.out.print("���̵� �Է� : ");
					String id = sc.next();

					System.out.print("��й�ȣ �Է� : ");
					String pw = sc.next();

					System.out.println();

					if (tama.login(id, pw) == 1) {
						System.out.println("ȯ���մϴ� " + id + " ��");
						coin = 1;
						tama.select(id);
						ima.heart();
						break;
					} else {
						System.out.println("�α��� ����");
						select = 0;
					}
				} else if (select == 2) {

					System.out.print("�α��� ���̵� ���� : ");
					String id = sc.next();

					System.out.print("�н����� : ");
					String pw = sc.next();

					System.out.println();

					System.out.println("= = = = = = = = = = = = = =");
					System.out.println(" = = = ĳ���͸� �����ϼ��� = = = ");
					System.out.println("= = = = = = = = = = = = = =");
					System.out.print(" [1]����ġ [2]����ġ [3]����ġ>> ");
					int a = sc.nextInt();
					System.out.println();
					System.out.print("����ġ�� �̸��� ������ּ��� >> ");
					nick = sc.next();

					tama.insert(id, pw, nick);
					tama.insert2(nick, 0, 1, 100, 1, 1, id);
					System.out.println();

					if (a == 1) {
						System.out.println("����ġ ����!!!");
					} else if (a == 2) {
						System.out.println("����ġ ����!!!!!");
					} else if (a == 3) {
						System.out.println("����ġ ����!!!");
					} else {
						System.out.println("�׷��� ����ġ!!!");
					}
					System.out.println();
					System.out.println("ȯ���մϴ� " + id + " ��");
					coin = 1;
					ima.heart();

					break;

				} else if (select == 3) {
					System.out.println("��¥ ���ž�?");
					System.out.print("[1]��!!! [2]�ƴ� �̾� ");
					int a = sc.nextInt();
					if (a == 1) {
						System.out.println("�ȳ�~~~");
						break;
					} else if (a == 2) {
						System.out.println("�ٽ� ������ �ּ���");
						select = 0;
					}
				} else {
					System.out.println("�޴��� �ٽ� �������ּ���");
					select = 0;
				}
			}
		}
		while (coin == 1) { // ���ӽ���

			// ������ �����ؼ� ����ġ��� ��������

			nick = tama.Nick();
			run2 = tama.gg();

			if (run2 == false) {
				tama.save();
				System.out.println("���� �Ϸ�");
				break;
			} else {
				eventNum = rd.nextInt(100) + 1; // ����ġ ��� ����� ������ ����

				if (eventNum <= 10) {
					System.out.println();

					System.out.println("******* ���� ��Ȳ �߻�!!! *******");
					System.out.println();

					while (run2) {
						run2 = tama.gg();
						if (run2 == false) {
							break;
						}
						System.out.println(nick + "�� �谡 ����");
						System.out.println();
						System.out.print("[1] �Ļ��ֱ� [2] ��ϱ� [3]���ڱ� >> ");
						select = sc.nextInt();
						System.out.println();

						if (select == 1) {
							ima.dinner();
							System.out.println(" ����� �ذ� Hp +20, Exp + 10, Trun + 2 ");
							System.out.println();

							tama.plusHp(20);
							tama.plusEp(10);
							tama.plusTurn(2);
							tama.print();
							break;
						} else {
							ima.sad2();
							System.out.println(" �屸�ذ� �ȵ� Hp - 40 ");
							tama.plusHp(-40);
							tama.print();
						}
					}
					System.out.println();

				} else if (eventNum >= 11 && eventNum <= 20) {

					System.out.println();
					System.out.println("******* ���� ��Ȳ �߻�!!! *******");
					System.out.println();

					while (run2) {
						run2 = tama.gg();
						if (run2 == false) {
							break;
						}
						System.out.println(nick + "�� �ɽ���");
						System.out.println();
						System.out.print("[1] �Ļ��ֱ� [2] ��ϱ� [3]���ڱ� >> ");
						select = sc.nextInt();
						System.out.println();

						if (select == 2) {
							ima.dumbbell();
							System.out.println(" �ɽ��� �ذ� Hp + 0, Exp + 10, Turn + 2  ");
							System.out.println();

							tama.plusHp(0);
							tama.plusEp(10);
							tama.plusTurn(2);
							tama.print();

							break;
						} else {
							ima.sad2();
							System.out.println(" �屸�ذ� �ȵ� Hp - 40 ");
							tama.plusHp(-40);
							tama.print();
						}
					}
					System.out.println();

				} else if (eventNum >= 21 && eventNum <= 30) {
					System.out.println();

					System.out.println("******* ���� ��Ȳ �߻�!!! *******");
					System.out.println();

					while (run2) {
						run2 = tama.gg(); // -> false

						if (run2 == false) {
							break;
						}
						System.out.println(nick + "����");
						System.out.println();
						System.out.print("[1] �Ļ��ֱ� [2] ��ϱ� [3]���ڱ� >> ");
						select = sc.nextInt();
						System.out.println();

						if (select == 3) {
							ima.bed2();
							System.out.println(" ���� �ذ� Hp + 20, Ep + 10, Turn + 5 ");
							System.out.println();

							tama.plusHp(20);
							tama.plusEp(10);
							tama.plusTurn(5);
							tama.print();

							break;
						} else {
							ima.sad2();
							System.out.println(" �屸�ذ� �ȵ� Hp - 40 ");
							tama.plusHp(-40);
							tama.print();
						}
					}
					System.out.println();

				} else if (eventNum >= 31 && eventNum <= 40) {
					System.out.println();
					System.out.println("��Դٰ� ü�� Hp - 20, Exp + 10, Turn + 1");
					tama.plusHp(-20);
					tama.plusEp(10);
					tama.plusTurn(1);
					tama.print();
					ima.sad();

				} else if (eventNum >= 41 && eventNum <= 50) {
					System.out.println();
					System.out.println("ħ�뿡�� ������ Hp - 10, Exp + 10, Turn + 1");
					tama.plusHp(-10);
					tama.plusEp(10);
					tama.plusTurn(1);
					tama.print();

				}

				if (run2 == false) {
					System.out.println();
					System.out.print(" [1] ����Ȯ�� [2] ���� >> ");
					select = sc.nextInt();
					System.out.println();

					if (select == 1) {

						tama.print();

					} else if (select == 2) {

						tama.save();
						System.out.println("���� �Ϸ�");
						break;
					}
				} else {

					System.out.println();
					System.out.print("[1] ����Ȯ�� [2] �Ļ� �ֱ� [3]��ϱ� [4]���ڱ� [5] �����ϱ� [6] �����ϱ� ");
					select = sc.nextInt();
					System.out.println();

					if (select == 1) {

						tama.print2();

					} else if (select == 2) {
						System.out.println("�޴��� ���ÿ�");
						System.out.print("[1] ���, [2] ��ä, [3] ���� ");
						int num2 = sc.nextInt();

						tama.eat(num2);

					} else if (select == 3) {
						System.out.println("�޴��� ���ÿ�");
						System.out.print("[1] ���̺�, [2] ������, [3] ���� ");
						int num2 = sc.nextInt();

						tama.exercise(num2);

					} else if (select == 4) {

						tama.sleep();

					} else if (select == 5) {

						tama.adv();

					} else if (select == 6) {
						tama.save();
						System.out.println("");
						System.out.println("���� �Ϸ�");
						System.out.println();
						System.out.println("= = = = = = = = = = = = =");
						System.out.println(" = = ������ ���� �Ǿ����ϴ� = = ");
						System.out.println("= = = = = = = = = = = = =");
						break;
					} else {
						System.out.println("�޴��� �ٽ� �������ּ���");
					}
				}
			}
		}
	}

}
