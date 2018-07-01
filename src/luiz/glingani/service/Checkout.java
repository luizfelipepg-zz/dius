package luiz.glingani.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import luiz.glingani.database.ItemDatabase;
import luiz.glingani.modal.CheckoutItem;
import luiz.glingani.modal.Item;

/**
 * Created by lglingani on 1/7/18.
 * Class responsible to manage the checkout
 */
public class Checkout {

	private static DecimalFormat df2 = new DecimalFormat(".##");
	
	/**
	 * Checkout information
	 * checkoutItems: All items on the checkout
	 * items: List of discounts to be applied
	 */
	private List<CheckoutItem> checkoutItems;
	private Set<Item> items;

	/**
	 * Initialize the checkout
	 */
	public Checkout(Object object){
        this.checkoutItems = new ArrayList<>();
        this.items = new HashSet<>();
    }

	/**
	 * Scan for a particular product code and add to the checkout list
	 */
    public void scan(String code){
        try {
        	Item item = ItemDatabase.getItem(code);
        	if (item != null) { 
        		if (item.getPricingRule() != null) {
        			items.add(item);
        		}
        		CheckoutItem checkoutItem = new CheckoutItem();
            	checkoutItem.setItem(item);
            	checkoutItem.setPrice(item.getPrice());
            	checkoutItems.add(checkoutItem);
        	}
        } catch(Exception e) {
            System.out.println("Invalid item. Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
	 * Calculate and print the total
	 */
    public Double total(){
    	System.out.println("--------------------");
        Double total = 0d;
        PricingRule pricingRule = new PricingRule();
        for(Item item: items) {
        	checkoutItems = pricingRule.update(item, checkoutItems); 
        }
        for(CheckoutItem checkoutItem: checkoutItems) {
            System.out.println(checkoutItem.getItem().getName() + "\t\t\t" + checkoutItem.getPrice());
            total = total+checkoutItem.getPrice();
        }
        System.out.println("Total: \t\t\t\t" + df2.format(total));
        return total;
    }

}
