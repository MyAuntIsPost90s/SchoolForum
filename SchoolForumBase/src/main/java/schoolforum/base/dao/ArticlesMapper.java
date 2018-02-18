package schoolforum.base.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import lingshi.mybaties.mapperextend.BaseMapper;
import schoolforum.base.models.Articles;

public interface ArticlesMapper extends BaseMapper<Articles> {

	public PageList<Articles> getListByTime(@Param("type") Integer type, @Param("userid") Long userid,
			@Param("beginTime") Date beginTime, @Param("endTime") Date endTime, PageBounds pageBounds);

}