package client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Static methods for Currency Pairs.
 */
public class PairUtils {
  static List<String> asList(List<Pair> pairs) {
    return pairs
        .stream()
        .map(Pair::getPair)
        .collect(Collectors.toList());
  }

  static public List<Pair> getPublicPairs() {
    List<Pair> publicPairs = new ArrayList<>();

    publicPairs.add(CurrencyPair.EUR_USD);
    publicPairs.add(CurrencyPair.USD_JPY);
    publicPairs.add(CurrencyPair.GBP_USD);
    publicPairs.add(CurrencyPair.EUR_GBP);
    publicPairs.add(CurrencyPair.USD_CHF);
    publicPairs.add(CurrencyPair.EUR_JPY);
    publicPairs.add(CurrencyPair.EUR_CHF);
    publicPairs.add(CurrencyPair.USD_CAD);
    publicPairs.add(CurrencyPair.AUD_USD);
    publicPairs.add(CurrencyPair.GBP_JPY);
    return publicPairs;
  }

  static public List<Pair> getPrivatePairs() {
    return Arrays.asList(CurrencyPair.values());
  }

  static public List<Pair> getCurrencyPairs(List<TrueFxPairModel> pairModels) {
    return pairModels.stream()
        .map(PairModel::getPair)
        .collect(Collectors.toList());
  }

}
