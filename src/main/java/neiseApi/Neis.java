package neiseApi;

import com.google.gson.Gson;
import neiseApi.payload.sche.ScheResponse;
import neiseApi.payload.sche.ScheShorten;
import neiseApi.payload.sche.SchoolType;
import neiseApi.payload.schoolInfo.SchoolShorten;
import neiseApi.payload.schoolInfo.SchoolInfoResponse;

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


public class Neis {

    /** baseUrls **/
    static final String MEAL = "https://open.neis.go.kr/hub/mealServiceDietInfo";
    static final String SCHOOLINFO = "https://open.neis.go.kr/hub/schoolInfo";
    static final String HIGHSCHE = "https://open.neis.go.kr/hub/hisTimetable";
    static final String CLASSINFO = "https://open.neis.go.kr/hub/classInfo";
    static final String ACADEMICCALANDER = "https://open.neis.go.kr/hub/SchoolSchedule";
    static final String MIDDLESCHE = "https://open.neis.go.kr/hub/misTimetable";
    static final String ELEMENTSCHE = "https://open.neis.go.kr/hub/elsTimetable";

    private String schoolInfo;
    private String highSche;
    private String middleSche;
    private String elementSche;
    private String meal;
    private String classInfo;
    private String serviceKey;
    private String academicCalander;


    /**
     * @brief api 키 등록 및 url에 키 포함되도록 설정
     * @param serviceKey 나이스 교육정보 공개포털 apiKey
     *
     */
    public Neis(String serviceKey) {

        System.setProperty("jsse.enableSNIExtension", "false");
        this.serviceKey = serviceKey;
        this.schoolInfo = SCHOOLINFO + "?KEY=" + this.serviceKey + "&Type=json&pIndex=1&pSize=100";
        this.highSche = HIGHSCHE + "?KEY=" + this.serviceKey + "&Type=json&pIndex=1&pSize=100";
        this.middleSche = MIDDLESCHE + "?KEY=" + this.serviceKey + "&Type=json&pIndex=1&pSize=100";
        this.elementSche = ELEMENTSCHE + "?KEY=" + this.serviceKey + "&Type=json&pIndex=1&pSize=100";
        this.meal = MEAL + "?KEY=" + this.serviceKey + "&Type=json&pIndex=1&pSize=100";
        this.classInfo = CLASSINFO + "?KEY=" + this.serviceKey + "&Type=json&pIndex=1&pSize=100";
        this.academicCalander = ACADEMICCALANDER + "?KEY=" + this.serviceKey + "&Type=json&pIndex=1&pSize=100";

    }

    /**
     *
     * @param schoolName you want to search
     * @return List of SchoolShorten
     * @throws NullPointerException it can be caused by serviceKey Error, or just theres no records.
     */
    public List<SchoolShorten> getSchool(String schoolName){
        String url = this.schoolInfo + "&SCHUL_NM=" + schoolName;
        ArrayList<SchoolShorten> arrayList = new ArrayList<>();
        Gson gson = new Gson();
        List<SchoolInfoResponse.SchoolInfo.Row> rows = gson.fromJson(url, SchoolInfoResponse.class).getSchoolInfo().row;
        if (rows.isEmpty()) throw new NullPointerException();
        rows.stream().map(
                row -> arrayList.add(new SchoolShorten(row.sD_SCHUL_CODE, row.sCHUL_NM, row.aTPT_OFCDC_SC_CODE, row.oRG_RDNZC, row.hMPG_ADRES,
                        row.oRG_TELNO, row.hS_SC_NM, row.sCHUL_KND_SC_NM)
                ));
        return arrayList;
    }


    /**
     *
     * @param schoolCode 학교 코드
     * @return 학교 하나의 정보만 반환함
     */

    public SchoolShorten getOneSchoolByCode(String schoolCode){
        String url = this.schoolInfo + "&SD_SCHUL_CODE=" + schoolCode;
        ArrayList<SchoolShorten> arrayList = new ArrayList<>();
        Gson gson = new Gson();
        List<SchoolInfoResponse.SchoolInfo.Row> rows = gson.fromJson(url, SchoolInfoResponse.class).getSchoolInfo().row;
        if (rows.isEmpty()) throw new NullPointerException();
        rows.stream().map(
                row -> arrayList.add(new SchoolShorten(row.sD_SCHUL_CODE, row.sCHUL_NM, row.aTPT_OFCDC_SC_CODE, row.oRG_RDNZC, row.hMPG_ADRES,
                        row.oRG_TELNO, row.hS_SC_NM, row.sCHUL_KND_SC_NM)
                ));
        return arrayList.get(0);
    }

    /**
     *
     * @param type ex) 고등학교, 중학교
     * @param areaCode ex) G10
     * @param schoolCode 학교 코드
     * @param year ex) 2021
     * @param seperateDay ex) 20210109
     * @param grade ex) 1
     * @param classNum ex) 3
     * @return sepreateDay 당일 시간표 정보
     */

    public List<ScheShorten> getSchedule(SchoolType type, String areaCode, String schoolCode, Long year, long seperateDay, int grade, int classNum){
        ArrayList arrayList = new ArrayList();
        String url;
        if (type.equals(SchoolType.ELEMENT)) url = this.elementSche;
        else if (type.equals(SchoolType.MIDDLE)) url = this.middleSche;
        else url = this.highSche;

        url = url + "&ATPT_OFCDC_SC_CODE=" + areaCode + "&SD_SCHUL_CODE=" + schoolCode
                + "&AY=" + year + "&ALL_TI_YMD=" +seperateDay + "&GRADE=" + grade + "&CLASS_NM=" +classNum;

        Gson gson = new Gson();
        List<ScheResponse.HisTimetable> timetable = gson.fromJson(url, ScheResponse.class).hisTimetable;
        timetable.get(1).row.stream().map(
                row -> arrayList.add(new ScheShorten(timetable.get(0).head.get(0).list_total_count,
                        row.aLL_TI_YMD, row.gRADE, row.cLASS_NM, row.pERIO, row.iTRT_CNTNT))
        );

        return arrayList;
    }

    





}
