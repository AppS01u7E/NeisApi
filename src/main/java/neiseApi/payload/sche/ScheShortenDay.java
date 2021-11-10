package neiseApi.payload.sche;

import java.util.List;

public class ScheShortenDay {
    public List<ScheShorten> getScheShortens() {
        return scheShortens;
    }

    private final List<ScheShorten> scheShortens;

    public ScheShortenDay(List<ScheShorten> scheShortens) {
        this.scheShortens = scheShortens;
    }

}
