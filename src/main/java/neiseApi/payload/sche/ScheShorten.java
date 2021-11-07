package neiseApi.payload.sche;

public class ScheShorten {
    private final int totalCount;
    private final String day;
    private final String grade;
    private final String classNum;
    private final String period;
    private final String subject;

    public ScheShorten(int totalCount, String day, String grade, String classNum, String period, String subject) {
        this.totalCount = totalCount;
        this.day = day;
        this.grade = grade;
        this.classNum = classNum;
        this.period = period;
        this.subject = subject;
    }
}
