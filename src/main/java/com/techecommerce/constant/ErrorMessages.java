package com.techecommerce.constant;

public class ErrorMessages {
    // Common errors
    public static final String INTERNAL_SERVER_ERROR = "An unexpected error occurred";
    public static final String INVALID_REQUEST = "Invalid request";
    public static final String UNAUTHORIZED = "Unauthorized access";
    public static final String FORBIDDEN = "Access denied";
    public static final String NOT_FOUND = "Resource not found";
    public static final String VALIDATION_ERROR = "Validation error";

    // Auth errors
    public static final String INVALID_CREDENTIALS = "Invalid username or password";
    public static final String ACCOUNT_DISABLED = "Account is disabled";
    public static final String ACCOUNT_LOCKED = "Account is locked";
    public static final String ACCOUNT_EXPIRED = "Account is expired";
    public static final String CREDENTIALS_EXPIRED = "Credentials are expired";
    public static final String INVALID_TOKEN = "Invalid token";
    public static final String EXPIRED_TOKEN = "Token has expired";
    public static final String INVALID_REFRESH_TOKEN = "Invalid refresh token";
    public static final String EMAIL_ALREADY_EXISTS = "Email already exists";
    public static final String USERNAME_ALREADY_EXISTS = "Username already exists";
    public static final String INVALID_VERIFICATION_TOKEN = "Invalid verification token";
    public static final String INVALID_RESET_TOKEN = "Invalid reset token";

    // User errors
    public static final String USER_NOT_FOUND = "User not found";
    public static final String USER_ALREADY_EXISTS = "User already exists";
    public static final String INVALID_USER_ID = "Invalid user ID";
    public static final String INVALID_USER_DATA = "Invalid user data";
    public static final String USER_DELETION_FAILED = "Failed to delete user";
    public static final String USER_UPDATE_FAILED = "Failed to update user";

    // Product errors
    public static final String PRODUCT_NOT_FOUND = "Product not found";
    public static final String PRODUCT_ALREADY_EXISTS = "Product already exists";
    public static final String INVALID_PRODUCT_ID = "Invalid product ID";
    public static final String INVALID_PRODUCT_DATA = "Invalid product data";
    public static final String PRODUCT_DELETION_FAILED = "Failed to delete product";
    public static final String PRODUCT_UPDATE_FAILED = "Failed to update product";
    public static final String INSUFFICIENT_STOCK = "Insufficient stock";

    // Category errors
    public static final String CATEGORY_NOT_FOUND = "Category not found";
    public static final String CATEGORY_ALREADY_EXISTS = "Category already exists";
    public static final String INVALID_CATEGORY_ID = "Invalid category ID";
    public static final String INVALID_CATEGORY_DATA = "Invalid category data";
    public static final String CATEGORY_DELETION_FAILED = "Failed to delete category";
    public static final String CATEGORY_UPDATE_FAILED = "Failed to update category";

    // Brand errors
    public static final String BRAND_NOT_FOUND = "Brand not found";
    public static final String BRAND_ALREADY_EXISTS = "Brand already exists";
    public static final String INVALID_BRAND_ID = "Invalid brand ID";
    public static final String INVALID_BRAND_DATA = "Invalid brand data";
    public static final String BRAND_DELETION_FAILED = "Failed to delete brand";
    public static final String BRAND_UPDATE_FAILED = "Failed to update brand";

    // Order errors
    public static final String ORDER_NOT_FOUND = "Order not found";
    public static final String INVALID_ORDER_ID = "Invalid order ID";
    public static final String INVALID_ORDER_DATA = "Invalid order data";
    public static final String ORDER_CANCELLATION_FAILED = "Failed to cancel order";
    public static final String ORDER_UPDATE_FAILED = "Failed to update order";
    public static final String INVALID_ORDER_STATUS = "Invalid order status";
    public static final String ORDER_ALREADY_CANCELLED = "Order is already cancelled";
    public static final String ORDER_ALREADY_COMPLETED = "Order is already completed";

    // Cart errors
    public static final String CART_NOT_FOUND = "Cart not found";
    public static final String INVALID_CART_ID = "Invalid cart ID";
    public static final String INVALID_CART_DATA = "Invalid cart data";
    public static final String CART_UPDATE_FAILED = "Failed to update cart";
    public static final String CART_ITEM_NOT_FOUND = "Cart item not found";
    public static final String INVALID_CART_ITEM = "Invalid cart item";

    // Wishlist errors
    public static final String WISHLIST_NOT_FOUND = "Wishlist not found";
    public static final String INVALID_WISHLIST_ID = "Invalid wishlist ID";
    public static final String INVALID_WISHLIST_DATA = "Invalid wishlist data";
    public static final String WISHLIST_UPDATE_FAILED = "Failed to update wishlist";
    public static final String WISHLIST_ITEM_NOT_FOUND = "Wishlist item not found";
    public static final String INVALID_WISHLIST_ITEM = "Invalid wishlist item";

    // Discount errors
    public static final String DISCOUNT_NOT_FOUND = "Discount not found";
    public static final String DISCOUNT_ALREADY_EXISTS = "Discount already exists";
    public static final String INVALID_DISCOUNT_ID = "Invalid discount ID";
    public static final String INVALID_DISCOUNT_DATA = "Invalid discount data";
    public static final String DISCOUNT_DELETION_FAILED = "Failed to delete discount";
    public static final String DISCOUNT_UPDATE_FAILED = "Failed to update discount";
    public static final String DISCOUNT_EXPIRED = "Discount has expired";
    public static final String DISCOUNT_INACTIVE = "Discount is inactive";

    // Payment errors
    public static final String PAYMENT_NOT_FOUND = "Payment not found";
    public static final String INVALID_PAYMENT_ID = "Invalid payment ID";
    public static final String INVALID_PAYMENT_DATA = "Invalid payment data";
    public static final String PAYMENT_FAILED = "Payment failed";
    public static final String PAYMENT_ALREADY_PROCESSED = "Payment already processed";
    public static final String INVALID_PAYMENT_METHOD = "Invalid payment method";

    // Shipping errors
    public static final String SHIPPING_NOT_FOUND = "Shipping not found";
    public static final String INVALID_SHIPPING_ID = "Invalid shipping ID";
    public static final String INVALID_SHIPPING_DATA = "Invalid shipping data";
    public static final String SHIPPING_UPDATE_FAILED = "Failed to update shipping";
    public static final String INVALID_SHIPPING_METHOD = "Invalid shipping method";
    public static final String SHIPPING_FEE_CALCULATION_FAILED = "Failed to calculate shipping fee";

    // Location errors
    public static final String LOCATION_NOT_FOUND = "Location not found";
    public static final String LOCATION_ALREADY_EXISTS = "Location already exists";
    public static final String INVALID_LOCATION_ID = "Invalid location ID";
    public static final String INVALID_LOCATION_DATA = "Invalid location data";
    public static final String LOCATION_DELETION_FAILED = "Failed to delete location";
    public static final String LOCATION_UPDATE_FAILED = "Failed to update location";
    public static final String INVALID_LOCATION_TYPE = "Invalid location type";
    public static final String INVALID_LOCATION_HIERARCHY = "Invalid location hierarchy";

    // Import errors
    public static final String IMPORT_NOT_FOUND = "Import not found";
    public static final String INVALID_IMPORT_ID = "Invalid import ID";
    public static final String INVALID_IMPORT_DATA = "Invalid import data";
    public static final String IMPORT_FAILED = "Import failed";
    public static final String IMPORT_ALREADY_PROCESSED = "Import already processed";
    public static final String INVALID_IMPORT_FILE = "Invalid import file";

    // File upload errors
    public static final String FILE_UPLOAD_FAILED = "File upload failed";
    public static final String INVALID_FILE_TYPE = "Invalid file type";
    public static final String FILE_SIZE_EXCEEDED = "File size exceeded";
    public static final String FILE_NOT_FOUND = "File not found";
    public static final String FILE_DELETION_FAILED = "Failed to delete file";

    // Comment errors
    public static final String COMMENT_NOT_FOUND = "Comment not found";
    public static final String INVALID_COMMENT_ID = "Invalid comment ID";
    public static final String INVALID_COMMENT_DATA = "Invalid comment data";
    public static final String COMMENT_DELETION_FAILED = "Failed to delete comment";
    public static final String COMMENT_UPDATE_FAILED = "Failed to update comment";

    // Tag errors
    public static final String TAG_NOT_FOUND = "Tag not found";
    public static final String TAG_ALREADY_EXISTS = "Tag already exists";
    public static final String INVALID_TAG_ID = "Invalid tag ID";
    public static final String INVALID_TAG_DATA = "Invalid tag data";
    public static final String TAG_DELETION_FAILED = "Failed to delete tag";
    public static final String TAG_UPDATE_FAILED = "Failed to update tag";

    // Role errors
    public static final String ROLE_NOT_FOUND = "Role not found";
    public static final String ROLE_ALREADY_EXISTS = "Role already exists";
    public static final String INVALID_ROLE_ID = "Invalid role ID";
    public static final String INVALID_ROLE_DATA = "Invalid role data";
    public static final String ROLE_DELETION_FAILED = "Failed to delete role";
    public static final String ROLE_UPDATE_FAILED = "Failed to update role";

    // Permission errors
    public static final String PERMISSION_NOT_FOUND = "Permission not found";
    public static final String PERMISSION_ALREADY_EXISTS = "Permission already exists";
    public static final String INVALID_PERMISSION_ID = "Invalid permission ID";
    public static final String INVALID_PERMISSION_DATA = "Invalid permission data";
    public static final String PERMISSION_DELETION_FAILED = "Failed to delete permission";
    public static final String PERMISSION_UPDATE_FAILED = "Failed to update permission";

    // Config errors
    public static final String CONFIG_NOT_FOUND = "Config not found";
    public static final String INVALID_CONFIG_ID = "Invalid config ID";
    public static final String INVALID_CONFIG_DATA = "Invalid config data";
    public static final String CONFIG_UPDATE_FAILED = "Failed to update config";

    // Email template errors
    public static final String EMAIL_TEMPLATE_NOT_FOUND = "Email template not found";
    public static final String EMAIL_TEMPLATE_ALREADY_EXISTS = "Email template already exists";
    public static final String INVALID_EMAIL_TEMPLATE_ID = "Invalid email template ID";
    public static final String INVALID_EMAIL_TEMPLATE_DATA = "Invalid email template data";
    public static final String EMAIL_TEMPLATE_DELETION_FAILED = "Failed to delete email template";
    public static final String EMAIL_TEMPLATE_UPDATE_FAILED = "Failed to update email template";

    // System log errors
    public static final String SYSTEM_LOG_NOT_FOUND = "System log not found";
    public static final String INVALID_SYSTEM_LOG_ID = "Invalid system log ID";
    public static final String INVALID_SYSTEM_LOG_DATA = "Invalid system log data";
    public static final String SYSTEM_LOG_DELETION_FAILED = "Failed to delete system log";

    // Report errors
    public static final String REPORT_GENERATION_FAILED = "Failed to generate report";
    public static final String INVALID_REPORT_TYPE = "Invalid report type";
    public static final String INVALID_REPORT_PARAMETERS = "Invalid report parameters";

    // Export errors
    public static final String EXPORT_FAILED = "Export failed";
    public static final String INVALID_EXPORT_TYPE = "Invalid export type";
    public static final String INVALID_EXPORT_PARAMETERS = "Invalid export parameters";

    // Dashboard errors
    public static final String DASHBOARD_DATA_NOT_FOUND = "Dashboard data not found";
    public static final String INVALID_DASHBOARD_PARAMETERS = "Invalid dashboard parameters";

    // API key errors
    public static final String API_KEY_NOT_FOUND = "API key not found";
    public static final String API_KEY_ALREADY_EXISTS = "API key already exists";
    public static final String INVALID_API_KEY = "Invalid API key";
    public static final String API_KEY_EXPIRED = "API key has expired";
    public static final String API_KEY_REVOKED = "API key has been revoked";

    // API log errors
    public static final String API_LOG_NOT_FOUND = "API log not found";
    public static final String INVALID_API_LOG_ID = "Invalid API log ID";
    public static final String INVALID_API_LOG_DATA = "Invalid API log data";
    public static final String API_LOG_DELETION_FAILED = "Failed to delete API log";
} 