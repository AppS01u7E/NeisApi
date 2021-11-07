package payload;


public class SchoolShorten {

    private final String code;

    private final String name;

    private final String areaCode;

    private final String addressCode;

    private final String homePage;

    private final String telephone;

    private final String type;

    private final String kind;

    public SchoolShorten(String code, String name, String areaCode, String addressCode, String homePage, String telephone, String type, String kind) {
        this.code = code;
        this.name = name;
        this.areaCode = areaCode;
        this.addressCode = addressCode;
        this.homePage = homePage;
        this.telephone = telephone;
        this.type = type;
        this.kind = kind;
    }
}
