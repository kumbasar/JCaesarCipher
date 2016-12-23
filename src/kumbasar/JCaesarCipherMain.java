package kumbasar;

import java.util.HashMap;


public class JCaesarCipherMain {
	
	final private char[] ALPHABET = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	
	private String codedStr = "";
	private HashMap<Character, Integer> hmap;
	
	public JCaesarCipherMain() {
		initial();
	}
	
	public JCaesarCipherMain(String codedStr) {
		initial();
		setCaesar(codedStr);
	}
	
	private void initial() {
		this.hmap = new HashMap<Character, Integer>();
		for(int i = 0; i <  ALPHABET.length ; ++i) {
			this.hmap.put(ALPHABET[i], i);
		}
	}
	
	public void setCaesar(String codedStr) {
		//Trim coded string and convert to upper case
		this.codedStr = codedStr.trim().toUpperCase();
		System.out.println("String: <<" + this.codedStr +">>");
	}
	
	public String getCaesar() {
		return this.codedStr;
	}
	
	public String decodeCaesar(int key) {
		String decodedStr = "";
		for (int i = 0; i < codedStr.length(); ++i) {
			if(hmap.get(codedStr.charAt(i)) == null ){
				decodedStr = decodedStr + codedStr.charAt(i);
			}
			else {
				decodedStr = decodedStr + ALPHABET[(hmap.get(codedStr.charAt(i)) + key)%ALPHABET.length];
			}
		}
		return decodedStr;
	}
	
	public String decodeCaesar(String codedStr, int key) {
		setCaesar(codedStr);
		return decodeCaesar(key);
	}
	
	public void bruteForce(){
		for (int i = 1; i <= ALPHABET.length; ++i ) {
			System.out.println( i + " key => " + decodeCaesar(i));	
		}
	}

	public static void main(String[] args) {
		JCaesarCipherMain main = new JCaesarCipherMain();
		main.setCaesar("THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG");
		System.out.println("Decoded String: " + JCipherUtil.decodeBase64("VEhFIFFVSUNLIEJST1dOIEZPWCBKVU1QUyBPVkVSIFRIRSBMQVpZIERPRw=="));
		main.bruteForce();
	}
}
