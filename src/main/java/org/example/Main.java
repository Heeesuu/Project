package org.example;


import java.awt.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        new Application(sc).run();
        sc.close();

    }
}