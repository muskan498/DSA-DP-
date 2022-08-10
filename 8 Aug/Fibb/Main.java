import java.util.*;
import java.io.*;
public class Main{
    // public static int[] arr=new int[n+1];
    public static int fib(int n){
        //bc
        if(n==0||n==1)
        return n;
        //faith
        int ans1=fib(n-1);
        int ans2=fib(n-2);
        //exp
        int ans=ans1+ans2;
        return ans;
    }
    public static int fibMem(int n,int[] dp){
        //bc
        if(n==0||n==1)
        return dp[n]=n;
        //chekcing if our subproblem is already solved
        if(dp[n]!=0){ //[0,0,0,0,0,0] //-1 or 0 shows that the value is not calculated at tht index
            return dp[n];
        }
        //faith
        int ans1=fib(n-1);
        int ans2=fib(n-2);
        //exp
        int ans=ans1+ans2;
        return dp[n]=ans;
    }

    public static int fibtab(int n, int[] dp){
        dp[0] = 0;
        dp[1] = 1;

        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    public static void main(String[] args){
    int n=7;
    // int [] dp=new int[n+1];
    // System.out.println(fibMem(n, dp));
    // System.out.println(fibtab(n, dp));
    int prev = 0;
    int prev1 = 1;
    int curr=0;
    for(int i=2; i<=n; i++){
        curr = prev + prev1;
        prev = prev1;
        prev1 = curr;
    }
    System.out.println(curr);
    }
}