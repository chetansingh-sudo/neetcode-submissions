
class Solution {
    /*Function to find the minimum length substring
    in string s that contains all characters from string t.*/
    public String minWindow(String s, String t) {
        
        /* Variable to store the minimum
        length of substring found*/
        int minLen = Integer.MAX_VALUE;
        
        /* Variable to store the starting index
        of the minimum length substring*/
        int sIndex = -1;
        
        // Iterate through string s
        for (int i = 0; i < s.length(); ++i) {
            
            // Array to count frequencies of characters in t
            int[] hash = new int[256];
            for (char c : t.toCharArray()) {
                hash[c]++;
            }
            
            int count = 0;
            
            // Iterate through current window 
            for (int j = i; j < s.length(); ++j) {
                if (hash[s.charAt(j)] > 0) {
                    count++;
                }
                hash[s.charAt(j)]--;
                
                /* If all characters from t 
                are found in current window*/
                if (count == t.length()) {
                    
                    /* Update minLen and sIndex 
                    if current window is smaller*/
                    if (j - i + 1 < minLen) {
                        minLen = j - i + 1;
                        sIndex = i;
                    }
                    break;
                }
            }
        }
        
        // Return the minimum length substring from s
        return (sIndex == -1) ? "" : s.substring(sIndex, sIndex + minLen);
    }

   
}
