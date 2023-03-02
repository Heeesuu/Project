package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private final Scanner sc;

    public App(Scanner sc){
        this.sc = sc;
    }
    public void run(){
        long lastWiseSayingId = 0;
        List<WiseSaying> wiseSayings = new ArrayList<>();

        System.out.println("== 명언 앱 ==");

        while (true) {

            System.out.print("명령 ) ");
            String command = sc.nextLine().trim();
            //trim() : 좌우 공백을 제거해준다.

            if (command.equals("종료")) {
                break;
            } else if (command.equals("등록")) {
                long id = lastWiseSayingId + 1;
                System.out.print("명언 : ");
                String content = sc.nextLine().trim();
                System.out.print("작가 : ");
                String authorName = sc.nextLine().trim();

                WiseSaying wiseSaying = new WiseSaying(id, content, authorName);
                //위에서 적은 항목들을 받아서 객체를 생성했음
                //wiseSaying이라는 객체에 list를 만들어야 의미가 있음
                wiseSayings.add(wiseSaying);
                //위에서 만든 리모콘을 아래로 복사하여 wiseSayings라는 리스트에 저장

                System.out.printf("%d번 명언이 등록되었습니다.\n", id);
                lastWiseSayingId = id;

            } else if (command.equals("목록")) {
                System.out.println("번호 / 작가 / 명언 ");
                System.out.println("-".repeat(30));

                for (int i = 0; i < wiseSayings.size(); i++){
                    WiseSaying wiseSaying = wiseSayings.get(i);

                    System.out.printf("%d / %s / %s\n", wiseSaying.getId(), wiseSaying.getAuthorName(), wiseSaying.getContent());
                }
            }
        }
    }
}
