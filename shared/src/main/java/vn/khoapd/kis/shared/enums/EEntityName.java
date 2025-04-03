package vn.khoapd.kis.shared.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EEntityName implements IEnumEx<String> {
    CATEGORY("Category"),
    ADMINISTRATIVE_ADDRESS("Administrative address"),
    TAG("Tag"),
    PRODUCT("Product"),
    BUCKET("Bucket");

    private final String name;


    @Override
    public String getValueEnum() {
        return name;
    }
}
