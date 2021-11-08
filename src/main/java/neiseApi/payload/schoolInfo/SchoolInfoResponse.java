package neiseApi.payload.schoolInfo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SchoolInfoResponse {
    public List<SchoolInfo> schoolInfo;

    public static class SchoolInfo{
        public List<Head> head;

        public List<Row> getRow() {
            return row;
        }

        public List<Row> row;

        public static class Head{
            public int list_total_count;
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
            public String getaTPT_OFCDC_SC_CODE() {
                return aTPT_OFCDC_SC_CODE;
            }

            @JsonProperty("ATPT_OFCDC_SC_CODE")
            public String aTPT_OFCDC_SC_CODE;
            @JsonProperty("ATPT_OFCDC_SC_NM")
            public String aTPT_OFCDC_SC_NM;

            public String getsD_SCHUL_CODE() {
                return sD_SCHUL_CODE;
            }

            @JsonProperty("SD_SCHUL_CODE")
            public String sD_SCHUL_CODE;

            public String getsCHUL_NM() {
                return sCHUL_NM;
            }

            @JsonProperty("SCHUL_NM")
            public String sCHUL_NM;
            @JsonProperty("ENG_SCHUL_NM")
            public String eNG_SCHUL_NM;

            public String getsCHUL_KND_SC_NM() {
                return sCHUL_KND_SC_NM;
            }

            @JsonProperty("SCHUL_KND_SC_NM")
            public String sCHUL_KND_SC_NM;
            @JsonProperty("LCTN_SC_NM")
            public String lCTN_SC_NM;
            @JsonProperty("JU_ORG_NM")
            public String jU_ORG_NM;
            @JsonProperty("FOND_SC_NM")
            public String fOND_SC_NM;

            public String getoRG_RDNZC() {
                return oRG_RDNZC;
            }

            @JsonProperty("ORG_RDNZC")
            public String oRG_RDNZC;
            @JsonProperty("ORG_RDNMA")
            public String oRG_RDNMA;
            @JsonProperty("ORG_RDNDA")
            public String oRG_RDNDA;

            public String getoRG_TELNO() {
                return oRG_TELNO;
            }

            @JsonProperty("ORG_TELNO")
            public String oRG_TELNO;

            public String gethMPG_ADRES() {
                return hMPG_ADRES;
            }

            @JsonProperty("HMPG_ADRES")
            public String hMPG_ADRES;
            @JsonProperty("COEDU_SC_NM")
            public String cOEDU_SC_NM;
            @JsonProperty("ORG_FAXNO")
            public String oRG_FAXNO;

            public String gethS_SC_NM() {
                return hS_SC_NM;
            }

            @JsonProperty("HS_SC_NM")
            public String hS_SC_NM;
            @JsonProperty("INDST_SPECL_CCCCL_EXST_YN")
            public String iNDST_SPECL_CCCCL_EXST_YN;
            @JsonProperty("HS_GNRL_BUSNS_SC_NM")
            public String hS_GNRL_BUSNS_SC_NM;
            @JsonProperty("SPCLY_PURPS_HS_ORD_NM")
            public Object sPCLY_PURPS_HS_ORD_NM;
            @JsonProperty("ENE_BFE_SEHF_SC_NM")
            public String eNE_BFE_SEHF_SC_NM;
            @JsonProperty("DGHT_SC_NM")
            public String dGHT_SC_NM;
            @JsonProperty("FOND_YMD")
            public String fOND_YMD;
            @JsonProperty("FOAS_MEMRD")
            public String fOAS_MEMRD;
            @JsonProperty("LOAD_DTM")
            public String lOAD_DTM;
        }

    }



    public List<SchoolInfo.Row> getSchoolInfo(){
        return this.schoolInfo.get(0).getRow();
    }
}

