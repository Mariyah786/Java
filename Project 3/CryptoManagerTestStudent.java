package cryptography;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CryptoManagerTestStudent {

    @Test
    public void testIsStringInBounds() {
        assertTrue(CryptoManager.isStringInBounds("THIS IS A TEST STRING"));
        assertFalse(CryptoManager.isStringInBounds("this is a test string"));
    }

    @Test
    public void testCaesarEncryption() {
        assertEquals("KHOOR ZRUOG", CryptoManager.caesarEncryption("HELLO WORLD", 3));
    }

    @Test
    public void testCaesarDecryption() {
        assertEquals("HELLO WORLD", CryptoManager.caesarDecryption("KHOOR ZRUOG", 3));
    }

    @Test
    public void testBellasoEncryption() {
        assertEquals("RIJVS UYVJN", CryptoManager.bellasoEncryption("HELLO WORLD", "KEY"));
    }

    @Test
    public void testBellasoDecryption() {
        assertEquals("HELLO WORLD", CryptoManager.bellasoDecryption("RIJVS UYVJN", "KEY"));
    }
}
