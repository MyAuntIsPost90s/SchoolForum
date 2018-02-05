package schoolforum.base.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;

public class Suggestions {
	private String suggestionid;

	private Long userid;

	private String suggestiontitle;

	private String suggestioncontent;

	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date suggestiontime;

	private String suggestionfeedback;

	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date suggestionfbtime;

	private Integer suggestionscore;

	private Long suggestionfbuid;

	private Integer suggestiontype;
	
	private Integer suggestionstatus;

	private Users user;

	private Users fbuser;

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

	public String getSuggestiontitle() {
		return suggestiontitle;
	}

	public void setSuggestiontitle(String suggestiontitle) {
		this.suggestiontitle = suggestiontitle;
	}

	public String getSuggestioncontent() {
		return suggestioncontent;
	}

	public void setSuggestioncontent(String suggestioncontent) {
		this.suggestioncontent = suggestioncontent;
	}

	public Date getSuggestiontime() {
		return suggestiontime;
	}

	public void setSuggestiontime(Date suggestiontime) {
		this.suggestiontime = suggestiontime;
	}

	public String getSuggestionfeedback() {
		return suggestionfeedback;
	}

	public void setSuggestionfeedback(String suggestionfeedback) {
		this.suggestionfeedback = suggestionfeedback;
	}

	public Date getSuggestionfbtime() {
		return suggestionfbtime;
	}

	public void setSuggestionfbtime(Date suggestionfbtime) {
		this.suggestionfbtime = suggestionfbtime;
	}

	public Integer getSuggestionscore() {
		return suggestionscore;
	}

	public void setSuggestionscore(Integer suggestionscore) {
		this.suggestionscore = suggestionscore;
	}

	public Long getSuggestionfbuid() {
		return suggestionfbuid;
	}

	public void setSuggestionfbuid(Long suggestionfbuid) {
		this.suggestionfbuid = suggestionfbuid;
	}

	public Integer getSuggestiontype() {
		return suggestiontype;
	}

	public void setSuggestiontype(Integer suggestiontype) {
		this.suggestiontype = suggestiontype;
	}
	
	public Integer getSuggestionstatus() {
		return suggestionstatus;
	}
	
	public void setSuggestionstatus(Integer suggestionstatus) {
		this.suggestionstatus = suggestionstatus;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Users getFbuser() {
		return fbuser;
	}
	
	public void setFbuser(Users fbuser) {
		this.fbuser = fbuser;
	}
}