import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String min = "";
        int mincnt = 0 ;
        String max = "";
        int maxcnt = 0;
        for(int i = 0 ; i<input.length() ; i++){
            if(input.charAt(i)=='K'){
                if(mincnt==0) min+=5;
                if(mincnt!=0) {
                    min+=1;
                    for(int j = 0 ; j<mincnt-1 ; j++){
                        min+=0;
                    }
                    min+=5;
                    mincnt = 0;
                }
                if(maxcnt==0) max+=5;
                if (maxcnt!=0) {
                    max+=5;
                    for(int j = 0 ; j<maxcnt; j++){
                        max+=0;
                    }
                    maxcnt = 0;
                }
            }else{
                mincnt++;
                maxcnt++;
            }
        }
        if(mincnt!=0) {
            min+=1;
            for(int i = 0 ; i<mincnt-1;i++){
                min+=0;
            }
        }
        if(maxcnt!=0) {
            for(int i = 0 ; i<maxcnt; i++){
                max+=1;
            }
        }
        System.out.println(max);
        System.out.println(min);
        }


}
