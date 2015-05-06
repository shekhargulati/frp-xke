package org.shekhar.xke.frp.flow;

import rx.Observable;
import rx.schedulers.Schedulers;

public class Example6 {

    public static void main(String[] args) {
        Observable<String> xlteam = Observable.just("shekhar", "sameer", "aditya", "ankur");


        xlteam.subscribeOn(Schedulers.newThread()).subscribe(name -> System.out.println("first .. I met " + name));
        xlteam.subscribe(name -> System.out.println("second .. I met " + name));

        Observable<String> xlteamWithS = xlteam.map(String::toUpperCase).filter(name -> name.startsWith("S"));
        xlteamWithS.subscribe(name -> System.out.println("I met XL team member with name starting with S. He is " + name));

        xlteam.mergeWith(xlteamWithS).subscribe(name -> System.out.println("I met all... " + name));
    }
}
