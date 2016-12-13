package client;

/**
 * Format for results to return.
 */
public enum Format {
  DEFAULT_RATE(""),
  CSV("csv"),
  HTML("html");

  private String value;

  Format(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
