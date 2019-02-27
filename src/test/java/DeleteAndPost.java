import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.client.methods.HttpOptions;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.charset.Charset;

public class DeleteAndPost extends BaseClass {

    CloseableHttpClient client;
    CloseableHttpResponse response;

    @BeforeMethod
    public void setUp() {
        client = HttpClientBuilder.create().build();
    }

    @AfterMethod
    public void closeResources() throws IOException {
        client.close();
        // response.close();
    }

    @Test(enabled = false)
    // Generate new token to authorise delete requests
    public void deleteIsSuccessful() throws IOException {

        HttpDelete request = new HttpDelete("https://api.github.com/repos/seb-faull/hi");

        request.setHeader(HttpHeaders.AUTHORIZATION, "token " + Credentials.TOKEN);
        response = client.execute(request);

        int actualStatusCode = response.getStatusLine().getStatusCode();

        assertEquals(actualStatusCode, 204);

    }

    @Test(enabled = false)
    public void createRepoReturns201() throws IOException {

        // Create a HttpPost with a valid Endpoint
        HttpPost request = new HttpPost("https://api.github.com/user/repos");

        // Set the Basic Auth Header
        request.setHeader(HttpHeaders.AUTHORIZATION, ResponseUtils.auth());

        // Define Json to Post and set the Entity
        String json = "{\"name\": \"hi\"}";

        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));

        // Send
        response = client.execute(request);

        int actualStatusCode = response.getStatusLine().getStatusCode();
        assertEquals(actualStatusCode, 201);
    }
}
