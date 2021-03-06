package effectiveJava.one;

import effectiveJava.one.NyPizza.Size;

public class Demo {
	public static void main(String[] args) throws IllegalAccessException {
		NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8)
				.calories(100).sodium(35).carbohydrate(27).build();
		
		System.out.println(cocaCola.toString());
		
		
		Pizza pizza = new NyPizza.Builder(Size.SMALL)
				.addTopping(Pizza.Topping.SAUSAGE).addTopping(Pizza.Topping.ONION).build();
		Pizza calzone = new Calzone.Builder()
				.addTopping(Pizza.Topping.HAM).sauceInside().build();
		
		System.out.println(pizza);
		System.out.println(calzone);
	}
}
