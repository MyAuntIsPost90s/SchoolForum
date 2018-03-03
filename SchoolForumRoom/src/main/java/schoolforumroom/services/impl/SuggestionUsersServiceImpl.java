package schoolforumroom.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import schoolforum.base.dao.SuggestionusersMapper;
import schoolforum.base.models.Suggestions;
import schoolforum.base.models.Suggestionusers;
import schoolforumroom.common.RandomNum;
import schoolforumroom.models.EUIPageList;
import schoolforumroom.services.SuggestionUsersService;
import schoolforumroom.services.SuggestionsService;

@Service
public class SuggestionUsersServiceImpl implements SuggestionUsersService {

	@Resource
	private SuggestionusersMapper suggestionusersMapper;
	@Resource
	private SuggestionsService suggestionsService;

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public void add(Suggestionusers suggestionusers) throws Exception {
		// 判断是否重复顶贴
		Suggestionusers temp = new Suggestionusers();
		temp.setSuggestionid(suggestionusers.getSuggestionid());
		temp.setUserid(suggestionusers.getUserid());
		if (suggestionusersMapper.count(temp) > 0) {
			throw new Exception("重复顶贴");
		}
		Suggestions suggestions =suggestionsService.getSingle(suggestionusers.getSuggestionid());
		suggestions.setSuggestioncount(suggestions.getSuggestioncount()+1);
		suggestionsService.update(suggestions);
		suggestionusers.setSuggestionuserid(RandomNum.getSID());
		suggestionusersMapper.insert(suggestionusers);
	}

	@Override
	public void update(Suggestionusers suggestionusers) {
		suggestionusersMapper.update(suggestionusers);
	}

	@Override
	public EUIPageList<Suggestionusers> getListByPage(Suggestionusers suggestionusers, int page, int rows) {
		PageList<Suggestionusers> pageList = suggestionusersMapper.getListWithPage(suggestionusers,
				new PageBounds(page, rows));
		return new EUIPageList<Suggestionusers>(pageList.getPaginator().getTotalCount(), pageList);
	}

	@Override
	public void delete(List<String> ids) {
		suggestionusersMapper.batchDelete(ids);
	}

	@Override
	public Boolean exist(Suggestionusers suggestionusers) {
		if (suggestionusersMapper.count(suggestionusers) > 0) {
			return true;
		}
		return false;
	}

}
