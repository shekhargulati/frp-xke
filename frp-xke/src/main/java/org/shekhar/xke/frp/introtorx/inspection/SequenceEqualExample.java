package org.shekhar.xke.frp.introtorx.inspection;

import rx.Observable;
import rx.subjects.ReplaySubject;

import java.util.Arrays;

public class SequenceEqualExample {

    public static void main(String[] args) {
        Observable<String> questions = Observable.from(Arrays.asList("1", "2", "3", "4", "5"));

        ReplaySubject<String> subject = ReplaySubject.create();
        questions.map(str -> str + "hi").subscribe(subject);
        subject.subscribe(System.out::println);

        Observable.sequenceEqual(questions, subject).subscribe(System.out::println);
    }
}
