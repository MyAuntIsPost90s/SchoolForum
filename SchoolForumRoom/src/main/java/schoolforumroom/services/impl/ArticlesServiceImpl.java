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

	@Override
	public EUIPageList<Articles> getListByType(Integer type, int page, int rows) {
		PageList<Articles> pageList = articlesMapper.getListByTime(type, null, null, new PageBounds(page,rows));
		return new EUIPageList<Articles>(pageList.getPaginator().getTotalCount(), pageList);
	}

	@Override
	public EUIPageList<Articles> getWeekHotList(int page, int rows) {
		try {
			SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd",Locale.CHINA);
			Calendar calendar = Calendar.getInstance(Locale.CHINA);
			calendar.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
			Date beginTime=Convert.toDate(simpleDateFormat.format(calendar.getTime()), "yyyy-MM-dd");
			calendar.set(Calendar.DAY_OF_WEEK,Calendar.SATURDAY);
			Date endTime=Convert.toDate(simpleDateFormat.format(calendar.getTime()), "yyyy-MM-dd");
			PageList<Articles> pageList = articlesMapper.getListByTime(1, beginTime, endTime, new PageBounds(page,rows));
			return new EUIPageList<Articles>(pageList.getPaginator().getTotalCount(), pageList);
		} catch (Exception e) {
			Logger.getRootLogger().info(e);
		}
		return null;
	}

}
