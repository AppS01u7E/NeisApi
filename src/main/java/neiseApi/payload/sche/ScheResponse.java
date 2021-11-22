package neiseApi.payload.sche;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ScheResponse {
    public List<HisTimetable> getHisTimetable() {
        return hisTimetable;
    }

    public List<HisTimetable> hisTimetable;
    
    public static class HisTimetable{
        public List<Head> getHead() {
            return head;
        }

        public List<Row> getRow() {
            return row;
        }

        public List<Head> head;
        public List<Row> row;
      
        public static class Head{
            public int getList_total_count() {
                return list_total_count;
            }

            public int list_total_count;

            public RESULT getrESULT() {
                return rESULT;
            }

            @JsonProperty("RESULT")
            public RESULT rESULT;
            
            public static class RESULT{
                @JsonProperty("CODE")
                public String cODE;
                @JsonProperty("MESSAGE")
                public String mESSAGE;
            }

        }

        public static class Row{
            @JsonProperty("ATPT_OFCDC_SC_CODE")
            public String aTPT_OFCDC_SC_CODE;
            @JsonProperty("ATPT_OFCDC_SC_NM")
            public String aTPT_OFCDC_SC_NM;
            @JsonProperty("SD_SCHUL_CODE")
            public String sD_SCHUL_CODE;
            @JsonProperty("SCHUL_NM")
            public String sCHUL_NM;
            @JsonProperty("AY")
            public String aY;
            @JsonProperty("SEM")
            public String sEM;

            public int getaLL_TI_YMD() {
                return aLL_TI_YMD;
            }

            @JsonProperty("ALL_TI_YMD")
            public int aLL_TI_YMD;
            @JsonProperty("DGHT_CRSE_SC_NM")
            public String dGHT_CRSE_SC_NM;
            @JsonProperty("ORD_SC_NM")
            public String oRD_SC_NM;
            @JsonProperty("DDDEP_NM")
            public String dDDEP_NM;

            public int getgRADE() {
                return gRADE;
            }

            @JsonProperty("GRADE")
            public int gRADE;
            @JsonProperty("CLRM_NM")
            public String cLRM_NM;

            public int getcLASS_NM() {
                return cLASS_NM;
            }

            @JsonProperty("CLASS_NM")
            public int cLASS_NM;


            public int getpERIO() {
                return pERIO;
            }

            @JsonProperty("PERIO")
            public int pERIO;

            public String getiTRT_CNTNT() {
                return iTRT_CNTNT;
            }

            @JsonProperty("ITRT_CNTNT")
            public String iTRT_CNTNT;
            @JsonProperty("LOAD_DTM")
            public String lOAD_DTM;
        }


    }
    
}

