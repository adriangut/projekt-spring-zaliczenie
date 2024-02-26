// Dekorator to wzorzec strukturalny, który pozwala dynamicznie dodawać obiektom nowe funkcjonalnosci.
// Robi to poprzez opakowanie w obiekty posiadające daną funkcjonalnosc.

interface Coffee {
    String getIngredients();
}

class BasicCoffee implements Coffee {
    @Override
    public String getIngredients() {
        return "Coffee";
    }
}

abstract class CoffeeDecorator implements Coffee {
    protected final Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee decoratedCoffee) {
        this.decoratedCoffee = decoratedCoffee;
    }

    public String getIngredients() {
        return decoratedCoffee.getIngredients();
    }
}

class Milk extends CoffeeDecorator {
    public Milk(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    public String getIngredients() {
        return super.getIngredients() + ", Milk";
    }
}

class Sugar extends CoffeeDecorator {
    public Sugar(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    public String getIngredients() {
        return super.getIngredients() + ", Sugar";
    }
}

public class DecoratorPatternExample {
    public static void main(String[] args) {
        // możemy dowolnie mieszać i aplikować dekoratory w celu dostosowania instancji klasy bazowej do naszych potrzeb
        Coffee complexCoffee = new Sugar(
                new Milk(
                        new Milk(
                                new SimpleCoffee()
                        )
                )
        );
        // wypisze "Skład: Coffee, Milk, Milk, Sugar"
        System.out.println("Skład: " + complexCoffee.getIngredients());
    }
}
