package schoolforumroom.services;

import java.util.List;

import schoolforum.base.models.Articlefeedbacks;
import schoolforumroom.models.EUIPageList;

public interface ArticleFeedbacksService {

	public EUIPageList<Articlefeedbacks> getWeekTop(int page, int rows);

	public EUIPageList<Articlefeedbacks> getListByPage(Articlefeedbacks articlefeedbacks, int page, int rows);

	public void add(Articlefeedbacks articlefeedbacks);

	public void update(Articlefeedbacks articlefeedbacks);

	public void delete(List<String> ids);
}
