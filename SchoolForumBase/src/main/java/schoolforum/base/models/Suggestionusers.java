package schoolforum.base.models;

public class Suggestionusers {
	private String suggestionid;

	private Long userid;

	private String suggestionuserid;

	private Users user;

	public String getSuggestionid() {
		return suggestionid;
	}

	public void setSuggestionid(String suggestionid) {
		this.suggestionid = suggestionid;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public String getSuggestionuserid() {
		return suggestionuserid;
	}

	public void setSuggestionuserid(String suggestionuserid) {
		this.suggestionuserid = suggestionuserid;
	}
}