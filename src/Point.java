class Point {
    private final double x;
    private final double y;

    public Point(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (getClass() != obj.getClass()) return false;
        return this.x == ((Point) obj).x && this.y == ((Point) obj).y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
