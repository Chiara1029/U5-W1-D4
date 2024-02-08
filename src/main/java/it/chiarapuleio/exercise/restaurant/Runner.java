package it.chiarapuleio.exercise.restaurant;

import it.chiarapuleio.exercise.restaurant.abstractClass.SuperMenu;
import it.chiarapuleio.exercise.restaurant.dao.SuperMenuService;
import it.chiarapuleio.exercise.restaurant.entities.*;
import it.chiarapuleio.exercise.restaurant.enums.OrderStatus;
import it.chiarapuleio.exercise.restaurant.enums.TableStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class Runner implements CommandLineRunner {
    @Autowired
    private AnnotationConfigApplicationContext ctx;
    @Autowired
    SuperMenuService smServ;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("----- MENU -----");
        MenuList ml = (MenuList) ctx.getBean("menuList");
        ml.printMenu();

        Table tb = (Table) ctx.getBean("table13");
        System.out.println("----- TABLES -----");
        System.out.println(tb);

        System.out.println("----- ORDERS -----");
        Pizza margherita = (Pizza) ctx.getBean("getMargherita");
        Pizza salami = (Pizza) ctx.getBean("getSalamiPizza");
        Drink water = (Drink) ctx.getBean("getWater");
        List<SuperMenu> orderItems = new ArrayList<>();
        orderItems.add(margherita);
        orderItems.add(margherita);
        orderItems.add(salami);
        orderItems.add(water);
        orderItems.add(water);
        tb.setTableStatus(TableStatus.OCCUPIED);
        Order order = new Order(tb, orderItems, 45, OrderStatus.IN_PROGRESS, 3, LocalTime.now());
        order.printOrder(order);
        double charge = (double) ctx.getBean("tableCharge");
        double price = order.getOrderPrice(orderItems, charge);
        System.out.println("Total charge: " + price);

//        ctx.close();

        System.out.println("----- DB INTERACTIONS -----");
        System.out.println("----- SAVE TOPPINGS -----");
        smServ.save((SuperMenu) ctx.getBean("getCheese"));
        smServ.save((SuperMenu) ctx.getBean("getHam"));
        smServ.save((SuperMenu) ctx.getBean("getOnions"));
        smServ.save((SuperMenu) ctx.getBean("getPineapple"));
        smServ.save((SuperMenu) ctx.getBean("getSalami"));
        System.out.println("----- SAVE PIZZAS -----");
        smServ.save((SuperMenu) ctx.getBean("getMargherita"));
        smServ.save((SuperMenu) ctx.getBean("getHawaiianPizza"));
        smServ.save((SuperMenu) ctx.getBean("getSalamiPizza"));
        System.out.println("----- SAVE DRINKS -----");
        smServ.save((SuperMenu) ctx.getBean("getLemonade"));
        smServ.save((SuperMenu) ctx.getBean("getWater"));
        smServ.save((SuperMenu) ctx.getBean("getWine"));

    }
}
