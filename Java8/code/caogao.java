package Java8;

import org.junit.Test;

public class caogao {
    @Test
    public void Answer(){
        Solution rebuilt = new Solution();
        int[] answer = rebuilt.sortArray(new int[]{1, 2, 3, 4, 5, 6, 7, 7, 88, 8, 9, 543});
        for (int j : answer) {
            System.out.print(j + " ");
        }
    }
}
