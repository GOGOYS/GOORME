package com.callor.memo.persistance;

import java.util.List;

import com.callor.memo.model.UserVO;


public interface UserDao {
	
	public List<UserDao> selectALL();
	public UserVO findById(Long seq);
	public int insert(UserVO memo);
	public int update(UserVO memo);
	public int delete(Long seq);
}
