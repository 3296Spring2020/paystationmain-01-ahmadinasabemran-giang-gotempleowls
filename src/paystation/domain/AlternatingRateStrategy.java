package paystation.domain;

public class AlternatingRateStrategy implements RateStrategy {

    private String dayOfTheWeek;
    private int moneyInserted = 0;
    private int time = 0;
    private String[] WeekDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
    private String[] Weekend = {"Saturday", "Sunday"};

    public AlternatingRateStrategy (String dayOfTheWeek, int moneyInserted) {
        this.dayOfTheWeek = dayOfTheWeek;
        this.moneyInserted = moneyInserted;
    }

    @Override
    public int calculateTime(int moneyInserted) {

        for(int i = 0; i < WeekDays.length; i++) {
            if(WeekDays[i] == dayOfTheWeek) {
                time = ((moneyInserted * 2) / 5);
            }
        }

        // less than an hour (60 Min) so amount <150 */
        // time = (amount * 2) / 5;
        // between 1st hour and 2nd hour so 350>amount >=150 */
        // time = (amount - 150) * (3 / 10) + 60;
        // greater than 2 hours so amount >= 350 */
        // time = (amount - 350) / 5 + 120;

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
