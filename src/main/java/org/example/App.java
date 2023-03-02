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

                String[] commandBits = command.split("\\?",2); // ?를 기준으로 최대 두개까지 나눈다.
                String actionCode = commandBits[0];

                Map<String, String> params = new HashMap<>();

                String[] paramBits = commandBits[1].split("&");

                for (String paramStr : paramBits) {
                    String[] paramStrBits = paramStr.split("=", 2);
                    String key = paramStrBits[0];
                    String value = paramStrBits[1];

                    params.put(key, value);
                }

                System.out.printf("actionCode : %s\n", actionCode);
                System.out.printf("params : %s\n", params);

                //정리끝
            }


        }
    }
}

