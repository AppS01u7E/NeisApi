package main;

import payload.SchoolShorten;

import java.util.List;

public class School extends NeisApi{

    /**
     * @param serviceKey neisApi 키
     */
    public School(String serviceKey) {
        super(serviceKey);
    }


    public List<SchoolShorten> getSchoolInfo(String key, String schoolName){
        return getSchool(schoolName);
    }


}
