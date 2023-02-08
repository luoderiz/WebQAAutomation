package lippia.web.constants;

public class PaymentGatewayConstants {

    public static final String FINAL_BILLING_DETAILS = "xpath://h3[.='Billing Details']";
    public static final String FINAL_ORDER_REVIEW_DETAILS = "xpath://h3[@id='order_review_heading']";
    public static final String FINAL_ADDITIONAL_DETAILS = "xpath://h3[.='Additional Information']";

    public static final String CART_DETAILS_PRODUCT_NAME = "xpath://tbody/tr[@class='cart_item']/td[@class='product-name']";

    public static final String CART_DETAILS_PRODUCT_PRICE = "xpath://tbody/tr[@class='cart_item']/td[@class='product-total']/span[@class='woocommerce-Price-amount amount']";

    public static final String CART_DETAILS_SUBTOTAL = "xpath://tr[@class='cart-subtotal']/td/span[@class='woocommerce-Price-amount amount']";

    public static final String CART_DETAILS_TOTAL = "xpath://tr[@class='order-total']/td/strong/span[@class='woocommerce-Price-amount amount']";

    public static final String CART_DETAILS_TAX = "xpath://tr[@class='tax-rate tax-rate-in-tax-1']/td/span[@class='woocommerce-Price-amount amount']";

    public static final String COUPON_ALERT = "xpath://a[@class='showcoupon']";

    public static final String COUPON_CODE_INPUT_BOX = "xpath://input[@id='coupon_code']";

    public static final String APPLY_COUPON_BUTTON = "xpath://input[@name='apply_coupon']";

    public static final String BILLING_FIRST_NAME_INPUT_BOX = "id:billing_first_name";

    public static final String BILLING_LAST_NAME_INPUT_BOX = "id:billing_last_name";

    public static final String BILLING_COMPANY_INPUT_BOX = "id:billing_company";

    public static final String BILLING_EMAIL_INPUT_BOX = "id:billing_email";

    public static final String BILLING_PHONE_INPUT_BOX = "id:billing_phone";

    public static final String BILLING_COUNTRY_DISPLAY_OPTIONS_BUTTON = "xpath://div[@class='select2-container country_to_state country_select']//b[1]";

    public static final String BILLING_COUNTRY_SELECTED_OPTION = "xpath://div[.='%s']";

    public static final String BILLING_STREET_ADDRESS_INPUT_BOX = "xpath://input[@placeholder='Street address']";

    public static final String BILLING_ADDRESS_APARTMENT_INPUT_BOX = "xpath://input[contains(@placeholder,'Apartment')]";

    public static final String BILLING_CITY_INPUT_BOX = "xpath://input[@id='billing_city']";

    public static final String BILLING_STATE_OPTIONS = "xpath://select[@id='billing_state']/option";

    public static final String BILLING_POSTCODE_INPUT_BOX = "xpath://input[@id='billing_postcode']";

    public static final String PAYMENT_METHOD_DIRECT_BANK_TRANSFER = "xpath://input[@id='payment_method_bacs']";

    public static final String PAYMENT_METHOD_CHECK = "xpath://input[@id='payment_method_cheque']";

    public static final String PAYMENT_METHOD_CASH_ON_DELIVERY = "xpath://input[@id='payment_method_cod']";

    public static final String PAYMENT_METHOD_PAYPAL_EXPRESS_CHECKOUT = "xpath://input[@id='payment_method_ppec_paypal']";

    public static final String PLACE_ORDER_BUTTON = "xpath://input[@id='place_order']";
}
