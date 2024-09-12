import java.util.Scanner;

// Base class representing a food item
class FoodItem {
    protected String name;
    protected int price;

    public FoodItem(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}

// Main class for the food ordering system
public class FoodOrder {
    public FoodItem[] menu; // Array to hold food items
    public int total = 0;
    private Scanner sc = new Scanner(System.in);

    public FoodOrder() {
        // Initializing the menu with food items
        menu = new FoodItem[]{
            new FoodItem("French Fries", 100),
            new FoodItem("Burger", 120),
            new FoodItem("Pastry", 100),
            new FoodItem("Cold Drink", 80),
            new FoodItem("Cold Coffee", 100),
            new FoodItem("Pizza", 200),
            new FoodItem("Iced Tea", 80)
        };
    }

    public static void main(String[] args) {
        FoodOrder foodOrder = new FoodOrder();
        foodOrder.displayMenu();
        foodOrder.order();
    }

    // Method for displaying the food menu
    public void displayMenu() {
        System.out.println("**************** Welcome To Our Cafe ****************");
        System.out.println("=====================================================");
        for (int i = 0; i < menu.length; i++) {
            System.out.println("           " + (i + 1) + ". " + menu[i].getName() + "          R" + menu[i].getPrice());
        }
        System.out.println("           8. Exit");
        System.out.println("======================================================");
        System.out.println("          What Do You Want to Order Today?");
    }

    // Method to order food items using switch statements
    public void order() {
        while (true) {
            System.out.print("Enter Your Choice: ");
            int choice = sc.nextInt();
            if (choice < 1 || choice > menu.length + 1) {
                System.out.println("Invalid Choice");
                continue;
            }
            if (choice == 8) {
                generateBill();
                System.exit(0);
            }

            System.out.println("You have Selected " + menu[choice - 1].getName());
            System.out.print("Enter the desired Quantity: ");
            int quantity = sc.nextInt();
            total += quantity * menu[choice - 1].getPrice();

            System.out.print("Do you wish to order anything else (Y/N): ");
            String again = sc.next();
            if (!again.equalsIgnoreCase("Y")) {
                generateBill();
                System.exit(0);
            }
        }
    }

    // Method to generate the bill
    public void generateBill() {
        System.out.println();
        System.out.println("***************** Thank You for Ordering ******************");
        System.out.println("* Your Bill is: R" + total);
    }
}