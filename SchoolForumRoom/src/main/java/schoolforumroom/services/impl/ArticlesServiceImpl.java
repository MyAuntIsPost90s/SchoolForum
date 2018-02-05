package schoolforumroom.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import schoolforum.base.dao.ArticlesMapper;
import schoolforum.base.models.Articles;
import schoolforumroom.models.EUIPageList;
import schoolforumroom.services.ArticlesService;

@Service
public class ArticlesServiceImpl implements ArticlesService {
	
	@Resource
	private ArticlesMapper articlesMapper;

	@Override
	public Articles getSingle(String id) {
		return articlesMapper.getSingle(id);
	}

	@Override
	public EUIPageList<Articles> getListWithPage(Articles articles, int page, int rows) {
		PageList<Articles> pageList = articlesMapper.getListWithPage(articles, new PageBounds(page,rows));
		return new EUIPageList<Articles>(pageList.getPaginator().getTotalCount(), pageList);
	}

	@Override
	public void add(Articles articles) {
		articlesMapper.insert(articles);
	}

	@Override
	public void update(Articles articles) {
		articlesMapper.update(articles);
	}

	@Override
	public void delete(List<String> ids) {
		articlesMapper.batchDelete(ids);
	}

}
