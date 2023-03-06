package org.example;

import java.util.Scanner;

public class Application {
    public final Scanner sc;
    ;

    public Application(Scanner sc){
        this.sc = sc;
    }

    public void run() {
        System.out.println("== 명언 앱 ==");

        int lastId = 1;

        while (true) {
            System.out.print("명령 )");
            String command = sc.nextLine().trim();

            if (command.equals("종료")){
                break;
            } else if (command.equals("등록")) {
                System.out.print("명언 : ");
                String content = sc.nextLine().trim();
                System.out.print("작가 : ");
                String authorName = sc.nextLine().trim();

                System.out.printf("%d번 명언이 등록되었습니다.\n", lastId);
                lastId++;

            }
        }
    }

}
