import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class lifegame {

	public static void main(String args[]) {
		int rows = 16, columns = 16;
		double spawnRate = 0.3;
		
		// first state
		int[][] firstStateArr = makeFirstStateArr(rows, columns, spawnRate);
		showStateArr(firstStateArr, rows, columns);

		// next state
		int gameTimes = 100;
		lifeGames(firstStateArr, gameTimes, rows, columns);
	}


	public static void lifeGames(int[][] firstStateArr, int gameTimes, int rows, int columns) {

		int[][] stateArr = firstStateArr;
		int[][] nextStateArr = new int[rows][columns]; 
		int[][] result = new int[rows][columns];

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
			Thread.sleep(200);
		}catch(InterruptedException e){}
	}


	public static int[][] makeNextStateArr(int[][] stateArr, int rows, int columns) {
		
		int[][] nextStateArr = new int[rows][columns];
		int[][] result = new int[rows][columns];

		int i = 0, j = 0;
		int temp = 0;


		int column_minous_1 = columns - 1;

		for (i = 0; i < columns; i++) {
			if (i == 0) {
				nextStateArr[0][i] = stateArr[0][1] + stateArr[1][0] + stateArr[1][1];
			} else if (i == (columns - 1)) {
				nextStateArr[0][i] = stateArr[0][i - 1] + stateArr[1][i] + stateArr[1][i - 1];
			} else {
				nextStateArr[0][i] = stateArr[0][i - 1] + stateArr[1][i - 1] + stateArr[1][i] + stateArr[1][i + 1] + stateArr[0][i + 1];
			}
		}

		for (i = 1; i < rows - 1; i++) {
			for (j = 0; j < columns; j++) {
				if (j == 0) {
					nextStateArr[i][j] = stateArr[i - 1][j] + stateArr[i - 1][j + 1] + stateArr[i][j + 1] + stateArr[i + 1][j + 1] + stateArr[i + 1][j];
				} else if (j == (columns - 1)) {
					nextStateArr[i][j] = stateArr[i - 1][j] + stateArr[i - 1][j - 1] +  stateArr[i][j - 1] + stateArr[i + 1][j - 1] + stateArr[i + 1][j];
				} else {
					nextStateArr[i][j] = stateArr[i - 1][j - 1] + stateArr[i][j - 1] + stateArr[i + 1][j - 1] + stateArr[i - 1][j] + stateArr[i + 1][j] + stateArr[i - 1][j + 1] + stateArr[i][j + 1] + stateArr[i + 1][j + 1]; 
				}
			}
		}

		for (i = 0; i < columns; i++) {
			if (i == 0) {
				nextStateArr[rows - 1][i] = stateArr[rows - 2][0] + stateArr[rows - 2][1] + stateArr[rows - 1][1];
			} else if (i == (columns - 1)) {
				nextStateArr[rows - 1][i] = stateArr[rows - 1][i - 1] + stateArr[rows - 2][i - 1] + stateArr[rows - 2][i];
			} else {
				nextStateArr[rows - 1][i] = stateArr[rows - 1][i - 1] + stateArr[rows - 2][i - 1] + stateArr[rows - 2][i] + stateArr[rows - 2][i + 1] + stateArr[rows - 1][i + 1];
			}
		}

		result = convertArrToBoolean(stateArr, nextStateArr, rows, columns);	

		return result;
	}

	// nextstatearrには周囲の黒ますの数が入っているので、その値を次世代の値に変化させる
	public static int[][] convertArrToBoolean(int[][] stateArr, int[][] nextStateArr, int rows, int columns) {
		int i = 0, j = 0;
		int spawnNum_2 = 2, spawnNum_3 = 3;
		int[][] result = new int[rows][columns];

		for (i = 0; i < rows; i++) {
			for (j = 0; j < columns; j++) {
				switch (stateArr[i][j]) {

					case 0:
					// 誕生（＝白→黒になる）条件：白いマスの周囲に3つの黒いマスがあれば次の世代では黒いマスになる。
						if(nextStateArr[i][j] == spawnNum_3) {
							result[i][j] = 1;
						} else {
							result[i][j] = 0;
						}
						break;
					case 1:
						// 維持（＝黒→黒のまま）条件：黒いマスの周囲に2つか3つの黒いマスがあれば次の世代でも黒いマスになる。
						if(nextStateArr[i][j] == spawnNum_2 || nextStateArr[i][j] == spawnNum_3) {
							result[i][j] = 1;
						} else {
							result[i][j] = 0;
						}
						break;
				}
			}
		}
	
		return result;
	}

	// 初期状態の配列の作成
	public static int[][] makeFirstStateArr(int rows, int columns, double spawnRate) {
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


