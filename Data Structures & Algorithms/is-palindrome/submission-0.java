class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder res = new StringBuilder();
        for(char ch : s.toLowerCase().toCharArray()){
            if(Character.isLetterOrDigit(ch)){
                res.append(Character.toLowerCase(ch));
            }
        }
        return res.toString().equals(res.reverse().toString());
    }
}
