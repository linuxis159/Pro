package src;

import java.util.*;

class Solution {
    static List<String> str1Set = new ArrayList();
    static List<String> str2Set = new ArrayList();
    static int intersectionElementCount = 0;
    static int unionElementCount = 0;
    static Scanner sc = new Scanner(System.in);
    static boolean isAlphabetChar(char charecter){
        if(charecter >= 65 && charecter <=90) {
            return true;
        }
        else
            return false;
    }
    public static void main(String[] args) {
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        for(int i=0; i+1<str1.length(); i++){
            char first = str1.charAt(i);
            char second = str1.charAt(i+1);
            if(isAlphabetChar(first) && isAlphabetChar(second)){
                String targetString=first+""+second;
                if(str1Set.contains(targetString)){
                    int k =0;
                    String checkString = targetString;
                    for(;str1Set.contains(checkString); k++) {
                        checkString = targetString+k;
                    }
                    targetString = checkString;
                }
                str1Set.add(targetString);
            }
        }

        for(int i=0; i+1<str2.length(); i++){
            char first = str2.charAt(i);
            char second = str2.charAt(i+1);
            if(isAlphabetChar(first) && isAlphabetChar(second)){
                String targetString = first+""+second;
                if(str2Set.contains(targetString)){
                    int k =0;
                    String checkString = targetString;
                    for(;str2Set.contains(checkString); k++) {
                        System.out.println(k);
                        checkString = targetString+k;
                    }
                    targetString = checkString;
                }
                str2Set.add(targetString);
            }
        }

        System.out.println(str1Set.toString());
        System.out.println(str2Set.toString());

        List<String> str2Copy =str2Set.subList(0,str2Set.size()-1);
        for(int i = 0; i<str1Set.size(); i++){
            for(int j=0; j<str2Copy.size(); j++){
                if(str1Set.get(i).equals(str2Set.get(j))){
                    intersectionElementCount++;
                    System.out.println(str2Copy.get(j));
                    str2Copy.remove(j);
                    break;
                }
            }
        }




        str1Set.addAll(str2Set);
        Set<String> set = new HashSet();
        set.addAll(str1Set);
        unionElementCount = set.size();
        System.out.println(intersectionElementCount);
        System.out.println(unionElementCount);
        System.out.println((double)intersectionElementCount/unionElementCount);
        System.out.println((int)(intersectionElementCount == 0 && unionElementCount == 0 ? 1 : ((double)intersectionElementCount/unionElementCount) * 65536));

    }
}