package src;

import java.awt.desktop.SystemSleepEvent;
import java.util.Scanner;

public class 이진변환반복하기_LEVEL2 {
    static int removedZerocount = 0;
    static int convertCount = 0;
    static Scanner sc = new Scanner(System.in);
    static String stringLengthConvertToBinaryString(int stringLength){
        convertCount++;
        String binaryString = "";
        for(;stringLength != 0;){
            if(stringLength % 2 == 0)
                binaryString  =  0 + binaryString;
            else
                binaryString = 1 + binaryString;
            stringLength = stringLength / 2;
        }
        System.out.println(binaryString);
        return binaryString;
    }
    static String removeZeroChar(String oneOrZero){
        String onesString = "";
        for(int i = 0; i<oneOrZero.length(); i++){
            char oneOrZeroChar = oneOrZero.charAt(i);
            if(oneOrZeroChar == '1'){
                onesString += '1';
            }
        }
        removedZerocount += oneOrZero.length() - onesString.length();
        System.out.println(onesString);
        return onesString;
    }


    public static void main(String[] args){
        String s = sc.next();
        for(; ;){
            String onlyOnesString = removeZeroChar(s);
            if(onlyOnesString.equals("1")){

                break;
            }
            s = stringLengthConvertToBinaryString(onlyOnesString.length());
        }
        System.out.println(removedZerocount+" "+convertCount + 1);

    }
}
