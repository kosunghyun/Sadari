package administrator.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import static common.JDBCTemplate.*;

import administrator.model.dao.ADM_MemberDao;
import administrator.model.vo.Hostmember;
import administrator.model.vo.Outmember;
import administrator.model.vo.Usermember;

public class ADM_MemberService {

	//1. 일반회원 리스트 조회용 메소드
	public ArrayList<Usermember> selectUserList() {
		Connection conn = getConnection();
		ArrayList<Usermember> list = new ADM_MemberDao().selectUserList(conn);
		
		close(conn);
		return list;
	}

	// 2. 임대인 회원 리스트 조회용 메소드
	public ArrayList<Hostmember> selectHostList() {
		System.out.println("service page 이동.");
		Connection conn = getConnection();
		ArrayList<Hostmember> list = new ADM_MemberDao().selectHostList(conn);
		
		close(conn);
		return list;
	}

	// 3. 탈퇴 회원 리스트 조회용 메소드
	public ArrayList<Outmember> selectOutList() {
		Connection conn = getConnection();
		ArrayList<Outmember> list = new ADM_MemberDao().selectOutList(conn);
		
		close(conn);
		return list;
	}
}
