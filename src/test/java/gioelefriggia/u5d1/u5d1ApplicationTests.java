import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import gioelefriggia.u5d1.entities.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class u5d1ApplicationTests {

	@Test
	void testPizzaCreation() {
		Pizza pizza = new Pizza("Test Pizza", 9.99, 1200);
		assertEquals("Test Pizza", pizza.getName());
		assertEquals(9.99, pizza.getPrice());
		assertEquals(1200, pizza.getCalories());
	}

	@Test
	void testAddTopping() {
		Pizza pizza = new Pizza("Test Pizza", 9.99, 1200);
		Topping topping = new Topping("Test Topping", 1.50, 50);
		pizza.addTopping(topping);
		assertEquals(1, pizza.getToppings().size());
		assertEquals(topping, pizza.getToppings().get(0));
	}

	@Test
	void testTotalAmountCalculation() {
		Order order = new Order(2, 1);
		Pizza pizza = new Pizza("Test Pizza", 9.99, 1200);
		Drink drink = new Drink("Test Drink", 2.50, 100);
		order.addItem(pizza);
		order.addItem(drink);
		assertEquals(12.49, order.getTotalAmount());
	}

	@Test
	void testTotalCaloriesCalculation() {
		Order order = new Order(2, 1);
		Pizza pizza = new Pizza("Test Pizza", 9.99, 1200);
		Drink drink = new Drink("Test Drink", 2.50, 100);
		order.addItem(pizza);
		order.addItem(drink);

		int totalCalories = pizza.getCalories() + drink.getCalories();
		assertEquals(totalCalories, order.calculateTotalCalories());
	}

	@ParameterizedTest
	@CsvSource({"1200, 100, 1300", "1400, 200, 1600", "800, 150, 950"})
	void testTotalCaloriesCalculationParametric(int pizzaCalories, int drinkCalories, int expectedTotalCalories) {
		Order order = new Order(2, 1);
		Pizza pizza = new Pizza("Test Pizza", 9.99, pizzaCalories);
		Drink drink = new Drink("Test Drink", 2.50, drinkCalories);
		order.addItem(pizza);
		order.addItem(drink);

		assertEquals(expectedTotalCalories, order.calculateTotalCalories());
	}
}
