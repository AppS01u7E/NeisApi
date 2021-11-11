package neiseApi.payload.sche;

public class ScheShortenBlock {

    private final int totalCount;
    private final int day;
    private final int grade;
    private final int classNum;
    private final int period;
    private final String subject;

    public ScheShortenBlock(int totalCount, int day, int grade, int classNum, int period, String subject) {
        this.totalCount = totalCount;
        this.day = day;
        this.grade = grade;
        this.classNum = classNum;
        this.period = period;
        this.subject = subject;
    }

    public int getTotalCount() {
        return totalCount;
    }


    public int getDay() {
        return day;
    }

    public int getGrade() {
        return grade;
    }

    public int getClassNum() {
        return classNum;
    }

    public int getPeriod() {
        return period;
    }

    public String getSubject() {
        return subject;
    }
}
