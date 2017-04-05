/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/happy-number/
 */ 

public class HappyNumber {
    public boolean isHappy(int n) {
        HashSet<Integer> hs = new HashSet<Integer>();
        while(true) {
            int sum = 0; 
            while(n != 0) {
                int digit = n%10;
                sum += digit*digit; 
                n = n/10; 
            }
            if(sum == 1) break;  
            if(hs.contains(sum)) return false;
            hs.add(sum);
            n = sum;
        }
        return true;
    }
}