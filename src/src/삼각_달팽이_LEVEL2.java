package src;

import java.util.Scanner;

public class 삼각_달팽이_LEVEL2 {
    static int count = 0;
    static int y;
    static int x;
    static int array[][];
    static int maxCount = 0;
    static int k = 0;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int n = sc.nextInt();
        array = new int[n][n*2-1];
        y = -1;
        x = n;
        if(n % 2 == 0){
            maxCount =  (1 + n) * (n/2);
        }
        else{
            maxCount = ((1 + n)) * (n/2) + (n/2 +1);
        }
        int result[] = new int[maxCount];
        for(; count<maxCount;){
            first();
            second();
            third();

        }
        for(int i = 0; i<n; i++){
            for(int j =0; j < n*2-1; j++){
                if(array[i][j] != 0) {
                    result[k] = array[i][j];
                    k++;
                }

            }
        }
    }
    static void first(){

        while((array.length > y+1 && x-1 >= 0) && array[y+1][x-1] == 0){
            System.out.println("first" + "X:" + x + " Y: " + y );
            array[++y][--x] = ++count;
        }
    }
    static void second(){
        while(x+2 < array[y].length && array[y][x+2] == 0){
            System.out.println("second" + "X:" + x + " Y: " + y );
            x += 2;
            array[y][x] = ++count;
        }
    }
    static void third(){
        while((0 <= y-1 && x-1 >= 0) && array[y-1][x-1] == 0){
            System.out.println("third" + "X:" + x + " Y: " + y );
            array[--y][--x] = ++count;
        }
    }
}
