package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Scanner scan;
    private static String[][] text = new String[12][1];


    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("src/com/company/data.txt");
        scan = new Scanner(file);
        int i = 0;
        while (scan.hasNextLine()) {
            text[i] = scan.nextLine().split(" ");

            i++;
        }


        // todo: print alle ord der starter med det der sendes med som argument,
        //printWordsStartingWith("Ø");
        //todo: print alle ord der har præcis det antal bogstaver der sendes med som argument (inkluderer IKKE tal og tegnene '.' og ',')
        //printWordsOfLength(3);


        //test dine metoder ved at kalde dem her:

        // todo: Task 1
        // printWordsWithDoubleConsonant();

        // todo: Task 2
        //..

        // todo: Task 3
        //printPartOfWord("København", 1, 10);

        // todo: Task 4
        printIfPalindrome("Den laks skal ned");

    }

    public static void printIfPalindrome(String sentence){
        String strReverse = new StringBuffer(sentence.toLowerCase()).reverse().toString();
        if(sentence.toLowerCase().equals(strReverse)) {
            System.out.println("\"" + sentence + "\"" + " is a palindrome .");
        }
        else {
            System.out.println("\"" + sentence + "\"" + " is not a palindrome.");
        }
    }


    private static void printPartOfWord(String word, int index, int len) {
        boolean tooLong = true;
        while(tooLong) {
            try {
                String subString = word.substring(index, index + len);
                System.out.println(subString);
                tooLong = false;

            } catch (StringIndexOutOfBoundsException e) {
                System.out.println(e);
                len--;
            }
        }
    }


    private static void printWordsOfLength(int l) {
        boolean wordisvalid = true;

        for (int i = 0; i < text.length; i++) {
            for (String s : text[i]) {
                if (s.length() == l) {
                    if (s.contains(",") || s.contains(".")) {
                        wordisvalid = false;
                    }
                     /*for (int j = 0; j < s.length(); j++) {
                         char c = s.charAt(j);
                         if(c == '.' || c == ','){
                             wordisvalid = false;
                         }
                     }*/
                    if (wordisvalid) {
                        System.out.println(s);
                    }
                }
            }
        }
    }

    private static void printWordsStartingWith(String pattern) {

        for (int i = 0; i < text.length; i++) {
            for (String s : text[i]) {
                if (s.startsWith(pattern) || s.startsWith(pattern.toLowerCase())) {
                    System.out.println(s);
                }
            }
        }
    }

    //skriv dine metoder herunder:
    private static void printWordsWithDoubleConsonant() {
        boolean wordisvalid = false;

        for (int i = 0; i < text.length; i++) {
            for (String s : text[i]) {
                for (int j = 0; j < s.length() - 1; j++) {
                    char c = s.charAt(j);
                    if (s.charAt(j) == s.charAt(j + 1)) {
                        if (checkCharType(c)) {
                            wordisvalid = true;
                        }
                    } else {
                        wordisvalid = false;
                    }
                    if (wordisvalid) {
                        System.out.println(s);
                    }
                }
            }
        }
    }

    private static boolean checkCharType(char c) {
        char ch = c;
        if (Character.isDigit(ch)) {
            return false;
        } else {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return false;
            } else {
                return true;
            }
        }
    }
}
