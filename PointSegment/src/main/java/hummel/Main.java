package main.java.hummel;

public class Main {
    public static void main(String[] args) {
        Segment first = new Segment(new Point(1, 1), new Point(4, 1));
        Segment second = new Segment(new Point(1, 1), new Point(4, 1));

        Point point = first.intersection(second);

        System.out.println(point.toString());
    }
}