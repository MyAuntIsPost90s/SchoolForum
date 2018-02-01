package schoolforum.base.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;

public class Votes {
    private String voteid;

    private String votetitle;

    private String votecontent;

    private String votefield;

    private String votevalue;

    @JSONField (format="yyyy-MM-dd HH:mm:ss")
   	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
   	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date votebegintime;

    @JSONField (format="yyyy-MM-dd HH:mm:ss")
   	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
   	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date voteendtime;

    @JSONField (format="yyyy-MM-dd HH:mm:ss")
   	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
   	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date votecreatetime;

    private Long userid;

    public String getVoteid() {
        return voteid;
    }

    public void setVoteid(String voteid) {
        this.voteid = voteid;
    }

    public String getVotetitle() {
        return votetitle;
    }

    public void setVotetitle(String votetitle) {
        this.votetitle = votetitle;
    }

    public String getVotecontent() {
        return votecontent;
    }

    public void setVotecontent(String votecontent) {
        this.votecontent = votecontent;
    }

    public String getVotefield() {
        return votefield;
    }

    public void setVotefield(String votefield) {
        this.votefield = votefield;
    }

    public String getVotevalue() {
        return votevalue;
    }

    public void setVotevalue(String votevalue) {
        this.votevalue = votevalue;
    }

    public Date getVotebegintime() {
        return votebegintime;
    }

    public void setVotebegintime(Date votebegintime) {
        this.votebegintime = votebegintime;
    }

    public Date getVoteendtime() {
        return voteendtime;
    }

    public void setVoteendtime(Date voteendtime) {
        this.voteendtime = voteendtime;
    }

    public Date getVotecreatetime() {
        return votecreatetime;
    }

    public void setVotecreatetime(Date votecreatetime) {
        this.votecreatetime = votecreatetime;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }
}