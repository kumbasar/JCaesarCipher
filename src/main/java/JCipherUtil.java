
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Base64;


public class JCipherUtil {

   static public String encodeBase64(String plaintext) {
		return new String(Base64.getEncoder().encode(plaintext.getBytes()));
	}
	
   static public String decodeBase64(String base64text) {
		return new String(Base64.getDecoder().decode(base64text.getBytes()));
	}
	
   static public String binary2Text(String binary) {
	   //http://stackoverflow.com/questions/4211705/binary-to-text-in-java
	   StringBuilder sb = new StringBuilder(); // Some place to store the chars
	   Arrays.stream( // Create a Stream
	   binary.split("(?<=\\G.{8})") // Splits the input string into 8-char-sections (Since a char has 8 bits = 1 byte)
	   ).forEach(s -> // Go through each 8-char-section...
	       sb.append((char) Integer.parseInt(s, 2)) // ...and turn it into an int and then to a char
	   );
	  return sb.toString();
   }
   
   static public String text2Binary(String text) {
	   byte[] infoBin = null;
	    try {
			infoBin = text.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	   return Arrays.toString(infoBin); 
   }
}
