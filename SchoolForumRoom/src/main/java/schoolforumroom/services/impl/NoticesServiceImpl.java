package schoolforumroom.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import schoolforum.base.dao.NoticesMapper;
import schoolforum.base.models.Notices;
import schoolforumroom.models.EUIPageList;
import schoolforumroom.services.NoticesService;

@Service
public class NoticesServiceImpl implements NoticesService {
	@Resource
	private NoticesMapper noticesMapper;
	
	@Override
	public Notices getSingle(String id) {
		return noticesMapper.getSingle(id);
	}

	@Override
	public EUIPageList<Notices> getListWithPage(Notices notices, int page, int rows) {
		PageList<Notices> pageList = noticesMapper.getListWithPage(notices, new PageBounds(page,rows));
		return new EUIPageList<Notices>(pageList.getPaginator().getTotalCount(),pageList);
	}

	@Override
	public void add(Notices notices) {
		noticesMapper.insert(notices);
	}

	@Override
	public void update(Notices notices) {
		noticesMapper.update(notices);
	}

	@Override
	public void delete(List<String> ids) {
		noticesMapper.batchDelete(ids);
	}

}
