package api.utils;
import io.restassured.RestAssured;
public class BaseAPI {
    public static final String APP_ID =
            "63a804408eb0cb069b57e43a";

    public static final String BASE_URL =
            "https://dummyapi.io/data/v1";

    static {
        RestAssured.baseURI = BASE_URL;
    }
}
