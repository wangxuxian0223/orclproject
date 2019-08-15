package org.wxx.ssm.orclproject.entity;

public class StudentInfo {
    private Integer studentid;

    private String studentname;

    private String studentsex;

    private Integer studentage;

    private Long studenttel;

    private String studentaddress;

    private Integer cid;
    
    private ClassInfo classInfo;

    public StudentInfo(Integer studentid, String studentname, String studentsex, Integer studentage, Long studenttel,
			String studentaddress, Integer cid) {
		super();
		this.studentid = studentid;
		this.studentname = studentname;
		this.studentsex = studentsex;
		this.studentage = studentage;
		this.studenttel = studenttel;
		this.studentaddress = studentaddress;
		this.cid = cid;
	}

	public StudentInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClassInfo getClassInfo() {
		return classInfo;
	}

	public void setClassInfo(ClassInfo classInfo) {
		this.classInfo = classInfo;
	}

	public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname == null ? null : studentname.trim();
    }

    public String getStudentsex() {
        return studentsex;
    }

    public void setStudentsex(String studentsex) {
        this.studentsex = studentsex == null ? null : studentsex.trim();
    }

    public Integer getStudentage() {
        return studentage;
    }

    public void setStudentage(Integer studentage) {
        this.studentage = studentage;
    }

    public Long getStudenttel() {
        return studenttel;
    }

    public void setStudenttel(Long studenttel) {
        this.studenttel = studenttel;
    }

    public String getStudentaddress() {
        return studentaddress;
    }

    public void setStudentaddress(String studentaddress) {
        this.studentaddress = studentaddress == null ? null : studentaddress.trim();
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }
}