package ninja.eivind.usagetracker.transmission;

import ninja.eivind.usagetracker.ClientActivity;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ValidationException;

import java.net.URL;

import static org.junit.Assert.*;

public class HttpClientActivitySenderTest {

    private HttpClientActivitySender sender;
    private ClientActivity activity;

    @Before
    public void setUp() throws Exception {
        sender = new HttpClientActivitySender(new URL("http://localhost:9000"));
        activity = new ClientActivity();
    }

    @Test
    public void testSend() throws Exception {
        fail("No preconditions for mocking a http server.");
    }

    @Test(expected = ValidationException.class)
    public void testSendWithInvalidObjectThrowsException() throws Exception {
        sender.send(activity);
    }
}
