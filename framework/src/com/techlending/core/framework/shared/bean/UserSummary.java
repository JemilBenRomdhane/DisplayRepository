package com.techlending.core.framework.shared.bean;

public class UserSummary {
    private Long id;
    private String username;
    private String name;
    private String surname;
    private String email;
    
    private String lancode;
    
    
    private String userrole;
    
    private Long mgid;
    private String status;
    private boolean locked;
    private String phone;
    private String mobile;


    public UserSummary(Long id, String username, String name) {
        this.id = id;
        this.username = username;
        this.name = name;
        
    }
    
    public UserSummary() {
        super();
    }
    

    public UserSummary(Long id, String username, String name, String surname, String email, String lancode,
			String userrole, Long mgid, String status, boolean locked, String phone, String mobile) {
		super();
		this.id = id;
		this.username = username;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.lancode = lancode;
		this.userrole = userrole;
		this.mgid = mgid;
		this.status = status;
		this.locked = locked;
		this.phone = phone;
		this.mobile = mobile;
	}


	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLancode() {
		return lancode;
	}

	public void setLancode(String lancode) {
		this.lancode = lancode;
	}

	public String getUserrole() {
		return userrole;
	}

	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}

	public Long getMgid() {
		return mgid;
	}

	public void setMgid(Long mgid) {
		this.mgid = mgid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
    
}

