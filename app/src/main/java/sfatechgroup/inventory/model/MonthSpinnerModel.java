package sfatechgroup.inventory.model;

/**
 * Created by D-1P-44 on 9/20/2016.
 */
public class MonthSpinnerModel {

    public String month;
    public String month_show;

    public MonthSpinnerModel(String month, String month_show) {
        this.month = month;
        this.month_show = month_show;
    }

    @Override
    public String toString() {
        return month_show;
    }
}
