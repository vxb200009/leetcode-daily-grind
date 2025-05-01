import java.util.ArrayDeque;
import java.util.Queue;

public class RottenOranges {
    public int orangesRotting(int[][] grid) {
        Queue<Pair<Integer,Integer>> queue = new ArrayDeque();

        int freshOranges = 0;
        int minutesElapsed =-1;
        int ROWS = grid.length, COLS = grid[0].length;

        for (int r = 0; r < ROWS; ++r)
            for (int c = 0; c < COLS; ++c)
                if(grid[r][c]==2)
                    queue.offer(new Pair(r,c));
                else if(grid[r][c]==1)
                    freshOranges++;

        queue.offer(new Pair(-1,-1));
        int[][] directions = {{1,0},{0,1},{0,-1},{-1,0}};

        while(!queue.isEmpty()){
            Pair<Integer,Integer> pair = queue.poll();
            int row = pair.getKey();
            int col = pair.getValue();
            if(row==-1){
                minutesElapsed++;

                if(!queue.isEmpty()){
                    queue.offer(new Pair(-1,-1));
                }
            }
            else{
                for(int[] d: directions){
                    int r=row+d[0];
                    int c=col+d[1];
                    if(r<ROWS && r>=0 && c<COLS && c>=0 && grid[r][c]==1){
                        grid[r][c] = 2;
                        queue.offer(new Pair(r,c));
                        freshOranges--;
                    }
                }
            }
        }

        return freshOranges==0?minutesElapsed:-1;
    }
}
