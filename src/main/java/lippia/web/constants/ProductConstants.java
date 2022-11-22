package lippia.web.constants;

public class ProductConstants {

    public static final String ADD_TO_BASKET_BUTTON = "xpath://button[contains(@class, 'add_to_cart')]";

    public static final String PRODUCT_PRICE = "xpath://p[@class='price']/span[contains(@class,'amount')]";

    public static final String VIEW_BASKET_BUTTON = "xpath://a[.='View Basket']";

    public static final String BASKET_SUBTOTAL_VALUE = "xpath://tr[@class='cart-subtotal']//span[@class='woocommerce-Price-amount amount']";

    public static final String BASKET_TOTAL_VALUE = "xpath://tr[@class='order-total']/td/strong/span[@class='woocommerce-Price-amount amount']";

    public static final String BASKET_TAX_VALUE = "xpath://tr[@class='tax-rate tax-rate-in-tax-1']/td/span[@class='woocommerce-Price-amount amount']";

    public static final String PROCEED_TO_CHECKOUT_BUTTON = "xpath://a[contains(.,'Proceed to Checkout')]";

    public static final String CHECKOUT_SUBTOTAL_VALUE = "xpath://*[@id='order_review']/table/tfoot/tr[@class='cart-subtotal']//span[@class='woocommerce-Price-amount amount']";

    public static final String CHECKOUT_TOTAL_VALUE = "xpath://*[@id='order_review']/table/tfoot/tr[@class='order-total']/td/strong/span";

    public static final String CHECKOUT_TAX_VALUE = "xpath://*[@id='order_review']/table/tfoot//tr[@class='tax-rate tax-rate-in-tax-1']/td/span";

}
