package com.shipping.model.company;

import com.shipping.common.Collection;
import com.shipping.common.Person;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import java.util.List;

@org.springframework.data.mongodb.core.mapping.Document(collection = Collection.USER_ROLE)
public class UserRole {
	@Transient
	public static final String SEQUENCE_NAME = Collection.USER_ROLE;

	@Id
	private long id;
	private String roleName, roleDesc;
	List<RoleRight> roleRights;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<RoleRight> getRoleRights() {
		return roleRights;
	}

	public void setRoleRights(List<RoleRight> roleRights) {
		this.roleRights = roleRights;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
}
