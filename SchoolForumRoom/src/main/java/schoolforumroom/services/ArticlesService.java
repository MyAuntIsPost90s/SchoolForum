package schoolforumroom.services;

import java.util.List;

import schoolforum.base.models.Articles;
import schoolforumroom.models.EUIPageList;

public interface ArticlesService {

	public Articles getSingle(String id);

	public EUIPageList<Articles> getListWithPage(Articles articles, int page, int rows);

	public EUIPageList<Articles> getListByType(Integer type, Long userid, int page, int rows);

	public EUIPageList<Articles> getWeekHotList(int page, int rows);

	public void add(Articles articles);

	public void update(Articles articles);

	public void delete(List<String> ids);
}
