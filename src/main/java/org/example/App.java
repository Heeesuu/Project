package org.example;

import org.example.system.controller.SystemController;
import org.example.wiseSaying.controller.WiseSayingController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {

    public void run() {

        SystemController systemController = new SystemController();
        WiseSayingController wiseSayingController = new WiseSayingController();

        System.out.println("== 명언 앱 ==");

        while (true) {

            System.out.print("명령 ) ");
            String command = Container.getScanner().nextLine().trim();
            //trim() : 좌우 공백을 제거해준다.

            if (command.equals("종료")) {
                systemController.exit();

                break;

            } else if (command.equals("등록")) {
                WiseSayingController.write();

            } else if (command.equals("목록")) {
                WiseSayingController.list();
            } else if (command.startsWith("삭제")){
                //정리시작
                Rq rq = new Rq(command);

                System.out.printf("actionCode : %s\n", rq.getActionCode());
                System.out.printf("params.id : %s\n", rq.getParam("id"));
                System.out.printf("params.authorName : %s\n", rq.getParam("authorName"));
                System.out.printf("params.content : %s\n", rq.getParam("content"));

                //정리끝

                wiseSayingController.remove();
            }


        }
    }
}

