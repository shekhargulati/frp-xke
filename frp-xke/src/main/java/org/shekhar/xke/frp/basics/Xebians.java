package org.shekhar.xke.frp.basics;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Xebians implements Iterable<String> {

    private final List<String> list;
    private int counter;

    public Xebians(List<String> list) {
        this.list = list;
    }

    public static void main(String[] args) {
        Xebians xebians = new Xebians(Arrays.asList("Shekhar", "Sameer", "Aditya"));
        for (String xebian : xebians) {
            System.out.println(xebian);
        }
    }



    @Override
    public Iterator<String> iterator() {
        return new XebianIterator();
    }

    private class XebianIterator implements Iterator<String>{

        @Override
        public boolean hasNext() {
            return counter < list.size();
        }

        @Override
        public String next() {
            return list.get(counter++);
        }
    }
}
