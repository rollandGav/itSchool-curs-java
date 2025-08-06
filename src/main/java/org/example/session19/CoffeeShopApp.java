package org.example.session19;


import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class CoffeeShopApp {
    public static void main(String[] args) {
        GreetingService greting = (name) -> System.out.println("Hello customer " + name + " welcome to out coffee shop");
        greting.greet("Marcel");

        Supplier<String> idGenerator = () -> "UUID-" + UUID.randomUUID().toString().substring(0,8);

        Function<String, Order> createOrder = (drink) -> new Order(idGenerator.get(), drink);

        List<Order> orders = Arrays.asList(
                createOrder.apply("Latte cu migdale"),
                createOrder.apply("Espresso"),
                createOrder.apply("Cappuccino"),
                createOrder.apply("Latte cu soia")
        );

        System.out.println("Orders:");
        Consumer<Order> printOrder = order -> System.out.println(order);
        orders.forEach(printOrder);

        Predicate<Order> isPlantBased = order -> order.getDrink().toLowerCase().contains("migdale") || order.getDrink().toLowerCase().contains("soia");
        List<Order> veganOrders = orders.stream()
                .filter(isPlantBased)
                .collect(Collectors.toList());
        System.out.println("comenzi vegane: ");
        veganOrders.forEach(printOrder);

        Map<String, Double> priceList = Map.of(
                "Latte cu migdale", 10.0,
                "Espresso", 7.0,
                "Cappuccino", 12.9,
                "Latte cu soia", 14.0
                );

        BinaryOperator<Double> totalCalc = Double::sum;
        double totalprice = orders.stream()
                .map(order -> priceList.getOrDefault(order.getDrink(), 0.0))
                .reduce(0.0, totalCalc);

        System.out.println(totalprice);
    }
}

@FunctionalInterface
interface GreetingService{
    void greet(String name);
}

class Order{
    private String id;
    private String drink;

    public Order() {
    }

    public Order(String id, String drink) {
        this.id = id;
        this.drink = drink;
    }

    public String getDrink() {
        return drink;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", drink='" + drink + '\'' +
                '}';
    }
}