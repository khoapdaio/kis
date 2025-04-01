package vn.khoapd.kis.taxonomy.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EAdministrative {
    MUNICIPALITY(1, "Thành phố trục thuộc trung ương", "Thành phố", "Municipality", "City"),
    PROVINCE(1,"Tỉnh", "Tỉnh", "Province", "Province"),
    MUNICIPAL_CITY(2,"Thành phố thuộc thành phố trực thuộc trung ương","Thành phố","Municipal city","City"),
    PROVINCIAL_CITY(2,"Thành phố thuộc tỉnh", "Thành phố", "City" ,"City"),
    URBAN_DISTRICT(2,"Quận","Quận","District", "District"),
    DISTRICT_LEVEL_TOWN(2,"Thị xã", "Thị xã","District-level town","Town"),
    DISTRICT(2,"Huyện","Huyện","District", "District"),
    WARD(3,"Phường","Phường","Ward", "Ward"),
    COMMUNE_LEVEL_TOWN(3,"Thị trấn","Thị Trấn","Commune level town","Township"),
    COMMUNE(3,"Xã","Xã","Commune", "Commune"),
    ;
    private final int level;
    private final String full_name_vn;
    private final String short_name_vn;
    private final String full_name_en;
    private final String short_name_en;
}
