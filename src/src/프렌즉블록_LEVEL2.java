package src;

import java.util.*;

public class 프렌즉블록_LEVEL2 {
    static List<Character> block = Arrays.asList('R','M','A','F','N','T','J','C');
    static Scanner sc = new Scanner(System.in);
    static String[] board;
    static int m;
    static int count = 0;
    static boolean flag = true;
    public static void main(String[] args) {

        m = sc.nextInt();
        board = new String[m];
        for(int i=0; i<m; i++){
            board[i] = sc.next();
        }
        for(;flag;) {
            flag = false;
            for (int i = m-2; i>=0; i--) {
                for (int j = 0; j < board[i].length(); j++) {
                    if(board[i].charAt(j) != '#' && board[i+1].charAt(j) == '#'){
                        for(int k=i+1; board[k].charAt(j) == '#'&& k+1<m; k++){
                            if(board[k+1].charAt(j) != '#' || k+1 == m-1){
                                if(k+1 == m-1 && board[k+1].charAt(j) =='#'){
                                    StringBuffer sb1 = new StringBuffer(board[k+1]);
                                    StringBuffer sb2 = new StringBuffer(board[i]);
                                    sb1.setCharAt(j,board[i].charAt(j));
                                    board[k+1] = sb1.toString();
                                    sb2.setCharAt(j,'#');
                                    board[i] = sb2.toString();
                                }
                                {
                                    StringBuffer sb1 = new StringBuffer(board[k]);
                                    StringBuffer sb2 = new StringBuffer(board[i]);
                                    sb1.setCharAt(j, board[i].charAt(j));
                                    board[k] = sb1.toString();
                                    sb2.setCharAt(j, '#');
                                    board[i] = sb2.toString();
                                }
                                break;
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < board[i].length(); j++) {
                    explode(i, j);
                }
            }
        }
        System.out.println(count);
    }
    static void explode(int y, int x){
        recursive(y,x);
    }

    static void recursive(int y, int x){
        if(y <= -1 || y >= m)
            return;
        if(x <= -1 || board[y].length() <= x)
            return;
        if(x+1 >= board[y].length())
            return;
        if(y+1 >= m)
            return;
        char firstValue = board[y].charAt(x);
        if(firstValue == '#')
            return;
        if(firstValue == board[y].charAt(x+1) && firstValue == board[y+1].charAt(x)
        && firstValue == board[y+1].charAt(x+1)) {
            System.out.println("x:"+x+"y:"+y+"value:"+board[y].charAt(x));
            recursive(y,x+1);
            recursive(y+1,x+1);
            recursive(y+1,x);
            recursive(y+1,x-1);
            StringBuffer sb1 = new StringBuffer(board[y]);
            if(sb1.charAt(x) != '#') {
                sb1.setCharAt(x, '#');
                count++;
            }
            if(sb1.charAt(x+1) != '#') {
                sb1.setCharAt(x + 1, '#');
                count++;
            }
            board[y] = sb1.toString();
            StringBuffer sb2 = new StringBuffer(board[y+1]);
            if(sb2.charAt(x) != '#') {
                sb2.setCharAt(x, '#');
                count++;
            }
            if(sb2.charAt(x+1) != '#') {
                sb2.setCharAt(x + 1, '#');
                count++;
            }

            board[y+1] = sb2.toString();

            flag = true;
        }
    }
}
