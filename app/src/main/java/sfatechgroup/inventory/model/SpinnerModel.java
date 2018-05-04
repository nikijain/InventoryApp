package sfatechgroup.inventory.model;

/**
 * Created by nikita on 11/14/2016.
 */
public class SpinnerModel {
    public String id;
    public String name;

    public SpinnerModel(String id, String text_name) {

        this.id = id;
        this.name = text_name;
    }

    @Override
    public String toString() {
        return name;
    }

}
