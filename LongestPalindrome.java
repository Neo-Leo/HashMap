/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/longest-palindrome/
 */ 

public class Solution {
    public int longestPalindrome(String s) {
        if(s == null || s.length() == 0) return 0; 
        int result=0; 
        HashSet<Character> hs = new HashSet<Character>(); 
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i); 
            if(!hs.contains(ch)) {
                hs.add(ch);
            } else {
                hs.remove(ch);
                result += 2; 
            }
        }
        if(hs.size() == 0) return result; 
        else return result+1; 
    }
}