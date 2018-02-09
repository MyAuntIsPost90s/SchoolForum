package schoolforum.base.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import lingshi.mybaties.mapperextend.BaseMapper;
import schoolforum.base.models.Articlefeedbacks;

public interface ArticlefeedbacksMapper extends BaseMapper<Articlefeedbacks> {
	
	public PageList<Articlefeedbacks> getFbTopUser(@Param("beginTime")Date beginTime,@Param("endTime")Date endTime,PageBounds pageBounds);
	
}