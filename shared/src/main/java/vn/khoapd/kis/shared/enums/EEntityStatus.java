package vn.khoapd.kis.shared.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EEntityStatus implements IEnumEx<Integer> {
    DELETED(0),
    NEW(1),
    UPDATED(2),

    ;

    private final int code;

    @Override
    public Integer getValueEnum() {
        return this.code;
    }
}
