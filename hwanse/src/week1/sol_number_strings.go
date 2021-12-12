package week1

import (
	"strconv"
	"strings"
)

func solution(s string) int {
	r := strings.NewReplacer(
		"zero", "0",
		"one", "1",
		"two", "2",
		"three", "3",
		"four", "4",
		"five", "5",
		"six", "6",
		"seven", "7",
		"eight", "8",
		"nine", "9",
	)

	result, _ := strconv.Atoi(r.Replace(s))
	return result
}