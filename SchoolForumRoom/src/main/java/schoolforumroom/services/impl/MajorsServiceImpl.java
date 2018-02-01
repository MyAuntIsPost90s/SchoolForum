package schoolforumroom.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import schoolforum.base.dao.MajorsMapper;
import schoolforum.base.models.Majors;
import schoolforumroom.models.EUIPageList;
import schoolforumroom.services.MajorsService;

@Service
public class MajorsServiceImpl implements MajorsService {
	@Resource
	private MajorsMapper majorsMapper;

	@Override
	public EUIPageList<Majors> getListWithPage(Majors majors, int page, int rows) {
		PageList<Majors> pageList = majorsMapper.getListWithPage(majors, new PageBounds(page, rows));
		return new EUIPageList<>(pageList.getPaginator().getTotalCount(), pageList);
	}

	@Override
	public void add(Majors majors) {
		majorsMapper.insert(majors);

	}

	@Override
	public void update(Majors majors) {
		majorsMapper.update(majors);

	}

	@Override
	public void delete(List<String> ids) {
		majorsMapper.batchDelete(ids);
	}

	@Override
	public Majors getSingle(String id) {
		return majorsMapper.getSingle(id);
	}

}
