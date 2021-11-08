package neiseApi.payload.sche;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class ScheResponse {
    public List<HisTimetable> hisTimetable;
    
    public class HisTimetable{
        public List<Head> head;
        public List<Row> row;
      
        public class Head{
            public int list_total_count;
            @JsonProperty("RESULT")
            public RESULT rESULT;
            
            public class RESULT{
                @JsonProperty("CODE")
                public String cODE;
                @JsonProperty("MESSAGE")
                public String mESSAGE;
            }

        }

        public class Row{
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
            @JsonProperty("ALL_TI_YMD")
            public String aLL_TI_YMD;
            @JsonProperty("DGHT_CRSE_SC_NM")
            public String dGHT_CRSE_SC_NM;
            @JsonProperty("ORD_SC_NM")
            public String oRD_SC_NM;
            @JsonProperty("DDDEP_NM")
            public String dDDEP_NM;
            @JsonProperty("GRADE")
            public String gRADE;
            @JsonProperty("CLRM_NM")
            public String cLRM_NM;
            @JsonProperty("CLASS_NM")
            public String cLASS_NM;
            @JsonProperty("PERIO")
            public String pERIO;
            @JsonProperty("ITRT_CNTNT")
            public String iTRT_CNTNT;
            @JsonProperty("LOAD_DTM")
            public String lOAD_DTM;
        }


    }
    
}

