package schoolforum.base.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;

public class Articles {
    private String articleid;

    private String articletitle;

    private String articlecontent;

    @JSONField (format="yyyy-MM-dd HH:mm:ss")
   	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
   	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date articletime;

    private Long userid;

    public String getArticleid() {
        return articleid;
    }

    public void setArticleid(String articleid) {
        this.articleid = articleid;
    }

    public String getArticletitle() {
        return articletitle;
    }

    public void setArticletitle(String articletitle) {
        this.articletitle = articletitle;
    }

    public String getArticlecontent() {
        return articlecontent;
    }

    public void setArticlecontent(String articlecontent) {
        this.articlecontent = articlecontent;
    }

    public Date getArticletime() {
        return articletime;
    }

    public void setArticletime(Date articletime) {
        this.articletime = articletime;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }
}