package schoolforumroom.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import schoolforum.base.dao.ClassesMapper;
import schoolforum.base.models.Classes;
import schoolforumroom.models.EUIPageList;
import schoolforumroom.services.ClassesService;

@Service
public class ClassesServiceImpl implements ClassesService {
	@Resource
	private ClassesMapper classesMapper;

	@Override
	public EUIPageList<Classes> getListWithPage(Classes classes, int page, int rows) {
		PageList<Classes> pageList = classesMapper.getListWithPage(classes, new PageBounds(page, rows));
		return new EUIPageList<>(pageList.getPaginator().getTotalCount(), pageList);
	}

	@Override
	public void add(Classes classes) {
		classesMapper.insert(classes);

	}

	@Override
	public void update(Classes classes) {
		classesMapper.update(classes);

	}

	@Override
	public void delete(List<String> ids) {
		classesMapper.batchDelete(ids);
	}

	@Override
	public Classes getSingle(String id) {
		return classesMapper.getSingle(id);
	}

}
