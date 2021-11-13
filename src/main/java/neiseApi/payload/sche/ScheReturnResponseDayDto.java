package neiseApi.payload.sche;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class ScheReturnResponseDayDto implements Serializable {

    private final int grade;
    private final int classNum;
    private final int totalCount;
    private final int day;
    private List<Subject> subjects = new ArrayList<>();

    public static class Subject {
        public String getName() {
            return name;
        }

        public int getPeriod() {
            return period;
        }

        private final String name;
        private final int period;

        public Subject(String name, int period) {
            this.name = name;
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
        return this.grade;
    }

    public int getClassNum() {
        return this.classNum;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public int getDay() {
        return this.day;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

}
