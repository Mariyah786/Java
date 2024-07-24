package holidaybonus;

public class HolidayBonus {

    private static final double BONUS_MULTIPLIER = 2000.0;

    public static double[] calculateHolidayBonus(double[][] sales) {
        double[] bonuses = new double[sales.length];
        for (int i = 0; i < sales.length; i++) {
            double rowTotal = TwoDimRaggedArrayUtility.getRowTotal(sales, i);
            bonuses[i] = rowTotal * BONUS_MULTIPLIER;
        }
        return bonuses;
    }

    public static double calculateTotalHolidayBonus(double[][] sales) {
        double totalBonus = 0;
        double[] bonuses = calculateHolidayBonus(sales);
        for (double bonus : bonuses) {
            totalBonus += bonus;
        }
        return totalBonus;
    }
}
