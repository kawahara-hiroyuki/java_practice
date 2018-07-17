import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class lifegame {

	public static void main(String args[]) {
		int rows = 16, columns = 16;
		
		// first state
		int[][] firstStateArr = makeFirstStateArr(rows, columns);
		showStateArr(firstStateArr, rows, columns);

		// next state
		int gameTimes = 100;
		lifeGames(firstStateArr, gameTimes, rows, columns);

		// 表示
		// showStateArr(array, array.length, array[0].length);
	}


	public static void lifeGames(int[][] firstStateArr, int rows, int columns) {
		

		int i = 0, j = 0;
		for (i = 0; i < rows; i++) {
			for (j = 0; j < columns; j++) {
				
				
				
			}
			
		}
	}

	public static int[][] makeNextStateArr(int[][] stateArr, int rows, int columns) {
	
	
	

	}






	// 初期状態の配列の作成
	public static int[][] makeFirstStateArr(int rows, int columns) {
		double spawnRate = 0.4;

		int[][] result = new int[rows][columns];
		
		Random rand = new Random();
		double randomNumber = 0;

		int i = 0, j = 0;
		for (i = 0; i < rows; i++) {
			for (j = 0; j < columns; j++) {
				randomNumber = rand.nextDouble();
				if (randomNumber < spawnRate) {
					result[i][j] = 1;
				} else {
					result[i][j] = 0;
				}
			}
		}
		return result;
	}

	// データの表示 
	public static void showStateArr(int stateArr[][], int rows, int columns) {
		int i = 0, j = 0;
		for (i = 0; i < rows; i++) {
			for ( j = 0; j < columns; j++) {
				if (stateArr[i][j] == 0 ) {
					System.out.print("￭");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}


}


