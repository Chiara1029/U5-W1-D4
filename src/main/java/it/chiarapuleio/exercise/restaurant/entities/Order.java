package it.chiarapuleio.exercise.restaurant.entities;

import it.chiarapuleio.exercise.restaurant.abstractClass.SuperMenu;
import it.chiarapuleio.exercise.restaurant.enums.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
public class Order {
    private Table table;
    private List<SuperMenu> orderList;
    private int numberOrd;
    private OrderStatus orderStatus;
    private int totalCostumers;
    private LocalTime orderTime;


    public Order(Table table, List<SuperMenu> orderList, int numberOrd, OrderStatus orderStatus, int totalCostumers, LocalTime orderTime) {
        this.table = table;
        this.orderList = orderList;
        this.numberOrd = numberOrd;
        this.orderStatus = orderStatus;
        this.totalCostumers = totalCostumers;
        this.orderTime = orderTime;
    }

    public double getOrderPrice(List<SuperMenu> orderItems, double charge){
        double orderPrice = 0.0;
        for(SuperMenu item : orderItems){
            orderPrice += item.getPrice();
        }
        orderPrice += charge*totalCostumers;
        return orderPrice;
    }

    public void printOrder(Order order) {
        System.out.println("----- Order -----");
        System.out.println("Table: " + order.getTable());
        System.out.println("Order n°: " + order.getNumberOrd());
        System.out.println("Customers: " + order.getTotalCostumers());
        System.out.println("Status: " + order.getOrderStatus());
        System.out.println("Time: " + order.getOrderTime());

        this.orderList.forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "Order{" +
                "table=" + table.getTableNumber() +
                ", orderList=" + orderList +
                ", numberOrd=" + numberOrd +
                ", orderStatus=" + orderStatus +
                ", totalCostumers=" + totalCostumers +
                ", orderTime=" + orderTime +
                '}';
    }
}
