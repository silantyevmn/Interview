package silantyevmn.ru.developerinterview.Lesson2.report;

/**
 * Created by silan on 25.11.2018.
 */

public class Programm {
    public static void main(String[] args){
        Report report = new Report(new DisplayReport());
        report.calculate();
        report.output();
        report.setOutputReport(new PrintReport());
        report.output();
    }
}
