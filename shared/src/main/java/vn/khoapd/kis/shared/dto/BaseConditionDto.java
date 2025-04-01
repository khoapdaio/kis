package vn.khoapd.kis.shared.dto;

import lombok.Getter;
import lombok.Setter;
import vn.khoapd.kis.shared.enums.EEntityStatus;

import java.time.LocalDateTime;

@Getter
@Setter
public class BaseConditionDto {
    String createBy;
    String updateBy;
    LocalDateTime createAt;
    LocalDateTime updateAt;
    Boolean isDeleted;
    EEntityStatus status;
    String deletedBy;
    LocalDateTime deletedAt;
}
