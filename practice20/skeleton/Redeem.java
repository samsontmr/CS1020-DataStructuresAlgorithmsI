// This program reads in an item's cost and some coupons' information,
// and then determines which is the best coupon to use and the amount 
// to pay.

// Add import statement(s) below
import java.util.*;

public class Redeem {
	public void run() {
		Scanner sc = new Scanner(System.in);
		double price = sc.nextDouble();
		int num = sc. nextInt();

		Coupon[] coupons = new Coupon[num];
		for (int i = 0; i < num; i++) {
			String name = sc.next();
			double rate = sc.nextDouble();
			coupons[i] = new Coupon(name, rate);
		}

		Coupon bestCoupon = coupons[0];
		for(Coupon elem: coupons) {
			if  (elem.payment(price) <= 0 && bestCoupon.payment(price) <= 0) {
				if (Math.abs(elem.payment(price)) < Math.abs(bestCoupon.payment(price))) {
					bestCoupon = elem;
				}
			} else  if (elem.payment(price) < bestCoupon.payment(price)) {
				bestCoupon = elem;
			}
		}
		System.out.println("Best choice: " + bestCoupon.getName());

		double pay = 0;
		if (bestCoupon.payment(price) > 0) {
			pay = bestCoupon.payment(price);
		}
		System.out.printf("You need to pay $%.2f\n", pay);
	}

	public static void main(String[] args) {

		Redeem r = new Redeem();
		r.run();
		// Output the result
		// Ensure your output is in the right format
	}
}

