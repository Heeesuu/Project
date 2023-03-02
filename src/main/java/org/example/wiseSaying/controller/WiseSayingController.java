package org.example.wiseSaying.controller;

import org.example.Container;
import org.example.Rq;
import org.example.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingController {

    private static long lastWiseSayingId;
    private static List<WiseSaying> wiseSayings;


    public WiseSayingController() {
        lastWiseSayingId = 0;
        wiseSayings = new ArrayList<>();
    }

    public static void write() {
        long id = lastWiseSayingId + 1;
        System.out.print("명언 : ");
        String content = Container.getScanner().nextLine().trim();
        System.out.print("작가 : ");
        String authorName = Container.getScanner().nextLine().trim();

        WiseSaying wiseSaying = new WiseSaying(id, content, authorName);
        //위에서 적은 항목들을 받아서 객체를 생성했음
        //wiseSaying이라는 객체에 list를 만들어야 의미가 있음
        wiseSayings.add(wiseSaying);
        //위에서 만든 리모콘을 아래로 복사하여 wiseSayings라는 리스트에 저장

        System.out.printf("%d번 명언이 등록되었습니다.\n", id);
        lastWiseSayingId = id;
    }

    public static void list() {
        System.out.println("번호 / 작가 / 명언 ");
        System.out.println("-".repeat(30));

        for (int i = 0; i < wiseSayings.size(); i++) {
            WiseSaying wiseSaying = wiseSayings.get(i);//?

            System.out.printf("%d / %s / %s\n", wiseSaying.getId(), wiseSaying.getAuthorName(), wiseSaying.getContent());
        }
    }

    public void remove(Rq rq) {
        int id = rq.getIntParam("id", -1);

        if (id == -1) {
            System.out.println("id(정수)를 입력해주세요.");
            return;
        }
        // 입력된 id와 일치하는 명언 객체 찾기
        WiseSaying wiseSaying = findById(id);

        if (wiseSaying == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n",id);
            return;
        }

        //찾은 명언 객체를 리스트에서 제거
        wiseSayings.remove(wiseSaying);

        System.out.printf("%d번 명언이 삭제되었습니다.\n", id);

    }

    private WiseSaying findById(int id) {
        for (WiseSaying wiseSaying : wiseSayings) {
            if (wiseSaying.getId() == id) {
                return wiseSaying;
            }
        }
        return null;
    }

    public void modify(Rq rq) {
        int id = rq.getIntParam("id", -1);

        if (id == -1) {
            System.out.println("id(정수)를 입력해주세요.");
            return;
        }
        // 입력된 id와 일치하는 명언 객체 찾기
        WiseSaying wiseSaying = findById(id);

        if (wiseSaying == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n",id);
            return;
        }
        System.out.printf("명언 (기존) : %s\n", wiseSaying.getContent());
        System.out.print("명언 : ");
        String content = Container.getScanner().nextLine().trim();
        System.out.printf("작가 (기존) : %s\n", wiseSaying.getAuthorName());
        System.out.print("작가 : ");
        String authorName = Container.getScanner().nextLine().trim();

        wiseSaying.setContent(content);
        wiseSaying.setAuthorName(authorName);

        System.out.printf("%d번 명언이 수정되었습니다.\n", id);
    }
}
