package FronJump;
import java.io.*;
import java.util.*;
public class Main {

    public static int MinEnergy(int i, int n, int[] earr){
        //bc
        if(i==n){
            return 0;
        }
        int ans1 = Integer.MAX_VALUE;
        int ans2 = Integer.MAX_VALUE;

        if(i+1<=n)
        ans1 = MinEnergy(i+1, n, earr) + (int)(Math.abs(earr[i+1]-earr[i]));
        if(i+2<=n)
        ans2 = MinEnergy(i+2, n, earr) + (int)(Math.abs(earr[i+2]-earr[i]));
        int ans;
        return ans = Math.min(ans1, ans2);

    }
    public static void main(String[] args) {
      int n = 4; 
      int [] arr = {10,20,30,10}; 
      System.out.println(MinEnergy(0, n-1, arr));
    }
    
}
