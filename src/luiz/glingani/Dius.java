package luiz.glingani;
import java.util.ArrayList;
import java.util.List;

import luiz.glingani.service.Checkout;

/**
 * Created by lglingani on 1/7/18.
 */
public class Dius {

	/**
	 * This is the main method. It wil receive a list of item codes as argument
	 * and calculate the final price. I am just adding the pricingRule because it is 
	 * on the description of the test but I found no reason to have the pricing rules at
	 * this stage. I believe it is more flexible if associated to the item.
	 */
    public Double main(String[] arg) {
    	Object pricingRules= null;
        Checkout co = new Checkout(pricingRules);
        for(String code: arg) {
        	co.scan(code);
        }
        return co.total();
    }
}
