public class RatMaze {
    public static void main(String[] args) {

        int maze[][]={{1,0,0,0},
        {1,1,0,1},
        {0,1,0,0},
        {1,1,1,1}};
        int n=maze.length;
        int sol[][]=new int[n][n];

        if(ratinmaze(maze,0,0,sol)){
            System.out.println("the path is :");
            printmaze(sol);
        }
        else{
            System.out.println("no path exists");
        }
    }

    public static void printmaze(int sol[][]) {
        for (int i = 0; i<sol.length; i++) {
            for (int j = 0; j<sol.length; j++) {
                System.out.print(" " + sol[i][j] + " ");
             }
         System.out.println();
        }
        }

        public static boolean isSafe(int maze[][], int x, int y) {
            int n=maze.length;
            // if (x, y outside maze) return false
            if(x >= 0 && x < n && y >= 0 && y < n && maze[x][y] == 1){
                return true;
            }else{
                return false;
            }
            }

            public static boolean ratinmaze(int maze[][], int x, int y, int sol[][]) {
                int n=maze.length;
                //base case
                if(x==n-1 && y==n-1){
                    sol[x][y]=1;
                    return true;

                }

                if(isSafe(maze, x, y)){
                    sol[x][y]=1;
                    //for down
                    if(ratinmaze(maze, x+1, y, sol)){
                        return true;
                    }
                    //for right
                    if(ratinmaze(maze, x, y+1, sol)){
                        return true;
                    }
                    //for up
                    if(ratinmaze(maze, x-1, y, sol)){
                        return true;
                    }
                    //for left
                    if(ratinmaze(maze, x, y-1, sol)){
                        return true;
                    }

                    sol[x][y]=0; //for backtracking
                    return false;
                }
                return false;

            }


    
}//for class
