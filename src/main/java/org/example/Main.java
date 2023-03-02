package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Container.init();
        new App().run();
        Container.close();
        //꺼주는 것은 필요함
    }
}