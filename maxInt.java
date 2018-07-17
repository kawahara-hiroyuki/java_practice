class maxValue {
	public static void main(String args[]){
	System.out.println("Integer.MAX_VALUE = " + Integer.MAX_VALUE);

	int maxInt = 2147483647;

	SystemPrint("maxInt", maxInt);
	SystemPrint("maxInt + 1", (maxInt + 1));
	SystemPrint("maxInt + 2", (maxInt + 2));
	}

	static void SystemPrint(String text, int num) {
		System.out.println(text + " = " + num);
	}
}

