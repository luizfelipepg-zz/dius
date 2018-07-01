package luiz.glingani.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import luiz.glingani.modal.CheckoutItem;
import luiz.glingani.modal.Item;
import luiz.glingani.service.PricingRuleFreeNewItem;

public class PricingRuleFreeNewItemTest {

	private PricingRuleFreeNewItem pricingRuleFreeNewItem;
	private Item item;
	private Item freeItem;
	private String freeItemCode = "vga";

	@Before
	public void setUp(){
		pricingRuleFreeNewItem = new PricingRuleFreeNewItem();
		Double price = new Double("5.00");
		Item item = new Item();
		item.setPrice(price);
		item.setQuantity(1);
		item.setFreeQuantity(1);
		item.setCode("code");
		item.setFreeItemCode(freeItemCode);
		this.item = item;
		Item freeItem = new Item();
		freeItem.setPrice(price);
		freeItem.setCode(freeItemCode);
		this.freeItem = freeItem;
	}
	
	@Test
	public void testAddToNullList() {
		List<CheckoutItem> items = pricingRuleFreeNewItem.update(item, null);
		Assert.assertEquals(0, items.size());
	}
	
	@Test
	public void testAddToNullItem() {
		List<CheckoutItem> list = new ArrayList<>();
		List<CheckoutItem> items = pricingRuleFreeNewItem.update(null, list);
		Assert.assertEquals(list, items);
	}
	
	@Test
	public void testAddToEmptyList() {
		List<CheckoutItem> list = new ArrayList<>();
		Double price = new Double("5.00");
		item.setPrice(price);
		List<CheckoutItem> items = pricingRuleFreeNewItem.update(item, list);
		Assert.assertEquals(0, items.size());
	}
	
	@Test
	public void testAddExistingItem() {
		List<CheckoutItem> list = new ArrayList<>();
		list.add(createCheckoutItem(item));
		list.add(createCheckoutItem(freeItem));
		List<CheckoutItem> items = pricingRuleFreeNewItem.update(item, list);
		Assert.assertEquals(2, items.size());
		Assert.assertEquals(item.getPrice(), items.get(0).getPrice());
		Assert.assertEquals(item.getCode(), items.get(0).getItem().getCode());
		Assert.assertEquals(0d, items.get(1).getPrice());
		Assert.assertEquals(freeItemCode, items.get(1).getItem().getCode());
	}
	
	@Test
	public void testAddNoExistingItem() {
		List<CheckoutItem> list = new ArrayList<>();
		list.add(createCheckoutItem(item));
		List<CheckoutItem> items = pricingRuleFreeNewItem.update(item, list);
		Assert.assertEquals(2, items.size());
		Assert.assertEquals(item.getPrice(), items.get(0).getPrice());
		Assert.assertEquals(item.getCode(), items.get(0).getItem().getCode());
		Assert.assertEquals(0d, items.get(1).getPrice());
		Assert.assertEquals(freeItemCode, items.get(1).getItem().getCode());
	}
	
	private CheckoutItem createCheckoutItem(Item item){
    	CheckoutItem checkoutItem = new CheckoutItem();
    	checkoutItem.setItem(item);
    	checkoutItem.setPrice(item.getPrice());
    	return checkoutItem;
    	
    }

}
