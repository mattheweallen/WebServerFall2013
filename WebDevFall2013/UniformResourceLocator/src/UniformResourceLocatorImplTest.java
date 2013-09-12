import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Matthew Allen
 *
 */
public class UniformResourceLocatorImplTest {
	private UniformResourceLocator url; 
	
	@Before 
	public void initialize() {
		url = new UniformResourceLocatorImpl()
					.scheme("https")
					.host("www.google.com")
					.port(443)
					.path("search")
					.queryParameter("q", "lion")
					.queryParameter("safe", "active");
	}

	/**
	 * Test method for {@link UniformResourceLocatorImpl#getScheme()}.
	 */
	@Test
	public final void testGetScheme() {
		assertEquals("https", url.getScheme());
	}

	/**
	 * Test method for {@link UniformResourceLocatorImpl#getHost()}.
	 */
	@Test
	public final void testGetHost() {
		assertEquals("www.google.com", url.getHost());
	}

	/**
	 * Test method for {@link UniformResourceLocatorImpl#getPort()}.
	 */
	@Test
	public final void testGetPort() {
		assertEquals(443, url.getPort(), 0);
	}

	/**
	 * Test method for {@link UniformResourceLocatorImpl#getPath()}.
	 */
	@Test
	public final void testGetPath() {
		assertEquals("search",url.getPath());
	}

	/**
	 * Test method for {@link UniformResourceLocatorImpl#getQueryKeys()}.
	 */
	@Test
	public final void testGetQueryKeys() {
		assertTrue(url.getQueryKeys().contains("q"));
		assertTrue(url.getQueryKeys().contains("safe"));
	}

	/**
	 * Test method for {@link UniformResourceLocatorImpl#getQueryValue(java.lang.String)}.
	 */
	@Test
	public final void testGetQueryValue() {
		assertEquals("lion",url.getQueryValue("q"));
		assertEquals("active",url.getQueryValue("safe"));
	}

	/**
	 * Test method for {@link UniformResourceLocatorImpl#getQuery()}.
	 */
	@Test
	public final void testGetQuery() {
		assertTrue(url.getQuery().size() == 2);
		assertEquals("lion", url.getQuery().get("q"));
		assertEquals("active", url.getQuery().get("safe"));
	}

	/**
	 * Test method for {@link UniformResourceLocatorImpl#getFragment()}.
	 */
	@Test
	public final void testGetFragment() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link UniformResourceLocatorImpl#toURL()}.
	 */
	@Test
	public final void testToURL() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link UniformResourceLocatorImpl#scheme(java.lang.String)}.
	 */
	@Test
	public final void testScheme() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link UniformResourceLocatorImpl#host(java.lang.String)}.
	 */
	@Test
	public final void testHost() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link UniformResourceLocatorImpl#port(java.lang.Integer)}.
	 */
	@Test
	public final void testPort() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link UniformResourceLocatorImpl#path(java.lang.String)}.
	 */
	@Test
	public final void testPath() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link UniformResourceLocatorImpl#queryParameter(java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testQueryParameter() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link UniformResourceLocatorImpl#fragment(java.lang.String)}.
	 */
	@Test
	public final void testFragment() {
		fail("Not yet implemented"); // TODO
	}
	
	/**
	 * Test method for {@link UniformResourceLocator#toString()}.
	 */
	@Test
	public final void testToString() {
		fail("Not yet implemented");
		//assertEquals("blarg",url.toString());
	}
	
	@Test
	public final void testNormalizeQuery() {
		UniformResourceLocatorImpl urli = new UniformResourceLocatorImpl();
		assertEquals("safe%3Dactiv%2B%26q%3Dl%3Fon", urli.encodeQuery("safe=activ+&q=l?on"));
		
	}

}
