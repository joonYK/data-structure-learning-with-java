package doIt.ch02.practice;

import java.util.Scanner;

/**
 * 기수 변환 과정을 자세히 나타내는 프로그램을 작성.
 *
 * 2|   50
 *  +-----
 * 2|   29  ... 1
 *
 */
public class Q_02_07 {
    //답
    static int cardConvR(int x, int r, char[] d) {
        int digits = 0; //변환 후의 자릿수
        String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        System.out.printf("%d |     %d\n", r, x);

        do {
            System.out.println("  + ------");

            d[digits++] = dchar.charAt(x % r); //r로 나눈 나머지를 저장
            x /= r;

            if(x != 0)
                System.out.printf("%d |     %d  ... %c\n", r, x, d[digits-1]);

        } while (x != 0);

        System.out.printf("        %d  ... %c\n", x, d[digits-1]);

        return digits;
    }

    //답안지 답
    static int cardConvEx(int x, int r, char[] d) {
        int n = ((Integer) x).toString().length(); // 변환 전의 자릿수
        int digits = 0; // 변환 뒤의 자릿수
        String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        System.out.printf(String.format("%%2d | %%%dd\n", n), r, x);
        do {
            System.out.printf("   +");
            for (int i = 0; i < n + 2; i++)
                System.out.print('-');
            System.out.println();

            if (x / r != 0)
                System.out.printf(String.format("%%2d | %%%dd    … %%d\n", n), r, x / r, x % r);
            else
                System.out.printf(String.format("     %%%dd    … %%d\n", n), x / r, x % r);
            d[digits++] = dchar.charAt(x % r); // r로 나눈 나머지를 저장
            x /= r;
        } while (x != 0);

        return digits;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int no;     // 변환하는 정수
        int cd;     // 기수
        int dno;    // 변환 후의 자릿수
        int retry;  // 다시 시도
        char[] cno = new char[32];  // 변환 후 각 자리의 숫자를 넣어두는 문자의 배열

        System.out.println("10진수를 기수 변환합니다.");
        do {
            do {
                System.out.print("변환하는 음이 아닌 정수 : ");
                no = scanner.nextInt();
            } while (no < 0);

            do {
                System.out.print("어떤 진수로 변환할까요 ? (2~36) : ");
                cd = scanner.nextInt();
            } while (cd < 2 || cd > 36);

            //dno = cardConvR(no, cd, cno);
            dno = cardConvEx(no, cd, cno);

            System.out.print(cd + "진수로는 ");
            for (int i = dno - 1; i >= 0; i--)
                System.out.print(cno[i]);
            System.out.println("입니다.");

            System.out.print("한 번 더 할까요? (1.예/0.아니오) : ");
            retry = scanner.nextInt();
        } while (retry == 1);
    }
}
