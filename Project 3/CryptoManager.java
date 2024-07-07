/*
 * Class: CMSC203 
 * Instructor:Professor Grinberg
 * Description: 
 * Due: 07/07/2024
 * Platform/compiler:
 * I pledge that I have completed the programming  assignment independently. 
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Mariyah Shahmalak
*/
package cryptography;

/**
 * This is a utility class that encrypts and decrypts a phrase using two
 * different approaches. The first approach is called the Caesar Cipher and is a
 * simple “substitution cipher” where characters in a message are replaced by a
 * substitute character. The second approach, due to Giovan Battista Bellaso,
 * uses a key word, where each character in the word specifies the offset for
 * the corresponding character in the message, with the key word wrapping around
 * as needed.
 * 
 * @version 7/16/2022
 */
public class CryptoManager {
	
	private static final char LOWER_RANGE = ' ';
	private static final char UPPER_RANGE = '_';
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_RANGE and UPPER_RANGE characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean isStringInBounds (String plainText) {
		for (char c : plainText.toCharArray()) {
			if (c < LOWER_RANGE || c > UPPER_RANGE) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher. The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String caesarEncryption(String plainText, int key) {
		if (!isStringInBounds(plainText)) {
			return "The selected string is not in bounds, Try again.";
		}
		
		StringBuilder encryptedText = new StringBuilder();
		for (char c : plainText.toCharArray()) {
			int newChar = c + key;
			while (newChar > UPPER_RANGE) {
				newChar -= RANGE;
			}
			encryptedText.append((char) newChar);
		}
		return encryptedText.toString();
	}
	
	/**
	 * Encrypts a string according to the Bellaso Cipher. Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String bellasoEncryption (String plainText, String bellasoStr) {
		if (!isStringInBounds(plainText)) {
			return "The selected string is not in bounds, Try again.";
		}
		
		StringBuilder encryptedText = new StringBuilder();
		for (int i = 0; i < plainText.length(); i++) {
			int key = bellasoStr.charAt(i % bellasoStr.length());
			int newChar = plainText.charAt(i) + key;
			while (newChar > UPPER_RANGE) {
				newChar -= RANGE;
			}
			encryptedText.append((char) newChar);
		}
		return encryptedText.toString();
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher. The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the caesarEncryption method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String caesarDecryption (String encryptedText, int key) {
		if (!isStringInBounds(encryptedText)) {
			return "The selected string is not in bounds, Try again.";
		}
		
		StringBuilder decryptedText = new StringBuilder();
		for (char c : encryptedText.toCharArray()) {
			int newChar = c - key;
			while (newChar < LOWER_RANGE) {
				newChar += RANGE;
			}
			decryptedText.append((char) newChar);
		}
		return decryptedText.toString();
	}
	
	/**
	 * Decrypts a string according to the Bellaso Cipher. Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText. This is the inverse of the bellasoEncryption method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String bellasoDecryption(String encryptedText, String bellasoStr) {
		if (!isStringInBounds(encryptedText)) {
			return "The selected string is not in bounds, Try again.";
		}
		
		StringBuilder decryptedText = new StringBuilder();
		for (int i = 0; i < encryptedText.length(); i++) {
			int key = bellasoStr.charAt(i % bellasoStr.length());
			int newChar = encryptedText.charAt(i) - key;
			while (newChar < LOWER_RANGE) {
				newChar += RANGE;
			}
			decryptedText.append((char) newChar);
		}
		return decryptedText.toString();
	}
}
