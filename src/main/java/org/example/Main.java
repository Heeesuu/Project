package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int id = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("== 명언 앱 ==");
        while (true) {
            System.out.printf("명령 ) ");
            String cmd = sc.nextLine();

            if (cmd.equals("등록")) {
                System.out.printf("명언 : ");
                String content = sc.nextLine();
                System.out.print("작가 : ");
                String author = sc.nextLine();
                id++;
                System.out.println(id + "번 명언이 등록되었습니다.");

            }
            if (cmd.equals("목록")){
                System.out.println("번호 / 작가 / 명언");
                System.out.println("-----------------------");
            }

            if (cmd.equals("종료")) {
                break;
            }
        }
        sc.close();

    }
}