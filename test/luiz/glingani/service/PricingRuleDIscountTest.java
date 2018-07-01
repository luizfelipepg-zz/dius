package luiz.glingani.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import luiz.glingani.modal.CheckoutItem;
import luiz.glingani.modal.Item;
import luiz.glingani.service.PricingRuleDIscount;

public class PricingRuleDIscountTest {

	private PricingRuleDIscount pricingRuleDIscount;
	private Item item;
	

	@Before
	public void setUp(){
		pricingRuleDIscount = new PricingRuleDIscount();
		Item item = new Item();
		item.setPrice(new Double("5.00"));
		item.setQuantity(3);
		item.setCode("code");
		item.setNewPrice(new Double("1.00"));
		this.item = item;
	}
	
	@Test
	public void testAddToNullList() {
		List<CheckoutItem> items = pricingRuleDIscount.update(item, null);
		Assert.assertEquals(0, items.size());
	}
	
	@Test
	public void testAddToNullItem() {
		List<CheckoutItem> list = new ArrayList<>();
		List<CheckoutItem> items = pricingRuleDIscount.update(null, list);
		Assert.assertEquals(list, items);
	}
	
	@Test
	public void testAddToEmptyList() {
		List<CheckoutItem> list = new ArrayList<>();
		List<CheckoutItem> items = pricingRuleDIscount.update(item, list);
		Assert.assertEquals(0, items.size());
		
	}
	
	@Test
	public void testNoFreeItem() {
		List<CheckoutItem> list = new ArrayList<>();
		list.add(createCheckoutItem(item));
		list.add(createCheckoutItem(item));
		List<CheckoutItem> items = pricingRuleDIscount.update(item, list);
		Assert.assertEquals(2, items.size());
		Assert.assertEquals(item.getPrice(), items.get(0).getPrice());
		Assert.assertEquals(item.getPrice(), items.get(1).getPrice());
	}
	
	@Test
	public void testFreeItem() {
		List<CheckoutItem> list = new ArrayList<>();
		list.add(createCheckoutItem(item));
		list.add(createCheckoutItem(item));
		list.add(createCheckoutItem(item));
		List<CheckoutItem> items = pricingRuleDIscount.update(item, list);
		Assert.assertEquals(3, items.size());
		Assert.assertEquals(item.getNewPrice(), items.get(0).getPrice());
		Assert.assertEquals(item.getNewPrice(), items.get(1).getPrice());
		Assert.assertEquals(item.getNewPrice(), items.get(2).getPrice());
	}
	
	private CheckoutItem createCheckoutItem(Item item){
    	CheckoutItem checkoutItem = new CheckoutItem();
    	checkoutItem.setItem(item);
    	checkoutItem.setPrice(item.getPrice());
    	return checkoutItem;
    	
    }

}
