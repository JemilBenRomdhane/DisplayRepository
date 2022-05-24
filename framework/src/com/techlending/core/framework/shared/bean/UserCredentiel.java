package com.techlending.core.framework.shared.bean;

import java.util.Collection;
import java.util.Objects;



import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserCredentiel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

    private String name;

    private String username;

    @JsonIgnore
    private String email;

    @JsonIgnore
    private String password;

    private String surname;
    private Long mgid;
    private String userrole;
    private String lancode;
    private String status;
    private boolean locked;
    private String phone;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;
    private String mobile;
    private static final String tokenType ="Bearer";
    private String token;
    
    public UserCredentiel(Long id, String name, String username, String email, String password, String surname, Long mgid, String userrole, String lancode, String status, boolean locked, String phone, String mobile) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.surname=surname;
        this.mgid=mgid;
        this.userrole=userrole;
        this.lancode=lancode;
        this.status=status;
        this.locked=locked;
        this.phone=phone;
        this.mobile=mobile;
      
    }

    
    
    
    public UserCredentiel() {
		super();
	}




	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public static String getTokentype() {
		return tokenType;
	}

	public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }



    
    public String getUsername() {
		return username;
	}




	public void setUsername(String username) {
		this.username = username;
	}




	public String getSurname() {
		return surname;
	}

	public Long getMgid() {
		return mgid;
	}

	public String getUserrole() {
		return userrole;
	}

	public String getLancode() {
		return lancode;
	}

	public String getStatus() {
		return status;
	}

	public boolean isLocked() {
		return locked;
	}

	public String getPhone() {
		return phone;
	}

	public String getMobile() {
		return mobile;
	}



    public boolean isAccountNonExpired() {
		return accountNonExpired;
	}




	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}




	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}




	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}




	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}




	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}




	public boolean isEnabled() {
		return enabled;
	}




	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}




	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCredentiel that = (UserCredentiel) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public static long getSerialversionuid() {
		return serialVersionUID;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public void setName(String name) {
		this.name = name;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public void setSurname(String surname) {
		this.surname = surname;
	}




	public void setMgid(Long mgid) {
		this.mgid = mgid;
	}




	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}




	public void setLancode(String lancode) {
		this.lancode = lancode;
	}




	public void setStatus(String status) {
		this.status = status;
	}




	public void setLocked(boolean locked) {
		this.locked = locked;
	}




	public void setPhone(String phone) {
		this.phone = phone;
	}




	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


}
