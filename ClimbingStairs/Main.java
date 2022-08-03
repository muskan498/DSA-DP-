package ClimbingStairs;
import java.util.*;
import java.io.*;
public class Main {

    public static int AllWaysClimbingStairs(int i, int n){
        //bc
        if(i==n){
            return 1;
        }
        int ans1 = 0, ans2 = 0, ans;

        if(i+1<=n)
        ans1 = AllWaysClimbingStairs(i+1, n);
        if(i+2<=n)
        ans2 = AllWaysClimbingStairs(i+2, n);
        
        return ans = ans1 + ans2;
    }
    
    public static int Memo(int i, int n, int[] dp){
        if(i==n){
            return dp[i] = 1;
        }
        if(dp[i] != 0)
        return dp[i];

        int ans1 = 0, ans2 = 0, ans;
        if(i+1<=n)
        ans1 = Memo(i+1, n, dp);
        if(i+2<=n)
        ans2 = Memo(i+2, n, dp);
        ans = ans1 + ans2;
        return dp[i] = ans;
    }

    public static int tab(int n, int [] dp){
        dp[n] = 1;
        dp[n-1] = 1;

        for(int i = n-2; i>=0; i--){
            dp[i] = dp[i+1] + dp[i+2];
        }
        return dp[0];
    } 
    public static void main(String[] args) {
        int n = 3;
        // int [] dp = new int[n+1];
        // System.out.println(AllWaysClimbingStairs(0, n));
        // System.out.println(Memo(0, n, dp));
        // System.out.println(tab(n, dp));
        int next = 1;
        int next2 = 1;
        int curr = 0;

        for (int i = n-2; i >= 0; i--){
            curr = next + next2;
            next2 = next;
            next = curr;
        }
        System.out.println(curr);
    }
    
}
