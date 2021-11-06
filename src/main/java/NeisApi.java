import com.google.gson.Gson;
import payload.School;
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
     * 생성자
     */
    public NeisApi(Builder builder){
        this.meal = builder.meal;
        this.schoolInfo = builder.schoolInfo;
        this.schedule = builder.schedule;
    }


    /**
     * @param key serviceKey
     */

    public void setServiceKey(String key){

        this.serviceKey = key;
    }

    /**
     *
     * @param schoolName which do you want to search
     * @return Schools List
     */


    public List<School> getSchool(String schoolName){
        ArrayList<School> arrayList = new ArrayList<>();

        Gson gson = new Gson();

        String url = this.schoolInfo + "&KEY=" + serviceKey;
        gson.fromJson(url, SchoolInfoResponse.class).getSchoolInfo().row.stream().map(
                row -> arrayList.add(new School(row.sD_SCHUL_CODE, row.sCHUL_NM, row.aTPT_OFCDC_SC_CODE, row.oRG_RDNZC, row.hMPG_ADRES,
                        row.oRG_TELNO, row.hS_SC_NM, row.sCHUL_KND_SC_NM)
        ));
        return arrayList;
    }

    public static class Builder {

        private String meal = MEAL + "?Type=Json";
        private String schoolInfo = SCHOOLINFO + "?Type=Json";
        private String schedule = SCHEDULE + "?Type=Json";

        /**
         * @param meal The Meal host setter.
         * @return A {@link Builder}
         */
        public Builder setMeal(String meal) {
            this.meal = meal;
            return this;
        }

        /**
         * @param schoolInfo The School host setter.
         * @return A {@link Builder}
         */
        public Builder setSchoolInfo(String schoolInfo) {
            this.schoolInfo = schoolInfo;
            return this;
        }

        /**
         * @param schedule The Menu pattern setter.
         * @return A {@link Builder}
         */
        public Builder setSchedule(String schedule) {
            this.schedule = schedule;
            return this;
        }

        public NeisApi build() {
            return new NeisApi(this);
        }

    }




}
