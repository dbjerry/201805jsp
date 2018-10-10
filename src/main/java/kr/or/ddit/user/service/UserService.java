package kr.or.ddit.user.service;

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

	@Override
	public List<UserVo> selectUserPageList(Map<PageVo, Integer> page) {
		return dao.selectUserPageList(page);
	}
	
}

