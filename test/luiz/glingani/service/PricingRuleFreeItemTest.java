package luiz.glingani.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import luiz.glingani.modal.CheckoutItem;
import luiz.glingani.modal.Item;
import luiz.glingani.service.PricingRuleFreeItem;

public class PricingRuleFreeItemTest {

	private PricingRuleFreeItem pricingRuleFreeItem;
	private Item item;

	@Before
	public void setUp(){
		pricingRuleFreeItem = new PricingRuleFreeItem();
		Double price = new Double("5.00");
		Item item = new Item();
		item.setPrice(price);
		item.setQuantity(3);
		item.setCode("code");
		this.item = item;
		
	}
	
	@Test
	public void testAddToNullList() {
		List<CheckoutItem> items = pricingRuleFreeItem.update(item, null);
		Assert.assertEquals(0, items.size());
	}
	
	@Test
	public void testAddToNullItem() {
		List<CheckoutItem> list = new ArrayList<>();
		List<CheckoutItem> items = pricingRuleFreeItem.update(null, list);
		Assert.assertEquals(list, items);
	}
	
	@Test
	public void testAddToEmptyList() {
		List<CheckoutItem> list = new ArrayList<>();
		List<CheckoutItem> items = pricingRuleFreeItem.update(item, list);
		Assert.assertEquals(0, items.size());
	}
	
	@Test
	public void testApplyFreeItem() {
		List<CheckoutItem> list = new ArrayList<>();
		list.add(createCheckoutItem(item));
		list.add(createCheckoutItem(item));
		list.add(createCheckoutItem(item));
		list.add(createCheckoutItem(item));
		List<CheckoutItem> items = pricingRuleFreeItem.update(item, list);
		Assert.assertEquals(4, items.size());
		Assert.assertEquals(item.getPrice(), items.get(0).getPrice());
		Assert.assertEquals(item.getPrice(), items.get(1).getPrice());
		Assert.assertEquals(0d, items.get(2).getPrice());
		Assert.assertEquals(item.getPrice(), items.get(3).getPrice());
	}
	
	@Test
	public void testApplyNoFreeItem() {
		List<CheckoutItem> list = new ArrayList<>();
		list.add(createCheckoutItem(item));
		list.add(createCheckoutItem(item));
		List<CheckoutItem> items = pricingRuleFreeItem.update(item, list);
		Assert.assertEquals(2, items.size());
		Assert.assertEquals(item.getPrice(), items.get(0).getPrice());
		Assert.assertEquals(item.getPrice(), items.get(1).getPrice());
	}
	
	private CheckoutItem createCheckoutItem(Item item){
    	CheckoutItem checkoutItem = new CheckoutItem();
    	checkoutItem.setItem(item);
    	checkoutItem.setPrice(item.getPrice());
    	return checkoutItem;
    	
    }

}
