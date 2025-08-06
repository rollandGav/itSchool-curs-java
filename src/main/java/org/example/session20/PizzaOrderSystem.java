package org.example.session20;

import java.util.List;

public class PizzaOrderSystem {

    public static void main(String[] args) {
        List<PizzaOrder> orders = List.of(
                new PizzaOrder("Margarita", List.of("branza"), 30),
                new PizzaOrder("Pepperoni", List.of("carne", "ardei"), 40),
                new PizzaOrder("Vegetariana", List.of("ciuperci", "ardei", "masline"), 50),
                new PizzaOrder("Margarita", List.of("ananas"), 50)
        );

        System.out.println(orders);

        //filter and for each
        orders.stream()
                .filter(o -> o.getPrice() > 30)
                .forEach(o -> System.out.println(o.getName()));




    }

}


class PizzaOrder{
    private String name;
    private List<String> toppings;
    private int price;

    public PizzaOrder(String name, List<String> toppings, int price) {
        this.name = name;
        this.toppings = toppings;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public List<String> getToppings() {
        return toppings;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "PizzaOrder{" +
                "name='" + name + '\'' +
                ", toppings=" + toppings +
                ", price=" + price +
                '}';
    }
}
