# [TrueFX Java API Client](https://www.truefx.com/dev/data/TrueFX_MarketDataWebAPI_DeveloperGuide.pdf)
TrueFX tracks forex currency pairs.  Visit [TrueFX](https://www.truefx.com/) for more information.

# Get Started
See the test directory for example usages.
## Unauthorized Requests
```java
List<TrueFxPairModel> pairs = new TrueFxApiClient().get();
```
Expected Response
```java
[TrueFxPairModel{pair='EUR/USD', timestamp=2016-12-13T22:29:07.107Z, bidBig=1.06, bidPips=241, offerBig=1.06, offerPips=263, high=1.06307, low=1.06241}, TrueFxPairModel{pair='USD/JPY', timestamp=2016-12-13T22:29:07.107Z, bidBig=115, bidPips=180, offerBig=115, offerPips=195, high=115.195, low=115.126}, TrueFxPairModel{pair='GBP/USD', timestamp=2016-12-13T22:29:07.106Z, bidBig=1.26, bidPips=594, offerBig=1.26, offerPips=632, high=1.26680, low=1.26546}, TrueFxPairModel{pair='EUR/GBP', timestamp=2016-12-13T22:29:07.117Z, bidBig=0.83, bidPips=896, offerBig=0.83, offerPips=931, high=0.83985, low=0.83887}, TrueFxPairModel{pair='USD/CHF', timestamp=2016-12-13T22:29:06.534Z, bidBig=1.01, bidPips=201, offerBig=1.01, offerPips=236, high=1.01504, low=1.00912}, TrueFxPairModel{pair='EUR/JPY', timestamp=2016-12-13T22:29:07.127Z, bidBig=122, bidPips=373, offerBig=122, offerPips=398, high=122.430, low=122.305}, TrueFxPairModel{pair='EUR/CHF', timestamp=2016-12-13T22:29:07.107Z, bidBig=1.07, bidPips=528, offerBig=1.07, offerPips=561, high=1.07676, low=1.07485}, TrueFxPairModel{pair='USD/CAD', timestamp=2016-12-13T22:29:06.047Z, bidBig=1.31, bidPips=360, offerBig=1.31, offerPips=388, high=1.31394, low=1.31281}, TrueFxPairModel{pair='AUD/USD', timestamp=2016-12-13T22:29:07.117Z, bidBig=0.74, bidPips=909, offerBig=0.74, offerPips=932, high=0.75025, low=0.74865}, TrueFxPairModel{pair='GBP/JPY', timestamp=2016-12-13T22:29:06.460Z, bidBig=145, bidPips=812, offerBig=145, offerPips=875, high=145.890, low=145.725}]
```
## Authorized Requests

```java
List<Pair> desiredPairs = new ArrayList<>();
desiredPairs.add(CurrencyPair.EUR_USD);
TrueFxSession trueFxSession = new TrueFxSession()
    .setUsername(TrueFxProperties.getDevUsername())
    .setPassword(TrueFxProperties.getDevPassword())
    .setPairs(desiredPairs);
List<TrueFxPairModel> pairs = new TrueFxApiSessionedClient(trueFxSession).get();
```
Expected Response
```java
[TrueFxPairModel{pair='EUR/USD', timestamp=2016-12-13T22:31:36.578Z, bidBig=1.06, bidPips=254, offerBig=1.06, offerPips=273, high=1.06307, low=1.06231}]
```


## Session Timeout
There is a server side ~70 sec session timeout.  The local session is 
refreshed every 60 sec.

## Local Maven
Can publish to local maven with `gradle publishToLocalMaven`

## Central Maven
The next iteration is working towards the first release into the 
Central Maven for public consumption.  This is my first time publishing
a jar.  Pull requests are welcome :)

