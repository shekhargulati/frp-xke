package org.shekhar.xke.frp.flow;

import rx.Observable;

import java.util.Arrays;

public class Example6 {

    public static void main(String[] args) {
        Observable<String> xlteam = Observable.from(Arrays.asList("shekhar", "sameer", "aditya", "ankur"));

        Observable<String> xlteamWithS = xlteam.map(String::toUpperCase).filter(name -> name.startsWith("S"));

        xlteam.subscribe(name -> System.out.println("first .. I met " + name));
        xlteam.subscribe(name -> System.out.println("second .. I met " + name));
        xlteamWithS.subscribe(name -> System.out.println("I met XL team member with name starting with S. He is " + name));

        xlteam.mergeWith(xlteamWithS).subscribe(name -> System.out.println("I met all... " + name));
    }
}
