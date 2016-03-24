import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Main class which parses the file and finds the top3 closest 
 * shops using helper classes
 */

/**
 * @author shashank
 *
 */
public class CoffeeshopFutureForce {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Coordinates userCoord = null;
		Coordinates coffeeShopCoord = null;

		if (args.length != 3) {
			System.out.println("Usage <userycoordinate> <userxcoordinate> <shopdatafilename>");
			System.exit(-1);
		}

		// parse the co-ordiantes and handle exceptions
		try {
			double userX = Double.parseDouble(args[0]);
			double userY = Double.parseDouble(args[1]);
			userCoord = new Coordinates(userX, userY);

		} catch (NumberFormatException nfe) {
			System.out.println(nfe.getMessage());
			System.exit(-1);
		}

		PriorityQueue<CoffeeShopDistance> top3Closest = new PriorityQueue<CoffeeShopDistance>(3,
				new CoffeeShopDistanceComparator());

		// parse the file and handle exceptions

		String csvFile = args[2];
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ","; // use comma as separator

		try {

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				// parse the line
				String[] coffeeShopCoordinates = line.split(cvsSplitBy);
				String coffeeShopName = coffeeShopCoordinates[0];
				double coffeeX = Double.parseDouble(coffeeShopCoordinates[1]);
				double coffeeY = Double.parseDouble(coffeeShopCoordinates[2]);
				coffeeShopCoord = new Coordinates(coffeeX, coffeeY);
				// compute Euclidean distance between user and coffeeshop
				double distance = userCoord.getEuclideanDistance(coffeeShopCoord);
				CoffeeShopDistance cfd = new CoffeeShopDistance(coffeeShopName, distance);

				// add first 3 coffee shops as closest
				if (top3Closest.size() < 3) {
					top3Closest.offer(cfd);
				} else {
					// check if the current coffee shop is a candidate for top 3
					// closest
					if (distance > top3Closest.peek().getDistance()) // not
																		// closer
																		// than
																		// current
																		// top 3
						continue;
					else { // closer than current top 3
						top3Closest.poll();
						top3Closest.offer(cfd);
					}
				}
			}

			System.out.println("Top 3 closest coffee shops");
			ArrayList<CoffeeShopDistance> top3 = new ArrayList<CoffeeShopDistance>();
			while (!top3Closest.isEmpty()) 
				top3.add(top3Closest.poll());
			
			Collections.sort(top3, new CoffeeShopDistanceComparator());
			
			for(int i=top3.size() - 1; i >= 0; i--)
				System.out.println(top3.get(i));

		} catch (IndexOutOfBoundsException iobe) {
			System.out.println(iobe.getMessage());
		} catch (FileNotFoundException fnfe) {
			System.out.println(fnfe.getMessage());
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		} catch (NumberFormatException nfe) {
			System.out.println(nfe.getMessage());
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException ioe) {
					System.out.println(ioe.getMessage());
				}
			}
		}
	}

}
