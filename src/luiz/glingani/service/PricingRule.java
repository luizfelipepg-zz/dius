package luiz.glingani.service;
import java.util.ArrayList;
import java.util.List;

import luiz.glingani.modal.CheckoutItem;
import luiz.glingani.modal.Item;
import luiz.glingani.modal.PricingRuleType;

/**
 * Created by lglingani on 1/7/18.
 */
public class PricingRule {
	
	/**
     * Update the checkout list depending on the items and discounts 
     */
    public List<CheckoutItem> update(Item item, List<CheckoutItem> checkoutItems) {
    	if (PricingRuleType.DISCOUNT.equals(item.getPricingRule())) {
            return new PricingRuleDIscount().update(item, checkoutItems);
        }
        if (PricingRuleType.FREE_ITEM.equals(item.getPricingRule())) {
            return new PricingRuleFreeItem().update(item, checkoutItems);
        }
        if (PricingRuleType.FREE_NEW_ITEM.equals(item.getPricingRule())) {
            return new PricingRuleFreeNewItem().update(item, checkoutItems);
        }
        return checkoutItems;
    }
    
    /**
     * Check if checkout is null and create a empty list instead of null list 
     */
    protected List<CheckoutItem> checkItems(List<CheckoutItem> checkoutItems){
    	if (checkoutItems == null) {
    		return new ArrayList<>();
    	}
    	return checkoutItems;
    }

    /**
     * Check number of items with same code 
     */
    protected Integer getListQuantity(String code, List<CheckoutItem> checkoutItems){
        Integer quantity = 0;
        for (CheckoutItem checkoutItem : checkoutItems) {
            if (code.equals(checkoutItem.getItem().getCode())) {
                quantity++;
            }
        }
        return quantity;
    }
    
    /**
     * Create checkout item 
     */
    protected CheckoutItem createCheckoutItem(Item item, Double price){
    	CheckoutItem checkoutItem = new CheckoutItem();
    	checkoutItem.setItem(item);
    	checkoutItem.setPrice(price);
    	return checkoutItem;
    	
    }

}