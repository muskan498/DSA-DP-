package FrogJump;
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

    public static int MinEnergyMem(int i, int n, int[] earr, int[] dp){
        //bc
        if(i==n){
            return dp[i] = 0;
        }
        if(dp[i] != 0)
        return dp[i];

        int ans1 = Integer.MAX_VALUE;
        int ans2 = Integer.MAX_VALUE;

        if(i+1<=n)
        ans1 = MinEnergyMem(i+1, n, earr, dp) + (int)(Math.abs(earr[i+1]-earr[i]));
        if(i+2<=n)
        ans2 = MinEnergyMem(i+2, n, earr, dp) + (int)(Math.abs(earr[i+2]-earr[i]));
        int ans = Math.min(ans1, ans2);
        return dp[i] = ans ;

    }

    public static int MinEnergyTab(int i, int n, int[] earr, int[] dp){
        dp[n] = 0;

        int ans1 = Integer.MAX_VALUE;
        int ans2 = Integer.MAX_VALUE;

        for(i = n-1; i>=0; i--){
            if(i+1<=n)
                ans1 = dp[i+1] + (int)(Math.abs(earr[i+1]-earr[i]));
            if(i+2<=n)
                ans2 = dp[i+2] + (int)(Math.abs(earr[i+2]-earr[i]));
            dp[i] = Math.min(ans1, ans2);
        }
        return dp[0];
    }

    public static int MinEnergySO(int i, int n, int[] earr){
        int next1 = 0;
        int next = (int)(Math.abs(earr[n]-earr[n-1]));
        
        int ans1 = Integer.MAX_VALUE;
        int ans2 = Integer.MAX_VALUE;

        int curr = 0;
        for (i = n-2; i >= 0; i--){
                ans1 = next + (int)(Math.abs(earr[i+1]-earr[i]));
                ans2 = next1 + (int)(Math.abs(earr[i+2]-earr[i]));
            curr = Math.min(ans1, ans2);
            next1 = next;
            next = curr;
        }
        return next;
    }

    public static void main(String[] args) {
      int n = 4; 
      int [] arr = {10,20,30,10}; 
    //   int [] dp = new int[n];
    //   System.out.println(MinEnergyMem(0, n-1, arr, dp));
      System.out.println(MinEnergySO(0, n-1, arr));
    }
    
}

