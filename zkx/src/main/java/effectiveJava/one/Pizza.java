package effectiveJava.one;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/**
 * 建造者模式应用于层级结构
 * 层级根部抽象类
 */
public abstract class Pizza {
	public enum Topping {HAM, MUSHROOM, ONION, PEPPER, SAUSAGE};
	final Set<Topping> toppings;
	
	abstract static class Builder<T extends Builder<T>> {
		EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
		
		public T addTopping(Topping topping) {
			toppings.add(Objects.requireNonNull(topping));
			return self();
		}
		
		abstract Pizza build();
		
		//继承重写这个方法时必须返回“this”
		protected abstract T self();
	}
	
	Pizza(Builder<?> builder) {
		toppings = builder.toppings.clone();
	}
}
