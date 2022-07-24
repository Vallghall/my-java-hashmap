package MyHashMap;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        MyHashMap<A, String> map = new MyHashMap<A, String>();
        map.put(new A("Roman"), "Hello");
        map.remove(new A("Roman"));
        System.out.println(map.get(new A("Roman")));
        map.put(new A("Ravi"), "Hi");

        map.put(new A("Ranni"), "Greetings");
        System.out.println(map.get(new A("Ravi")));
        System.out.println(map.get(new A("Ranni")));
    }
}

class A {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        A a = (A) o;
        return Objects.equals(v, a.v);
    }

    @Override
    public int hashCode() {
        return Objects.hash(v.charAt(0));
    }

    String v;
    A(String v) {
        this.v = v;
    }

}
