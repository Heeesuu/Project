package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int id = 0;
        int k = 0;
        String newcontent;
        String newauthor;
        Scanner sc = new Scanner(System.in);
        Map<Integer, String> contentmap = new HashMap<>();
        Map<Integer, String> authormap = new HashMap<>();


        System.out.println("== 명언 앱 ==");
        while (true) {
            System.out.printf("명령 ) ");
            String cmd = sc.nextLine();


            if (cmd.equals("등록")) {
                id++;
                System.out.printf("명언 : ");
                String content = sc.nextLine();
                contentmap.put(id, content);

                System.out.print("작가 : ");
                String author = sc.nextLine();
                authormap.put(id, author);

                System.out.println(id + "번 명언이 등록되었습니다.");

            }
            if (cmd.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("-----------------------");
                for (int i = 1; i <= id; i++) {
                    System.out.println(i + " / " + authormap.get(i) + " / " + contentmap.get(i));
                }


            }
            if (cmd.equals("삭제")){
                System.out.printf("?id=");
                k = sc.nextInt();

                if (contentmap.get(k) != null) {
                    System.out.println(k + "번 명언이 삭제되었습니다.");
                    contentmap.remove(k);
                    authormap.remove(k);
                } else {
                    System.out.println(k + "번 명언은 존재하지 않습니다.");
                }

            }

            if (cmd.equals("수정")) {
                System.out.printf("?id=");
                k = sc.nextInt();

                System.out.println("명언(기존) : " + contentmap.get(k));
                System.out.printf("명언 : ");
                sc.nextLine();
                newcontent = sc.nextLine();
                contentmap.put(k, newcontent);

                System.out.println("작가(기존) : " + authormap.get(k));
                System.out.printf("작가 : ");
                newauthor = sc.nextLine();
                authormap.put(k, newauthor);

            }

            if (cmd.equals("종료")) {
                break;
            }
        }
        sc.close();

    }
}