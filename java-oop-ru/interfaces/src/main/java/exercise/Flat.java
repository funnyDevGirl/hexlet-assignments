package exercise;

// BEGIN
class Flat implements Home {
    private double area;
    private double balconyArea;
    private int floor;

    public Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }

    public double getFlatArea() {
        return area;
    }

    public double getBalconyArea() {
        return balconyArea;
    }

    public int getFloor() {
        return floor;
    }

    @Override
    public double getArea() {
        return getFlatArea() + getBalconyArea();
    }

    @Override
    public int compareTo(Home another) {
        Home flat = new Flat(area, balconyArea, floor);

        if (flat.getArea() == another.getArea()) {
            return 0;
        }
        int result = (flat.getArea() > another.getArea()) ? 1 : -1;
        return result;
    }

    @Override
    public String toString() {
        return "Квартира площадью " +
                getArea() +
                " метров на " + getFloor() +
                " этаже";
    }
}
// END
