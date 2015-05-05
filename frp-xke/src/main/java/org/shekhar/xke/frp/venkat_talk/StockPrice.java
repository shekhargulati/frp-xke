package org.shekhar.xke.frp.venkat_talk;

import rx.Observable;

import java.util.Arrays;
import java.util.List;

public class StockPrice {
    public static void main(String[] args) {
        List<String> stocks = Arrays.asList("AMZN", "GOOG", "ORCL");

        Observable<StockInfo> feed = StockService.getFeed(stocks);

        feed.subscribe(System.out::println);

    }
}
