package sfatechgroup.inventory.model;

/**
 * Created by D-1P-44 on 9/20/2016.
 */
public class YearSpinnerModel {

    public int year;
    public String year_show;

    public YearSpinnerModel(int year, String year_show) {
        this.year = year;
        this.year_show = year_show;
    }

    @Override
    public String toString() {
        return year_show;
    }
}
