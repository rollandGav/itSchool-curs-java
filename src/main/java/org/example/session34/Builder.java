package org.example.session34;

import java.util.ArrayList;
import java.util.List;

class Pizza{
    private String blat;
    private String sos;
    private List<String> toppings;

    public static class PizzaBuilder{
        private Pizza pizza;
        public PizzaBuilder(){
            pizza = new Pizza();
            pizza.toppings = new ArrayList<>();
        }

        public PizzaBuilder blat(String blat){
            pizza.blat = blat;
            return this;
        }
        public PizzaBuilder sos(String sos){
            pizza.sos = sos;
            return this;
        }
        public PizzaBuilder addToppings(String topping){
            pizza.toppings.add(topping);
            return this;
        }

        public Pizza build(){
            return pizza;
        }
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "toppings=" + toppings +
                ", sos='" + sos + '\'' +
                ", blat='" + blat + '\'' +
                '}';
    }
}

class PizzaB{
    private String blat;
    private String sos;
    private List<String> toppings;

    public PizzaB withBlat(String blat){
        this.blat = blat;
        return this;
    }
    public PizzaB withSos(String sos){
        this.sos = sos;
        return this;
    }
    public PizzaB withTopping(String topping){
        if(toppings == null) toppings = new ArrayList<>();
        toppings.add(topping);
        return this;
    }

    @Override
    public String toString() {
        return "PizzaB{" +
                "blat='" + blat + '\'' +
                ", sos='" + sos + '\'' +
                ", toppings=" + toppings +
                '}';
    }
}


public class Builder {
    public static void main(String[] args) {
        Pizza pizza = new Pizza.PizzaBuilder()
                .blat("Subtire")
                .sos("Rosii")
                .addToppings("MOzzarela")
                .addToppings("Pui")
                .addToppings("Ciuperci")
                .addToppings("Ardei")
                .build();
        System.out.println(pizza.toString());

        PizzaB pizzaB = new PizzaB()
                .withBlat("Pufos")
                .withSos("Rosii")
                .withTopping("Pui")
                .withTopping("Ananas")
                .withTopping("Para")
                .withTopping("Porumb");
        System.out.println(pizzaB);

    }
}
