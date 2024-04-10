import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


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
