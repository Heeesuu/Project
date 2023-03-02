package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        new App(sc).run();
        //sc 스캐너를 가지고 있는 App이 생긴다.

        sc.close();

    }
}