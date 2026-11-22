package com.campushire.logging;

public final class LogMask {

    private LogMask() {
    }

    public static String email(String email) {
        if (email == null) {
            return "null";
        }
        int at = email.indexOf('@');
        if (at <= 1) {
            return "***";                                
        }
        return email.charAt(0) + "***" + email.substring(at);  
    }
}