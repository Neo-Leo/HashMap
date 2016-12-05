/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/group-shifted-strings/
 */ 

public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        //Arrays.sort(strings); // This is o(m^2 * n^2 * logm * logn) where m is the avg length of a string and n are such total strings
        List<List<String>> resList = new LinkedList<List<String>>(); 
        HashMap<String, List<String>> hm = new HashMap<String, List<String>>();
        for(String s : strings) { // This is O(m*n)
            StringBuilder sb = new StringBuilder(); 
            sb.append("0");
            for(int i=1; i<s.length(); i++){ // This is o(m)
                int diff = s.charAt(i) - s.charAt(i-1);
                if(diff>=0)
                    sb.append(diff);
                else 
                    sb.append(diff + 26);
            }
            String key = new String(sb);
            List<String> tempList;
            if(hm.containsKey(key)){ // O(1)
                tempList = hm.get(key);
            } else {
                tempList = new ArrayList<String>();
            }
            tempList.add(s);
            hm.put(key,tempList);
        }
        for(String s : hm.keySet()){ // O(n)
            /*
            Collections.sort(hm.get(s), new Comparator<String>(){
                public int compare(String s1, String s2){
                    return s1.compareTo(s2); 
                }
            });
            */ 
            // Strings can be sorted without any custom comparator
            Collections.sort(hm.get(s)); 
            resList.add(hm.get(s));
        }
        return resList;
    }
}
