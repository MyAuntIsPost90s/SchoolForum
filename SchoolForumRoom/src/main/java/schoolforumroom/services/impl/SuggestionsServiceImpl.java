package schoolforumroom.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import schoolforum.base.dao.SuggestionsMapper;
import schoolforum.base.models.Suggestions;
import schoolforumroom.models.EUIPageList;
import schoolforumroom.services.SuggestionsService;

@Service
public class SuggestionsServiceImpl implements SuggestionsService {

	@Resource
	private SuggestionsMapper suggestionsMapper;

	@Override
	public Suggestions getSingle(String id) {
		return suggestionsMapper.getSingle(id);
	}

	@Override
	public EUIPageList<Suggestions> getListWithPage(Suggestions suggestions, int page, int rows) {
		PageList<Suggestions> pageList = suggestionsMapper.getListWithPage(suggestions, new PageBounds(page, rows));
		return new EUIPageList<>(pageList.getPaginator().getTotalCount(), pageList);
	}

	@Override
	public void add(Suggestions suggestions) {
		suggestionsMapper.insert(suggestions);
	}

	@Override
	public void update(Suggestions suggestions) {
		suggestionsMapper.update(suggestions);
	}

	@Override
	public void delete(List<String> ids) {
		suggestionsMapper.batchDelete(ids);
	}

}
