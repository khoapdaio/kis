package vn.khoapd.kis.taxonomy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.khoapd.kis.shared.controller.AbstractBaseController;
import vn.khoapd.kis.shared.enums.EEntityName;
import vn.khoapd.kis.taxonomy.dto.AdministrativeAddressDto;
import vn.khoapd.kis.taxonomy.entity.AdministrativeAddressEo;
import vn.khoapd.kis.taxonomy.mapper.IAdministrativeAddressMapper;
import vn.khoapd.kis.taxonomy.repository.IAdministrativeAddressRepository;
import vn.khoapd.kis.taxonomy.service.AdministrativeAddressServiceImpl;

@RestController
@RequestMapping("/api/v1/address")
@Slf4j
public class AdministrativeAddressControllerImpl extends AbstractBaseController<
        AdministrativeAddressEo,
        AdministrativeAddressDto, Long,
        IAdministrativeAddressRepository,
        IAdministrativeAddressMapper,
        AdministrativeAddressServiceImpl> {

    @Override
    protected String getEntityName() {
        return EEntityName.ADMINISTRATIVE_ADDRESS.getName();
    }
}
