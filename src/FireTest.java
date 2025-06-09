import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

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

    


    @Test
    public void adjacentTrees() {
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
    public void timeToBurn_OneTree() {
        char[][] forest = {
            {'t','.'},
            {'.','.'},
            {'.','.'},
            {'t','t'}
        };

        int matchR = 0;
        int matchC = 0;

        int expected = 0;
        int actual = Fire.timeToBurn(forest, matchR, matchC);

        assertEquals(expected, actual);
    }

    @Test
    public void timeToBurn_TwoTrees() {
    char[][] forest = {
        {'t','.'},
        {'.','.'},
        {'.','.'},
        {'t','t'}
    };

    int matchR = 3;
    int matchC = 1;

    int expected = 1;
    int actual = Fire.timeToBurn(forest, matchR, matchC);

    assertEquals(expected, actual);
    }

    @Test
    public void adjacentTrees_TwoTrees() {
        char[][] forest = {
            {'t','.'},
            {'.','.'},
            {'.','.'},
            {'t','t'}
        };

        boolean[][] visited = new boolean[forest.length][forest[0].length];
        

        List<int[]> expected = new ArrayList<>();
        expected.add(new int[]{3, 0, 1});

        int matchR = 3;
        int matchC = 1;
        int depth = 0;

        int[] start = new int[] {matchR, matchC, depth};
        visited[matchR][matchC] = true;

        List<int[]> nearby = Fire.findAdjacentTrees(forest, visited, start);

        for (int i = 0; i < expected.size(); i++) {
            assertArrayEquals(expected.get(i), nearby.get(i));
        }
    }

    @Test
    public void adjacentTrees_NoneAdjacent() {
        char[][] forest = {
            {'t','.'},
            {'.','.'},
            {'.','.'},
            {'t','t'}
        };

        boolean[][] visited = new boolean[forest.length][forest[0].length];

        int matchR = 0;
        int matchC = 0;
        int depth = 0;

        int[] start = new int[] {matchR, matchC, depth};
        visited[matchR][matchC] = true;

        List<int[]> nearby = Fire.findAdjacentTrees(forest, visited, start);

        assertEquals(0, nearby.size());
    }
}
