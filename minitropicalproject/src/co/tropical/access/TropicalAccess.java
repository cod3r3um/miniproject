package co.tropical.access;

import java.util.ArrayList;

import co.tropical.model.Tropical;

public interface TropicalAccess {
	
	// 관리자 로그인
	public boolean adLogin (String id, int pw);
	
	// 관리자 전체 조회
	public ArrayList<Tropical> selectAll();
	
	// 관리자 한 건 조회
	public ArrayList<Tropical> selectBook(String guest_id);

	// 공동 예약
	public void book (Tropical tropical);
	
	// 관리자 예약 변경
	public void adChange (Tropical tropical);
	
	// 관리자 예약 취소
	public void adCancel (String id);
	
	
	

	// 회원가입
	public void signUp(Tropical tropical);
	
	// 게스트 로그인
	public boolean gstLogin (String guest_id, int guest_pw);

	// 게스트 예약건 확인
	public ArrayList<Tropical> selectYours(String guest_id);

	// 게스트 예약건 변경
	public void gstChange (Tropical tropical);

	// 게스트 예약건 취소
	public void gstCancel (String guest_id);	
	
	// 권한
	public boolean right(String guest_id, int guest_pw);
	
	// welcome message
	public Tropical printName(String guest_id);

	
	
	

}
