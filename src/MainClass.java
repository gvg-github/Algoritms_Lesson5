/* Гурьевских В.Г.
(Task1) Реализовать перевод из 10 в 2 систему счисления с использованием стека.
(Task2) Написать программу, которая определяет, является ли введенная скобочная последовательность правильной.
(Task3) Реализовать очередь.

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {

        //Перевод из 10 в 2 систему счисления с использованием стека.
        Task1();

        //Определение, является ли введенная скобочная последовательность правильной.
        try {
            Task2();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Реализовать очередь.
        Task3();
    }

    //Реализовать очередь.
    private static void Task3() {
        MyQueue queue = new MyQueue();
        System.out.println("Push in queue: 10, 20, 30, 40");
        queue.push(10);
        queue.push(20);
        queue.push(30);
        queue.push(40);
        System.out.println("Take from queue:");
        System.out.print(queue.pop());
        System.out.print("," + queue.pop());
        System.out.print("," + queue.pop());
        System.out.print("," + queue.pop());
        System.out.println("," + queue.pop());
        System.out.println("Push in queue: 30, 40");
        queue.push(30);
        queue.push(40);
        System.out.println("Take from queue:");
        System.out.print(queue.pop());
        System.out.print("," + queue.pop());

    }

    //Перевод из 10 в 2 систему счисления с использованием стека.
    private static void Task1() {

        Scanner scr = new Scanner(System.in);
        System.out.println("Enter number in decimal format:");
        int number = scr.nextInt();
        converToBinaryFormat(number);

    }

    private static void converToBinaryFormat(int number) {
        int tecNumber = number;

        //Стек реализован в отдельном классе.
        MyStack stack = new MyStack();

        do {
            stack.push(number%2);
            number = number/2;
        }while(number > 0);
        System.out.println(Short.MAX_VALUE);
        System.out.println("Decimal format: " + tecNumber + ", bunary format: " + stack.toString());
    }

    //+ Определение, является ли введенная скобочная последовательность правильной.
    private static void Task2() throws IOException {
        char[] arrOpen = new char[]{'(', '[', '{'};
        char[] arrClose = new char[]{')', ']', '}'};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter mathematical expression with brackets:");
        String s = br.readLine();
        char[] input = s.toCharArray();
        checkBrackets(input, arrOpen, arrClose);
    }

    private static void checkBrackets(char[] input, char[] arrOpen, char[] arrClose) {

        char[] stack = new char[input.length];
        boolean isOpenBracket;
        int closeBracket;
        boolean removedFromStack;
        int count = 0;

        for (int i = 0; i < input.length; i++) {
            isOpenBracket = checkOpenBrackets(input[i], arrOpen);
            if (isOpenBracket) {
                count = addToStack(count, input[i], stack);
            } else {
                closeBracket = checkCloseBrackets(input[i], arrClose);
                if (closeBracket != -1) {
                    removedFromStack = findRemoveBracketFromStack(count, stack, closeBracket, arrOpen);
                    if (removedFromStack) {
                        count--;
                    } else {
                        System.out.println("Pair not found for bracket: " + input[i] + ", index:" + i);
                        count++;
                        break;
                    }
                }
            }
        }
        if (count > 0){
            System.out.println("Wrong brackets sequence!");
        }else{
            System.out.println("Brackets sequence is correct!");
        }
    }

    private static boolean findRemoveBracketFromStack(int count, char[] stack, int closeBracket, char[] arrOpen) {
        char item = stack[count - 1];
        if (item == arrOpen[closeBracket]) {
            return true;
        }
        return false;
    }

    private static int addToStack(int index, char c, char[] stack) {
        stack[index] = c;
        return ++index;
    }

    private static int checkCloseBrackets(char item, char[] arrClose) {
        for (int i = 0; i < arrClose.length; i++) {
            if (item == arrClose[i]) return i;
        }
        return -1;
    }

    private static boolean checkOpenBrackets(char item, char[] arrOpen) {
        for (int i = 0; i < arrOpen.length; i++) {
            if (item == arrOpen[i]) return true;
        }
        return false;
    }//- Определение, является ли введенная скобочная последовательность правильной.

}

