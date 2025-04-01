package vn.khoapd.kis.taxonomy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.khoapd.kis.shared.controller.AbstractBaseController;
import vn.khoapd.kis.shared.enums.EEntityName;
import vn.khoapd.kis.taxonomy.dto.CategoryDto;
import vn.khoapd.kis.taxonomy.entity.CategoryEo;
import vn.khoapd.kis.taxonomy.mapper.ICategoryMapper;
import vn.khoapd.kis.taxonomy.repository.ICategoryRepository;
import vn.khoapd.kis.taxonomy.service.CategoryServiceImpl;

@RestController
@RequestMapping("/api/v1/category")
@Slf4j
public class CategoryControllerImpl extends AbstractBaseController<CategoryEo, CategoryDto, Long, ICategoryRepository, ICategoryMapper, CategoryServiceImpl> {


    @Override
    protected String getEntityName() {
        return EEntityName.CATEGORY.name();
    }
}
