package simple

func addBinary(a string, b string) string {
	ars := []rune(a)
	brs := []rune(b)

	al := len(ars) - 1
	bl := len(brs) - 1
	x := '0'
	var r rune
	var res []rune
	for al >= 0 && bl >= 0 {
		ar := ars[al]
		br := brs[bl]
		al--
		bl--

		if ar == '1' && br == '1' {
			if x == '0' {
				r = '0'
			} else {
				r = '1'
			}
			x = '1'
		} else if ar == '0' && br == '0' {
			if x == '1' {
				r = '1'
			} else {
				r = '0'
			}
			x = '0'
		} else {
			if x == '1' {
				r = '0'
				x = '1'
			} else {
				r = '1'
				x = '0'
			}
		}

		res = append(res, r)
	}
	reverseRune(res, 0, len(res)-1)

	if x == '0' {
		if al >= 0 {
			return string(ars[:al+1]) + string(res)
		}
		if bl >= 0 {
			return string(brs[:bl+1]) + string(res)
		}
		return string(res)
	}

	if al >= 0 {
		return increse(ars[:al+1]) + string(res)
	}
	if bl >= 0 {
		return increse(brs[:bl+1]) + string(res)
	}
	return "1" + string(res)

}

func increse(ars []rune) string {
	al := len(ars) - 1
	x := '1'
	var r rune
	var res []rune
	var s string
	for al >= 0 {
		ar := ars[al]
		al--
		if ar == '1' && x == '1' {
			x = '1'
			r = '0'
		} else if ar == '0' && x == '0' {
			break
		} else {
			r = '1'
			x = '0'
		}
		res = append(res, r)
	}
	reverseRune(res, 0, len(res)-1)

	if al >= 0 {
		s = string(ars[:al+2]) + string(res)
	} else {
		s = string(res)
	}
	if x == '1' {
		return "1" + s
	}
	return s
}

func reverseRune(res []rune, i, j int) {
	for i < j {
		res[i], res[j] = res[j], res[i]
		i++
		j--
	}
}
