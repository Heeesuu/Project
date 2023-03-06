package org.example;

import org.example.system.controller.SystemController;
import org.example.wiseSaying.controller.WiseSayingController;

public class App {
    public void run() {

        SystemController systemController = new SystemController();
        WiseSayingController wiseSayingController = new WiseSayingController();


        System.out.println("== 명언 앱 ==");
        while (true) {
            System.out.print("명령 ) ");
            String command = Container.getScanner().nextLine().trim();
            Rq rq = new Rq(command);

            switch (rq.getActionCode()) {
                case "종료":
                    SystemController.exit();
                    return;

                case "등록":
                    wiseSayingController.write();
                    break;

                case "목록":
                    wiseSayingController.list();
                    break;

                case "삭제":
                    wiseSayingController.remove(rq);
                    break;

                case "수정":
                    wiseSayingController.modify(rq);
                    break;

            }
        }


    }
}
