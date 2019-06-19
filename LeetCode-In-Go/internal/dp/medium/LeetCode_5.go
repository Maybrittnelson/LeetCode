package medium

// "babad"是否是回文子串 j i
// "aba"  长度小于3不用判断，dp[j+1][i-1] 是否为回文子串
//

// "cbbd" j i
// "bb" 是不是j+1 i-1

func longestPalindrome(s string) string {
	rs := []rune(s)
	l := len(rs)
	dp := make([][]bool, l)
	for i := 0; i < l; i++ {
		dp[i] = make([]bool, l)
	}
	res := ""
	for i := 0; i < l; i++ {
		for j := i; j >= 0; j-- {
			if rs[i] == rs[j] && (i-j < 2 || dp[i-1][j+1]) {
				dp[i][j] = true
			}
			if dp[i][j] && (i-j+1 > len(res)) {
				res = string(rs[j : i+1])
			}
		}
	}
	return res
}
