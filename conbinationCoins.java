import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

class conbinationCoins {

	public static void main(String args[]) throws IOException {

		int price = 0;

		price = getPrice();
		
		conbinationCoins(price);
		
		// ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		// result = getConbinationCoins(price)
		// showConbinationCoins(result);

	}



	public static int getPrice() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

		System.out.print("おいくら万円？：");

		String price = br.readLine();

		int result = Integer.parseInt(price);
		
		return result;
	}



	public static void conbinationCoins(int price) {
		int operatedPrice = price;
		int under5 = 0;
		int i = 0, j = 0;
		ArrayList<Integer> arr = new ArrayList<>();
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();

		// 最小枚数の組み合わせを作成
		ArrayList<Integer> minCoins = new ArrayList<>();

		minCoins = getMinCoins(price);

		System.out.println("minCoins = " + minCoins);

		result = getCoinConbination(minCoins);
		
		System.out.println(result);
	}




	public static ArrayList getCoinConbination(ArrayList minCoins) {
		int[][][] equalValueCoins = {{{5, {1,1,1,1,1}}}};
	

		System.out.println(Arrays.deepToString(equalValueCoins));
	

		return minCoins;
	
	}

	

	
	public static ArrayList getMinCoins(int price) {
		int operatedPrice = price;
		int[] typeOfCoins = {500, 100, 50, 10, 5, 1}; 

		ArrayList<Integer> result = new ArrayList<>();

		int i = 0, j = 0;
		int length = typeOfCoins.length;
		for (i = 0; i < length; i++) {
			while (operatedPrice >= typeOfCoins[i]) {
				result.add(typeOfCoins[i]);
				operatedPrice -= typeOfCoins[i];
			}
		}

		return result; 
	}
}


