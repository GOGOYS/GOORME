package com.callor.memo.service;

import java.util.List;

import com.callor.memo.model.UserVO;

public interface UserService {
	
	public List<UserVO> selectAll();
	public UserVO findById(String u_userid);
	public UserVO findByName(String u_name);
	public int insert(UserVO userVO);
	public int update(UserVO userVO);
	public int delete(long seq);
	
	public void create_memo_table();
	
	
}
