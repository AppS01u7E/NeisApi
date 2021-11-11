package neiseApi.payload.sche;


import java.util.ArrayList;
import java.util.List;

public class ScheReturnResponseDayDto {

    private int grade;
    private int classNum;
    private int totalCount;
    private int day;
    private List<Subject> subjects = new ArrayList<>();

    public static class Subject {
        private String name;
        private int period;

        public Subject(String subject, int period) {
            this.name = subject;
            this.period = period;
        }

    }


    public ScheReturnResponseDayDto(int grade, int classNum, int totalCount, int day, List<Subject> subjects) {
        this.grade = grade;
        this.classNum = classNum;
        this.totalCount = totalCount;
        this.day = day;
        this.subjects = subjects;
    }

    public int getGrade() {
        return grade;
    }

    public int getClassNum() {
        return classNum;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public int getDay() {
        return day;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public ScheReturnResponseDayDto setGrade(int grade) {
        this.grade = grade;
        return this;
    }

    public ScheReturnResponseDayDto setClassNum(int classNum) {
        this.classNum = classNum;
        return this;
    }

    public ScheReturnResponseDayDto setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        return this;
    }

    public ScheReturnResponseDayDto setDay(int day) {
        this.day = day;
        return this;
    }

    public ScheReturnResponseDayDto setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
        return this;
    }

}
