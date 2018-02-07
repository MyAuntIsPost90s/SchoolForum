package schoolforum.base.dao;

import org.apache.ibatis.annotations.Param;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import lingshi.mybaties.mapperextend.BaseMapper;
import schoolforum.base.models.Votes;

public interface VotesMapper extends BaseMapper<Votes> {
	
	public PageList<Votes> getListByTime(@Param("timetype")Integer timetype,PageBounds pageBounds);
	
}