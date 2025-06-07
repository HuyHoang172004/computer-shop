package com.techecommerce.constant;

public class ApiEndpoints {
    // Base API path
    public static final String API_BASE = "/api";

    // Auth endpoints
    public static final String AUTH_BASE = API_BASE + "/auth";
    public static final String AUTH_REGISTER = AUTH_BASE + "/register";
    public static final String AUTH_LOGIN = AUTH_BASE + "/login";
    public static final String AUTH_LOGOUT = AUTH_BASE + "/logout";
    public static final String AUTH_REFRESH_TOKEN = AUTH_BASE + "/refresh-token";
    public static final String AUTH_FORGOT_PASSWORD = AUTH_BASE + "/forgot-password";
    public static final String AUTH_RESET_PASSWORD = AUTH_BASE + "/reset-password";
    public static final String AUTH_VERIFY_EMAIL = AUTH_BASE + "/verify-email";
    public static final String AUTH_RESEND_VERIFICATION = AUTH_BASE + "/resend-verification";

    // User endpoints
    public static final String USER_BASE = API_BASE + "/users";
    public static final String USER_PROFILE = USER_BASE + "/profile";
    public static final String USER_PASSWORD = USER_BASE + "/password";
    public static final String USER_EMAIL = USER_BASE + "/email";
    public static final String USER_ADDRESS = USER_BASE + "/address";
    public static final String USER_PAYMENT = USER_BASE + "/payment";
    public static final String USER_NOTIFICATION = USER_BASE + "/notification";

    // Product endpoints
    public static final String PRODUCT_BASE = API_BASE + "/products";
    public static final String PRODUCT_SEARCH = PRODUCT_BASE + "/search";
    public static final String PRODUCT_FILTER = PRODUCT_BASE + "/filter";
    public static final String PRODUCT_IMAGE = PRODUCT_BASE + "/{id}/images";
    public static final String PRODUCT_SPECIFICATION = PRODUCT_BASE + "/{id}/specifications";
    public static final String PRODUCT_WARRANTY = PRODUCT_BASE + "/{id}/warranty";
    public static final String PRODUCT_REVIEW = PRODUCT_BASE + "/{id}/reviews";
    public static final String PRODUCT_COMMENT = PRODUCT_BASE + "/{id}/comments";
    public static final String PRODUCT_TAG = PRODUCT_BASE + "/{id}/tags";
    public static final String PRODUCT_VARIANT = PRODUCT_BASE + "/{id}/variants";
    public static final String PRODUCT_ATTRIBUTE = PRODUCT_BASE + "/{id}/attributes";

    // Category endpoints
    public static final String CATEGORY_BASE = API_BASE + "/categories";
    public static final String CATEGORY_HIERARCHY = CATEGORY_BASE + "/hierarchy";
    public static final String CATEGORY_PRODUCTS = CATEGORY_BASE + "/{id}/products";

    // Brand endpoints
    public static final String BRAND_BASE = API_BASE + "/brands";
    public static final String BRAND_LOGO = BRAND_BASE + "/{id}/logo";
    public static final String BRAND_PRODUCTS = BRAND_BASE + "/{id}/products";

    // Order endpoints
    public static final String ORDER_BASE = API_BASE + "/orders";
    public static final String ORDER_STATUS = ORDER_BASE + "/{id}/status";
    public static final String ORDER_PAYMENT = ORDER_BASE + "/{id}/payment";
    public static final String ORDER_SHIPPING = ORDER_BASE + "/{id}/shipping";
    public static final String ORDER_CANCEL = ORDER_BASE + "/{id}/cancel";
    public static final String ORDER_STATISTICS = ORDER_BASE + "/statistics";
    public static final String ORDER_USER = ORDER_BASE + "/user/{userId}";
    public static final String ORDER_DATE_RANGE = ORDER_BASE + "/date-range";

    // Cart endpoints
    public static final String CART_BASE = API_BASE + "/cart";
    public static final String CART_ITEM = CART_BASE + "/items";
    public static final String CART_CLEAR = CART_BASE + "/clear";
    public static final String CART_CHECKOUT = CART_BASE + "/checkout";

    // Wishlist endpoints
    public static final String WISHLIST_BASE = API_BASE + "/wishlist";
    public static final String WISHLIST_ITEM = WISHLIST_BASE + "/items";
    public static final String WISHLIST_CLEAR = WISHLIST_BASE + "/clear";

    // Discount endpoints
    public static final String DISCOUNT_BASE = API_BASE + "/discounts";
    public static final String DISCOUNT_APPLY = DISCOUNT_BASE + "/apply";
    public static final String DISCOUNT_REMOVE = DISCOUNT_BASE + "/remove";
    public static final String DISCOUNT_VALIDATE = DISCOUNT_BASE + "/validate";

    // Payment endpoints
    public static final String PAYMENT_BASE = API_BASE + "/payments";
    public static final String PAYMENT_PROCESS = PAYMENT_BASE + "/process";
    public static final String PAYMENT_REFUND = PAYMENT_BASE + "/refund";
    public static final String PAYMENT_WEBHOOK = PAYMENT_BASE + "/webhook";

    // Shipping endpoints
    public static final String SHIPPING_BASE = API_BASE + "/shipping";
    public static final String SHIPPING_CALCULATE = SHIPPING_BASE + "/calculate";
    public static final String SHIPPING_TRACK = SHIPPING_BASE + "/track";
    public static final String SHIPPING_STATUS = SHIPPING_BASE + "/status";

    // Location endpoints
    public static final String LOCATION_BASE = API_BASE + "/locations";
    public static final String LOCATION_HIERARCHY = LOCATION_BASE + "/hierarchy";
    public static final String LOCATION_PARENT = LOCATION_BASE + "/parent/{parentId}";
    public static final String LOCATION_TYPE = LOCATION_BASE + "/type/{type}";
    public static final String LOCATION_ACTIVE = LOCATION_BASE + "/active";
    public static final String LOCATION_SEARCH = LOCATION_BASE + "/search";
    public static final String LOCATION_SHIPPING_FEE = LOCATION_BASE + "/shipping-fee";

    // Import endpoints
    public static final String IMPORT_BASE = API_BASE + "/imports";
    public static final String IMPORT_PROCESS = IMPORT_BASE + "/process";
    public static final String IMPORT_CANCEL = IMPORT_BASE + "/cancel";
    public static final String IMPORT_STATISTICS = IMPORT_BASE + "/statistics";
    public static final String IMPORT_TEMPLATE = IMPORT_BASE + "/template";

    // File upload endpoints
    public static final String FILE_BASE = API_BASE + "/files";
    public static final String FILE_UPLOAD = FILE_BASE + "/upload";
    public static final String FILE_DOWNLOAD = FILE_BASE + "/download";
    public static final String FILE_DELETE = FILE_BASE + "/delete";

    // Comment endpoints
    public static final String COMMENT_BASE = API_BASE + "/comments";
    public static final String COMMENT_LIKE = COMMENT_BASE + "/{id}/like";
    public static final String COMMENT_UNLIKE = COMMENT_BASE + "/{id}/unlike";
    public static final String COMMENT_REPLY = COMMENT_BASE + "/{id}/reply";

    // Tag endpoints
    public static final String TAG_BASE = API_BASE + "/tags";
    public static final String TAG_PRODUCTS = TAG_BASE + "/{id}/products";

    // Role endpoints
    public static final String ROLE_BASE = API_BASE + "/roles";
    public static final String ROLE_PERMISSIONS = ROLE_BASE + "/{id}/permissions";
    public static final String ROLE_USERS = ROLE_BASE + "/{id}/users";

    // Permission endpoints
    public static final String PERMISSION_BASE = API_BASE + "/permissions";
    public static final String PERMISSION_ROLES = PERMISSION_BASE + "/{id}/roles";
    public static final String PERMISSION_USERS = PERMISSION_BASE + "/{id}/users";

    // Config endpoints
    public static final String CONFIG_BASE = API_BASE + "/configs";
    public static final String CONFIG_VALUE = CONFIG_BASE + "/{key}/value";

    // Email template endpoints
    public static final String EMAIL_TEMPLATE_BASE = API_BASE + "/email-templates";
    public static final String EMAIL_TEMPLATE_SEND = EMAIL_TEMPLATE_BASE + "/{id}/send";
    public static final String EMAIL_TEMPLATE_PREVIEW = EMAIL_TEMPLATE_BASE + "/{id}/preview";

    // System log endpoints
    public static final String SYSTEM_LOG_BASE = API_BASE + "/system-logs";
    public static final String SYSTEM_LOG_SEARCH = SYSTEM_LOG_BASE + "/search";
    public static final String SYSTEM_LOG_EXPORT = SYSTEM_LOG_BASE + "/export";

    // Report endpoints
    public static final String REPORT_BASE = API_BASE + "/reports";
    public static final String REPORT_GENERATE = REPORT_BASE + "/generate";
    public static final String REPORT_DOWNLOAD = REPORT_BASE + "/download";
    public static final String REPORT_SCHEDULE = REPORT_BASE + "/schedule";

    // Export endpoints
    public static final String EXPORT_BASE = API_BASE + "/exports";
    public static final String EXPORT_GENERATE = EXPORT_BASE + "/generate";
    public static final String EXPORT_DOWNLOAD = EXPORT_BASE + "/download";
    public static final String EXPORT_SCHEDULE = EXPORT_BASE + "/schedule";

    // Dashboard endpoints
    public static final String DASHBOARD_BASE = API_BASE + "/dashboard";
    public static final String DASHBOARD_STATISTICS = DASHBOARD_BASE + "/statistics";
    public static final String DASHBOARD_CHART = DASHBOARD_BASE + "/chart";
    public static final String DASHBOARD_WIDGET = DASHBOARD_BASE + "/widget";

    // API key endpoints
    public static final String API_KEY_BASE = API_BASE + "/api-keys";
    public static final String API_KEY_REVOKE = API_KEY_BASE + "/{id}/revoke";
    public static final String API_KEY_PERMISSIONS = API_KEY_BASE + "/{id}/permissions";

    // API log endpoints
    public static final String API_LOG_BASE = API_BASE + "/api-logs";
    public static final String API_LOG_SEARCH = API_LOG_BASE + "/search";
    public static final String API_LOG_EXPORT = API_LOG_BASE + "/export";
} 