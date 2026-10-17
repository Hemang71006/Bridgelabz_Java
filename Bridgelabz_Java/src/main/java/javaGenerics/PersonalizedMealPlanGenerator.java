
package javaGenerics;

interface MealPlan {
    String getMealDetails();
}

class VegetarianMeal implements MealPlan {
    public String getMealDetails() {
        return "Vegetarian: Rice, vegetables and paneer";
    }
}

class VeganMeal implements MealPlan {
    public String getMealDetails() {
        return "Vegan: Rice, vegetables and tofu";
    }
}

class KetoMeal implements MealPlan {
    public String getMealDetails() {
        return "Keto: Eggs, avocado and salad";
    }
}

class HighProteinMeal implements MealPlan {
    public String getMealDetails() {
        return "High-Protein: Chicken, eggs and lentils";
    }
}

class Meal<T extends MealPlan> {
    private T plan;

    public Meal(T plan) {
        this.plan = plan;
    }

    public T getPlan() {
        return plan;
    }
}

class MealPlanGenerator {
    public <T extends MealPlan> void generateMeal(T plan) {
        if (plan != null) {
            System.out.println("Your personalized meal plan:");
            System.out.println(plan.getMealDetails());
        } else {
            System.out.println("Invalid meal plan.");
        }
    }
}

public class PersonalizedMealPlanGenerator {
    public static void main(String[] args) {
        MealPlanGenerator generator = new MealPlanGenerator();

        Meal<VegetarianMeal> vegetarian =
                new Meal<>(new VegetarianMeal());

        Meal<VeganMeal> vegan = new Meal<>(new VeganMeal());

        Meal<KetoMeal> keto = new Meal<>(new KetoMeal());

        Meal<HighProteinMeal> protein =
                new Meal<>(new HighProteinMeal());

        generator.generateMeal(vegetarian.getPlan());
        generator.generateMeal(vegan.getPlan());
        generator.generateMeal(keto.getPlan());
        generator.generateMeal(protein.getPlan());
    }
}

