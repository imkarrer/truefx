package client;

import org.apache.commons.lang3.StringUtils;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

/**
 * Encapsulates a TrueFx Session.
 */
public class TrueFxSession {
  static private String TRUE_FX_URL_BASE =
      "http://webrates.truefx.com/rates/connect.html";

  private String TRUE_FX_QUERY_STRING_TEMPLATE_BASE = "?u=%s&p=%s&q=%s&c=%s" +
      "&s=%s";

  private String TRUE_FX_QUERY_STRING_TEMPLATE =
      TRUE_FX_URL_BASE + TRUE_FX_QUERY_STRING_TEMPLATE_BASE;

  private String TRUE_FX_SESSION_TEMPLATE_BASE = "?id=%s";

  private String TRUE_FX_QUERY_SESSION_TEMPLATE =
      TRUE_FX_URL_BASE + TRUE_FX_SESSION_TEMPLATE_BASE;

  public Duration getSESSION_TIMEOUT() {
    return SESSION_TIMEOUT;
  }

  private final Duration SESSION_TIMEOUT = Duration.ofSeconds(60);

  private String username;

  private String password;

  private String qualifier = "foobar";

  private String sessionId;

  private boolean isSnapshot;

  // Defualt to DEFAULT_RATE since that parser can be used for auth and unauth
  private Format format = Format.DEFAULT_RATE;

  private Instant lastUsed;

  private List<Pair> pairs;

  public TrueFxSession() {}

  public TrueFxSession(String sessionId) {
    this.sessionId = sessionId;
  }

  public TrueFxSession(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public TrueFxSession setUsername(String username) {
    this.username = username;
    return this;
  }

  public String getPassword() {
    return password;
  }

  public TrueFxSession setPassword(String password) {
    this.password = password;
    return this;
  }

  public String getQualifier() {
    return qualifier;
  }

  public TrueFxSession setQualifier(String qualifier) {
    this.qualifier = qualifier;
    return this;
  }

  public String getSessionId() {
    return sessionId;
  }

  public TrueFxSession setSessionId(String sessionId) {
    this.sessionId = sessionId;
    return this;
  }

  public boolean isActive() {
    if (this.getSessionId() == null) {
      return false;
    }
    String[] sessionParts = this.getSessionId().split(":");
    // The session timestamp is the last value in the colon delimited string.
    Instant sessionTs =
        Instant.ofEpochMilli(
            Long.parseLong(sessionParts[sessionParts.length - 1]));
    return Duration
        .between(sessionTs, Instant.now()).compareTo(SESSION_TIMEOUT) < 0;
  }


  public boolean isSnapshot() {
    return isSnapshot;
  }

  public TrueFxSession setSnapshot(boolean snapshot) {
    isSnapshot = snapshot;
    return this;
  }

  public Format getFormat() {
    return format;
  }

  public TrueFxSession setFormat(Format format) {
    this.format = format;
    return this;
  }

  public Instant getLastUsed() {
    return lastUsed;
  }

  public TrueFxSession setLastUsed(Instant lastUsed) {
    this.lastUsed = lastUsed;
    return this;
  }

  public List<Pair> getPairs() {
    return pairs;
  }

  public String getCsvPairs() {
    return StringUtils.join(PairUtils.asList(pairs), ",");
  }

  public TrueFxSession setPairs(List<Pair> pairs) {
    this.pairs = pairs;
    return this;
  }

  static public String getBaseUrl() {
    return TRUE_FX_URL_BASE;
  }

  public String getQueryUrl() {
    return String.format(
        TRUE_FX_QUERY_STRING_TEMPLATE,
        this.getUsername(),
        this.getPassword(),
        this.getQualifier(),
        this.getCsvPairs(),
        this.isSnapshot());
  }

  public String getSessionUrl() {
    return String.format(
        TRUE_FX_QUERY_SESSION_TEMPLATE,
        this.getSessionId());
  }
}
