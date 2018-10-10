package kr.or.ddit.user.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.db.SqlFactoryBuilder;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.model.PageVo;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserDao implements UserDaoInf{
	
	// jspuser 테이블 데이터 전체 조회 쿼리
	// select query id : selectUserAll
	public List<UserVo> selectUserAll(){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		// selectOne : 데이터가 한 건일 때
		// selectList : 여러건의 데이터를 조회
		// 메서드 인자 : 문자열 = 네임스페이스(모듈명).쿼리아이디 
		return session.selectList("jspUser.selectUserAll");
//		return session.selectOne("jspUser.selectUserAll");
	}
	
	/* 회원정보조회 */
	public UserVo selectUser(String userId){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		// selectOne : VO객체로 받으면 컬럼의 갯수와 상관없이 selectOne을 사용할 수 있다.
		return session.selectOne("jspUser.selectUser", userId);
	}
	
	public UserVo selectUser(UserVo userVo){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		// selectOne : VO객체로 받으면 컬럼의 갯수와 상관없이 selectOne을 사용할 수 있다.
		return session.selectOne("jspUser.selectUserByVo", userVo);
	}

	@Override
	public List<UserVo> userAllList() {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		return session.selectList("jspUser.userAllList");
	}

	@Override
	public List<UserVo> selectUserPageList(Map<PageVo, Integer> page) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		return session.selectList("jspuser.selectUserPageList", page);
	}
	
}

