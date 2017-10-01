package de.jbamberger.offlineclient.source.jodel.model;

public class UserTypeRequest {
    public final String userType;
    public int age;
    public String gender;

    public UserTypeRequest(UserType userType) {
        this.userType = userType.backendValue;
    }

    public UserTypeRequest(String str) {
        this.userType = str;
    }
}
