package SpellChecker;
import java.util.Scanner;

public class KnightTour {

    int[][] solution;
    int path=0;

    public KnightTour(int j){
        solution = new int[j][j];
        for(int i =0; i<j;i++){
            for(int k=0; k<j;k++){
                solution[i][k] = 0;
            }
        }
    }

    public static void main(String[] args) {
        // Scanner for mixed inputs. Dont suggest going over 7.
        int i;
        System.out.print("Enter a number: ");
        Scanner scan = new Scanner(System.in);
        i = scan.nextInt();

        KnightTour kt = new KnightTour(i);
        kt.solve();
    }

    // Solves and prints if their is a possible solution.
    public void solve(){
        try {
            if (findPath(0, 0, 0, solution.length)) {
                printBoard();
            } else {
                System.out.println("No Path Found");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    // Path finder. Returns false if no path can be found.
    public boolean findPath(int row, int col , int index, int N){

        if(solution[row][col] != 0){
            return false;
        }

        solution[row][col] = path++;

        if(index == N * N -1){
            return true;
            // Solved
        }

        // Down Right
        if (canMove(row + 2, col + 1, N)
                && findPath(row + 2, col + 1, index + 1, N)) {
            return true;
        }
        // Right Down
        if (canMove(row + 1, col + 2, N)
                && findPath(row + 1, col + 2, index + 1, N)) {
            return true;
        }
        // Right Up
        if (canMove(row - 1, col + 2, N)
                && findPath(row - 1, col + 2, index + 1, N)) {
            return true;
        }
        // Up Right
        if (canMove(row - 2, col + 1, N)
                && findPath(row - 2, col + 1, index + 1, N)) {
            return true;
        }
        // Up Left
        if (canMove(row - 2, col - 1, N)
                && findPath(row - 2, col - 1, index + 1, N)) {
            return true;
        }
        // Left Up
        if (canMove(row - 1, col - 2, N)
                && findPath(row - 1, col - 2, index + 1, N)) {
            return true;
        }
        // Left Down
        if (canMove(row + 1, col - 2, N)
                && findPath(row + 1, col - 2, index + 1, N)) {
            return true;
        }
        // Down Left
        if (canMove(row + 2, col - 1, N)
                && findPath(row + 2, col - 1, index + 1, N)) {
            return true;
        }
        // No path has been found
        solution[row][col] = 0;
        path--;
        return false;

    }
    // Validates if knight can move.
    public boolean canMove(int row , int col , int i){
        if(row >= 0 && col >= 0 && row < i && col < i){
            return true;
        }
        return false;
    }
    // Prints board.
    public void printBoard(){
        for(int i=0; i < solution.length; i++){
            for(int k=0; k < solution.length; k++){
                System.out.print(solution[i][k] + " ");
            } System.out.println();
        }
    }

}
