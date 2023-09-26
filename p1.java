// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        //check if the top element is the one which which can be the same
        int re = check(tops, bottoms, tops[0]);
        if(re != -1) return re;
        //check if the top element is the one which which can be the same
        return check(tops, bottoms, bottoms[0]);
    }

    private int check(int[] tops, int[] bottoms, int target){
        int top = 0;
        int bottom = 0;
        //Go through all the pairs and check the number of rotations required to make the top or bottom same
        for(int i=0; i<tops.length; i++){
            if(tops[i] != target && bottoms[i] != target){
                return -1;
            } else if(bottoms[i] == target && tops[i] == target){
                continue;
            } else if(bottoms[i] == target){
                bottom++;
            } else{
                top++;
            }

        }
        return Math.min(top, bottom);
    }
}