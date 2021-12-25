//https://programmers.co.kr/learn/courses/30/lessons/12899
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class word124 {
    public String solution(int n) {
        String answer = "";
        String[] numbers = {"4", "1", "2"};
        while (n > 0) {
            answer = numbers[n % 3] + answer;
            n = (n / 3) - (n % 3 == 0 ? 1 : 0);
        }

        return answer;
    }

    @Test
    public void _test(){
        assertEquals("41",solution(10));
    }
}
