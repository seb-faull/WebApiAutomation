import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.User;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

public class ResponseUtils {

    public static String getHeader(CloseableHttpResponse response, String headerName) {

        // Get All headers
        Header[] headers = response.getAllHeaders();
        List<Header> httpHeaders = Arrays.asList(headers);
        String returnHeader = "";

        // Loop over the headers list
        for (Header header : httpHeaders) {
            if (headerName.equalsIgnoreCase(header.getName())) {
                returnHeader = header.getValue();
            }
        }

        // If no header found - throw an exception
        if (returnHeader.isEmpty()) {
            throw new RuntimeException("Didn't find the Header: " + headerName);
        }

        // Return the header
        return returnHeader;
    }

    public static String getHeaderJava8Way(CloseableHttpResponse response, String headerName) {

        List<Header> httpHeaders = Arrays.asList(response.getAllHeaders());

        // Take a list of headers and stream them, flowing one-by-one.
        // Filter for a given header.
        // Then invoke findFirst, which finds and returns the first header that matches the criteria
        // Or throw an exception
        Header matchedHeader = httpHeaders.stream()
                                .filter(header -> headerName.equalsIgnoreCase(header.getName()))
                                .findFirst().orElseThrow(() -> new RuntimeException("Didn't find the header"));

        return matchedHeader.getValue();

    }

    public static boolean headerIsPresent(CloseableHttpResponse response, String headerName) {

        List<Header> httpHeaders = Arrays.asList(response.getAllHeaders());

        return httpHeaders.stream()
                .anyMatch(header -> header.getName().equalsIgnoreCase(headerName));

    }

    public static User unmarshall(CloseableHttpResponse response, Class<User> userClass) throws IOException {

        String jsonBody = EntityUtils.toString(response.getEntity());

        return new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .readValue(jsonBody, userClass);

    }

    // T = Type
    public static <T> T unmarshallGeneric(CloseableHttpResponse response, Class<T> clazz) throws IOException {

        String jsonBody = EntityUtils.toString(response.getEntity());

        return new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .readValue(jsonBody, clazz);

    }

    public static String auth() {
        String auth = Credentials.EMAIL + ":" + Credentials.PASSWORD;
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("ISO-8859-1")));
        String authHeader = "Basic " + new String(encodedAuth);

        return authHeader;
    }

}
