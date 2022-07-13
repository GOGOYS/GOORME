package com.callor.memo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {
	
	public String u_seq;
	public String u_userid;
	public String u_password;
	public String u_email;
	public String u_name;
	public String u_image;
	public String u_up_image;
	public String u_role;
}
