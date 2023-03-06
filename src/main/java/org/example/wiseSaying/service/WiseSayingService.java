package org.example.wiseSaying.service;

import org.example.Container;
import org.example.Rq;
import org.example.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingService {

    private long lastWiseSayingId;
    private final List<WiseSaying> wiseSayings;


    public WiseSayingService() {
        lastWiseSayingId = 0;
        wiseSayings = new ArrayList<>();
    }

    public WiseSaying findById(long id) {
        for (WiseSaying wiseSaying : wiseSayings) {
            if (wiseSaying.getId() == id) {
                return wiseSaying;

            }
        }
        return null;
    }

    public List<WiseSaying> findAll() {
        return wiseSayings;
    }


    public long write(String content, String authorName) {
        long id = lastWiseSayingId + 1;

        WiseSaying wiseSaying = new WiseSaying(id, content, authorName);
        wiseSayings.add(wiseSaying);

        lastWiseSayingId = id;

        return id;
    }

    public void list() {

    }

    public void remove(WiseSaying wiseSaying) {
        wiseSayings.remove(wiseSaying);

    }

    public void modify(WiseSaying wiseSaying, String content, String authorName) {
        wiseSaying.setContent(content);
        wiseSaying.setAuthorName(authorName);
    }
}
