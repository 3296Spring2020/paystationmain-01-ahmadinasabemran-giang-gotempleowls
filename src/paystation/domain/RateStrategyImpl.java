package paystation.domain;
import java.util.Calendar;

public class RateStrategyImpl implements RateStrategy {

    
    @Override
    public int calculateTimeLinear(int insertedSoFar) {
        
        //Default rate strategy for Alphatown
        int time;
        time = (insertedSoFar * 2) / 5;
        return time;

    }

    @Override
    public int calculateTimeProgressive(int insertedSoFar) {
        
        //Betatown rate strategy
        int time = 0;
        
        if(insertedSoFar < 150) { //x < 150
            time = ((insertedSoFar * 2) / 5);
        }
        if((150 <= insertedSoFar) && (insertedSoFar < 350)) { //150 <= x < 350
            time = (((insertedSoFar - 150) * (3 / 10)) + 60);
        }
        if(insertedSoFar >= 350) { //350 <= x
            time = (((insertedSoFar - 350) / 5) + 120);
        }
        
        return time;

    }

    @Override
    public int calculateTimeAlternating(int insertedSoFar) {
        
        //Gammatown rate strategy
        //On weekdays uses progressive rate
        //On weekends uses linear rate
        //Use calendar class to determine day of the week
        int time;
        Calendar calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        
        //On weekends
        if(dayOfWeek == Calendar.SATURDAY 
                || dayOfWeek == Calendar.SUNDAY){
            
            //Use progressive rate
            time = calculateTimeProgressive(insertedSoFar);

        } else{     //Else on weekdays
            
            time = ((insertedSoFar * 2) / 5);
        }
        
        return time;

    }
}
