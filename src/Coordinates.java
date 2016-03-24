/**
 * Maintain x,y Co-ordinates
 * @author shashank
 *
 */
public class Coordinates {
	double x;
	double y;

	public Coordinates(double x, double y) {
		this.x = x;
		this.y = y;
	}

	double getEuclideanDistance(Coordinates coffeeShop) {
		double xDiff = this.x - coffeeShop.x;
		double xSq = Math.pow(xDiff, 2);
		double yDiff = this.y - coffeeShop.y;
		double ySq = Math.pow(yDiff, 2);
		return Math.sqrt(xSq + ySq);
	}
}