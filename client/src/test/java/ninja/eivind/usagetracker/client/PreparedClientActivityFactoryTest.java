package ninja.eivind.usagetracker.client;

import ninja.eivind.usagetracker.ClientActivity;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class PreparedClientActivityFactoryTest {

    public static final String APP_ID = "test-app";
    private ClientActivityFactory factory;
    private Validator validator;

    @Before
    public void setUp() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
        UUID clientId = UUID.randomUUID();
        factory = new PreparedClientActivityFactory(clientId, APP_ID);
    }

    @Test
    public void testCreateActivity() throws Exception {
        ClientActivity activity = factory.createActivity();

        Set<ConstraintViolation<ClientActivity>> expected = new HashSet<>();
        Set<ConstraintViolation<ClientActivity>> actual = validator.validate(activity);

        assertEquals("Validating the object provided by the factory gives an empty set.", expected, actual);
    }
}
