package de.jbamberger.offlinefetcher.source.jodel.model;

public class UserTypeRequest {
    public int age;
    public String gender;
    public final String userType;

    public UserTypeRequest(UserType userType) {
        this.userType = userType.backendValue;
    }

    public UserTypeRequest(String str) {
        this.userType = str;
    }
}
