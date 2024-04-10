import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Vegetable tomato = new BaseVegetable("Помидорка", "Красная");

        // первая часть задания
        SpecialVegetable marrow = new SpecialVegetable("Кабачок", "Зеленый", "что-то особенное...");
        marrow.grow();
        marrow.harvest();
        marrow.performSpecialAction();
        System.out.println(marrow);

        // вторая часть задания
        System.out.println(tomato);
        tomato.grow();
        Vegetable copy = tomato.shallowCopy();
        System.out.println(copy.equals(tomato));
        System.out.println(copy.hashCode() == tomato.hashCode());
        System.out.println(copy.compareTo((BaseVegetable) tomato));
        System.out.println(copy);

        
        // третья часть задания
        SpecialVegetable carrot = new SpecialVegetable("Морковь", "Оранжевая", "зрение лучше");
        SpecialVegetable pepper = new SpecialVegetable("Перец", "Черный", "пищу острой");        
        SpecialVegetable onion = new SpecialVegetable("Лук", "Зеленый", "суп вкуснее");
        
        List<SpecialVegetable> vegetableList = new ArrayList<>();
        vegetableList.add(carrot);
        vegetableList.add(pepper);
        vegetableList.add(onion);

        for (SpecialVegetable vegetable : vegetableList) {
            vegetable.performSpecialAction();   
        }
    }
}
