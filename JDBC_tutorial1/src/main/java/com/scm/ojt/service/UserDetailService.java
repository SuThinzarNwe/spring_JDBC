package com.scm.ojt.service;

import java.util.List;

import com.scm.ojt.model.UserDetail;

public interface UserDetailService {
	public UserDetail getUserDetail(int id);

	public List<UserDetail> getAllUserDetail();

	public int addUserDetail(UserDetail userDetail);

	public int updateUserDetail(UserDetail userDetail);

	public int deleteUserDetail(int id);
}
