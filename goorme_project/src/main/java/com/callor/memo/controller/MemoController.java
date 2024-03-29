package com.callor.memo.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.callor.memo.model.MemoDTO;
import com.callor.memo.model.UserVO;
import com.callor.memo.model.WeatherVO;
import com.callor.memo.service.MemoService;
import com.callor.memo.service.WeatherService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="memo/map")
public class MemoController {
	
	
	@Autowired
	private MemoService memoService;
	@Autowired
	private WeatherService weatherService;
	
	@RequestMapping(value={"","/","/all"},method=RequestMethod.GET)
	public String map(@ModelAttribute("memo") MemoDTO memo, HttpSession session, Model model)throws IOException  {
		
		UserVO userVO = (UserVO) session.getAttribute("USER");
		
		if(userVO == null) {
			return "redirect:/";
		}
		
		memo.setM_author(userVO.getU_name());
		
		List<MemoDTO> memoList = memoService.findByAuthor(userVO.getU_name());
		
		JSONArray array = new JSONArray(memoList);
		
		model.addAttribute("MEMOLIST",array);

		model.addAttribute("MEMOS",memoList);
		
		WeatherVO weatherVO = weatherService.getWeather();
		String rnYn = weatherService.getRNYN(weatherVO);
		
		model.addAttribute("rnYn",rnYn);
		
		return "/memo/map";
	}
	
	@RequestMapping(value={"/public"},method=RequestMethod.GET)
	public String okPublic(@ModelAttribute("memo") MemoDTO memo, HttpSession httpSession, Model model)throws IOException  {
		
		List<MemoDTO> memoList = memoService.findByPersonal("OK");
	

		JSONArray array = new JSONArray(memoList);
		
		model.addAttribute("MEMOLIST",array);
		model.addAttribute("MEMOS",memoList);
		
		WeatherVO weather = weatherService.getWeather();
		String rnYn = weatherService.getRNYN(weather);
		
		model.addAttribute("rnYn",rnYn);
		
		
		return "/memo/map";
	}
	
	
	/*
	 * 첨부파일이 있는 프로젝트에서 
	 * form의 file input box의 이름은 절대 VO, DTO에 선언된 이름을 사용하면 안된다.
	 * 타입이 달라서 400 오류가 뜬다.
	 */
	@RequestMapping(value={"","/","/all"},method=RequestMethod.POST)
	public String insert(@ModelAttribute("memo") MemoDTO memo,
			 			 MultipartFile file, HttpSession httpSession) {
		
		//메모를 저장하기 전에 현재 session에 저장된 usename을 가져오기
		UserVO userVO = (UserVO)httpSession.getAttribute("USER");
		//저장할 메모 정보에 username 세팅
		memo.setM_author(userVO.getU_name());
		log.debug(file.getOriginalFilename());
		
		
		memoService.insertAndUpdate(memo, file);
		
		return "redirect:/memo/map";
	}	
	
	
	@RequestMapping(value="/public",method=RequestMethod.POST)
	public String insertPublic(@ModelAttribute("memo") MemoDTO memo,
			MultipartFile file, HttpSession httpSession) {
		
		//메모를 저장하기 전에 현재 session에 저장된 usename을 가져오기
		UserVO userVO = (UserVO)httpSession.getAttribute("USER");
		//저장할 메모 정보에 username 세팅
		memo.setM_author(userVO.getU_name());
		log.debug(file.getOriginalFilename());
		
		
		memoService.insertAndUpdate(memo, file);
		
		return "redirect:/memo/map/public";
	}	
	
	
	@RequestMapping(value="/detail/{seq}", method=RequestMethod.GET)
	public String detail(@PathVariable("seq") String seq, @ModelAttribute("memo") MemoDTO memo, Model model) {
		
		long m_seq = Long.valueOf(seq);
		
		memo = memoService.findById(m_seq);
		model.addAttribute("MEMO", memo);
		return "memo/detail";
	}
	
	@RequestMapping(value="/{seq}/update", method=RequestMethod.GET)
	public String update(@PathVariable("seq") String seq, Model model) {
		
		//전달 받은 seq에 해당하는 데이터 select
		MemoDTO memo = memoService.findById(Long.valueOf(seq));
		model.addAttribute("MEMO",memo);
		return "memo/update";
	}
	

	@RequestMapping(value="/{seq}/update", method=RequestMethod.POST)
	public String update(@PathVariable("seq") String seq,
			@ModelAttribute("memo") MemoDTO memoDTO, MultipartFile file, HttpSession session) {
		
		long m_seq = Long.valueOf(seq);
		UserVO userVO = (UserVO)session.getAttribute("USER");
		
		if(userVO == null) {
			return "redirect:/user/login";
		}
		memoDTO.setM_author(userVO.getU_name());
		memoDTO.setM_seq(m_seq);
		memoService.insertAndUpdate(memoDTO, file);
		return String.format("redirect:/memo/map/%s/detail",seq);
	}
	
	@RequestMapping(value="/{seq}/delete",method=RequestMethod.GET)
	public String delete(@PathVariable("seq") String seq) {
		memoService.delete(Long.valueOf(seq));
		return "redirect:/memo/map";
	}
	
	@RequestMapping(value="/find/{static}/{image}/{png:.+}",method=RequestMethod.GET)
	public String iconChoice(@PathVariable("static") String root,
							 @PathVariable("image") String image,
							 @PathVariable("png") String png, Model model) throws IOException {
		
		String iconUrl = "/"+ root + "/"+ image + "/" +png;
		
		List<MemoDTO> memoList = memoService.findByIcon(iconUrl);
		
		JSONArray array = new JSONArray(memoList);
		
		model.addAttribute("MEMOLIST",array);

		model.addAttribute("MEMOS",memoList);
		
		WeatherVO weather = weatherService.getWeather();
		String rnYn = weatherService.getRNYN(weather);
		
		model.addAttribute("rnYn",rnYn);
		
		return "/memo/map";
		
	}
	
	@RequestMapping(value={"/find/{static}/{image}/{png:.+}"},method=RequestMethod.POST)
	public String pInsert(@PathVariable("static") String root,
			 			  @PathVariable("image") String image,
			 			  @PathVariable("png") String png,
			 			  MultipartFile file,@ModelAttribute("memo") MemoDTO memo, HttpSession httpSession) {
		
		String icon = "/"+ root + "/"+ image + "/" +png;
		
		//메모를 저장하기 전에 현재 session에 저장된 usename을 가져오기
		UserVO userVO = (UserVO)httpSession.getAttribute("USER");
		//저장할 메모 정보에 username 세팅
		memo.setM_author(userVO.getU_name());
		
		
		memoService.insertAndUpdate(memo, file);
		
		return "redirect:/memo/map/find"+icon;
	}	
	
	@ModelAttribute("memo")
	private MemoDTO memoDTO() {
		
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat toDay = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat toTime = new SimpleDateFormat("HH:mm:SS");
		
		MemoDTO memo = MemoDTO.builder()
					.m_date(toDay.format(date))
					.m_time(toTime.format(date))
					.build();
		
		return memo;
	}
	
}
