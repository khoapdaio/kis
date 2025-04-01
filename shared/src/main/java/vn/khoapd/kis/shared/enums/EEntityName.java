package vn.khoapd.kis.shared.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
public enum EEntityName implements IEnumEx<String>{
    CATEGORY("Category"),
    ADMINISTRATIVE_ADDRESS("Administrative address"),
    TAG("Tag"),
    PRODUCT("Product");

    private final String name;


    @Override
    public String getValueEnum() {
        return name;
    }
}
