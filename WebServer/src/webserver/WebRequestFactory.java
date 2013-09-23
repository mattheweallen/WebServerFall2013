/**
 * 
 */
package webserver;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * The purpose of WebRequestFactory is to create a WebRequest object based on data from a BufferedReader. 
 * 
 * @author Matthew Allen
 * @version September 23, 2013
 *
 */
public class WebRequestFactory {
	
	/**
	 * createRequest builds a WebRequest based on bufferedReader.
	 * 
	 * @param bufferedReader
	 * @return
	 * @throws IOException 
	 */
	public static WebRequest createRequest(BufferedReader bufferedReader) throws IOException {
		WebRequest webRequest = new WebRequestImpl();
		String sCurrentLine = bufferedReader.readLine();
		String[] requestLine = sCurrentLine.split(" ");

		webRequest.setMethod(requestLine[0].trim());
		webRequest.setPath(requestLine[1].trim());
		webRequest.setVersion(requestLine[2].trim());
		
		while(!(sCurrentLine = bufferedReader.readLine()).equals("")) {
			String[] requestHeader = sCurrentLine.split(":");
			webRequest.addHeader(requestHeader[0], requestHeader[0]);
		}
		return webRequest;
	}
}
