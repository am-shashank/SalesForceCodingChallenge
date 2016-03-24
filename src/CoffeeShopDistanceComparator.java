import java.util.Comparator;

/**
 * Comparator to assist sorting of coffee shops by distance
 * @author shashank
 *
 */
public class CoffeeShopDistanceComparator implements Comparator<CoffeeShopDistance>{
	
	@Override
	public int compare(CoffeeShopDistance o1, CoffeeShopDistance o2) {
		if (o2.getDistance() > o1.getDistance())
			return 1;
		if (o2.getDistance() < o1.getDistance())
			return -1;
		return 0;
	}

	
}
