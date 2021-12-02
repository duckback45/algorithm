import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class stringCompression {
    public int solution(String s){
        int count = 1;
        int answer = 0;

        do {
            int loopCnt = count;
            int wordCount = 0;
            StringBuilder word= new StringBuilder();
            String lastWord = "";
            String matched = "";
            for (int i = 0; s.length() >= loopCnt + count; ) {
                if (s.substring(i, loopCnt).equals(s.substring(i + count, loopCnt + count))) {

                    wordCount += 1;
                        matched = s.substring(i, loopCnt);

                    if(s.length() <= loopCnt + count + count)
                        word.append(wordCount + 1).append(matched);

                } else {
                    if(!matched.isEmpty()){
                        word.append(wordCount + 1).append(matched);
                    }
                    if(!matched.equals(s.substring(i, loopCnt))){
                        word.append(s.substring(i, loopCnt));
                    }else if(!(loopCnt + count + count <= s.length() && i + count + count <= s.length())){
                        if(!s.substring(i + count + count, loopCnt + count + count).equals(s.substring(i + count, loopCnt + count))){
                            word.append(s.substring( i+ count, loopCnt + count));
                        }
                    }
                    wordCount = 0;
                     matched = "";
                }

                loopCnt += count;
                i += count;

            }
            if(count == 1 || answer == 0){
                answer = word.length();
            }


            if(word.length() < answer ){
                answer = word.length();
                System.out.println(word);
                System.out.println(answer);
            }


            count += 1;


        } while ((s.length()/2) >= count);

        return (answer == 0 ? s.length() : answer);
    }

    @Test
    public void _test (){
       // assertEquals(7, solution("aabbaccc"));
        assertEquals(9, solution("ababcdcdababcdcd"));
        assertEquals(8, solution("abcabcdede"));
        assertEquals(14, solution("abcabcabcabcdededededede"));
        assertEquals(17, solution("xababcdcdababcdcd"));

    }
}
