package luiz.glingani.service;
import java.util.List;

import luiz.glingani.database.ItemDatabase;
import luiz.glingani.modal.CheckoutItem;
import luiz.glingani.modal.Item;

/**
 * Created by lglingani on 1/7/18.
 * Implementation for Items with Free New Items 
 */
public class PricingRuleFreeNewItem extends PricingRule{

    public List<CheckoutItem> update(Item item, List<CheckoutItem> checkoutItems){
    	if (item == null) {
    		return checkoutItems;
    	}
    	checkoutItems = checkItems(checkoutItems);
    	String freeItemCode = item.getFreeItemCode();
    	Integer numberFreeItems = getListQuantity(item.getCode(), checkoutItems);
    	for(CheckoutItem checkoutItem : checkoutItems) {
    		if (numberFreeItems == 0) {
    			break;
    		}
    		if(freeItemCode.equals(checkoutItem.getItem().getCode()) && checkoutItem.getPrice() != 0d) {
    			checkoutItem.setPrice(0d);
    			numberFreeItems--;
    		}
    	}
    	Item freeItem = ItemDatabase.getItem(freeItemCode);
    	for(int count = 1; count <= numberFreeItems; count++) {
    		checkoutItems.add(createCheckoutItem(freeItem, 0d));
    	}
    	return checkoutItems;
    }
   
}
