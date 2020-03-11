package com.example.first.startactivityforresult;

public class DataManager {

    static Profile myProfile;

    public static Profile getMyProfile() {
        return myProfile;
    }

    public static void setMyProfile(Profile myProfile) {
        DataManager.myProfile = myProfile;
    }
}
