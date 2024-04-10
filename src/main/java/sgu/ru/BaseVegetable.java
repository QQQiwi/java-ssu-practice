import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

interface Vegetable extends Comparable<Vegetable> {
    void grow();
    void harvest();

    boolean equals(Object o);
    int hashCode();
    int compareTo(Vegetable o);
    String toString();
    Vegetable shallowCopy();
    Vegetable deepCopy();
}


class BaseVegetable implements Vegetable, Cloneable {
    private String name;
    private String color;

    public BaseVegetable(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void grow() {
        System.out.println(name + " растет.");
    }

    public void harvest() {
        System.out.println(name + " собран.");
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseVegetable that = (BaseVegetable) o;
        return Objects.equals(name, that.name) &&
               Objects.equals(color, that.color);
    }

    public int hashCode() {
        return Objects.hash(name, color);
    }

    public int compareTo(Vegetable o) {
        return this.name.compareTo(o.toString());
    }

    public String toString() {
        return "Овощ{" +
               "имя='" + name + '\'' +
               ", цвет='" + color + '\'' +
               '}';
    }

    public Vegetable shallowCopy() {
        try {
            return (Vegetable) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public Vegetable deepCopy() {
        return new BaseVegetable(this.name, this.color);
    }
}


class SpecialVegetable extends BaseVegetable {
    private String specialProperty;

    public SpecialVegetable(String name, String color, String specialProperty) {
        super(name, color);
        this.specialProperty = specialProperty;
    }

    public void performSpecialAction() {
        System.out.println(getName() + " делает " + specialProperty);
    }
}