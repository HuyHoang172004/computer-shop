package com.techecommerce.constant;

public class SecurityConstants {
    // JWT Constants
    public static final String JWT_SECRET = "your-secret-key";
    public static final long JWT_EXPIRATION = 86400000; // 24 hours
    public static final long JWT_REFRESH_EXPIRATION = 604800000; // 7 days
    public static final String JWT_HEADER = "Authorization";
    public static final String JWT_PREFIX = "Bearer ";
    public static final String JWT_CLAIM_USER_ID = "userId";
    public static final String JWT_CLAIM_USERNAME = "username";
    public static final String JWT_CLAIM_EMAIL = "email";
    public static final String JWT_CLAIM_ROLES = "roles";
    public static final String JWT_CLAIM_PERMISSIONS = "permissions";

    // Security Headers
    public static final String HEADER_X_FORWARDED_FOR = "X-Forwarded-For";
    public static final String HEADER_X_REAL_IP = "X-Real-IP";
    public static final String HEADER_USER_AGENT = "User-Agent";
    public static final String HEADER_X_API_KEY = "X-API-Key";
    public static final String HEADER_X_REQUEST_ID = "X-Request-ID";

    // Security Roles
    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_USER = "ROLE_USER";
    public static final String ROLE_GUEST = "ROLE_GUEST";
    public static final String ROLE_MANAGER = "ROLE_MANAGER";
    public static final String ROLE_STAFF = "ROLE_STAFF";

    // Security Permissions
    public static final String PERMISSION_READ = "READ";
    public static final String PERMISSION_WRITE = "WRITE";
    public static final String PERMISSION_DELETE = "DELETE";
    public static final String PERMISSION_ADMIN = "ADMIN";

    // Security Patterns
    public static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
    public static final String USERNAME_PATTERN = "^[a-zA-Z0-9_]{3,20}$";
    public static final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@(.+)$";
    public static final String PHONE_PATTERN = "^\\d{10,15}$";

    // Security Messages
    public static final String MSG_INVALID_TOKEN = "Invalid token";
    public static final String MSG_EXPIRED_TOKEN = "Token has expired";
    public static final String MSG_INVALID_CREDENTIALS = "Invalid username or password";
    public static final String MSG_ACCOUNT_LOCKED = "Account is locked";
    public static final String MSG_ACCOUNT_DISABLED = "Account is disabled";
    public static final String MSG_ACCOUNT_EXPIRED = "Account has expired";
    public static final String MSG_CREDENTIALS_EXPIRED = "Credentials have expired";
    public static final String MSG_ACCESS_DENIED = "Access denied";
    public static final String MSG_UNAUTHORIZED = "Unauthorized";
    public static final String MSG_FORBIDDEN = "Forbidden";
    public static final String MSG_INVALID_API_KEY = "Invalid API key";
    public static final String MSG_EXPIRED_API_KEY = "API key has expired";
    public static final String MSG_REVOKED_API_KEY = "API key has been revoked";

    // Security Config
    public static final int MAX_LOGIN_ATTEMPTS = 5;
    public static final int LOCK_TIME_DURATION = 30; // minutes
    public static final int PASSWORD_EXPIRY_DAYS = 90;
    public static final int SESSION_TIMEOUT_MINUTES = 30;
    public static final boolean REQUIRE_HTTPS = true;
    public static final boolean ENABLE_CSRF = true;
    public static final boolean ENABLE_XSS_FILTER = true;
    public static final boolean ENABLE_CONTENT_SECURITY_POLICY = true;
    public static final boolean ENABLE_FRAME_OPTIONS = true;
    public static final boolean ENABLE_HSTS = true;

    // Security Headers Values
    public static final String CONTENT_SECURITY_POLICY = "default-src 'self'; script-src 'self' 'unsafe-inline' 'unsafe-eval'; style-src 'self' 'unsafe-inline'; img-src 'self' data:; font-src 'self' data:; connect-src 'self'";
    public static final String X_FRAME_OPTIONS = "DENY";
    public static final String X_CONTENT_TYPE_OPTIONS = "nosniff";
    public static final String X_XSS_PROTECTION = "1; mode=block";
    public static final String STRICT_TRANSPORT_SECURITY = "max-age=31536000; includeSubDomains";

    // Security File Upload
    public static final long MAX_FILE_SIZE = 10485760; // 10MB
    public static final String[] ALLOWED_FILE_TYPES = {".jpg", ".jpeg", ".png", ".gif", ".pdf", ".doc", ".docx", ".xls", ".xlsx"};
    public static final String UPLOAD_DIRECTORY = "uploads";
    public static final boolean SCAN_FILES_FOR_VIRUSES = true;
    public static final boolean VALIDATE_FILE_CONTENT = true;

    // Security Rate Limiting
    public static final int RATE_LIMIT_REQUESTS = 100;
    public static final int RATE_LIMIT_DURATION = 60; // seconds
    public static final int RATE_LIMIT_BURST = 200;
    public static final boolean ENABLE_RATE_LIMITING = true;

    // Security Logging
    public static final boolean LOG_SECURITY_EVENTS = true;
    public static final boolean LOG_AUTHENTICATION_ATTEMPTS = true;
    public static final boolean LOG_ACCESS_DENIED = true;
    public static final boolean LOG_INVALID_TOKENS = true;
    public static final boolean LOG_API_CALLS = true;

    // Security CORS
    public static final String[] ALLOWED_ORIGINS = {"http://localhost:3000", "https://yourdomain.com"};
    public static final String[] ALLOWED_METHODS = {"GET", "POST", "PUT", "DELETE", "OPTIONS"};
    public static final String[] ALLOWED_HEADERS = {"Authorization", "Content-Type", "X-Requested-With", "X-API-Key"};
    public static final boolean ALLOW_CREDENTIALS = true;
    public static final int MAX_AGE = 3600; // seconds

    // Security OAuth2
    public static final String OAUTH2_CLIENT_ID = "your-client-id";
    public static final String OAUTH2_CLIENT_SECRET = "your-client-secret";
    public static final String OAUTH2_REDIRECT_URI = "http://localhost:3000/oauth2/callback";
    public static final String OAUTH2_AUTHORIZATION_URI = "https://oauth2.provider.com/authorize";
    public static final String OAUTH2_TOKEN_URI = "https://oauth2.provider.com/token";
    public static final String OAUTH2_USER_INFO_URI = "https://oauth2.provider.com/userinfo";
    public static final String[] OAUTH2_SCOPES = {"read", "write", "profile", "email"};

    // Security 2FA
    public static final boolean ENABLE_2FA = true;
    public static final String TOTP_ISSUER = "YourApp";
    public static final int TOTP_DIGITS = 6;
    public static final int TOTP_PERIOD = 30; // seconds
    public static final int BACKUP_CODES_COUNT = 10;
    public static final int BACKUP_CODE_LENGTH = 8;

    // Security Password Reset
    public static final int PASSWORD_RESET_TOKEN_EXPIRY = 30; // minutes
    public static final int PASSWORD_RESET_MAX_ATTEMPTS = 3;
    public static final boolean REQUIRE_PASSWORD_HISTORY = true;
    public static final int PASSWORD_HISTORY_SIZE = 5;

    // Security Session
    public static final String SESSION_COOKIE_NAME = "JSESSIONID";
    public static final boolean SESSION_COOKIE_SECURE = true;
    public static final boolean SESSION_COOKIE_HTTP_ONLY = true;
    public static final String SESSION_COOKIE_SAME_SITE = "Strict";
    public static final int SESSION_COOKIE_MAX_AGE = 1800; // seconds
} 