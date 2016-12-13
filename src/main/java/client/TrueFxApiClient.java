package client;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 *  Client that enables interaction with the TrueFx API.
 */
public class TrueFxApiClient implements TrueFxOperations {

  protected RestTemplate restTemplate;

  /**
   * For unauthorized API requests, quickstart
   */
  public TrueFxApiClient() {
    restTemplate = new RestTemplate();
  }

  public List<TrueFxPairModel> get() {
      ResponseEntity<String> resp =
          restTemplate
              .exchange(
                  TrueFxSession.getBaseUrl(),
                  HttpMethod.GET, null, String.class);
      return Decoder.decode(
          Format.DEFAULT_RATE, resp.getBody());
  }
}
