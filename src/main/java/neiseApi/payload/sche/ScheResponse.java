package neiseApi.payload.sche;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class ScheResponse {
    public List<HisTimetable> hisTimetable;
    
    public class HisTimetable{
        public List<Head> head;
        public List<Row> row;
      
        public class Head{
            public int list_total_count;
            @SerializedName("RESULT")
            public RESULT rESULT;
            
            public class RESULT{
                @SerializedName("CODE")
                public String cODE;
                @SerializedName("MESSAGE")
                public String mESSAGE;
            }

        }

        public class Row{
            @SerializedName("ATPT_OFCDC_SC_CODE")
            public String aTPT_OFCDC_SC_CODE;
            @SerializedName("ATPT_OFCDC_SC_NM")
            public String aTPT_OFCDC_SC_NM;
            @SerializedName("SD_SCHUL_CODE")
            public String sD_SCHUL_CODE;
            @SerializedName("SCHUL_NM")
            public String sCHUL_NM;
            @SerializedName("AY")
            public String aY;
            @SerializedName("SEM")
            public String sEM;
            @SerializedName("ALL_TI_YMD")
            public String aLL_TI_YMD;
            @SerializedName("DGHT_CRSE_SC_NM")
            public String dGHT_CRSE_SC_NM;
            @SerializedName("ORD_SC_NM")
            public String oRD_SC_NM;
            @SerializedName("DDDEP_NM")
            public String dDDEP_NM;
            @SerializedName("GRADE")
            public String gRADE;
            @SerializedName("CLRM_NM")
            public String cLRM_NM;
            @SerializedName("CLASS_NM")
            public String cLASS_NM;
            @SerializedName("PERIO")
            public String pERIO;
            @SerializedName("ITRT_CNTNT")
            public String iTRT_CNTNT;
            @SerializedName("LOAD_DTM")
            public String lOAD_DTM;
        }


    }
    
}

