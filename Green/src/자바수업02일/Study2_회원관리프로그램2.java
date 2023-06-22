package 자바수업02일;

import java.util.Scanner;

public class Study2_회원관리프로그램2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// 친구관리 프로그램
		// 친구추가, 친구보기 친구수정 친구삭제 종료
		int MAX = 100;
		int input;
		String name[] = new String[MAX];
		String addr[] = new String[MAX];
		String memo[] = new String[MAX];
		String pN[] = new String[MAX];
		int cnt = 0;// 현재 친구 수

		while (true) {
			System.out.println("<친구관리 프로그램>");
			System.out.println("1.친구추가");
			System.out.println("2.친구보기");
			System.out.println("3.친구수정");
			System.out.println("4.친구삭제");
			System.out.println("5.종료");
			System.out.print("선택: ");
			input = sc.nextInt();

			switch (input) {
			case 1:

				System.out.println("<" + (cnt + 1) + "번 친구정보입력>");

				System.out.println("이름:");
				name[cnt] = sc.next();
				System.out.println("번호:");
				pN[cnt] = sc.next();
				System.out.println("사는곳:");
				addr[cnt] = sc.next();
				System.out.println("메모:");
				memo[cnt] = sc.next();
				System.out.println("\n친구정보가 등록되었습니다.\n");
				cnt++;// 친구한명 등록하면 증가

				break;

			case 2:

				for (int i = 0; i < cnt; i++) {
					System.out.println(i + 1 + "번 " + name[i] + "/" + pN[i] + "/" + addr[i] + "/" + memo[i]);
				}
				break;

			case 3:

				System.out.println("수정대상이름:");
				String modify = sc.next();

				for (int i = 0; i < cnt; i++) {

					if (modify.equals(name[i])) {
						System.out.println("정보(" + name[i] + "/" + pN[i] + "/" + addr[i] + "/" + memo[i] + ")");
						System.out.println("수정이름");
						name[i] = sc.next();
						System.out.println("수정전번");
						pN[i] = sc.next();
						System.out.println("수정사는곳");
						addr[i] = sc.next();
						System.out.println("수정메모");
						memo[i] = sc.next();
						System.out.println("\n수정이 완료되었습니다.\n");
					}

				}

				break;

			case 4:

				System.out.println("삭제대상이름");
				String delete = sc.next();

				for (int i = 0; i < cnt; i++) {

					if (delete.equals(name[i])) {
						System.out.println("정보(" + name[i] + "/" + pN[i] + "/" + addr[i] + "/" + memo[i] + ")");
					}

					System.out.println("정말 삭제하시겠습니까?(y,n): ");
					String yNo = sc.next();

					if (yNo.equals("y")) {

						for (int d = i; d < cnt; d++) {
							name[d] = name[d + 1];
							pN[d] = pN[d + 1];
							addr[d] = addr[d + 1];
							memo[d] = memo[d + 1];
						}
						cnt--; // 한명삭제되어서 카운트감소

						System.out.println("\n정보가 삭제되었습니다.\n");
					} else if (yNo.equals("n")) {
						System.out.println("삭제취소");
					}
				}
				break;

			case 5:
				System.out.println("종료");
				break;

			default:
				break;
			}

		}
	}

}
