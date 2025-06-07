import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FireTest {
    @Test
    public void testTimeToBurnExample() {
        char[][] forest = {
            {'t','.','.','t','t','t','t','.','t'},
            {'.','.','t','t','.','.','.','.','t'},
            {'.','.','t','t','t','t','t','t','t'},
            {'t','t','t','t','.','.','.','.','.'}
        };

        int matchR = 2;
        int matchC = 6;

        int expected = 8;
        int actual = Fire.timeToBurn(forest, matchR, matchC);

        assertEquals(expected, actual);
    }

    @Test 
    public void testSingleTree() {
        char[][] forest = {
            {'.', '.', '.'},
            {'.', 't', '.'},
            {'.', '.', '.'}
        };
        int matchR = 1;
        int matchC = 1;

        //one tree burn
        int expected = 0;  
        int actual = Fire.timeToBurn(forest, matchR, matchC);

        assertEquals(expected, actual);
    }

    @Test
    public void testNoTree(){
        char[][] forest = {
            {'.', '.', '.'},
            {'.', '.', '.'},
            {'.', '.', '.'}
        };
        int matchR = 1;
        int matchC = 1;

        int expected = 0;  
        int actual = Fire.timeToBurn(forest, matchR, matchC);

        assertEquals(expected, actual);
        
    }

     @Test
    public void testAllTreesConnected() {
        char[][] forest = {
            {'t', 't', 't'},
            {'t', 't', 't'},
            {'t', 't', 't'}
        };
        int matchR = 1;
        int matchC = 1;

        int expected = 2; 
        int actual = Fire.timeToBurn(forest, matchR, matchC);

        assertEquals(expected, actual);
    }

    

}
