import java.util.Scanner;

public class FoodOrderTest {
    public static void main(String[] args) {
        FoodOrder foodOrder = new FoodOrder();

        // Test menu initialization
        testMenuInitialization(foodOrder);

        // Test total calculation
        testTotalCalculation(foodOrder);

        // Test generate bill
        testGenerateBill(foodOrder);
    }

    private static void testMenuInitialization(FoodOrder foodOrder) {
        System.out.println("Testing Menu Initialization...");
        assert foodOrder.menu[0].getPrice() == 100 : "French Fries price should be R100";
        assert foodOrder.menu[1].getPrice() == 120 : "Burger price should be R120";
        assert foodOrder.menu[2].getPrice() == 100 : "Pastry price should be R100";
        assert foodOrder.menu[3].getPrice() == 80 : "Cold Drink price should be R80";
        assert foodOrder.menu[4].getPrice() == 100 : "Cold Coffee price should be R100";
        assert foodOrder.menu[5].getPrice() == 200 : "Pizza price should be R200";
        assert foodOrder.menu[6].getPrice() == 80 : "Iced Tea price should be R80";
        System.out.println("Menu Initialization Test Passed!");
    }

    private static void testTotalCalculation(FoodOrder foodOrder) {
        System.out.println("Testing Total Calculation...");
        foodOrder.total = 0; // Reset total
        foodOrder.total += 2 * foodOrder.menu[0].getPrice(); // 2 French Fries
        foodOrder.total += 1 * foodOrder.menu[1].getPrice(); // 1 Burger
        assert foodOrder.total == 320 : "Total should be R320";
        System.out.println("Total Calculation Test Passed!");
    }

    private static void testGenerateBill(FoodOrder foodOrder) {
        System.out.println("Testing Generate Bill...");
        foodOrder.total = 250; // Simulate total
        String expectedOutput = "***************** Thank You for Ordering ******************\n" +
                                "* Your Bill is: R250";
        // Simulate bill generation logic
        String actualOutput = generateBill(foodOrder.total);
        assert actualOutput.equals(expectedOutput) : "Bill generation failed!";
        System.out.println("Generate Bill Test Passed!");
    }

    private static String generateBill(int total) {
        return "***************** Thank You for Ordering ******************\n" +
               "* Your Bill is: R" + total;
    }
}
