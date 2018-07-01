package luiz.glingani.modal;

/**
 * Created by lglingani on 1/7/18.
 * Items available
 */
public class Item {

    private String code;
    private String name;
    private Double price;
    private PricingRuleType pricingRule;
    private Integer quantity;
    private Double newPrice;
    private String freeItemCode;
    private Integer freeQuantity;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public PricingRuleType getPricingRule() {
        return pricingRule;
    }

    public void setPricingRule(PricingRuleType pricingRule) {
        this.pricingRule = pricingRule;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(Double newPrice) {
        this.newPrice = newPrice;
    }

    public String getFreeItemCode() {
        return freeItemCode;
    }

    public void setFreeItemCode(String freeItemCode) {
        this.freeItemCode = freeItemCode;
    }

    public Integer getFreeQuantity() {
        return freeQuantity;
    }

    public void setFreeQuantity(Integer freeQuantity) {
        this.freeQuantity = freeQuantity;
    }
}
