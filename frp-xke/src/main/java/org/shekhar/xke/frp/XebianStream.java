package org.shekhar.xke.frp;

import java.util.Iterator;
import java.util.UUID;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class XebianStream implements Iterable<String>{

    public static void main(String[] args) {
        XebianStream xebians = new XebianStream();
        xebians.stream().limit(5).forEach(System.out::println);
    }

    public Stream<String> stream(){
        return StreamSupport.stream(this.spliterator(),false);
    }
    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public String next() {
                return UUID.randomUUID().toString();
            }
        };
    }

}

