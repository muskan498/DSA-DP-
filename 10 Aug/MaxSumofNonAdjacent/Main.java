// package 10 Aug;
import java.io.*;
import java.util.*;

public class Main {
    public static int MaxSum(int i, int n, ArrayList<Integer> arr){
        //bc
        if(i == n){
            return 0;
        }
        if(i==n-1){
            return arr.get(i);
        }
        int ansY = Integer.MIN_VALUE;
        int ansN = Integer.MIN_VALUE;

        if(i+2<=n)
            ansY = MaxSum(i+2, n, arr) + arr.get(i);
        if(i+1<=n)
            ansN = MaxSum(i+1, n, arr);
        int ans = Math.max(ansN, ansY);
        return ans;
    }

    public static int MaxSumMemo(int i, int n, ArrayList<Integer> arr, int[] dp){
        //bc
        if(i == n){
            return dp[i] = 0;
        }
        if(i==n-1){
            return dp[i] = arr.get(i);
        }
         if(dp[i]!= 0){
             return dp[i];
         }
        int ansY = Integer.MIN_VALUE;
        int ansN = Integer.MIN_VALUE;

        if(i+2<=n)
            ansY = MaxSumMemo(i+2, n, arr, dp) + arr.get(i);
        if(i+1<=n)
            ansN = MaxSumMemo(i+1, n, arr, dp);
        int ans = Math.max(ansN, ansY);
        return dp[i] = ans;
    }
    public static int MaxSumTabu(int i, int n, ArrayList<Integer> arr, int[] dp){
        
        dp[n] = 0;
        dp[n-1] = arr.get(n-1);
        int ansY = Integer.MIN_VALUE;
        int ansN = Integer.MIN_VALUE;
        for(i = n-2; i>=0; i--){
            if(i+2<=n)
                ansY = dp[i+2] + arr.get(i);
            if(i+1<=n)
                ansN = dp[i+1];
            dp[i] = Math.max(ansN, ansY);
        }
        return dp[0];
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        //int ans = MaxSum(0, nums.size(), nums);
        int [] dp = new int[nums.size()+1];
        //int ans = MaxSumMemo(0, nums.size(), nums, dp);
        int ans = MaxSumTabu(0, nums.size(), nums, dp);
        System.out.println(ans);
    }
}
