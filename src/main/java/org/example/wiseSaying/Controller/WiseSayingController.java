package org.example.wiseSaying.Controller;

import org.example.Container;

public class WiseSayingController {

    public static void write() {
        System.out.print("명언 : ");
        String content = Container.getScanner().nextLine();
        System.out.print("작가 : ");
        String authorName = Container.getScanner().nextLine();
        System.out.println("1번 명언이 등록되었습니다.");
    }

}
