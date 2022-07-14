package com.callor.memo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callor.memo.model.UserVO;
import com.callor.memo.persistance.UserDao;
import com.callor.memo.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Autowired
	@Override
	public void create_memo_table() {
		userDao.create_user_table();
	}
	
	@Override
	public List<UserVO> selectAll() {
		// TODO Auto-generated method stub
		return userDao.selectAll();
	}

	@Override
	public UserVO findById(String u_userid) {
		// TODO Auto-generated method stub
		return userDao.findById(u_userid);
	}

	@Override
	public UserVO findByName(String u_name) {
		// TODO Auto-generated method stub
		return userDao.findByName(u_name);
	}
	
	@Override
	public int insert(UserVO userVO) {
		// TODO Auto-generated method stub
		return userDao.insert(userVO);
	}

	@Override
	public int update(UserVO userVO) {
		// TODO Auto-generated method stub
		return userDao.update(userVO);
	}

	@Override
	public int delete(long seq) {
		// TODO Auto-generated method stub
		return userDao.delete(seq);
	}



}
