package client;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Does a basic integration test with the private
 * API that requires authentication.
 */
public class TrueFxApiSessionedClientTest {
  TrueFxApiSessionedClient trueFxApiSessionedClient;
  TrueFxSession trueFxSession;


  @Before
  public void setUp() {
    List<Pair> pairs = PairUtils.getPrivatePairs();
    this.trueFxSession = new TrueFxSession()
        .setUsername(TrueFxProperties.getDevUsername())
        .setPassword(TrueFxProperties.getDevPassword())
        .setPairs(pairs);
    this.trueFxApiSessionedClient = new TrueFxApiSessionedClient(trueFxSession);
  }

  @Test
  public void testGet() {
    List<Pair> desiredPairs = new ArrayList<>();
    desiredPairs.add(CurrencyPair.EUR_USD);
    TrueFxSession trueFxSession = new TrueFxSession()
        .setUsername(TrueFxProperties.getDevUsername())
        .setPassword(TrueFxProperties.getDevPassword())
        .setPairs(desiredPairs);
    List<TrueFxPairModel> pairs = new TrueFxApiSessionedClient(trueFxSession).get();
    System.out.println(pairs);

    Assert.assertEquals(PairUtils.getCurrencyPairs(
        this.trueFxApiSessionedClient.get()),
        PairUtils.getPrivatePairs());
  }

  @After
  public void tearDown() {

  }
}
