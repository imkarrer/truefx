package client;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Isaac Karrer on 12/12/16.
 */
public class Decoder {

  private static final int BIG_LEN = 4;
  private static final int TS_LEN = 13;
  private static final int HIGH_LOW_LEN = 7;
  private static final int PIP_LEN = 3;
  private static final int PAIR_LEN = 7;

  public static List<TrueFxPairModel> decode(Format format, String data) {
    List<TrueFxPairModel> trueFxPairModels = new ArrayList<>();
    switch (format) {
      case DEFAULT_RATE:
        int numPairs = (int) data.chars().filter(c -> c == '/').count();
        int pairGap = numPairs * PAIR_LEN;
        int bigBidGap = pairGap + numPairs * BIG_LEN;
        int bidPipsGap = bigBidGap + numPairs * PIP_LEN;
        int offerBigGap = bidPipsGap + numPairs * BIG_LEN;
        int offerPipGap = offerBigGap + numPairs * PIP_LEN;
        int highGap = offerPipGap + numPairs * HIGH_LOW_LEN;
        int lowGap = highGap + numPairs * HIGH_LOW_LEN;

        int i = 0;
        while(i < numPairs) {
          TrueFxPairModel trueFxPairModel = new TrueFxPairModel()
              .setPair(CurrencyPair.findByPair(data.substring(
                  i * PAIR_LEN, i * PAIR_LEN + PAIR_LEN)))
              .setBidBig(
                  new BigDecimal(
                      data.substring(
                          pairGap + i * BIG_LEN, pairGap + (BIG_LEN * (i + 1)))
                          .replaceAll("#", "")))
              .setBidPips(
                  Integer.parseInt(
                      data.substring(
                          bigBidGap + i * PIP_LEN,
                          bigBidGap + (PIP_LEN * (i + 1)))))
              .setOfferBig(
                  new BigDecimal(
                      data.substring(
                          bidPipsGap + i * BIG_LEN,
                          bidPipsGap + (BIG_LEN * (i + 1)))
                          .replaceAll("#", "")))
              .setOfferPips(
                  Integer.parseInt(
                      data.substring(
                          offerBigGap + i * PIP_LEN,
                          offerBigGap + (PIP_LEN * (i + 1)))))
              .setHigh(
                  new BigDecimal(
                      data.substring(
                          offerPipGap + i * HIGH_LOW_LEN,
                          offerPipGap + (HIGH_LOW_LEN * (i + 1)))
                          .replaceAll("#", "")))
              .setLow(
                  new BigDecimal(
                      data.substring(
                          highGap + i * HIGH_LOW_LEN,
                          highGap + (HIGH_LOW_LEN * (i + 1)))
                          .replaceAll("#", "")))
              .setTimestamp(
                  Instant.ofEpochMilli(
                      Long.parseLong(data.substring(
                          lowGap + i * TS_LEN,
                          lowGap + (TS_LEN * (i + 1))))));
          trueFxPairModels.add(trueFxPairModel);

          i++;
        }
        break;
      case CSV:
        break;
      case HTML:
        break;
      default:
        break;
    }
    return trueFxPairModels;
  }
}
