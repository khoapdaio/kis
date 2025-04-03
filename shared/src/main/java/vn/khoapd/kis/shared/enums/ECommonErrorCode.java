package vn.khoapd.kis.shared.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ECommonErrorCode implements IEnumError {
    // 400
    BUCKET_NAME_NOT_VALID(400, "400001", "Bucket name is not valid"),
    OBJECT_NAME_NOT_VALID(400, "400002", "Object name is not valid"),

    // 404
    CATEGORY_ID_NOT_FOUND(404, "404001", "Category does not exist"),
    CATEGORY_ID_PARENT_NOT_FOUND(404, "404002", "Parent of category does not exist"),
    ADMINISTRATIVE_ID_PARENT_NOT_FOUND(404, "404003", "Parent of Administrative does not exist"),
    RESOURCE_ID_NOT_FOUND(404, "404003", "Resource does not exist"),

    // 405
    OBJECT_SIZE_MUST_ZERO(405, "405001", "Object size must be zero"),

    //409
    CATEGORY_NAME_DUPLICATED(409, "409001", "Category name already exists"),
    ADMINISTRATIVE_NAME_DUPLICATED(409, "409002", "Administrative name already exists"),
    TAG_NAME_DUPLICATED(409, "409003", "Tag name already exists"),
    BUCKET_NAME_DUPLICATED(409, "409004", "Bucket name already exists"),
    ;
    private final int statusCode;
    private final String code;
    private final String message;

}
