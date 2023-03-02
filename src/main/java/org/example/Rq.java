package org.example;

import java.util.HashMap;
import java.util.Map;

public class Rq {
    private String actionCode;
    private Map<String, String> params;

    public Rq(String command) {
        String[] commandBits = command.split("\\?", 2); // ?를 기준으로 최대 두개까지 나눈다.
        actionCode = commandBits[0];

        params = new HashMap<>();
        String[] paramBits = commandBits[1].split("&");

        for (String paramStr : paramBits) {
            String[] paramStrBits = paramStr.split("=", 2);
            String key = paramStrBits[0];
            String value = paramStrBits[1];

            params.put(key, value);
        }
    }

    public String getActionCode() {
        return actionCode;
    }

    public String getParam(String name) {
        return params.get(name);
    }
}