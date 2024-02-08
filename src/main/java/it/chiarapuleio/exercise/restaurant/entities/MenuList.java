package it.chiarapuleio.exercise.restaurant.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Component("menuList")
public class MenuList {
    private List<Pizza> pizzaList;
    private List<Drink> drinkList;
    private List<Toppings> toppingsList;

    public MenuList(List<Pizza> pizzaList, List<Drink> drinkList, List<Toppings> toppingsList) {
        this.pizzaList = pizzaList;
        this.drinkList = drinkList;
        this.toppingsList = toppingsList;
    }

    public void printMenu() {
        System.out.println("----- PIZZAS -----");
        this.pizzaList.forEach(System.out::println);

        System.out.println("----- TOPPINGS -----");
        this.toppingsList.forEach(System.out::println);

        System.out.println("----- DRINKS -----");
        this.drinkList.forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "MenuList{" +
                "pizzaList=" + pizzaList +
                ", drinkList=" + drinkList +
                ", toppingsList=" + toppingsList +
                '}';
    }
}