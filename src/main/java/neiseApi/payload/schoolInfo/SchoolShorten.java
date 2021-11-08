package neiseApi.payload.schoolInfo;


import neiseApi.payload.sche.SchoolType;

public class SchoolShorten {

    private final String coxde;

    private final String name;

    private final String areaCode;

    private final String addressCode;

    private final String homePage;

    private final String telephone;

    private final String type;

    private final SchoolType kind;

    public SchoolShorten(String code, String name, String areaCode, String addressCode, String homePage, String telephone, String type, String kind) {
        this.code = code;
        this.name = name;
        this.areaCode = areaCode;
        this.addressCode = addressCode;
        this.homePage = homePage;
        this.telephone = telephone;
        this.type = type;
        if (kind.equals("고등학교")) this.kind = SchoolType.HIGH;
        else if (kind.equals("중학교")) this.kind = SchoolType.MIDDLE;
        else this.kind = SchoolType.ELEMENT;
    }


    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public String getAddressCode() {
        return addressCode;
    }

    public String getHomePage() {
        return homePage;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getType() {
        return type;
    }

    public SchoolType getKind() {
        return kind;
    }
}
