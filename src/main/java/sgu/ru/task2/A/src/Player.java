enum damageTypeEnum {PHYSICAL, MAGICAL};

public interface InnerPlayer {
    
}

public class Player {
    private String name;
    private int health;
    private int mana;
    private int damage;

    public String getName() {
        return name;
    }
    public void setName(String newName) {
        name = newName;
    }

    public int getHealth() {
        return health;
    }
    public void setHealth(int newHealth) {
        health = newHealth;
    }

    public int getDamage() {
        return damage;
    }
    public void setDamage(int newDamage) {
        damage = newDamage;
    }

    public int getMana() {
        return mana;
    }
    public void setMana(int newMana) {
        damage = newMana;
    }
}
