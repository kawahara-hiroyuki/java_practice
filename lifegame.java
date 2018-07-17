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
	}


	public static void lifeGames(int[][] firstStateArr, int gameTimes, int rows, int columns) {

		int[][] stateArr = firstStateArr;
		int[][] nextStateArr = new int[rows][columns]; 

		int i = 0;
		for (i = 0; i < gameTimes; i++) {
			organizeView();

			// math of next stateArr
			nextStateArr = makeNextStateArr(stateArr, rows, columns);

			showStateArr(nextStateArr, rows, columns);

			stateArr = nextStateArr;

		}
	}

	public static void organizeView() {
		System.out.println();
		System.out.println("-----------------");
		System.out.println();

		try {
			Thread.sleep(3000);
		}catch(InterruptedException e){}
	}



	public static int[][] makeNextStateArr(int[][] stateArr, int rows, int columns) {
		return stateArr;
	}






	// 初期状態の配列の作成
	public static int[][] makeFirstStateArr(int rows, int columns) {
		double spawnRate = 0.2;

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
				if (stateArr[i][j] == 1 ) {
					System.out.print("￭");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}


}


