package schoolforum.base.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;

public class Articlefeedbacks {
	private String articlefeedbackid;

	private String articleid;

	private String articlefeedbackcontent;

	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date articlefeedbacktime;

	private Long fromuserid;

	private Long touserid;

	private Integer articlefeedbackcount;

	private String parentid;

	/** DTO部分 **/

	private String articletitle;

	private Users fromuser;

	private Users touser;

	public String getArticlefeedbackid() {
		return articlefeedbackid;
	}

	public void setArticlefeedbackid(String articlefeedbackid) {
		this.articlefeedbackid = articlefeedbackid;
	}

	public String getArticleid() {
		return articleid;
	}

	public void setArticleid(String articleid) {
		this.articleid = articleid;
	}

	public String getArticlefeedbackcontent() {
		return articlefeedbackcontent;
	}

	public void setArticlefeedbackcontent(String articlefeedbackcontent) {
		this.articlefeedbackcontent = articlefeedbackcontent;
	}

	public Date getArticlefeedbacktime() {
		return articlefeedbacktime;
	}

	public void setArticlefeedbacktime(Date articlefeedbacktime) {
		this.articlefeedbacktime = articlefeedbacktime;
	}

	public Long getFromuserid() {
		return fromuserid;
	}

	public void setFromuserid(Long fromuserid) {
		this.fromuserid = fromuserid;
	}

	public Long getTouserid() {
		return touserid;
	}

	public void setTouserid(Long touserid) {
		this.touserid = touserid;
	}

	public String getParentid() {
		return parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	public Integer getArticlefeedbackcount() {
		return articlefeedbackcount;
	}

	public void setArticlefeedbackcount(Integer articlefeedbackcount) {
		this.articlefeedbackcount = articlefeedbackcount;
	}

	public String getArticletitle() {
		return articletitle;
	}

	public void setArticletitle(String articletitle) {
		this.articletitle = articletitle;
	}

	public Users getFromuser() {
		return fromuser;
	}

	public void setFromuser(Users fromuser) {
		this.fromuser = fromuser;
	}

	public Users getTouser() {
		return touser;
	}

	public void setTouser(Users touser) {
		this.touser = touser;
	}
}