package schoolforumroom.services.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import lingshi.convert.Convert;
import schoolforum.base.dao.ArticlefeedbacksMapper;
import schoolforum.base.models.Articlefeedbacks;
import schoolforumroom.common.RandomNum;
import schoolforumroom.models.EUIPageList;
import schoolforumroom.services.ArticleFeedbacksService;

@Service
public class ArticleFeedbacksServiceImpl implements ArticleFeedbacksService {

	@Resource
	private ArticlefeedbacksMapper articlefeedbacksMapper;
	
	@Override
	public EUIPageList<Articlefeedbacks> getListByPage(Articlefeedbacks articlefeedbacks, int page, int rows) {
		PageList<Articlefeedbacks> pageList =articlefeedbacksMapper.getListWithPage(articlefeedbacks, new PageBounds(page,rows));
		return new EUIPageList<Articlefeedbacks>(pageList.getPaginator().getTotalCount(), pageList);
	}

	@Override
	public void add(Articlefeedbacks articlefeedbacks) {
		articlefeedbacks.setArticlefeedbackid(RandomNum.getAID());
		articlefeedbacks.setArticlefeedbacktime(new Date());
		articlefeedbacksMapper.insert(articlefeedbacks);
	}

	@Override
	public void update(Articlefeedbacks articlefeedbacks) {
		articlefeedbacksMapper.update(articlefeedbacks);
	}

	@Override
	public void delete(List<String> ids) {
		articlefeedbacksMapper.batchDelete(ids);
	}

	@Override
	public EUIPageList<Articlefeedbacks> getWeekTop(int page,int rows) {
		try {
			SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd",Locale.CHINA);
			Calendar calendar = Calendar.getInstance(Locale.CHINA);
			calendar.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
			Date beginTime=Convert.toDate(simpleDateFormat.format(calendar.getTime()), "yyyy-MM-dd");
			calendar.set(Calendar.DAY_OF_WEEK,Calendar.SATURDAY);
			Date endTime=Convert.toDate(simpleDateFormat.format(calendar.getTime()), "yyyy-MM-dd");
			PageList<Articlefeedbacks> pageList = articlefeedbacksMapper.getFbTopUser(beginTime, endTime, new PageBounds(page,rows));
			return new EUIPageList<Articlefeedbacks>(pageList.getPaginator().getTotalCount(), pageList);
		} catch (Exception e) {
			Logger.getRootLogger().info(e);
		}
		return null;
	}

}
