package client;

/**
 * Encapsulates values for Pair requiring authentication.
 */
public enum CurrencyPair implements Pair {

  EUR_USD(PairStrings.getEurUsd()),
  USD_JPY(PairStrings.getUsdJpy()),
  GBP_USD(PairStrings.getGbpUsd()),
  EUR_GBP(PairStrings.getEurGbp()),
  USD_CHF(PairStrings.getUsdChf()),
  EUR_JPY(PairStrings.getEurJpy()),
  EUR_CHF(PairStrings.getEurChf()),
  USD_CAD(PairStrings.getUsdCad()),
  AUD_USD(PairStrings.getAudUsd()),
  GBP_JPY(PairStrings.getGbpJpy()),
  AUD_CAD(PairStrings.getAudCad()),
  AUD_CHF(PairStrings.getAudChf()),
  AUD_JPY(PairStrings.getAudJpy()),
  AUD_NZD(PairStrings.getAudNzd()),
  CAD_CHF(PairStrings.getCadChf()),
  CAD_JPY(PairStrings.getCadJpy()),
  CHF_JPY(PairStrings.getChfJpy()),
  EUR_AUD(PairStrings.getEurAud()),
  EUR_CAD(PairStrings.getEurCad()),
  EUR_NOK(PairStrings.getEurNok()),
  EUR_NZD(PairStrings.getEurNzd()),
  GBP_CAD(PairStrings.getGbpCad()),
  GBP_CHF(PairStrings.getGbpChf()),
  NZD_JPY(PairStrings.getNzdJpy()),
  NZD_USD(PairStrings.getNzdUsd()),
  USD_NOK(PairStrings.getUsdNok()),
  USD_SEK(PairStrings.getUsdSek());

  private String pair;

  CurrencyPair(String pair) {
    this.pair = pair;
  }

  public String getPair() {
    return this.pair;
  }

  public String toString() {
    return this.pair;
  }

  static public Pair findByPair(String pair) {
    for (Pair p : values()) {
      if (p.getPair().equals(pair)) {
        return p;
      }
    }
    throw new IllegalArgumentException("Enum does not exist: " + pair);
  }
}
