package it.chiarapuleio.exercise.restaurant.abstractClass;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="menu")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "menu_items")
public abstract class SuperMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    protected String name;
    protected int kcal;
    protected double price;

    public SuperMenu(String name, int kcal, double price) {
        this.name = name;
        this.kcal = kcal;
        this.price = price;
    }
}
