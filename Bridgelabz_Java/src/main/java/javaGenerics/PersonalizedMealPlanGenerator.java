package javaGenerics;

/*
 * Problem Statement:
 * Design a Personalized Meal Plan Generator where users can choose
 * different meal categories, such as Vegetarian, Vegan, Keto, or
 * High-Protein.
 *
 * Use the MealPlan interface, a generic Meal<T extends MealPlan>
 * class, and a generic method to generate meal plans while ensuring
 * that only valid meal plan types are accepted.
 *
 * Author: Hemang
 * Date: 14-10-2026
 */

// Interface defining the common behavior of all meal plans.
interface MealPlan {

    // Returns the details of a specific meal plan.
    String getMealDetails();
}

// Represents a vegetarian meal plan.
class VegetarianMeal implements MealPlan {
    public String getMealDetails() {
        return "Vegetarian: Rice, vegetables and paneer";
    }
}

// Represents a vegan meal plan.
class VeganMeal implements MealPlan {
    public String getMealDetails() {
        return "Vegan: Rice, vegetables and tofu";
    }
}

// Represents a keto meal plan.
class KetoMeal implements MealPlan {
    public String getMealDetails() {
        return "Keto: Eggs, avocado and salad";
    }
}

// Represents a high-protein meal plan.
class HighProteinMeal implements MealPlan {
    public String getMealDetails() {
        return "High-Protein: Chicken, eggs and lentils";
    }
}

// Generic Meal class that accepts only MealPlan implementations.
class Meal<T extends MealPlan> {
    private T plan;

    // Stores the selected meal plan.
    public Meal(T plan) {
        this.plan = plan;
    }

    // Returns the stored meal plan.
    public T getPlan() {
        return plan;
    }
}

// Generates and displays personalized meal plan details.
class MealPlanGenerator {

    // Generic method accepts any type that implements MealPlan.
    public <T extends MealPlan> void generateMeal(T plan) {

        // Check that the selected meal plan is not null.
        if (plan != null) {
            System.out.println("Your personalized meal plan:");

            // Display the details of the selected meal.
            System.out.println(plan.getMealDetails());
        } else {
            // Display an error message when no valid plan is provided.
            System.out.println("Invalid meal plan.");
        }
    }
}

// Main class demonstrates generating different meal plans.
public class PersonalizedMealPlanGenerator {
    public static void main(String[] args) {

        // Create the generator used to display meal plans.
        MealPlanGenerator generator = new MealPlanGenerator();

        // Create a vegetarian meal.
        Meal<VegetarianMeal> vegetarian =
                new Meal<>(new VegetarianMeal());

        // Create a vegan meal.
        Meal<VeganMeal> vegan = new Meal<>(new VeganMeal());

        // Create a keto meal.
        Meal<KetoMeal> keto = new Meal<>(new KetoMeal());

        // Create a high-protein meal.
        Meal<HighProteinMeal> protein =
                new Meal<>(new HighProteinMeal());

        // Generate and display each selected meal plan.
        generator.generateMeal(vegetarian.getPlan());
        generator.generateMeal(vegan.getPlan());
        generator.generateMeal(keto.getPlan());
        generator.generateMeal(protein.getPlan());
    }
}