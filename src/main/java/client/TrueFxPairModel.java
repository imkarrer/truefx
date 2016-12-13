package client;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * A class to encapsulate information about a pair.
 */
public class TrueFxPairModel implements PairModel {

  private Pair pair;
  private Instant timestamp;
  private BigDecimal bidBig;
  private Integer bidPips;
  private BigDecimal offerBig;
  private Integer offerPips;
  private BigDecimal high;
  private BigDecimal low;

  public TrueFxPairModel() {
  }

  public BigDecimal getBidBig() {
    return bidBig;
  }

  public TrueFxPairModel setBidBig(BigDecimal bidBig) {
    this.bidBig = bidBig;
    return this;
  }

  public Integer getBidPips() {
    return bidPips;
  }

  public TrueFxPairModel setBidPips(Integer bidPips) {
    this.bidPips = bidPips;
    return this;
  }

  public BigDecimal getOfferBig() {
    return offerBig;
  }

  public TrueFxPairModel setOfferBig(BigDecimal offerBig) {
    this.offerBig = offerBig;
    return this;
  }

  public Integer getOfferPips() {
    return offerPips;
  }

  public TrueFxPairModel setOfferPips(Integer offerPips) {
    this.offerPips = offerPips;
    return this;
  }

  public Pair getPair() {
    return pair;
  }

  public TrueFxPairModel setPair(Pair pair) {
    this.pair = pair;
    return this;
  }

  public Instant getTimestamp() {
    return timestamp;
  }

  public TrueFxPairModel setTimestamp(Instant timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  public BigDecimal getHigh() {
    return high;
  }

  public TrueFxPairModel setHigh(BigDecimal high) {
    this.high = high;
    return this;
  }

  public BigDecimal getLow() {
    return low;
  }

  public TrueFxPairModel setLow(BigDecimal low) {
    this.low = low;
    return this;
  }

  @Override
  public String toString() {
    return "TrueFxPairModel{" +
        "pair='" + pair + '\'' +
        ", timestamp=" + timestamp +
        ", bidBig=" + bidBig +
        ", bidPips=" + bidPips +
        ", offerBig=" + offerBig +
        ", offerPips=" + offerPips +
        ", high=" + high +
        ", low=" + low +
        '}';
  }

}
