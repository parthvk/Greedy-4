// Time Complexity :O(s+t)
// Space Complexity :O(s)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

class Solution {
    public int shortestWay(String source, String target) {
        HashMap<Character, List<Integer>> map = new HashMap<>();
        //HashMap to store the source characters and it's indexes in
        for(int i=0; i<source.length(); i++){
            char c = source.charAt(i);
            if(!map.containsKey(c)){
                map.put(c, new ArrayList<>());
            }
            map.get(c).add(i);
        }
        // System.out.println(map);

        int i = 0;
        int j = 0;
        int result = 1;
        //Go through all the characters in tagret
        // If that character is not there in hahsmap, return -1
        //We have to find how many times we reset the index in the list in hashmap to zero
        while(i < target.length()){
            char t = target.charAt(i);
            if(map.containsKey(t)){
                List<Integer> list = map.get(t);
                int sch = Collections.binarySearch(list, j);
                // System.out.println(sch);
                if(sch < 0){
                    sch = -sch-1;
                    
                }
                if(sch == list.size()){
                    sch = 0;
                    result++;
                }
                j = list.get(sch);
                i++;
                j++;  
            }
            else{
                return -1;
            }
        }
        return result;
    }
}