package effectiveJava.one;

public class Demo {
	public static void main(String[] args) throws IllegalAccessException {
		NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8)
				.calories(100).sodium(35).carbohydrate(27).build();
		
		System.out.println(cocaCola.toString());
		
	}
}
