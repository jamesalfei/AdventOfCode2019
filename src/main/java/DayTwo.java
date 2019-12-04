public class DayTwo {

	private static int[] intCode = new int[]{1, 0, 0, 3, 1, 1, 2, 3, 1, 3, 4, 3, 1, 5, 0, 3, 2, 1, 10, 19, 1, 9, 19, 23, 1, 13, 23, 27, 1, 5, 27, 31, 2, 31, 6, 35, 1, 35, 5, 39, 1, 9, 39, 43, 1, 43, 5, 47, 1, 47, 5, 51, 2, 10, 51, 55, 1, 5, 55, 59, 1, 59, 5, 63, 2, 63, 9, 67, 1, 67, 5, 71, 2, 9, 71, 75, 1, 75, 5, 79, 1, 10, 79, 83, 1, 83, 10, 87, 1, 10, 87, 91, 1, 6, 91, 95, 2, 95, 6, 99, 2, 99, 9, 103, 1, 103, 6, 107, 1, 13, 107, 111, 1, 13, 111, 115, 2, 115, 9, 119, 1, 119, 6, 123, 2, 9, 123, 127, 1, 127, 5, 131, 1, 131, 5, 135, 1, 135, 5, 139, 2, 10, 139, 143, 2, 143, 10, 147, 1, 147, 5, 151, 1, 151, 2, 155, 1, 155, 13, 0, 99, 2, 14, 0, 0};

	public static void main(String[] args) {
		int[] qOne = intCode.clone();
		qOne[1] = 12;
		qOne[2] = 2;
		System.out.println(getAnswerOne(qOne));

		getAnswerTwo();
	}

	private static void getAnswerTwo() {
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				int[] temp = intCode.clone();
				temp[1] = i;
				temp[2] = j;

				try {
					int result = getAnswerOne(temp);

					if (result == 19690720) {
						System.out.println(i);
						System.out.println(j);
						return;
					}
				} catch (Exception e) {
					//Do nothing
				}
			}
		}
	}

	private static int getAnswerOne(int[] intCode) {
		for (int i = 0; i < intCode.length; i += 4) {
			int operation = intCode[i];
			int firstArg = intCode[i + 1];
			int secondArg = intCode[i + 2];
			int resultArg = intCode[i + 3];

			if (operation == 99) {
				break;
			}

			performOperation(operation, firstArg, secondArg, resultArg, intCode);
		}
		return intCode[0];
	}

	private static void performOperation(int operation, int firstArg, int secondArg, int resultArg, int[] tempArr) {
		if (operation == 1) {
			tempArr[resultArg] = tempArr[firstArg] + tempArr[secondArg];
		} else if (operation == 2) {
			tempArr[resultArg] = tempArr[firstArg] * tempArr[secondArg];
		}
	}

}