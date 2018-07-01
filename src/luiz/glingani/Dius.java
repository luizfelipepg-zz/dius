package luiz.glingani;

import luiz.glingani.service.Checkout;

/**
 * Created by lglingani on 1/7/18.
 */
public class Dius {

	/**
	 * This is the main method. It will receive a list of item codes as argument
	 * and calculate the final price. I am just adding the pricingRule because it is 
	 * on the description of the test but I found no reason to have the pricing rules at
	 * this stage. I believe it is more flexible if associated to the item.
	 */
	public static void main(String[] args) {
		Checkout co = new Checkout(null);
        for(String code: args) {
        	co.scan(code);
        }
        co.total();
	}

	/**
	 * Same as before but being used by the unit test in case you rather run 
	 * using junit
	 */
    public Double run(String[] args) {
    	Object pricingRules= null;
        Checkout co = new Checkout(pricingRules);
        for(String code: args) {
        	co.scan(code);
        }
        return co.total();
    }
}
