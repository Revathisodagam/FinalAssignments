package Tasks;
public class RatInMaze {

    private static final int N = 6; 

    public static boolean SolveMaze(int[][] maze) {
        int[][] solution = new int[N][N];

        if (!SolveMazeUtil(maze, 0, 0, solution)) {
            System.out.println("No solution exists.");
            return false;
        }

        printSolution(solution);
        return true;
    }

    private static boolean SolveMazeUtil(int[][] maze, int x, int y, int[][] solution) {
       
        if (x == N - 1 && y == N - 1) {
            solution[x][y] = 1;
            return true;
        }

        if (isSafe(maze, x, y)) {
          
            solution[x][y] = 1;

            if (SolveMazeUtil(maze, x, y + 1, solution)) {
                return true;
            }

            if (SolveMazeUtil(maze, x + 1, y, solution)) {
                return true;
            }

            if (SolveMazeUtil(maze, x, y - 1, solution)) {
                return true;
            }

            if (SolveMazeUtil(maze, x - 1, y, solution)) {
                return true;
            }

            solution[x][y] = 0;
            return false;
        }

        return false;
    }
    private static boolean isSafe(int[][] maze, int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1);
    }

    private static void printSolution(int[][] solution) {
        System.out.println("Solution path:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(solution[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] maze = {
            {1, 0, 1, 1, 0, 1},
            {1, 1, 1, 0, 1, 1},
            {0, 1, 0, 1, 1, 0},
            {1, 1, 1, 0, 1, 1},
            {1, 0, 1, 1, 0, 1},
            {1, 1, 1, 1, 1, 1}
        };

        if (!SolveMaze(maze)) {
            System.out.println("No solution found.");
        }
    }
}
