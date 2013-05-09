
import java.io.*;
import java.util.Scanner;

/**
 * The <code>Console</code> class implements a simple data type class to read data input from the system console.
 *
 * For each fundamental datatype and for String objects there exists a corresponding read method. All read 
 * methods wait until the user types in the corresponding value. 
 * <p>
 * Example: <p> (i) For reading a long value you can write:<p>
 * 			<code>System.out.println("Please input a long number:");</code><br>
 * 			<code>long l = Console.readLong();</code>
 * <p><p>
 * 			(ii) To shorten the statements above there also exists a read method with a String argument. So the
 * 			following code is equivalent to the example above: <p>
 * 			<code>long l = Console.readLong("Please input a long number:");</code>
 * 
 * @author Prof. Volkhard Pfeiffer
 * @version 1.1
 * @see TestConsole, JOptionPane 
 * 
 *
 */
public class Console {
	private static Scanner scanner = new Scanner(System.in);
	
	/** Read a byte value from the system console with output. The method waits until user inputs the value. 
	 * 
	 * @param s the string to be printed out to the system console  
	 * @return the byte value read from the console
	 * @throws - currently not implemented correctly
	 */
	public static byte readByte(String s){
		System.out.println(s);
		return readByte();
	}
	/** Read the next integer value. The method waits until user inputs one or more values. 
	 *  For example, this code allows a user to input a number sequence from Console. 
	 *  <code>nextInt</code> reads the next integer number out of the sequence: 
	 *  
	 *  <blockquote><pre>
	 *  System.out.println("Please input an integer sequence:");
	 *  	while (true) {
	 * 		int n = Console.nextInt();
	 *		System.out.println(n);
	 *	}</pre></blockquote>
	 *  
	 * @return the next integer value from the console
	 * @throws - currently not implemented correctly
	 */
	public static int nextInt() {
		return scanner.nextInt();
		
	}
	/** Read a short value from the system console with output. The method waits until user inputs the value. 
	 * 
	 * @param s the string to be printed out to the system console  
	 * @return the short value read from the console
	 * @throws - currently not implemented correctly
	 */
	public static short readShort(String s){
		System.out.println(s);
		return readShort();
	}
	
	/** Read an int value from the system console with output. The method waits until user inputs the value. 
	 * 
	 * @param s the string to be printed out to the system console  
	 * @return the int value read from the console
	 * @throws - currently not implemented correctly
	 */
	public static int readInt(String s){
		System.out.println(s);
		return readInt();
	}
	
	/** Read a long value from the system console with output. The method waits until user inputs the value. 
	 * 
	 * @param s the string to be printed out to the system console  
	 * @return the long value read from the console
	 * @throws - currently not implemented correctly
	 */
	public static long readLong(String s){
		System.out.println(s);
		return readLong();
	}
	
	/** Read a char value from the system console with output. The method waits until user inputs the value. 
	 * 
	 * @param s the string to be printed out to the system console  
	 * @return the char value read from the console
	 * @throws - currently not implemented correctly
	 */
	public static char readChar(String s){
		System.out.println(s);
		return readChar();
	}
	
	/** Read a boolean value from the system console with output. The method waits until user inputs the value. 
	 * 
	 * @param s the string to be printed out to the system console  
	 * @return the boolean value read from the console
	 * @throws - currently not implemented correctly
	 */
	public static boolean readBoolean(String s){
		System.out.println(s);
		return readBoolean();
	}
	
	/** Read a float value from the system console with output. The method waits until user inputs the value. 
	 * 
	 * @param s the string to be printed out to the system console  
	 * @return the float value read from the console
	 * @throws - currently not implemented correctly
	 */
	public static float readFloat(String s){
		System.out.println(s);
		return readFloat();
	}
	
	/** Read a double value from the system console with output. The method waits until user inputs the value. 
	 * 
	 * @param s the string to be printed out to the system console  
	 * @return the double value read from the console
	 * @throws - currently not implemented correctly
	 */
	public static double readDouble(String s){
		System.out.println(s);
		return readDouble();
	}
	
	/** Read a string  from the system console with output. The method waits until user inputs the value. 
	 * 
	 * @param s the string to be printed out to the system console  
	 * @return the string  read from the console
	 * @throws - currently not implemented correctly
	 */
	public static String readString(String s){
		System.out.println(s);
		return readString();
	}
	
	/** Read a byte value from the system console. The method waits until user inputs the value. 
	 * 
	 * 
	 * @return the byte value read from the console
	 * @throws - currently not implemented correctly
	 */
	public static byte readByte(){ 
		try {
			BufferedReader din = new BufferedReader(new InputStreamReader(System.in));
			return Byte.parseByte(din.readLine());
		}
		catch (Exception e) {
			e.printStackTrace();		
			System.exit(1);
			return -1;
		}
	}
	
	/** Read a short value from the system console. The method waits until user inputs the value. 
	 * 
	 * @return the short value read from the console
	 * @throws - currently not implemented correctly
	 */
	public static short readShort(){ 
		try {
			BufferedReader din = new BufferedReader(new InputStreamReader(System.in));
			return Short.parseShort(din.readLine());
		}
		catch (Exception e) {
			e.printStackTrace();		
			System.exit(1);
			return -1;
		}
	}
	
	/** Read an int value from the system console. The method waits until user inputs the value. 
	 * 
	 * @return the int value read from the console
	 * @throws - currently not implemented correctly
	 */
	public static int readInt(){ 
		try {
			BufferedReader din = new BufferedReader(new InputStreamReader(System.in));
			return Integer.parseInt(din.readLine());
		}
		catch (Exception e) {
			e.printStackTrace();		
			System.exit(1);
			return -1;
		}
	}
	/** Read a long value from the system console. The method waits until user inputs the value. 
	 * 
	 * @return the long value read from the console
	 * @throws - currently not implemented correctly
	 */
	public static long readLong(){ 
		try {
			BufferedReader din = new BufferedReader(new InputStreamReader(System.in));
			return Long.parseLong(din.readLine());
		}
		catch (Exception e) {
			e.printStackTrace();		
			System.exit(1);
			return -1;
		}
	}
	
	/** Read a double value from the system console. The method waits until user inputs the value. 
	 * 
	 * @return the double value read from the console
	 * @throws - currently not implemented correctly
	 */
	public static double readDouble(){ 
		try {
			BufferedReader din = new BufferedReader(new InputStreamReader(System.in));
			return Double.parseDouble(din.readLine());
		}
		catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
			return -1;
		}
	}
	
	/** Read a float value from the system console. The method waits until user inputs the value. 
	 * 
	 * @return the float value read from the console
	 * @throws - currently not implemented correctly
	 */
	public static float readFloat(){ 
		try {
			BufferedReader din = new BufferedReader(new InputStreamReader(System.in));
			return Float.parseFloat(din.readLine());
		}
		catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
			return -1;
		}
	}
	
	/** Read a character from the system console. The method waits until user inputs the value. 
	 * 
	 * @return the character  read from the console
	 * @throws - currently not implemented correctly
	 */
	public static char readChar(){ 
		try {
			String s;
			BufferedReader din = new BufferedReader(new InputStreamReader(System.in));
			s = din.readLine();
			if (s.length() > 1) throw new Exception("Wrong string length");
			return s.charAt(0);
		}
		catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
			return '\r';
		}
	}
	
	/** Read a boolean value from the system console. The method waits until user inputs the value. 
	 * 
	 * @return the boolean value read from the console
	 * @throws - currently not implemented correctly
	 */
	public static boolean readBoolean(){ 
		try {
			BufferedReader din = new BufferedReader(new InputStreamReader(System.in));
			return Boolean.parseBoolean(din.readLine());
		}
		catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
			return false;
		}
	}
	/** Read a String from the system console. The method waits until user inputs the value. 
	 * 
	 * @return the String read from the console
	 * @throws - currently not implemented correctly
	 */
	public static String readString(){ 
		try {
			BufferedReader din = new BufferedReader(new InputStreamReader(System.in));
			return din.readLine();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
			return null;
		}
	}
	
	/**Read a hexadecimal number from the system console and converts the number to a decimal number. The method waits until user inputs the value. 
	 * 
	 * @param s the string to be printed out to the system console  
	 * @return the input number in decimal format
	 * @throws - currently not implemented correctly
	 */
	public static int readIntAsHex(String s){
		System.out.println(s);
		return readIntAsHex();
	}
	
	/** Read a hexadecimal number from the system console and converts the number to a decimal number. The method waits until user inputs the value. 
	 * 
	 * @return the input number in decimal format
	 * @throws - currently not implemented correctly
	 */
	public static int readIntAsHex(){ 
		return readIntWithBase(16);
	}
	
	
	/**Read a octal number from the system console and converts the number to a decimal number. The method waits until user inputs the value. 
	 * 
	 * @param s the string to be printed out to the system console  
	 * @return the input number in decimal format
	 * @throws - currently not implemented correctly
	 */
	public static int readIntAsOctal(String s){
		System.out.println(s);
		return readIntAsOctal();
	}
	/** Read an octal number from the system console and converts the number to a decimal number. The method waits until user inputs the value. 
	 * 
	 * 
	 * @return the input number in decimal format
	 * @throws - currently not implemented correctly
	 */
	public static int readIntAsOctal(){ 
		return readIntWithBase(8);
	}
	
	/** Read a binary number from the system console and converts the number to a decimal number. The method waits until user inputs the value. 
	 *  
	 * @param s the string to be printed out to the system console  
	 * @return the input number in decimal format
	 * @throws - currently not implemented correctly
	 */
	public static int readIntAsBinary(String s){ 
		System.out.println(s);
		return readIntWithBase(2);
	}
	
	/** Read a binary number from the system console and converts the number to a decimal number. The method waits until user inputs the value. 
	 * 
	 * @return the input number in decimal format
	 * @throws - currently not implemented correctly
	 */
	public static int readIntAsBinary(){ 
		return readIntWithBase(2);
	}
	
	private static int readIntWithBase(int i){ 
		try {
			BufferedReader din = new BufferedReader(new InputStreamReader(System.in));
			return Integer.parseInt(din.readLine(), i);
		}
		catch (Exception e) {
			e.printStackTrace();		
			System.exit(1);
			return -1;
		}
	}
	
}
