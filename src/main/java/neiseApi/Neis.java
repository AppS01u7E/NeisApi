package main;

import com.google.gson.Gson;
import payload.SchoolShorten;
import payload.SchoolInfoResponse;

import java.util.ArrayList;
import java.util.List;


/**
 * @mainpage JAVA SDK
 * @section intro 소개
 *     - 소개 : Neise API
 *     - 버전 : 1.0.0
 *     - 설명 : Neise Api를 Java Code에서 사용할 수 있도록 만들어진 code입니다.
 * @section CreateInfo 작성 정보
 *     - 작성자 : Jinwoo794533
 *     - 작성일 : 2021/11/07 *
 * @section common 기타 정보
 *     - 저작권 MIT
 */


public class NeisApi {
    /** baseUrls **/
    static final String MEAL = "https://open.neis.go.kr/hub/mealServiceDietInfo";
    static final String SCHOOLINFO = "https://open.neis.go.kr/hub/schoolInfo";
    static final String SCHEDULE = "https://open.neis.go.kr/hub/hisTimetable";
    static final String CLASSINFO = "https://open.neis.go.kr/hub/classInfo";


    private String schoolInfo;
    private String schedule;
    private String meal;
    private String classInfo;
    private String serviceKey;

    /**
     *
     * @param serviceKey neisApi 키
     *
     */

    public NeisApi(String serviceKey) {
        // disable SNI. Java 1.7 bug
        System.setProperty("jsse.enableSNIExtension", "false");
        this.serviceKey = serviceKey;
        this.schoolInfo = SCHOOLINFO + "?KEY=" + this.serviceKey + "&Type=json";
        this.schedule = SCHEDULE + "?KEY=" + this.serviceKey + "&Type=json";
        this.meal = MEAL + "?KEY=" + this.serviceKey + "&Type=json";
        this.classInfo = CLASSINFO + "?KEY=" + this.serviceKey + "&Type=json";
    }

    /**
     *
     * @param schoolName which do you want to search
     * @return Schools List
     */


    public List<SchoolShorten> getSchool(String schoolName){
        ArrayList<SchoolShorten> arrayList = new ArrayList<>();

        Gson gson = new Gson();

        gson.fromJson(this.schoolInfo + "&SCHUL_NM=" + schoolName, SchoolInfoResponse.class).getSchoolInfo().row.stream().map(
                row -> arrayList.add(new SchoolShorten(row.sD_SCHUL_CODE, row.sCHUL_NM, row.aTPT_OFCDC_SC_CODE, row.oRG_RDNZC, row.hMPG_ADRES,
                        row.oRG_TELNO, row.hS_SC_NM, row.sCHUL_KND_SC_NM)
        ));
        return arrayList;
    }

}
