package neiseApi.payload.sche;

import java.util.List;

public class ScheShortenDay {
    public List<ScheShortenBlock> getScheShortens() {
        return scheShortens;
    }

    private final List<ScheShortenBlock> scheShortens;

    public ScheShortenDay(List<ScheShortenBlock> scheShortens) {
        this.scheShortens = scheShortens;
    }

}
