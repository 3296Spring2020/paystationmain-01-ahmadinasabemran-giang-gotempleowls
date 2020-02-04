public class RateStrategyImpl implements RateStrategy {

    private String[] WeekDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
    private String[] Weekend = {"Saturday", "Sunday"};

    @Override
    public double calculateTimeLinearRateStrategy(double moneyInserted) {

        double time;
        time = (moneyInserted * 2.0) / 5.0;
        return time;

    }

    @Override
    public double calculateTimeProgressiveRateStrategy(double moneyInserted) {

        double time = 0.0;

        if(moneyInserted < 150.0) {
            time = ((moneyInserted * 2.0) / 5.0);
        }
        if((150.0 <= moneyInserted) && (moneyInserted < 350.0)) {
            time = (((moneyInserted - 150.0) * (3.0 / 10.0)) + 60.0);
        }
        if(moneyInserted >= 350.0) {
            time = (((moneyInserted - 350.0) / 5.0) + 120.0);
        }

        return time;

    }

    @Override
    public double calculateTimeAlternatingRateStrategy(String dayOfTheWeek, double moneyInserted) {

        double time = 0.0;

        for (String weekDay : WeekDays)
            if (weekDay.equals(dayOfTheWeek)) {
                time = ((moneyInserted * 2.0) / 5.0);
                break;
            }

        for (String weekend : Weekend) {
            if (weekend.equals(dayOfTheWeek)) {
                if (moneyInserted < 150.0) {
                    time = ((moneyInserted * 2.0) / 5.0);
                }
                if ((150.0 <= moneyInserted) && (moneyInserted < 350.0)) {
                    time = (((moneyInserted - 150.0) * (3.0 / 10.0)) + 60.0);
                }
                if (moneyInserted >= 350.0) {
                    time = (((moneyInserted - 350.0) / 5.0) + 120.0);
                }
            }
        }

        return time;

    }
}
