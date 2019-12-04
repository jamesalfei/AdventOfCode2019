import java.util.Arrays;
import java.util.List;

public class DayOne {
	private static List<Integer> modules = Arrays.asList(
			137503,
			60363,
			103031,
			141000,
			101650,
			76081,
			139069,
			63717,
			135021,
			66034,
			53912,
			83417,
			125978,
			73206,
			77497,
			108822,
			133339,
			113618,
			91973,
			88741,
			109942,
			96523,
			95973,
			56595,
			118638,
			63936,
			101635,
			149154,
			85522,
			140962,
			108196,
			105804,
			148464,
			68429,
			146808,
			82541,
			85581,
			117253,
			117900,
			83457,
			103354,
			123875,
			88412,
			108573,
			140651,
			103774,
			95291,
			91290,
			98690,
			87761,
			122907,
			91499,
			141746,
			127300,
			114866,
			75472,
			65369,
			50978,
			119756,
			144115,
			92483,
			146317,
			100770,
			124156,
			109933,
			138037,
			101126,
			58517,
			83653,
			135656,
			111483,
			82784,
			107459,
			106641,
			138030,
			53599,
			123886,
			74425,
			96919,
			65410,
			63823,
			148278,
			133753,
			106661,
			51147,
			120571,
			77900,
			131827,
			107882,
			149359,
			127565,
			67109,
			131547,
			114874,
			130493,
			94905,
			138654,
			58504,
			79591,
			133856
	);

	public static void main(String[] args) {
		System.out.println(getFirstAnswer());
		System.out.println(getSecondAnswer());
	}

	private static int getFirstAnswer() {
		int total = 0;
		for (int item : modules) {
			total += getFuelCalc(item);
		}
		return total;
	}

	private static int getFuelCalc(int mass) {
		return (mass / 3) - 2;
	}

	private static int getSecondAnswer() {
		int total = 0;
		for (int item : modules) {
			int moduleFuel = getFuelCalc(item);
			int fuelForFuel = getFuelForFuelMass(moduleFuel);
			total += moduleFuel + fuelForFuel;
		}
		return total;
	}

	private static int getFuelForFuelMass(int overallMass) {
		int fuelRequired = getFuelCalc(overallMass);
		if (fuelRequired <= 0) {
			return 0;
		}
		return fuelRequired + getFuelForFuelMass(fuelRequired);
	}
}
