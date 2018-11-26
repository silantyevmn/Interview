package silantyevmn.ru.developerinterview.Lesson2.report;

/**
 * Created by silan on 25.11.2018.
 */

public class ReportItem {
    private String description;

    private float amount;

    public ReportItem(String description, float amount){
        this.description = description;
        this.amount = amount;
    }
    public String getDescription(){
        return description;
    }
    public float getAmount(){
        return amount;
    }
}
