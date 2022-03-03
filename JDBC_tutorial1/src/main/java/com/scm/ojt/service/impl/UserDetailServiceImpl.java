package com.scm.ojt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.scm.ojt.dao.UserDetailDao;
import com.scm.ojt.model.UserDetail;
import com.scm.ojt.service.UserDetailService;

public class UserDetailServiceImpl implements UserDetailService {
	@Autowired
	private UserDetailDao userDetailDao;

	public UserDetail getUserDetail(int id) {

		return userDetailDao.getUserDetail(id);
	}

	public List<UserDetail> getAllUserDetail() {
		return userDetailDao.getAllUsserDetail();
	}

	@Override
	public int addUserDetail(UserDetail userDetail) {
		return userDetailDao.addUserDetail(userDetail);
	}

	@Override
	public int updateUserDetail(UserDetail userDetail) {
		return userDetailDao.updateUserDetail(userDetail);
	}

	@Override
	public int deleteUserDetail(int id) {
		return userDetailDao.deleteUserDetail(id);
	}

	public UserDetailDao getUserDetialDao() {
		return userDetailDao;
	}
}
