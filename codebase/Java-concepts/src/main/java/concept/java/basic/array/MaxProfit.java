package concept.java.basic.array;

import java.util.ArrayList;
import java.util.List;

class Interval {
	int buy, sell;
}

public class MaxProfit {
	public static void main(String[] args) {
		int price[] = { 100, 180, 260, 310, 40, 535, 695 };
		int n = price.length;
		stockBuySell(price, n);
	}

	private static void stockBuySell(int[] price, int n) {

		if (n == 1)
			return;
		int count = 0, i = 0;
		List<Interval> sol = new ArrayList<>();
		while (i < n - 1) {
			while (i < n - 1 && (price[i] >= price[i + 1]))
				i++;
			if (i == n - 1)
				return;
			Interval interval = new Interval();
			interval.buy = i++;
			while (i < n && (price[i] >= price[i - 1]))
				i++;
			interval.sell = i - 1;
			count++;
			sol.add(interval);

		}
		if (count == 0)
			System.out.println("There is no day when buying the stock " + "will make profit");
		else
			for (int j = 0; j < count; j++)
				System.out.println("Buy on day: " + sol.get(j).buy + "        " + "Sell on day : " + sol.get(j).sell);
	}

}
