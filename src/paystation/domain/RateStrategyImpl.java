package paystation.domain;

public class RateStrategyImpl implements RateStrategy {

    private String dayOfTheWeek;
    private int moneyInserted = 0;
    private int time = 0;
    private String[] WeekDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
    private String[] Weekend = {"Saturday", "Sunday"};

    public RateStrategyImpl (String dayOfTheWeek, int moneyInserted) {
        if((moneyInserted >= 0) && (dayOfTheWeek != null)) {
            this.dayOfTheWeek = dayOfTheWeek;
            this.moneyInserted = moneyInserted;
        }

        if((moneyInserted < 0) && (dayOfTheWeek == null)) {
            System.out.println("moneyInserted is less than 0 and needs to be greater than 0");
            System.out.println("dayOfTheWeek can not be an empty string");
        }
    }

    @Override
    public int calculateTimeLinearRateStrategy(int moneyInserted) {

        time = ((moneyInserted * 2) / 5);

        return time;
    }

    @Override
    public int calculateTimeProgressiveRateStrategy(int moneyInserted) {

        if(moneyInserted < 150) {
            time = ((moneyInserted * 2) / 5);
        }
        if((150 <= moneyInserted) && (moneyInserted < 350)) {
            time = (((moneyInserted - 150) * (3 / 10)) + 60);
        }
        if(moneyInserted >= 350) {
            time = (((moneyInserted - 350) / 5) + 120);
        }

        return time;
    }

    @Override
    public int calculateTimeAlternatingRateStrategy(int moneyInserted) {

        for(int i = 0; i < WeekDays.length; i++) {
            if(WeekDays[i] == dayOfTheWeek) {
                time = ((moneyInserted * 2) / 5);
            }
        }

        for(int i = 0; i < Weekend.length; i++) {
            if(Weekend[i] == dayOfTheWeek) {
                if(moneyInserted < 150) {
                    time = ((moneyInserted * 2) / 5);
                }
                if((150 <= moneyInserted) && (moneyInserted < 350)) {
                    time = (((moneyInserted - 150) * (3 / 10)) + 60);
                }
                if(moneyInserted >= 350) {
                    time = (((moneyInserted - 350) / 5) + 120);
                }
            }
        }

        return time;
    }
}
