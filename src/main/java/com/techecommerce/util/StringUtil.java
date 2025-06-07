package com.techecommerce.util;

import java.util.UUID;
import java.util.regex.Pattern;

public class StringUtil {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    private static final Pattern PHONE_PATTERN = Pattern.compile("^[0-9]{10,15}$");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
    private static final Pattern URL_PATTERN = Pattern.compile("^(https?|ftp)://[^\\s/$.?#].[^\\s]*$");

    public static boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static String defaultIfEmpty(String str, String defaultValue) {
        return isEmpty(str) ? defaultValue : str;
    }

    public static String truncate(String str, int maxLength) {
        if (isEmpty(str)) {
            return str;
        }
        return str.length() <= maxLength ? str : str.substring(0, maxLength);
    }

    public static String toSlug(String str) {
        if (isEmpty(str)) {
            return "";
        }
        return str.toLowerCase()
                .replaceAll("[^a-z0-9\\s-]", "")
                .replaceAll("\\s+", "-");
    }

    public static String defaultIfNull(String str, String defaultValue) {
        return str == null ? defaultValue : str;
    }

    public static String trimToNull(String str) {
        if (str == null) return null;
        String trimmed = str.trim();
        return trimmed.isEmpty() ? null : trimmed;
    }

    public static String trimToEmpty(String str) {
        return str == null ? "" : str.trim();
    }

    public static boolean equalsIgnoreCase(String str1, String str2) {
        if (str1 == str2) return true;
        if (str1 == null || str2 == null) return false;
        return str1.equalsIgnoreCase(str2);
    }

    public static boolean containsIgnoreCase(String str, String searchStr) {
        if (str == null || searchStr == null) return false;
        return str.toLowerCase().contains(searchStr.toLowerCase());
    }

    public static String generateUUID() {
        return UUID.randomUUID().toString();
    }

    public static String generateShortUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 8);
    }

    public static boolean isValidEmail(String email) {
        if (isEmpty(email)) return false;
        return EMAIL_PATTERN.matcher(email).matches();
    }

    public static boolean isValidPhone(String phone) {
        if (isEmpty(phone)) return false;
        return PHONE_PATTERN.matcher(phone).matches();
    }

    public static boolean isValidPassword(String password) {
        if (isEmpty(password)) return false;
        return PASSWORD_PATTERN.matcher(password).matches();
    }

    public static boolean isValidUrl(String url) {
        if (isEmpty(url)) return false;
        return URL_PATTERN.matcher(url).matches();
    }

    public static String maskEmail(String email) {
        if (isEmpty(email)) return email;
        int atIndex = email.indexOf('@');
        if (atIndex <= 1) return email;
        return email.charAt(0) + "***" + email.substring(atIndex);
    }

    public static String maskPhone(String phone) {
        if (isEmpty(phone)) return phone;
        if (phone.length() <= 4) return phone;
        return "***" + phone.substring(phone.length() - 4);
    }

    public static String maskCardNumber(String cardNumber) {
        if (isEmpty(cardNumber)) return cardNumber;
        if (cardNumber.length() <= 4) return cardNumber;
        return "****" + cardNumber.substring(cardNumber.length() - 4);
    }

    public static String toCamelCase(String str) {
        if (isEmpty(str)) return str;
        StringBuilder result = new StringBuilder();
        boolean capitalizeNext = false;
        for (char c : str.toCharArray()) {
            if (c == '_' || c == ' ') {
                capitalizeNext = true;
            } else {
                if (capitalizeNext) {
                    result.append(Character.toUpperCase(c));
                    capitalizeNext = false;
                } else {
                    result.append(Character.toLowerCase(c));
                }
            }
        }
        return result.toString();
    }

    public static String toSnakeCase(String str) {
        if (isEmpty(str)) return str;
        return str.replaceAll("([a-z])([A-Z])", "$1_$2").toLowerCase();
    }

    public static String toTitleCase(String str) {
        if (isEmpty(str)) return str;
        StringBuilder result = new StringBuilder();
        boolean capitalizeNext = true;
        for (char c : str.toCharArray()) {
            if (c == '_' || c == ' ') {
                result.append(' ');
                capitalizeNext = true;
            } else {
                if (capitalizeNext) {
                    result.append(Character.toUpperCase(c));
                    capitalizeNext = false;
                } else {
                    result.append(Character.toLowerCase(c));
                }
            }
        }
        return result.toString();
    }
} 