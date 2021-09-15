package spring;

import java.time.LocalDateTime;

// 한 클래스가 다른 클래스의 메소드를 실행할때 이를 의존 한다고 표현
// 여기서는 MemberRegisterService 클래스가 MemberDao 클래스에 의존한다고 표현
public class MemberRegisterService {

	/*
	private MemberDao memberDao = new MemberDao()와의 차이
	-> 의존성 주입(DI) -> 의존 객체를 직접 생성하지않음 -> 생성자를 통해 객체를 전달받기 때문	 */
	/*
	DI의 장점 -> 변경할 코드가 한곳으로 집중되도록 유도 가능
	 */
	private MemberDao memberDao;
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public Long regist(RegisterRequest req) {
		Member member = memberDao.selectByEmail(req.getEmail());
		if (member != null) {
			throw new DuplicateMemberException("dup email " + req.getEmail());
		}
		Member newMember = new Member(
				req.getEmail(), req.getPassword(), req.getName(), 
				LocalDateTime.now());
		memberDao.insert(newMember);
		return newMember.getId();
	}
}
