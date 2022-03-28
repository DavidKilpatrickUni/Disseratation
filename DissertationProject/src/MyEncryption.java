
/**
 * <h1> Class </h1>
 * 
 * <p>
 * Utility Layer of the Tiered architecture structure.
 * </p>
 * 
 * <p>
 * MyEncryption
 * </p>
 * 
 * <p>
 * Class design to hold encryption KEY for mySQL queries. This is so all queries have access to the same consistent final variable.
 * <br> This does mean if the program had a reset or bought by a company, a new encryption key could be setup without hassle, as only one variable has to be changed.
 * </p>
 * 
 */
public class MyEncryption {

	
	private static final String encryptionKey  = "encrypt";
	
	/**
	 * <h1> Method </h1>
	 * <p>
	 * To get encryptionKey variable for mySQL queries that require it.
	 * </p>
	 * 
	 *
     * @see MyEncryption
	 * @see String
	 */
	
	public static String getEncryptionKey() {
		
		return encryptionKey;
		
	}
	
}
