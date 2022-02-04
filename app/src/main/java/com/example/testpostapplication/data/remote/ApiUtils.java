package com.example.testpostapplication.data.remote;

public class ApiUtils {
    private ApiUtils() {}
    public static final String BASE_URL = "https://api.funtranslations.com/translate/";
    public static APIService getAPIService() {
        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}