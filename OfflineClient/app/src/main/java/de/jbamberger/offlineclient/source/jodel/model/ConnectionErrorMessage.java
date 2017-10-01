package de.jbamberger.offlineclient.source.jodel.model;

public class ConnectionErrorMessage {
    private final ErrorType errorType;
    public String serverMessage;

    public enum ErrorType {
        CONNECTION_UNAVAILABLE("no_internet"),
        INTERNAL_SERVER_ERROR("internal_server_error"),
        USER_UNAUTHORISED("user_unauthorised"),
        NOT_FOUND("not_found"),
        ACCOUNT_NOT_VERIFIED("account_unverified"),
        REQUEST_RATE_EXCEEDED("request_rate_limit"),
        INVALID_HMAC("invalid_hmac"),
        CLIENT_SIDE_ERROR("client_exception");
        
        public final String key;

        private ErrorType(String str) {
            this.key = str;
        }
    }

    public ConnectionErrorMessage(String str, ErrorType errorType) {
        this.serverMessage = str;
        this.errorType = errorType;
    }

    public ConnectionErrorMessage(ErrorType errorType) {
        this.errorType = errorType;
    }

    public ErrorType getErrorType() {
        return this.errorType;
    }
}
