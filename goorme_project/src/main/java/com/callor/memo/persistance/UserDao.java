package com.callor.memo.persistance;

import java.util.List;

import com.callor.memo.model.UserVO;


public interface UserDao {
	
	public List<UserVO> selectAll();
	public UserVO findById(String u_userid);
	public UserVO findByName(String u_name);
	public int insert(UserVO userVO);
	public int update(UserVO userVO);
	public int delete(Long seq);
	
	public void create_user_table();
}
