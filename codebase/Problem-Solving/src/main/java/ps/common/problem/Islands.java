package ps.common.problem;

class Max{
	int data;
	public Max(int m) {
		// TODO Auto-generated constructor stub
		this.data=m;
	}
}

class Islands
{
 //No of rows and columns
 static final int ROW = 5, COL = 5;

 // A function to check if a given cell (row, col) can
 // be included in DFS
 boolean isSafe(int M[][], int row, int col,
                boolean visited[][])
 {
     // row number is in range, column number is in range
     // and value is 1 and not yet visited
     return (row >= 0) && (row < ROW) &&
            (col >= 0) && (col < COL) &&
            (M[row][col]==1 && !visited[row][col]);
 }

 // A utility function to do DFS for a 2D boolean matrix.
 // It only considers the 8 neighbors as adjacent vertices
 void DFS(int M[][], int row, int col, boolean visited[][],Max el)
 {
	
     // These arrays are used to get row and column numbers
     // of 8 neighbors of a given cell
     int rowNbr[] = new int[] {-1, -1, -1,  0, 0,  1, 1, 1};
     int colNbr[] = new int[] {-1,  0,  1, -1, 1, -1, 0, 1};

     // Mark this cell as visited
     visited[row][col] = true;

     // Recur for all connected neighbours
     for (int k = 0; k < 8; ++k)
         if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited) ) {
        	 el.data++;
             DFS(M, row + rowNbr[k], col + colNbr[k], visited,el);
             }
 }

 // The main function that returns count of islands in a given
 //  boolean 2D matrix
 int countIslands(int M[][])
 {
     // Make a bool array to mark visited cells.
     // Initially all cells are unvisited
     boolean visited[][] = new boolean[ROW][COL];
     
     Max max=new Max(Integer.MIN_VALUE);
     int gmax=Integer.MIN_VALUE;


     // Initialize count as 0 and travese through the all cells
     // of given matrix
     int count = 0;
     for (int i = 0; i < ROW; ++i)
         for (int j = 0; j < COL; ++j)
             if (M[i][j]==1 && !visited[i][j]) // If a cell with
             {                                 // value 1 is not
                 // visited yet, then new island found, Visit all
                 // cells in this island and increment island count
            	max.data=1;
                 DFS(M, i, j, visited,max);
                 
               gmax=max.data>gmax?max.data:gmax;
                 
                 
                 ++count;
             }
     
     System.out.println("gmax :"+gmax);

     return count;
 }

 // Driver method
 public static void main (String[] args) throws java.lang.Exception
 {
     int M[][]=  new int[][] {{1, 1, 0, 0, 0},
                              {0, 1, 0, 0, 1},
                              {1, 0, 0, 1, 1},
                              {0, 0, 0, 0, 0},
                              {1, 0, 1, 0, 1}
                             };
     Islands I = new Islands();
     System.out.println("Number of islands is: "+ I.countIslands(M));
 }
} 