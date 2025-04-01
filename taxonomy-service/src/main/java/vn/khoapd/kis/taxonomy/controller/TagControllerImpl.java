package vn.khoapd.kis.taxonomy.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.khoapd.kis.shared.controller.AbstractBaseController;
import vn.khoapd.kis.shared.enums.EEntityName;
import vn.khoapd.kis.taxonomy.dto.TagDto;
import vn.khoapd.kis.taxonomy.entity.TagEo;
import vn.khoapd.kis.taxonomy.mapper.ITagMapper;
import vn.khoapd.kis.taxonomy.repository.ITagRepository;
import vn.khoapd.kis.taxonomy.service.TagServiceImpl;

@RestController
@RequestMapping("/api/v1/tag")
@Scope(
        value = "request",
        proxyMode = ScopedProxyMode.TARGET_CLASS
)
public class TagControllerImpl extends AbstractBaseController<
        TagEo, TagDto, Long, ITagRepository, ITagMapper, TagServiceImpl> {


    @Override
    protected String getEntityName() {
        return EEntityName.TAG.getName();
    }

}
