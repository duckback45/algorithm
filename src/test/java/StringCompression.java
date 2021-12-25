import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class StringCompression {
    public int solution(String s){

        if(s.length() == 1){
            return 1;
        } else if (s.length() == 2){
            return 2;
        }

        int answer = s.length();
        int loopCount = 1;
        String word = s;

        do {
            word = s;
            int matchedCount = 0;
            StringBuffer compressionWord = new StringBuffer();
            String matchedWord = "";
            while (true) {
                if (word.substring(0, loopCount).equals(word.substring(loopCount, loopCount + loopCount))) {
                    matchedCount += 1;
                    matchedWord = word.substring(0, loopCount);
                    word = word.substring(loopCount, word.length());
                } else {
                    if (matchedCount != 0) {
                        compressionWord.append(matchedCount + 1).append(matchedWord);
                        word = word.substring(loopCount , word.length());
                    } else {
                        compressionWord.append(word.substring(0, loopCount));
                        word = word.substring(loopCount, word.length());
                    }
                    matchedCount = 0;
                    matchedWord = "";
                }

                if(word.length() < loopCount + loopCount){
                    if(matchedCount != 0) {
                        compressionWord.append(matchedCount + 1).append(matchedWord);
                    }else {
                        compressionWord.append(word.substring(0, loopCount));
                    }
                    if(s.length()%loopCount !=0){
                        compressionWord.append(s.substring(s.length()-s.length()%loopCount,s.length()));
                    }

                    answer = Math.min(answer,compressionWord.length());
                    break;
                }
            }
                loopCount += 1;

        }while (loopCount <= s.length()/2);
        return answer;
    }

    @Test
    public void _test (){
        assertEquals(9,solution("acacacacaccccciiii"));
        assertEquals(6,solution("aaaaaaaaaabbbbbbbbbb"));
        assertEquals(9,solution("xztjabcdabcd"));
        assertEquals(14,solution("abrabcabcadqabcabc"));
        assertEquals(5,solution("aababa"));
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
