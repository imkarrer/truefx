package client;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Makes authenticated requests with the TrueFx API.
 */
public class TrueFxApiSessionedClient extends TrueFxApiClient {

  private TrueFxSession trueFxSession;

  public TrueFxApiSessionedClient(TrueFxSession trueFxSession) {
    this.trueFxSession = trueFxSession;
  }

  @Override
  public List<TrueFxPairModel> get() {
    //Start the session if not active
    return this.get(this.trueFxSession.getFormat());
  }

  private List<TrueFxPairModel> get(Format format) {
    if (!trueFxSession.isActive()) {
      ResponseEntity<String> start = restTemplate
          .exchange(
              trueFxSession.getQueryUrl(), HttpMethod.GET, null, String.class);
      trueFxSession.setSessionId(start.getBody().replaceAll("\r\n", ""));
    }
    ResponseEntity<String> resp =
        restTemplate.exchange(
            trueFxSession.getSessionUrl(), HttpMethod.GET, null, String.class);
    return Decoder.decode(format, resp.getBody());
  }
}
