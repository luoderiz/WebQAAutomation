package lippia.web.constants;

public class OrderConfirmationConstants {

    public static final String ORDER_NUMBER = "xpath://li[@class='order']/strong";

    public static final String ORDER_DATE = "xpath://li[@class='date']/strong";

    public static final String ORDER_TOTAL ="xpath://li[@class='total']/strong";

    public static final String ORDER_PAYMENT_METHOD ="xpath://li[@class='method']/strong";

    public static final String PRODUCT_NAME = "xpath://tr[@class='order_item']/td[@class='product-name']/a";

    public static final String PRODUCT_QUANTITY = "xpath://tr[@class='order_item']/td[@class='product-name']/strong[@class='product-quantity']";

    public static final String PRODUCT_TOTAL = "xpath://tr[@class='order_item']/td[@class='product-total']/span";

    public static final String ORDER_DETAILS_SUBTOTAL = "xpath://tr[th[contains(text(), 'Subtotal')]]/td/span[@class='woocommerce-Price-amount amount']";

    public static final String ORDER_DETAILS_TAX = "xpath://tr[th[contains(text(), 'Tax')]]/td/span[@class='woocommerce-Price-amount amount']";

    public static final String ORDER_DETAILS_TOTAL = "xpath://tr[th[contains(text(), 'Total')]]/td/span[@class='woocommerce-Price-amount amount']";

}
