package com.scm.ojt.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.scm.ojt.dao.UserDetailDao;
import com.scm.ojt.model.UserDetail;
import com.scm.ojt.rowmapper.UserDetailRowmapper;

@Repository
public class UserDetailDaoImpl implements UserDetailDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@SuppressWarnings("deprecation")
	@Transactional
	public UserDetail getAllUserDetail(int id) {
		UserDetail userDetail = (UserDetail) jdbcTemplate.queryForObject("select * from user_detail",
				new Object[] { id }, new UserDetailRowmapper());
		return userDetail;
	}

	@Transactional
	public int addUserDetail(UserDetail userDetail) {
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		simpleJdbcInsert.withTableName("user_detail").usingGeneratedKeyColumns("id");
		Map<String, Object> parameters = new HashMap<String, Object>(4);
		parameters.put("first_name", userDetail.getFirstName());
		parameters.put("last_name", userDetail.getLastName());
		parameters.put("email", userDetail.getEmail());
		parameters.put("dao", userDetail.getDob());
		Number insertId = simpleJdbcInsert.executeAndReturnKey(parameters);
		return insertId.intValue();
	}

	@Transactional
	public int updateUserDetail(UserDetail userDetail) {
		String sql = "update user_detail set first_name = ?, last_name=?, email=?, dob=? where id=?";
		int resp = jdbcTemplate.update(sql, new Object[] { userDetail.getFirstName(), userDetail.getLastName(),
				userDetail.getEmail(), userDetail.getDob(), userDetail.getId() });
		return resp;
	}

	@Transactional
	public int deleteUserDetail(int id) {
		int resp = jdbcTemplate.update("delete from user_detail where id=?", id);
		return resp;
	}

	@Override
	public UserDetail getUserDetail(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDetail> getAllUsserDetail() {
		// TODO Auto-generated method stub
		return null;
	}
}
