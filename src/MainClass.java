/* Гурьевских В.Г.

(Task1) Написать программу, которая определяет, является ли введенная скобочная последовательность правильной.

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainClass {

    public static void main(String[] args) {
        //Определение, является ли введенная скобочная последовательность правильной.
        try {
            Task1();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //+ Определение, является ли введенная скобочная последовательность правильной.
    private static void Task1() throws IOException {
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
