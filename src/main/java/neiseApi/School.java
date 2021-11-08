package neiseApi;

import neiseApi.exception.InvaildDateException;
import neiseApi.payload.sche.ScheShorten;
import neiseApi.payload.sche.SchoolType;
import neiseApi.payload.schoolInfo.ReturnType;
import neiseApi.payload.schoolInfo.SchoolInfoResponse;
import neiseApi.payload.schoolInfo.SchoolShorten;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class School extends Neis {


    private List<SchoolShorten> schoolShortens;
    private SchoolShorten schoolShorten;
    /**
     * @param serviceKey neisApi 키
     */
    public School(String serviceKey) {
        super(serviceKey);
    }

    /**
     *
     * @param schoolName - 검색할 문장 ex) 대덕 or 대덕소프트 or 대덕소프트웨어마이스터고등학교
     * @return DetailSchool List (초, 중, 고 모두 포함)
     */
    public List<SchoolShorten> getSchoolDetailInfo(String schoolName) throws IOException {
        try{
            this.schoolShortens = getSchool(schoolName);
            return this.schoolShortens;
        } catch (IOException e){
            throw new IOException();
        }
    }

    /**
     *
     * @param schoolName 서치문
     * @return 리턴시 가장 정확도 높은 SchoolShorten
     * @throws IOException
     */
    public SchoolShorten getFirstSchoolDetailInfo(String schoolName) throws IOException {
        try{
            this.schoolShorten = getSchool(schoolName).get(0);
            return this.schoolShorten;
        } catch (IOException e){
            throw new IOException();
        }
    }


    /**
     *
     * @param schoolCode 학교 코드
     * @param grade 학년 ex) 1
     * @param classNum 반 ex) 3
     * @param startDate 검색 시작 날짜 ex) 20211104
     * @param endDate 검색 끝 날짜 ex) 20211105
     * @return
     */

    public List<List<ScheShorten>> getSchoolSchedule(String schoolCode, int grade, int classNum , int startDate, int endDate) throws IOException{
        if ((startDate - endDate) > 0) throw new InvaildDateException();
        List<List<ScheShorten>> scheduleList = new ArrayList<>(new ArrayList<>());
        SchoolShorten schoolShorten = getOneSchoolByCode(schoolCode);
        for (int i = startDate; startDate <= endDate; startDate++) {
            scheduleList.add(getSchedule(schoolShorten ,
                    i/10000, i, grade, classNum));
        }
        return scheduleList;
    }

    /**
     * @param grade 원하는 학년
     * @param classNum 반
     * @param startDate 검색 시작일
     * @param endDate 검색 종료일
     * @return List of List of ScheShorten
     * @throws IOException
     */
   public List<List<ScheShorten>> getSchoolSchedule(int grade, int classNum , int startDate, int endDate) throws IOException{
        if ((startDate - endDate) > 0) throw new InvaildDateException();
        List<List<ScheShorten>> scheduleList = new ArrayList<>(new ArrayList<>());

        for (int i = startDate; startDate <= endDate; startDate++) {
            scheduleList.add(getSchedule(this.schoolShorten,
                    i/10000, i, grade, classNum));
        }
        return scheduleList;
    }




}
