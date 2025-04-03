package vn.khoapd.kis.shared.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EResourceType implements IEnumEx<String> {
    IMG("image"),
    VIDEO("video"),
    AUDIO("audio"),
    FILE("file"),
    DOC("doc"),
    DOCX("docx"),
    PDF("pdf"),
    TXT("txt"),
    XLS("xls"),
    XLSX("xlsx"),
    PPT("ppt"),
    PPTX("pptx"),
    ;


    private final String name;

    public static EResourceType getByName(String name) {
        for (EResourceType type : EResourceType.values()) {
            if (type.name.equals(name))
                return type;
        }
        return null;
    }

    @Override
    public String getValueEnum() {
        return this.name;
    }
}
