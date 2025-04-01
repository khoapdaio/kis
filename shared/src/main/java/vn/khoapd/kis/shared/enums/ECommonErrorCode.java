package vn.khoapd.kis.shared.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ECommonErrorCode implements IEnumError {

    // 404
    CATEGORY_ID_NOT_FOUND(404, "404001", "Category does not exist"),
    CATEGORY_ID_PARENT_NOT_FOUND(404, "404002", "Parent of category does not exist"),
    ADMINISTRATIVE_ID_PARENT_NOT_FOUND(404, "404003", "Parent of Administrative does not exist"),

    //409
    CATEGORY_NAME_DUPLICATED(409, "409001", "Category name already exists"),
    ADMINISTRATIVE_NAME_DUPLICATED(409, "409002", "Administrative name already exists"),
    TAG_NAME_DUPLICATED(409, "409003", "Tag name already exists"),
    ;
    private final int statusCode;
    private final String code;
    private final String message;

}
