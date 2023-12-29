package exercise;

// BEGIN
class Cottage implements Home {
    private double area;
    private int floorCount;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    public int getFloorCount() {
        return floorCount;
    }

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public int compareTo(Home another) {
        Home cottage = new Cottage(area, floorCount);

        if (cottage.getArea() == another.getArea()) {
            return 0;
        }
        int result = (cottage.getArea() > another.getArea()) ? 1 : -1;
        return result;
    }

    @Override
    public String toString() {
        return getFloorCount() +
                " этажный коттедж площадью " +
                getArea() +
                " метров";
    }
}
// END
