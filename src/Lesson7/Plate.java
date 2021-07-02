package Lesson7;

public class Plate {


    private int foodAmount;
    public Plate(int foodAmount) {
        this.foodAmount = foodAmount;
    }

    public void PlateFullnessInfo() {
        System.out.printf("Available food amount: %d%n", foodAmount);
    }

    public void DecreaseFoodAmount(int n) {
        foodAmount -= n;
    }

    public void RefillPlate(int n) {
        foodAmount += n;
    }

    public int getFoodAmount() {
        return foodAmount;
    }
}
