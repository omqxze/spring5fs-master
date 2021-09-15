package assembler;

import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberRegisterService;

public class Assembler {
/*
	객체를 생성하고 의존 객체를 주입해주는 클래스를 따로 작성
	의존 객체의 주입 -> 서로 다른 객체들의 조립
 */
	private MemberDao memberDao;
	private MemberRegisterService regSvc;
	private ChangePasswordService pwdSvc;

	public Assembler() {
		memberDao = new MemberDao(); // 의존 객체 생성
		//의존 객체를 변경하려면 new MemberDao()에서 new CachedMemberDao()로만 변경해주면 된다
		regSvc = new MemberRegisterService(memberDao); //의존 객체 주입
		pwdSvc = new ChangePasswordService();
		pwdSvc.setMemberDao(memberDao);
	}

	public MemberDao getMemberDao() {
		return memberDao;
	}

	public MemberRegisterService getMemberRegisterService() { return regSvc; }

	public ChangePasswordService getChangePasswordService() {
		return pwdSvc;
	}

}
