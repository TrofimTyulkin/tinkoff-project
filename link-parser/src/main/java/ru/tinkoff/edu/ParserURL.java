package ru.tinkoff.edu;

import java.util.Scanner;

public class ParserURL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("type URL");
        String test = sc.nextLine();
        test = test.strip();
        System.out.println(test);
        if (test.startsWith("https://") || test.startsWith("http://")){
            test = test.split("://")[1];
            String[] piece_url = test.split("/");
            switch (piece_url[0]){
                case ("github.com") -> {
                    GitHub some = new GitHub(piece_url[1], piece_url[2]);
                    System.out.println(some);
                }
                case ("stackoverflow.com") -> {
                    StackOverFlow some = new StackOverFlow(piece_url[2]);
                    System.out.println(some);
                }
                default -> System.err.println("BAD");
            }
        }
        else {
            System.err.println("BAD");
        }
    }
    record GitHub(String user, String repository){}
    record StackOverFlow(String id){}
}
//        https://github.com/sanyarnd/tinkoff-java-course-2022/
//        https://stackoverflow.com/questions/1642028/what-is-the-operator-in-c
//        https://stackoverflow.com/search?q=unsupported%20link