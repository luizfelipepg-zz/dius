package luiz.glingani.service;
import java.util.ArrayList;
import java.util.List;

import luiz.glingani.modal.CheckoutItem;
import luiz.glingani.modal.Item;

/**
 * Created by lglingani on 1/7/18.
 * Implementation for Items with Free Items 
 */
public class PricingRuleFreeItem extends PricingRule{

    public List<CheckoutItem> update(Item item, List<CheckoutItem> checkoutItems){
    	if (item == null) {
    		return checkoutItems;
    	}
    	checkoutItems = checkItems(checkoutItems);
    	String code = item.getCode();
    	Integer freeItemQuantity = item.getQuantity() == null ? 0 : item.getQuantity();
    	Integer quantity = 0;
    	for (CheckoutItem checkoutItem: checkoutItems) {
    		if (code.equals(checkoutItem.getItem().getCode())) {
    			quantity++;
    			if (quantity == freeItemQuantity) {
    				checkoutItem.setPrice(0d);
    				quantity = 0;
    			}
    		}
    	}
        return checkoutItems;
    }
}
