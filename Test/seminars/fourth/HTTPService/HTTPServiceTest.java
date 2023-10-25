package seminars.fourth.HTTPService;

import org.junit.jupiter.api.Test;
import seminars.fourth.webService.HTTPClient;
import seminars.fourth.webService.webService;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class HTTPServiceTest {

    @Test
    void httpRequestTest() {
        HTTPClient httpClient = mock(HTTPClient.class);
        webService webService = new webService(httpClient);
        when(httpClient.getHTTPRequest(anyString())).thenReturn("Site");
        String url = "map.com";

        webService.getHTTP(url);

        verify(httpClient, times(1)).getHTTPRequest(anyString());
    }
}