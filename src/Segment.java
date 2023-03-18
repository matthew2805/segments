import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

class Segment {
    Point start;
    Point end;

    public Segment(Point start, Point end) {
        if (start.equals(end)) throw new IllegalArgumentException();
        else {
            this.start = start;
            this.end = end;
        }
    }

    double length() {
        return sqrt(pow(end.getX() - start.getX(), 2) +
                pow(end.getY() - start.getY(), 2));
    }

    Point middle() {
        return new Point((end.getX() + start.getX()) / 2, (end.getY() + start.getY()) / 2);
    }

    Point intersection(Segment another) {
        var dx1 = this.end.getX() - this.start.getX();
        var dy1 = this.end.getY() - this.start.getY();
        var dx2 = another.end.getX() - another.start.getX();
        var dy2 = another.end.getY() - another.start.getY();
        var dxx = this.start.getX() - another.start.getX();
        var dyy = this.start.getY() - another.start.getY();

        var div = dy2 * dx1 - dx2 * dy1;
        if (div == 0) return null;

        var a = (dx1 * dyy - dy1 * dxx) / div;
        if (a < 0 || a > 1.0) return null;

        var b = (dx2 * dyy - dy2 * dxx) / div;
        if (b < 0 || b > 1.0) return null;

        return new Point(this.start.getX() + b * dx1, this.start.getY() + b * dy1);
    }

}
