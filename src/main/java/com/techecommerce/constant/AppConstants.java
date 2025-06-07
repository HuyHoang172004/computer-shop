package com.techecommerce.constant;

public class AppConstants {
    // Common Constants
    public static final String DEFAULT_LANGUAGE = "en";
    public static final String DEFAULT_TIMEZONE = "UTC";
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
    public static final String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DEFAULT_TIME_FORMAT = "HH:mm:ss";
    public static final String DEFAULT_CURRENCY = "USD";
    public static final String DEFAULT_COUNTRY = "US";
    public static final String DEFAULT_LOCALE = "en_US";
    public static final String DEFAULT_ENCODING = "UTF-8";
    public static final String DEFAULT_CONTENT_TYPE = "application/json";
    public static final String DEFAULT_CHARSET = "UTF-8";
    public static final String DEFAULT_MEDIA_TYPE = "application/json;charset=UTF-8";
    public static final String DEFAULT_ACCEPT = "application/json";
    public static final String DEFAULT_USER_AGENT = "Mozilla/5.0";
    public static final String DEFAULT_IP = "127.0.0.1";
    public static final String DEFAULT_HOST = "localhost";
    public static final int DEFAULT_PORT = 8080;
    public static final String DEFAULT_PROTOCOL = "http";
    public static final String DEFAULT_CONTEXT_PATH = "";
    public static final String DEFAULT_SERVLET_PATH = "";
    public static final String DEFAULT_PATH_INFO = null;
    public static final String DEFAULT_QUERY_STRING = null;
    public static final String DEFAULT_METHOD = "GET";
    public static final String DEFAULT_SCHEME = "http";
    public static final String DEFAULT_SERVER_NAME = "localhost";
    public static final int DEFAULT_SERVER_PORT = 8080;
    public static final String DEFAULT_REMOTE_ADDR = "127.0.0.1";
    public static final String DEFAULT_REMOTE_HOST = "localhost";
    public static final int DEFAULT_REMOTE_PORT = 0;
    public static final String DEFAULT_LOCAL_ADDR = "127.0.0.1";
    public static final String DEFAULT_LOCAL_NAME = "localhost";
    public static final int DEFAULT_LOCAL_PORT = 8080;

    // Pagination Constants
    public static final String DEFAULT_PAGE_NUMBER = "0";
    public static final String DEFAULT_PAGE_SIZE = "10";
    public static final String DEFAULT_SORT_BY = "id";
    public static final String DEFAULT_SORT_DIRECTION = "asc";
    public static final int MAX_PAGE_SIZE = 100;
    public static final int MIN_PAGE_SIZE = 1;
    public static final int DEFAULT_PAGE_NUMBER_INT = 0;
    public static final int DEFAULT_PAGE_SIZE_INT = 10;
    public static final String PAGE_NUMBER_PARAM = "page";
    public static final String PAGE_SIZE_PARAM = "size";
    public static final String SORT_BY_PARAM = "sortBy";
    public static final String SORT_DIRECTION_PARAM = "sortDirection";
    public static final String TOTAL_ELEMENTS_HEADER = "X-Total-Elements";
    public static final String TOTAL_PAGES_HEADER = "X-Total-Pages";
    public static final String CURRENT_PAGE_HEADER = "X-Current-Page";
    public static final String PAGE_SIZE_HEADER = "X-Page-Size";
    public static final String HAS_NEXT_PAGE_HEADER = "X-Has-Next-Page";
    public static final String HAS_PREVIOUS_PAGE_HEADER = "X-Has-Previous-Page";
    public static final String IS_FIRST_PAGE_HEADER = "X-Is-First-Page";
    public static final String IS_LAST_PAGE_HEADER = "X-Is-Last-Page";

    // Sorting Constants
    public static final String SORT_DIRECTION_ASC = "asc";
    public static final String SORT_DIRECTION_DESC = "desc";
    public static final String[] ALLOWED_SORT_DIRECTIONS = {SORT_DIRECTION_ASC, SORT_DIRECTION_DESC};
    public static final String[] ALLOWED_SORT_FIELDS = {"id", "name", "createdAt", "updatedAt"};
    public static final String SORT_SEPARATOR = ",";
    public static final String SORT_FIELD_SEPARATOR = ":";
    public static final String SORT_DIRECTION_SEPARATOR = " ";
    public static final String SORT_PREFIX = "sort=";
    public static final String SORT_SUFFIX = "";
    public static final String SORT_PATTERN = "^[a-zA-Z0-9_]+:(asc|desc)$";
    public static final String SORT_PATTERN_MULTIPLE = "^[a-zA-Z0-9_]+:(asc|desc)(,[a-zA-Z0-9_]+:(asc|desc))*$";

    // Search Constants
    public static final String SEARCH_QUERY_PARAM = "q";
    public static final String SEARCH_FIELDS_PARAM = "fields";
    public static final String SEARCH_OPERATOR_PARAM = "operator";
    public static final String SEARCH_FUZZY_PARAM = "fuzzy";
    public static final String SEARCH_PHRASE_PARAM = "phrase";
    public static final String SEARCH_WILDCARD_PARAM = "wildcard";
    public static final String SEARCH_REGEX_PARAM = "regex";
    public static final String SEARCH_MIN_SHOULD_MATCH_PARAM = "minShouldMatch";
    public static final String SEARCH_BOOST_PARAM = "boost";
    public static final String SEARCH_FIELD_SEPARATOR = ",";
    public static final String SEARCH_OPERATOR_AND = "AND";
    public static final String SEARCH_OPERATOR_OR = "OR";
    public static final String[] ALLOWED_SEARCH_OPERATORS = {SEARCH_OPERATOR_AND, SEARCH_OPERATOR_OR};
    public static final boolean DEFAULT_SEARCH_FUZZY = false;
    public static final boolean DEFAULT_SEARCH_PHRASE = false;
    public static final boolean DEFAULT_SEARCH_WILDCARD = false;
    public static final boolean DEFAULT_SEARCH_REGEX = false;
    public static final int DEFAULT_SEARCH_MIN_SHOULD_MATCH = 1;
    public static final float DEFAULT_SEARCH_BOOST = 1.0f;
    public static final int DEFAULT_SEARCH_FUZZY_PREFIX_LENGTH = 0;
    public static final int DEFAULT_SEARCH_FUZZY_MIN_SIMILARITY = 0;
    public static final int DEFAULT_SEARCH_FUZZY_MAX_EXPANSIONS = 50;
    public static final int DEFAULT_SEARCH_PHRASE_SLOP = 0;
    public static final int DEFAULT_SEARCH_WILDCARD_MIN_LENGTH = 0;
    public static final int DEFAULT_SEARCH_REGEX_FLAGS = 0;
    public static final String DEFAULT_SEARCH_REGEX_PATTERN = "";
    public static final String DEFAULT_SEARCH_WILDCARD_PATTERN = "";
    public static final String DEFAULT_SEARCH_PHRASE_PATTERN = "";
    public static final String DEFAULT_SEARCH_FUZZY_PATTERN = "";
    public static final String DEFAULT_SEARCH_PATTERN = "";
    public static final String DEFAULT_SEARCH_FIELDS = "";
    public static final String DEFAULT_SEARCH_OPERATOR = SEARCH_OPERATOR_OR;
    public static final String DEFAULT_SEARCH_QUERY = "";

    // File Constants
    public static final String FILE_STORAGE_PATH = "uploads/";
    public static final String FILE_TEMP_PATH = "temp/";
    public static final String FILE_IMAGE_PATH = "images/";
    public static final String FILE_DOCUMENT_PATH = "documents/";
    public static final String FILE_MAX_SIZE = "10485760"; // 10MB
    public static final String[] FILE_ALLOWED_TYPES = {"jpg", "jpeg", "png", "gif", "pdf", "doc", "docx", "xls", "xlsx"};

    // Email Constants
    public static final String EMAIL_FROM = "no-reply@techecommerce.com";
    public static final String EMAIL_SUPPORT = "support@techecommerce.com";
    public static final String EMAIL_SUBJECT_VERIFICATION = "Verify your email address";
    public static final String EMAIL_SUBJECT_PASSWORD_RESET = "Reset your password";
    public static final String EMAIL_SUBJECT_ORDER_CONFIRMATION = "Order Confirmation";
    public static final String EMAIL_SUBJECT_ORDER_STATUS = "Order Status Update";
    public static final String EMAIL_SUBJECT_IMPORT_NOTIFICATION = "Import Notification";
    public static final String EMAIL_SUBJECT_EXPORT_NOTIFICATION = "Export Notification";

    // Notification Constants
    public static final String NOTIFICATION_TYPE_EMAIL = "EMAIL";
    public static final String NOTIFICATION_TYPE_SMS = "SMS";
    public static final String NOTIFICATION_TYPE_PUSH = "PUSH";
    public static final String NOTIFICATION_TYPE_SYSTEM = "SYSTEM";
    public static final String NOTIFICATION_STATUS_SENT = "SENT";
    public static final String NOTIFICATION_STATUS_FAILED = "FAILED";
    public static final String NOTIFICATION_STATUS_PENDING = "PENDING";

    // System Constants
    public static final String SYSTEM_NAME = "TechEcommerce";
    public static final String SYSTEM_VERSION = "1.0.0";
    public static final String SYSTEM_ENV = "production";
    public static final String SYSTEM_ADMIN_EMAIL = "admin@techecommerce.com";
    public static final String SYSTEM_SUPPORT_EMAIL = "support@techecommerce.com";
    public static final String SYSTEM_TIMEZONE = "Asia/Ho_Chi_Minh";

    // Payment Constants
    public static final String PAYMENT_METHOD_CASH = "CASH";
    public static final String PAYMENT_METHOD_CREDIT_CARD = "CREDIT_CARD";
    public static final String PAYMENT_METHOD_BANK_TRANSFER = "BANK_TRANSFER";
    public static final String PAYMENT_STATUS_PENDING = "PENDING";
    public static final String PAYMENT_STATUS_COMPLETED = "COMPLETED";
    public static final String PAYMENT_STATUS_FAILED = "FAILED";
    public static final String PAYMENT_STATUS_REFUNDED = "REFUNDED";

    // Shipping Constants
    public static final String SHIPPING_METHOD_STANDARD = "STANDARD";
    public static final String SHIPPING_METHOD_EXPRESS = "EXPRESS";
    public static final String SHIPPING_METHOD_PICKUP = "PICKUP";
    public static final String SHIPPING_STATUS_PENDING = "PENDING";
    public static final String SHIPPING_STATUS_PROCESSING = "PROCESSING";
    public static final String SHIPPING_STATUS_SHIPPED = "SHIPPED";
    public static final String SHIPPING_STATUS_DELIVERED = "DELIVERED";
    public static final String SHIPPING_STATUS_RETURNED = "RETURNED";

    // Import Constants
    public static final String IMPORT_STATUS_PENDING = "PENDING";
    public static final String IMPORT_STATUS_PROCESSING = "PROCESSING";
    public static final String IMPORT_STATUS_COMPLETED = "COMPLETED";
    public static final String IMPORT_STATUS_FAILED = "FAILED";

    // Export Constants
    public static final String EXPORT_TYPE_ORDERS = "ORDERS";
    public static final String EXPORT_TYPE_PRODUCTS = "PRODUCTS";
    public static final String EXPORT_TYPE_REVENUE = "REVENUE";
    public static final String EXPORT_FORMAT_PDF = "PDF";
    public static final String EXPORT_FORMAT_EXCEL = "EXCEL";
    public static final String EXPORT_FORMAT_CSV = "CSV";

    // Dashboard Constants
    public static final String DASHBOARD_TYPE_OVERVIEW = "OVERVIEW";
    public static final String DASHBOARD_TYPE_ORDERS = "ORDERS";
    public static final String DASHBOARD_TYPE_PRODUCTS = "PRODUCTS";
    public static final String DASHBOARD_TYPE_REVENUE = "REVENUE";

    // API Constants
    public static final String API_VERSION = "v1";
    public static final String API_KEY_HEADER = "X-API-Key";
    public static final String API_LOG_REQUEST = "API_LOG_REQUEST";
    public static final String API_LOG_RESPONSE = "API_LOG_RESPONSE";

    // OAuth2 Constants
    public static final String OAUTH2_PROVIDER_GOOGLE = "GOOGLE";
    public static final String OAUTH2_PROVIDER_FACEBOOK = "FACEBOOK";
    public static final String OAUTH2_PROVIDER_GITHUB = "GITHUB";

    // 2FA Constants
    public static final String TWO_FA_TYPE_TOTP = "TOTP";
    public static final String TWO_FA_TYPE_SMS = "SMS";
    public static final String TWO_FA_TYPE_EMAIL = "EMAIL";

    // Session Constants
    public static final String SESSION_USER = "SESSION_USER";
    public static final String SESSION_CART = "SESSION_CART";
    public static final String SESSION_WISHLIST = "SESSION_WISHLIST";

    // Rate Limiting Constants
    public static final int RATE_LIMIT_MAX_REQUESTS = 100;
    public static final int RATE_LIMIT_TIME_WINDOW = 60; // seconds

    // Logging Constants
    public static final String LOG_LEVEL_INFO = "INFO";
    public static final String LOG_LEVEL_WARNING = "WARNING";
    public static final String LOG_LEVEL_ERROR = "ERROR";
    public static final String LOG_LEVEL_DEBUG = "DEBUG";
} 