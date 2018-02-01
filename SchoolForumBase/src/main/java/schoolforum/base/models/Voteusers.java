package schoolforum.base.models;

public class Voteusers {
    private String voteid;

    private Long userid;

    private String votefield;

    public String getVoteid() {
        return voteid;
    }

    public void setVoteid(String voteid) {
        this.voteid = voteid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getVotefield() {
        return votefield;
    }

    public void setVotefield(String votefield) {
        this.votefield = votefield;
    }
}