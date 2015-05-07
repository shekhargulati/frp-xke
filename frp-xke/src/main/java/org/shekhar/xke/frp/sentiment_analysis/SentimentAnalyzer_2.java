package org.shekhar.xke.frp.sentiment_analysis;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.ArrayUtils;
import rx.Observable;
import rx.observables.ConnectableObservable;
import twitter4j.Status;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class SentimentAnalyzer_2 {

    private static final String[] NEGATIVE_WORDS = words("src/main/resources/negative_words.txt");
    private static final String[] POSITIVE_WORDS = words("src/main/resources/positive_words.txt");

    public static void main(String[] args) {
        ConnectableObservable<Status> observable = TweetObservable.tweetObservable(new String[]{"Salman Khan", "Messi"}).publish();
        observable.connect();
        Observable<String> tweetStream = observable.<String>flatMap(status -> Observable.create(sub -> sub.onNext(status.getText())));

        Observable<String> positiveTweets = tweetStream.filter(tweet -> isPositiveTweet(tweet));

        positiveTweets.count().subscribe(val -> System.out.println("Tweet count " + val));

        Observable<String> negativeTweets = tweetStream.filter(tweet -> isNegativeTweet(tweet));

        negativeTweets.count().subscribe(val -> System.out.println("Tweet count " + val));
    }

    private static boolean isNegativeTweet(String tweet) {
        String[] words = tweet.toLowerCase().split("\\s");
        return Arrays.stream(words).anyMatch(word -> ArrayUtils.contains(NEGATIVE_WORDS, word));
    }

    private static boolean isPositiveTweet(String tweet) {
        String[] words = tweet.toLowerCase().split("\\s");
        return Arrays.stream(words).anyMatch(word -> ArrayUtils.contains(POSITIVE_WORDS, word));
    }


    private static String[] words(String file) {
        try {
            return FileUtils.readLines(new File(file)).toArray(new String[0]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
