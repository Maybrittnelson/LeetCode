package string

func reverseStrings(s []byte) {
	len := len(s)
	for i := 0; i < len/2; i++ {
		tmp := s[len-1-i]
		s[len-1-i] = s[i]
		s[i] = tmp
	}
}
