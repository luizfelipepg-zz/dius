package luiz.glingani.database;
import java.util.HashMap;
import java.util.Map;

import luiz.glingani.modal.Item;
import luiz.glingani.modal.PricingRuleType;

/**
 * Created by lglingani on 1/7/18.
 * This class was created to simulate all items stored in the system. 
 */
public class ItemDatabase {

    static final Map<String, Item> data = new HashMap<String, Item>(){{
        put("ipd", create("ipd", "Super iPad", new Double("549.99"), PricingRuleType.DISCOUNT, 4, new Double("499.99"), null, null));
        put("mbp", create("mbp", "MacBook Pro", new Double("1399.99"), PricingRuleType.FREE_NEW_ITEM, 1, null, "vga", 1));
        put("atv", create("atv", "Apple TV", new Double("109.50"), PricingRuleType.FREE_ITEM, 3, null, null, 1));
        put("vga", create("vga", "VGA adapter", new Double("30.00"), null, null, null, null, null));
    }};

    public static Item getItem(String code){
        try {
            return data.get(code);
        } catch (Exception ex) {
            System.out.println("Not able to get item with code: " + code);
        }
        return null;
    }
    
    private static final Item create(String code, String name, Double price, PricingRuleType pricingRuleCode, Integer quantity, Double newPrice, String itemCode, Integer freeQuantity){
        Item item = new Item();
        item.setCode(code);
        item.setName(name);
        item.setPrice(price);
        item.setPricingRule(pricingRuleCode);
        item.setQuantity(quantity);
        item.setNewPrice(newPrice);
        item.setFreeQuantity(freeQuantity);
        item.setFreeItemCode(itemCode);
        return item;
    }


}
