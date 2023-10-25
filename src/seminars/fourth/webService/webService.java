package seminars.fourth.webService;

public class webService {
    HTTPClient httpClient;

    public webService(HTTPClient httpClient) {
        this.httpClient = httpClient;
    }

    public void getHTTP(String url) {
        System.out.println(httpClient.getHTTPRequest(url));
    }
}
