/**
 * 
 */
package webserver;

import java.io.DataOutputStream;

/**
 * The purpose of WebRequestHandler class is to generate a valid HTTP response.
 * 
 * @author Matthew Allen
 * @version September 23, 2013
 */
public class WebRequestHandler {
	/**
	 * The method handleRequest writes a valid HTTP response based on webRequest to dataOutputStream.
	 * The only valid method is GET. The HTTP response will consist of valid HTTP header and HTTP body.
	 * 
	 * @param webRequest
	 * @param dataOutputStream
	 */
	public void handleRequest(WebRequest webRequest, DataOutputStream dataOutputStream) {
		
	}
	
//	
//	* headerFields will be used in getHeader to generate name value pairs separated by colon, 
//	 * and terminated with carriage return and line feed. 
//			 
//			 * get the header, which will consist of the name value pair request headers from headerFields.
//			 * TODO update these comments this may be implemented else where this is just to return header value?
//			 * The name value pairs will be separated by a colon, and terminated with the carriage return and line feed \r\n where \r is carriage return \n is line feed.
//			 * The end of the header will be indicated by two consecutive carriage return line feed pairs.
}
