// package 15Aug.LongestCommonLengthSS;

public class Main {
    public static int maxLengthCommonSSString(int i1, int i2, String s1, String s2) {
        // bc
        if (i1 == 0 && i2 == 0) {
            if (s1.charAt(i1) == s2.charAt(i2))
                return 1;
            return 0;
        }
        // exp
        int ans = 0;
        if (s1.charAt(i1) == s2.charAt(i2)) {
            int ansMatch = 0;
            // oob
            if (i1 - 1 >= 0 && i2 - 1 >= 0)
                ansMatch = maxLengthCommonSSString(i1 - 1, i2 - 1, s1, s2);

            ans = 1 + ansMatch;
        } else {
            int ansMatchi1 = Integer.MIN_VALUE;
            int ansMatchi2 = Integer.MIN_VALUE;
            // i1
            if (i1 - 1 >= 0)
                ansMatchi1 = maxLengthCommonSSString(i1 - 1, i2, s1, s2);
            // i2
            if (i2 - 1 >= 0)
                ansMatchi2 = maxLengthCommonSSString(i1, i2 - 1, s1, s2);
            ans = 0 + Math.max(ansMatchi1, ansMatchi2);
        }
        return ans;
    }

    public static int maxLengthCommonSSStringMemo(int i1, int i2, String s1, String s2, int[][] dp) {
        // bc
        if (i1 == 0 && i2 == 0) {
            if (s1.charAt(i1) == s2.charAt(i2))
                return dp[i1][i2] = 1;
            else
                return dp[i1][i2] = 0;
        }
        // sub
        if (dp[i1][i2] != -1)
            return dp[i1][i2];
        // exp
        int ans = 0;
        if (s1.charAt(i1) == s2.charAt(i2)) {
            int ansMatch = 0;
            // oob
            if (i1 - 1 >= 0 && i2 - 1 >= 0)
                ansMatch = maxLengthCommonSSStringMemo(i1 - 1, i2 - 1, s1, s2, dp);

            ans = 1 + ansMatch;
        } else {
            int ansMatchi1 = Integer.MIN_VALUE;
            int ansMatchi2 = Integer.MIN_VALUE;
            // i1
            if (i1 - 1 >= 0)
                ansMatchi1 = maxLengthCommonSSStringMemo(i1 - 1, i2, s1, s2, dp);
            // i2
            if (i2 - 1 >= 0)
                ansMatchi2 = maxLengthCommonSSStringMemo(i1, i2 - 1, s1, s2, dp);
            ans = 0 + Math.max(ansMatchi1, ansMatchi2);
        }
        return dp[i1][i2] = ans;
    }

    public static int maxLengthCommonSSStringTabu(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];
        // direction
        for (int i1 = 0; i1 < dp.length; i1++) {
            for (int i2 = 0; i2 < dp[0].length; i2++) {
                // bc
                if (i1 == 0 && i2 == 0) {
                    if (s1.charAt(i1) == s2.charAt(i2))
                        dp[i1][i2] = 1;
                    else
                        dp[i1][i2] = 0;
                } else {
                    int ans = 0;
                    if (s1.charAt(i1) == s2.charAt(i2)) {
                        int ansMatch = 0;
                        // oob
                        if (i1 - 1 >= 0 && i2 - 1 >= 0)
                            ansMatch = dp[i1 - 1][i2 - 1];

                        ans = 1 + ansMatch;
                    } else {
                        int ansMatchi1 = Integer.MIN_VALUE;
                        int ansMatchi2 = Integer.MIN_VALUE;
                        // i1
                        if (i1 - 1 >= 0)
                            ansMatchi1 = dp[i1 - 1][i2];
                        // i2
                        if (i2 - 1 >= 0)
                            ansMatchi2 = dp[i1][i2 - 1];
                        ans = 0 + Math.max(ansMatchi1, ansMatchi2);
                    }
                    dp[i1][i2] = ans;
                }

            }
        }
        
        return dp[dp.length - 1][dp[0].length - 1];
    }

    public static int longestCommonSS(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];
        // direction
        for (int i1 = 0; i1 < dp.length; i1++) {
            for (int i2 = 0; i2 < dp[0].length; i2++) {
                // bc
                if (i1 == 0 && i2 == 0) {
                    if (s1.charAt(i1) == s2.charAt(i2))
                        dp[i1][i2] = 1;
                    else
                        dp[i1][i2] = 0;
                } else {
                    int ans = 0;
                    if (s1.charAt(i1) == s2.charAt(i2)) {
                        int ansMatch = 0;
                        // oob
                        if (i1 - 1 >= 0 && i2 - 1 >= 0)
                            ansMatch = dp[i1 - 1][i2 - 1];

                        ans = 1 + ansMatch;
                    } else {
                        int ansMatchi1 = Integer.MIN_VALUE;
                        int ansMatchi2 = Integer.MIN_VALUE;
                        // i1
                        if (i1 - 1 >= 0)
                            ansMatchi1 = dp[i1 - 1][i2];
                        // i2
                        if (i2 - 1 >= 0)
                            ansMatchi2 = dp[i1][i2 - 1];
                        ans = 0 + Math.max(ansMatchi1, ansMatchi2);
                    }
                    dp[i1][i2] = ans;
                }

            }
        }
        // getting the substring (trting to get the common substring from the dp only)
        char[] ans = new char[dp[dp.length - 1][dp[0].length - 1]];
        int idxAns = ans.length - 1;
        int i1 = s1.length() - 1;
        int i2 = s2.length() - 1;
        while (idxAns >= 0) {
            // matching
            if (s1.charAt(i1) == s2.charAt(i2)) {
                // we got the matching character
                ans[idxAns--] = s1.charAt(i1);
                // move it upwardsa diagonally
                i1--;
                i2--;
            } else {
                int ansi1 = Integer.MIN_VALUE;
                int ansi2 = Integer.MIN_VALUE;
                if (i1 - 1 >= 0) {
                    ansi1 = dp[i1 - 1][i2];
                }
                if (i2 - 1 >= 0) {
                    ansi2 = dp[i1][i2 - 1];
                }
                if (ansi1 > ansi2) {
                    i1--;
                } else {
                    i2--;
                }
            }
        }
        System.out.print(new String(ans));
        return dp[dp.length - 1][dp[0].length - 1];
    }

    public static void main(String[] args) {

    }
}