import java.io.*;
import java.util.*;
public class Main{
    
    public static int MinEnergy(int i, int n, int k, int[] earr){
        //bc
        if(i==n){
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        // int ans1 = Integer.MAX_VALUE;
        for(int j = 1; j <= k; j++){
            if(i+j<=n){
            int ans1 = MinEnergy(i+j, n, k, earr) + (int)(Math.abs(earr[i+j]-earr[i]));
            ans = Math.min(ans, ans1);
            }
        }
        return ans;
    }

    public static int MinEnergyMem(int i, int n, int k, int[] earr, int[] dp){
        //bc
        if(i==n){
            return dp[i] = 0;
        }
        if(dp[i]!=0){
            return dp[i];
        }
        int ans = Integer.MAX_VALUE;
        // int ans1 = Integer.MAX_VALUE;
        for(int j = 1; j <= k; j++){
            if(i+j<=n){
            int ans1 = MinEnergyMem(i+j, n, k, earr, dp) + (int)(Math.abs(earr[i+j]-earr[i]));
            ans = Math.min(ans, ans1);
            
            }
        }
        return dp[i] = ans;
    }

    public static void main(String[] args) {
        int n = 4; 
      int [] arr = {10,20,30,10}; 
      int[] dp = new int[n];
      System.out.println(MinEnergyMem(0, n-1, 2, arr, dp));
        
    }
}