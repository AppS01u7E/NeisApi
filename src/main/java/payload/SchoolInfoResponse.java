package payload;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class SchoolInfoResponse {
    public List<SchoolInfo> schoolInfo;

    public class SchoolInfo{
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
            @SerializedName("ENG_SCHUL_NM")
            public String eNG_SCHUL_NM;
            @SerializedName("SCHUL_KND_SC_NM")
            public String sCHUL_KND_SC_NM;
            @SerializedName("LCTN_SC_NM")
            public String lCTN_SC_NM;
            @SerializedName("JU_ORG_NM")
            public String jU_ORG_NM;
            @SerializedName("FOND_SC_NM")
            public String fOND_SC_NM;
            @SerializedName("ORG_RDNZC")
            public String oRG_RDNZC;
            @SerializedName("ORG_RDNMA")
            public String oRG_RDNMA;
            @SerializedName("ORG_RDNDA")
            public String oRG_RDNDA;
            @SerializedName("ORG_TELNO")
            public String oRG_TELNO;
            @SerializedName("HMPG_ADRES")
            public String hMPG_ADRES;
            @SerializedName("COEDU_SC_NM")
            public String cOEDU_SC_NM;
            @SerializedName("ORG_FAXNO")
            public String oRG_FAXNO;
            @SerializedName("HS_SC_NM")
            public String hS_SC_NM;
            @SerializedName("INDST_SPECL_CCCCL_EXST_YN")
            public String iNDST_SPECL_CCCCL_EXST_YN;
            @SerializedName("HS_GNRL_BUSNS_SC_NM")
            public String hS_GNRL_BUSNS_SC_NM;
            @SerializedName("SPCLY_PURPS_HS_ORD_NM")
            public Object sPCLY_PURPS_HS_ORD_NM;
            @SerializedName("ENE_BFE_SEHF_SC_NM")
            public String eNE_BFE_SEHF_SC_NM;
            @SerializedName("DGHT_SC_NM")
            public String dGHT_SC_NM;
            @SerializedName("FOND_YMD")
            public String fOND_YMD;
            @SerializedName("FOAS_MEMRD")
            public String fOAS_MEMRD;
            @SerializedName("LOAD_DTM")
            public String lOAD_DTM;
        }

    }



    public SchoolInfo getSchoolInfo(){
        return this.schoolInfo.get(1);
    }
}

