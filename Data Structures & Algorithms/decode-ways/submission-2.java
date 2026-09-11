class Solution {
    public int numDecodings(String s) {
        Integer[] memo = new Integer[s.length()];
        return dfs(0, s, memo);
    }

    private int dfs(int i, String s, Integer[] memo){
        if(i == s.length()) return 1;
        if(s.charAt(i) == '0') return 0;
        
        if(memo[i] != null) return memo[i];

        int res = dfs(i + 1, s, memo);
        if(i < s.length() - 1){
            if(s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) < '7')){
                res += dfs(i + 2, s, memo);
            }
        }

        memo[i] = res;

        return res;
    }
}
