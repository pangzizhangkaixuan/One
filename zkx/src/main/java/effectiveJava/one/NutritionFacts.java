package effectiveJava.one;

/**
 * 建造者模式（创建不可变对象）
 * (在Activity工作流程框架中有使用)
 * 拥有重叠构造器的安全性和JavaBeans模式的可读性。
 * 在build方法可以更快的检验参数有效性，但对象域依然要再一次检测
 */
public class NutritionFacts {
	private final int servingSize;
	private final int servings;
	private final int calories;
	private final int fat;
	private final int sodium;
	private final int carbohydrate;
	

	public NutritionFacts(Builder builder) throws IllegalArgumentException {
		servingSize = builder.servingSize;
		servings = builder.servings;
		calories = builder.calories;
		fat = builder.fat;
		sodium = builder.sodium;
		carbohydrate = builder.carbohydrate;
		
		//校验参数有效性
		checkValue();
	}
	
	public static class Builder {
		private final int servingSize;
		private final int servings;
		
		private int calories = 0;
		private int fat = 0;
		private int sodium = 0;
		private int carbohydrate = 0;
		
		public Builder(int servingSize, int servings) {
			this.servingSize = servingSize;
			this.servings = servings;
		}
		
		public Builder calories(int val) {
			calories = val;
			return this;
		}
		public Builder fat(int val) {
			fat = val;
			return this;
		}
		public Builder sodium(int val) {
			sodium = val;
			return this;
		}
		public Builder carbohydrate(int val) {
			carbohydrate = val;
			return this;
		}
		
		public NutritionFacts build() throws IllegalArgumentException {
			return new NutritionFacts(this);
		}
	}
	
	/**
	 * 对象域参数检查
	 * @throws IllegalAccessException 
	 */
	private void checkValue() throws IllegalArgumentException {
		if (servingSize == 10) {
			throw new IllegalArgumentException("servingSize" + servingSize + "超出数值范围");
		}
	}
	
	@Override
	public String toString() {
		return "NutritionFacts [servingSize=" + servingSize + ", servings=" + servings + ", calories=" + calories
				+ ", fat=" + fat + ", sodium=" + sodium + ", carbohydrate=" + carbohydrate + "]";
	}
}
