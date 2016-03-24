
/**
 * Maintain coffee shop name and distance from user
 * @author shashank
 *
 */
public class CoffeeShopDistance{
	private String coffeeShop; // name of shop
	private double distance;   // distance from user
	
	public CoffeeShopDistance(String coffeeShop, double distance) {
		this.distance = distance;
		this.coffeeShop = coffeeShop;
	}

	public String getCoffeeShop() {
		return coffeeShop;
	}
	
	public double getDistance() {
		return distance;
	}

	@Override
	public String toString() {
		return coffeeShop + " : " + String.format( "%.4f", distance );
	}
}
