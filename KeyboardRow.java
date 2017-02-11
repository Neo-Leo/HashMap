/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/keyboard-row/
 */ 

public class KeyboardRow {
    public String[] findWords(String[] words) {
        HashMap<Character,Integer> hm = new HashMap<Character, Integer>(); 
        String[] strings = {"qQwWeErRtTyYuUiIoOpP","aAsSdDfFgGhHjJkKlL","zZxXcCvVbBnNmM"}; 
        for(int i=0; i<=strings.length-1; i++){
            for(char ch : strings[i].toCharArray()){
                hm.put(ch,i);
            }
        }
        List<String> list = new ArrayList<String>(); 
        for(int i=0; i<=words.length-1; i++) {
            int prev = -1;
            boolean add=true; 
            for(char ch : words[i].toCharArray()) {
                if(prev == -1) {
                    prev = hm.get(ch); 
                } else {
                    if(prev != hm.get(ch)) {
                        add = false; 
                        break; 
                    } 
                }
            }
            if(add) list.add(words[i]); 
        }
        String[] res = new String[list.size()];
        for(int i=0; i<=list.size()-1; i++){
            res[i] = list.get(i);
        }
        return res; 
    }
}