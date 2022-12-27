package src;

import java.util.Scanner;
import java.util.Stack;

public class 괄호_회전하기_LEVEL2 {
    static Scanner sc = new Scanner(System.in);
    static Stack<Character> stack = new Stack();
    static String target;
    static boolean resultFlag = false;
    static boolean checkChar(char target){
        boolean resultFlag = false;
        if(stack.isEmpty())
            return resultFlag;
        char popedChar = stack.pop();
        if(popedChar == '[' && target == ']'){
            resultFlag = true;
        }
        else if(popedChar == '(' && target == ')'){
            resultFlag = true;
        }
        else if(popedChar == '{' && target == '}'){
            resultFlag = true;
        }
        return resultFlag;

    }
    static String leftShift(String target){
        char[] tempString = new char[target.length()];
        for(int i = 0; i<target.length(); i++){
            if(i == 0){
                tempString[target.length()-1] = target.charAt(0);
            }
            else{
                tempString[i-1] = target.charAt(i);
            }
        }

        StringBuilder sb = new StringBuilder(target);
        for(int i=0; i<tempString.length; i++){
            sb.setCharAt(i,tempString[i]);
        }
        return sb.toString();
    }
    public static void main(String[] args){
        String target = sc.next();

        int count = 0;
        for(int j=0; j<target.length(); j++) {
            boolean result = false;
            for (int i = 0; i < target.length(); i++) {
                if (target.charAt(i) == '[' || target.charAt(i) == '(' || target.charAt(i) == '{')
                    stack.push(target.charAt(i));
                else {
                   result = checkChar(target.charAt(i));
                   if(!result)
                       break;
                }
            }
            if(result && stack.isEmpty())
                count++;
            stack.clear();
            target = leftShift(target);

        }
        System.out.println(count);
    }
}
