package vn.khoapd.kis.taxonomy.mapper;

import org.springframework.stereotype.Component;
import vn.khoapd.kis.shared.mapper.IBaseMapper;
import vn.khoapd.kis.taxonomy.dto.CategoryDto;
import vn.khoapd.kis.taxonomy.entity.CategoryEo;


public interface ICategoryMapper extends IBaseMapper<CategoryEo, CategoryDto> {
}
