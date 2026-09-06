class Solution {
    public int countSubstrings(String s) {
        int count = 0;

        for(int i = 0; i < s.length(); i++){
            count += countPalindrome(s, i , i);
            count += countPalindrome(s, i , i + 1);
        }

        return count;
    }

    public int countPalindrome(String s, int l, int r){
        int count = 0;

        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            count++;
            l--;
            r++;
        }

        return count;
    }
}
