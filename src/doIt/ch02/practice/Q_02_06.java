package doIt.ch02.practice;

import java.util.Scanner;

/**
 * 배열의 앞쪽에 아랫자리가 아니라 윗자리를 넣어두는 메서드를 작성하세요.
 */
public class Q_02_06 {
    //답
    static int cardConv(int x, int r, char[] d) {
        int digits = 0; //변환 후의 자릿수
        String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] temp = new char[d.length];

        do {
            temp[digits++] = dchar.charAt(x % r); //r로 나눈 나머지를 저장
            x /= r;
        } while (x != 0);

        for (int i = 0; i < digits; i++)
            d[i] = temp[digits - i - 1];

        return digits;
    }

    //답안지 답
    /*static int cardConv(int x, int r, char[] d) {
        int digits = 0;// 변환 뒤의 자릿수
        String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        do {
            d[digits++] = dchar.charAt(x % r); // r로 나눈 나머지를 저장
            x /= r;
        } while (x != 0);

        for (int i = 0; i < digits / 2; i++) { // d[0]~d[digits-1]
            char temp = d[i];
            d[i] = d[digits - i - 1];
            d[digits - i - 1] = temp;
        }
        return digits;
    }*/

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

            dno = cardConv(no, cd, cno);

            System.out.print(cd + "진수로는 ");
            for (int i = 0; i < dno; i++)
                System.out.print(cno[i]);
            System.out.println("입니다.");

            System.out.print("한 번 더 할까요? (1.예/0.아니오) : ");
            retry = scanner.nextInt();
        } while (retry == 1);
    }
}
