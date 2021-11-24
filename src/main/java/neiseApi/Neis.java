package neiseApi;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import neiseApi.exception.TooBigRegioinException;
import neiseApi.payload.sche.ScheResponse;
import neiseApi.payload.sche.ScheShortenBlock;
import neiseApi.payload.sche.SchoolType;
import neiseApi.payload.schoolInfo.SchoolShorten;
import neiseApi.payload.schoolInfo.SchoolInfoResponse;

import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;


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
    private final DateTimeFormatter intDateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");


    /**
     * @brief api 키 등록 및 url에 키 포함되도록 설정
     * @param serviceKey 나이스 교육정보 공개포털 apiKey
     *
     */
    protected Neis(String serviceKey) {

        System.setProperty("jsse.enableSNIExtension", "false");
        this.serviceKey = serviceKey;
        this.schoolInfo = SCHOOLINFO + ("?KEY=") + (this.serviceKey) + ("&Type=json&pIndex=1&pSize=100");
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
    protected List<SchoolShorten> getSchool(String schoolName) throws IOException{
        URL url = new URL(this.schoolInfo + "&SCHUL_NM=" + URLEncoder.encode(schoolName));

        ArrayList<SchoolShorten> arrayList = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        List<SchoolInfoResponse.SchoolInfo.Row> rows = mapper.readValue(url, SchoolInfoResponse.class).getSchoolInfo();
        if (rows.isEmpty()) throw new NullPointerException();
        if (rows.size() >= 30) throw new TooBigRegioinException();
        rows.stream().map(
                row -> arrayList.add(new SchoolShorten(row.getsD_SCHUL_CODE(), row.getsCHUL_NM(), row.getaTPT_OFCDC_SC_CODE(), row.getoRG_RDNZC(), row.gethMPG_ADRES(),
                        row.getoRG_TELNO(), row.gethS_SC_NM(), row.getsCHUL_KND_SC_NM())
                )).collect(Collectors.toList());
        return arrayList;
    }


    /**
     *
     * @param schoolCode 학교 코드
     * @return 학교 하나의 정보만 반환함
     */

    protected SchoolShorten getOneSchoolByCode(String schoolCode) throws IOException{
        URL url = new URL(this.schoolInfo + "&SD_SCHUL_CODE=" + Integer.valueOf(schoolCode));

        ArrayList<SchoolShorten> arrayList = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        List<SchoolInfoResponse.SchoolInfo.Row> rows = mapper.readValue(url, SchoolInfoResponse.class).getSchoolInfo();
        if (rows.isEmpty()) throw new NullPointerException();
        rows.stream().map(
                row -> arrayList.add(new SchoolShorten(row.getsD_SCHUL_CODE(), row.getsCHUL_NM(), row.getaTPT_OFCDC_SC_CODE(), row.getoRG_RDNZC(), row.gethMPG_ADRES(),
                        row.getoRG_TELNO(), row.gethS_SC_NM(), row.getsCHUL_KND_SC_NM())
                )).collect(Collectors.toList());
        return arrayList.get(0);
    }

    /**
     * @param year ex) 2021
     * @param seperateDay ex) 20210109
     * @param grade ex) 1
     * @param classNum ex) 3
     * @return sepreateDay 당일 시간표 정보
     */

    protected List<ScheShortenBlock> getSchedule(SchoolType type, String areaCode, String schoolCOde, int year, int seperateDay, int grade, int classNum) throws IOException{
        List<ScheShortenBlock> arrayList = new ArrayList();
        String sche;
        if (type.equals(SchoolType.ELEMENT)) sche = this.elementSche;
        else if (type.equals(SchoolType.MIDDLE)) sche = this.middleSche;
        else sche = this.highSche;

        URL url = new URL(sche + "&ATPT_OFCDC_SC_CODE=" + (areaCode) + "&SD_SCHUL_CODE=" + Integer.valueOf(schoolCOde)
                + "&AY=" + year + "&ALL_TI_YMD=" +seperateDay + "&GRADE=" + grade + "&CLASS_NM=" +classNum);

        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        try{
            List<ScheResponse.HisTimetable> timetable = mapper.readValue(url, ScheResponse.class).getHisTimetable();


            for (int i = 1; i < 10; i++){
                ScheResponse.HisTimetable.Row row = timetable.get(1).getRow().get(i-1);
                if ((LocalDate.parse(String.valueOf(seperateDay), intDateTimeFormatter)).getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.KOREAN).equals("토")){
                    try {
                        arrayList.add(new ScheShortenBlock(timetable.get(0).getHead().get(0).getList_total_count(), row.getaLL_TI_YMD(), row.getgRADE(), row.getcLASS_NM(), i,
                                row.getiTRT_CNTNT()));
                    } catch (Exception e){
                        break;
                    }
                } else
                try {

                    arrayList.add(new ScheShortenBlock(10,
                            row.getaLL_TI_YMD(), row.getgRADE(), row.getcLASS_NM(), i,
                            row.getiTRT_CNTNT()));
                } catch (IndexOutOfBoundsException e){

                    arrayList.add(new ScheShortenBlock(10,
                            year, grade, classNum, i,
                            "자습"));
                }
            }

            return arrayList;
        } catch (IOException e){
            for (int i = 1; i <= 4;i++) {
                arrayList.add(new ScheShortenBlock(4, seperateDay, grade, classNum, i, "휴일"));
            }
            return arrayList;
        }
    }



}
