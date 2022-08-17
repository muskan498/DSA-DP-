//package 11 Aug.HouseRobber;
import java.io.*;
import java.util.*;
public class Main {
    
    public static int MaxSumSO(int i, int n, ArrayList<Integer> arr){
        int next2 = 0;
        int next1 = arr.get(n-1);
            
        int ansY = Integer.MIN_VALUE;
        int ansN = Integer.MIN_VALUE;
        int curr = 0; 
        for(i = n-2; i>=0; i--){
            if(i+2<=n)
                ansY = next2 + arr.get(i);
            if(i+1<=n)
                ansN = next1;
            curr = Math.max(ansN, ansY);
            next2 = next1;
            next1 = curr;            
        }
        return next1;
    }
    
    public static void main(String[] args) {
        int [] valueInHouse = {2, 3, 2};
        int n = valueInHouse.length;
        if(n == 1){
            System.out.print(valueInHouse[0]);
        }
        ArrayList<Integer> nums1 = new ArrayList<>();
        ArrayList<Integer> nums2 = new ArrayList<>();
        for(int i = 0; i<= n-1; i++){
            if(i!=0){
                nums1.add(valueInHouse[i]);
            }
            if(i!=n-1){
                nums2.add(valueInHouse[i]);
            }
        }
        long ans = MaxSumSO(0, nums1.size(), nums1); 
        long ans1 = MaxSumSO(0, nums2.size(), nums2); 
        long result = Math.max(ans, ans1);
        System.out.println(result);
	}	
    
}
