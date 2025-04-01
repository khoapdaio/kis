package vn.khoapd.kis.taxonomy.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.khoapd.kis.shared.entity.AbstractBaseEntity;
import vn.khoapd.kis.taxonomy.enums.EAdministrative;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "administrative_address")
public class AdministrativeAddressEo extends AbstractBaseEntity {
    private String code;
    @Column(name="level_administrative")
    private EAdministrative levelAdministrative;
    private String name;
    @Column(name="name_en")
    private String nameEn;
    @Column(name="full_name")
    private String fullName;
    @Column(name="full_name_en")
    private String fullNameEn;
    @Column(name="code_name")
    private String codeName;
    @Column(name="id_parent")
    private Long idParent;

}
