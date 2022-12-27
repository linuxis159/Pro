package src;

import java.util.*;

public class 캐시_LEVE_2 {
    static Scanner sc = new Scanner(System.in);
    static String[] cities = {"Jeju", "Jeju", "Jeju", "Jeju"};
    static int cacheSize = 0;
    static int count = 0;
    static List<String> cache = new LinkedList();
    public static void main(String[] args){
        cacheSize = sc.nextInt();


        for(int i=0; i<cities.length; i++){
            if(cache.contains(cities[i].toUpperCase())){
                // 캐시저장순서 변경
                for(int j=0; j<cache.size(); j++){
                    // 캐시가 적중된 순번
                    if(cities[i].toUpperCase().equals(cache.get(j).toUpperCase())){
                        //제거
                        cache.remove(j);
                        //가장 쇠신으로
                        cache.add(cities[i].toUpperCase());

                    }
                }
                count+=1;
            }
            else{
                cache.add(cities[i].toUpperCase());
                //캐시 사이즈를 초과했다면
                if(cache.size() > cacheSize){
                    //가장 오래된 거 삭제
                    cache.remove(0);
                }
                count+=5;
            }
        }
        System.out.println(count);
    }
}
