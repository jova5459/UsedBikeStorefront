import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class StoreTest {

    private Store store;
    private final InputStream systemIn = System.in;

    @BeforeEach
    public void setUp() {
        store = new Store();
    }

    @Test
    public void testSignUp_ValidEmail() {
        String input = "Jon\njon@example.com\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        store.signUp();
        // Verify that the customer list contains the expected user after sign-up
        Assertions.assertTrue(store.getCustomers().stream().anyMatch(c -> c.getEmail().equals("jon@example.com")));
    }

    @Test
    public void testReturnProcess() {
        // Test the return functionality
        // ByteArrayInputStream simulates user input for returning a purchased bike
        String input = "1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Perform the return process
        store.returnPurchase();
    }

    @Test
    public void testBlockchain_AddBlock() {
        Block transaction = new Block(1, "prevHash", null, null, 100.00);
        store.getBlockchain().addBlock(transaction);
        assertEquals(transaction, store.getBlockchain().getLatestBlock()); // Ensure block addition
    }
}
