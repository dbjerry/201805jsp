package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.model.PageVo;

public class UserService implements UserServiceInf{
	
	UserDao dao = new UserDao();
	
	@Override
	public List<UserVo> selectUserAll() {
		return dao.selectUserAll();
	}

	@Override
	public UserVo selectUser(String userId) {
		return dao.selectUser(userId);
	}

	@Override
	public UserVo selectUser(UserVo userVo) {
		return dao.selectUser(userVo);
	}

	@Override
	public List<UserVo> userAllList() {
		return dao.userAllList();
	}

	/**
	 * Method : selectUserPageList
	 * 작성자 : 김지태
	 * 변경이력 :
	 * @param pageVo
	 * @return
	 * Method 설명 : 사용자 페이징 조회
	 */
	@Override
	public Map<String, Object> selectUserPageList(PageVo pageVo) {
		
		// 페이지에 해당하는 유저 리스트(1~10건 사이)
		List<UserVo> userList = dao.selectUserPageList(pageVo);
		
		// 페이지 내비게이션을 위한 전체 유저 리스트 조회
		int totalUserCnt = dao.getUserCnt();
		
		// 결과를 담는 map객체
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("userList", userList);
		resultMap.put("pageCnt", 
				(int)Math.ceil((double)totalUserCnt / pageVo.getPageSize()));
		
		return resultMap;
	}

	/**
	 * Method : getUserCnt
	 * 작성자 : 김지태
	 * 변경이력 :
	 * @return
	 * Method 설명 : 사용자 전체 건수 조회
	 */
	@Override
	public int getUserCnt() {
		return dao.getUserCnt();
	}
	
}

