package com.scm.ojt.dao;

import java.util.List;

import com.scm.ojt.model.UserDetail;

public interface UserDetailDao {
	public UserDetail getUserDetail(int id);

	public List<UserDetail> getAllUsserDetail();

	public int addUserDetail(UserDetail userDetail);

	public int updateUserDetail(UserDetail userDetail);

	public int deleteUserDetail(int id);
}
