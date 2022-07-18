package main.java.hummel;

public class Segment {
    private Point start;
    private Point end;

    @Override
    public String toString() {
        return "Segment{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }

    public Segment(Point start, Point end) {
        if (start.getX() == end.getX() && start.getY() == end.getY()) {
            throw new IllegalArgumentException();
        } else if (start == null || end == null) {
            throw new IllegalArgumentException();
        } else {
            this.start = start;
            this.end = end;
        }
    }

    double length() {
        Segment segment = new Segment(start, end);
        return Math.sqrt((Math.pow((segment.end.getX() - segment.start.getX()), 2)) +
                Math.pow((segment.end.getY() - segment.start.getY()), 2));
    }

    Point middle() {
        Point resPoint = new Point((this.start.getX() + this.end.getX()) / 2,
                (this.start.getY() + this.end.getY()) / 2);
        return resPoint;
    }

    public boolean containsPoint(Point point) {
		return ((point.getX() - this.start.getX()) * (this.end.getY() - this.start.getY()) == ((point.getY() - this.start.getY()) * (this.end.getX() - this.start.getX())));
    }

    Point intersection(Segment segment2) {
    	Point result = new Point(0, 0);
    	Segment segment1 = new Segment(start, end);
    	double x11 = this.start.getX();
    	double x21 = segment2.start.getX();
    	double x12 = this.end.getX();
    	double x22 = segment2.end.getX();

    	double y11 = this.start.getY();
    	double y21 = segment2.start.getY();
    	double y12 = this.end.getY();
    	double y22 = segment2.end.getY();

    	int xmin = (int) Math.round(Math.min(Math.min(x11, x21), Math.min(x12, x22)));
    	int xmax = (int) Math.round(Math.max(Math.max(x11, x21), Math.max(x12, x22)));
    	int ymin = (int) Math.round(Math.min(Math.min(y11, y21), Math.min(y12, y22)));
    	int ymax = (int) Math.round(Math.max(Math.max(y11, y21), Math.max(y12, y22)));

    	for (int x = xmin; x <= xmax; x++) {
        	for (int y = ymin; y <= ymax; y++) {
    			if (segment1.containsPoint(new Point(x, y)) && segment2.containsPoint(new Point(x, y))) {
    				result = new Point(x, y);
    				break;
    			}
        	}
    	}
		return result;
    }

}
