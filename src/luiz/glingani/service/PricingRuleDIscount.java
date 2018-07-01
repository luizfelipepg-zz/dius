package luiz.glingani.service;
import java.util.List;

import luiz.glingani.modal.CheckoutItem;
import luiz.glingani.modal.Item;

/**
 * Created by lglingani on 1/7/18.
 * Implementation for Items with Price Discount
 */
public class PricingRuleDIscount extends PricingRule {

    public List<CheckoutItem> update(Item item, List<CheckoutItem> checkoutItems) {
    	if (item == null) {
    		return checkoutItems;
    	}
    	checkoutItems = checkItems(checkoutItems);
    	Integer quantity = item.getQuantity();
        Integer listQuantity = getListQuantity(item.getCode(), checkoutItems);
        if (quantity != null && listQuantity >= quantity) {
            System.out.println("Applying discount");
            updateListPrice(item.getCode(), item.getNewPrice(), checkoutItems);
        }
        return checkoutItems;
    }

    /**
     * Update all items price
     */
    private List<CheckoutItem> updateListPrice(String code, Double newPrice, List<CheckoutItem> checkoutItems){
        for (CheckoutItem checkoutItem : checkoutItems) {
        	Item item = checkoutItem.getItem();
            if (code.equals(item.getCode())) {
            	checkoutItem.setPrice(newPrice);
            }
        }
        return checkoutItems;
    }
    
    


}
