package org.wxx.ssm.orclproject.entity;

public class ClassInfo {
    private Integer classid;

    private String classname;

    public ClassInfo(Integer classid, String classname) {
		super();
		this.classid = classid;
		this.classname = classname;
	}

	public ClassInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname == null ? null : classname.trim();
    }
}