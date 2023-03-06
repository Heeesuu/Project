package org.example;

public class App {
    public void run(){
        System.out.println("== 명언 앱 ==");
        while (true) {
            System.out.print("명령 ) ");
            String input = Container.getScanner().nextLine().trim();
            if (input.equals("종료")) {
                return;
            }

        }
    }
}
