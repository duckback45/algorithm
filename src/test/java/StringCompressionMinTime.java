import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringCompressionMinTime {
        public int solution(String s) {
            int min = s.length();
            int len = s.length()/2+1;
            for(int i = 1; i < len; i++) {
                String before = "";
                int sum = 0;
                int cnt = 1;
                for(int j = 0; j < s.length();) {
                    int start = j;
                    j = (j+i > s.length()) ? s.length():j+i;
                    String temp = s.substring(start, j);
                    if(temp.equals(before)) {
                        cnt++;
                    } else {
                        if(cnt != 1) {
                            sum += (int)Math.log10(cnt)+1;
                        }
                        cnt = 1;
                        sum+=before.length();
                        before = temp;
                    }
                }
                sum+=before.length();
                if(cnt != 1) {
                    sum += (int)Math.log10(cnt)+1;
                }
                min = (min > sum) ? sum : min;
            }

            return min;
        }

        @Test
    public void _test () {
        assertEquals(9, solution("acacacacaccccciiii"));
        assertEquals(6, solution("aaaaaaaaaabbbbbbbbbb"));
        assertEquals(9, solution("xztjabcdabcd"));
        assertEquals(14, solution("abrabcabcadqabcabc"));
        assertEquals(5, solution("aababa"));
        assertEquals(1, solution("s"));
        assertEquals(7, solution("aabbaccc"));
        assertEquals(9, solution("ababcdcdababcdcd"));
        assertEquals(8, solution("abcabcdede"));
        assertEquals(14, solution("abcabcabcabcdededededede"));
        assertEquals(17, solution("xababcdcdababcdcd"));
        assertEquals(17, solution("xababcdcdababcdcd"));
        assertEquals(2, solution("xxxxx"));
        assertEquals(3, solution("zxxxxx"));
        assertEquals(6, solution("zaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaz"));
        assertEquals(9, solution("acacacbacacac"));
        assertEquals(9, solution("acacacacacacbacacacacacac"));
        assertEquals(15, solution("bbbbbzzzzzzaaaaaaaaaaaaaaaaaaaaffcccaiai"));
        assertEquals(4, solution("zaaaaaaaaaa"));
        assertEquals(5, solution("faabab"));
        assertEquals(4, solution("xaxaxaxaxaa"));
        assertEquals(4, solution("cwid"));
        assertEquals(7, solution("aaaaaaaaaaaaaaabbbbbbbbbbc"));
        assertEquals(5, solution("acdhdh"));
        assertEquals(7, solution("abcdefg"));


    }
    }

