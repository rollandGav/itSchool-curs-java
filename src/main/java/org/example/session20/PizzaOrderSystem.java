package org.example.session20;

import java.util.List;
import java.util.stream.Collectors;

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

        List<String> messages = orders.stream()
                .map(o -> "Pizza " + o.getName() + " costs " + o.getPrice() + " and has toppings: " + String.join(", ", o.getToppings()))
                .filter(o -> o.contains("Margarita"))
                .collect(Collectors.toList());

        messages.forEach(System.out::println);
        orders.stream()
                .map(PizzaOrder::getName)
                .distinct()
                .sorted()
                .forEach(System.out::println);

        orders.stream()
                .flatMap(o -> o.getToppings().stream())
                .distinct()
                .forEach(System.out::println);

        int total = orders.stream()
                .map(PizzaOrder::getPrice) // o-> o.getPrice()
                .reduce(0, Integer::sum); // .reduce(0, (a, b) -> a + b)
        System.out.println("Total price is "+total);

        long nrOfOrders = orders.stream()
                .filter(o -> o.getToppings().contains("carne"))
                .count();
        System.out.println("Number of orders with meat is "+nrOfOrders);
        boolean hasVeganPizza = orders.stream().anyMatch(o -> !o.getToppings().contains("carne"));
        System.out.println("Has vegan pizza: " + hasVeganPizza);


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
