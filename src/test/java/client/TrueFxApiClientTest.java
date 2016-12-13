package client;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Does a basic integration tests with the public API.
 */
public class TrueFxApiClientTest {

  TrueFxApiClient trueFxApiClient;


  @Before
  public void setUp() {
    this.trueFxApiClient = new TrueFxApiClient();
  }

  /**
   * This is a really lazy integration test.  Ideally these should be unit
   * tests.  This was a really quick way to verify that everything works.
   */
  @Test
  public void testGet() {
    Assert.assertEquals(PairUtils.getCurrencyPairs(this.trueFxApiClient.get()),
        PairUtils.getPublicPairs());
  }

  @After
  public void tearDown() {

  }
}
