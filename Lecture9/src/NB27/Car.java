package NB27;

public class Car implements Comparable<Car> {
    private final String brand;
    private final int year;
    private final int miles;

    public Car(String brand, int year, int miles) {
        this.brand = brand;
        this.year = year;
        this.miles = miles;
    }

    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }

    public int getMiles() {
        return miles;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", year=" + year +
                ", miles=" + miles +
                '}';
    }

    @Override
    public int compareTo(Car o) {
        if (this.brand.equals(o.brand)) return 0;
        else if (this.brand.compareTo(o.brand) > 0) return 1;
        else if (this.brand.compareTo(o.brand) < 0) return -1;

        return 1;
    }
}
