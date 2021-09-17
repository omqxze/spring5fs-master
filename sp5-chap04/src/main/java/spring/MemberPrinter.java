package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;

import java.time.format.DateTimeFormatter;

public class MemberPrinter {
	private DateTimeFormatter dateTimeFormatter;
	
	public MemberPrinter() {
		dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
	}
	
	public void print(Member member) {
		if (dateTimeFormatter == null) {
			System.out.printf(
					"회원 정보: 아이디=%d, 이메일=%s, 이름=%s, 등록일=%tF\n", 
					member.getId(), member.getEmail(),
					member.getName(), member.getRegisterDateTime());
		} else {
			System.out.printf(
					"회원 정보: 아이디=%d, 이메일=%s, 이름=%s, 등록일=%s\n", 
					member.getId(), member.getEmail(),
					member.getName(), 
					dateTimeFormatter.format(member.getRegisterDateTime()));
		}
	}
	//매칭 되는 빈이 없어도 자둥주입x과 익셉션x
	/*
	@Autowired(required = false)
	public void setDateFormatter(DateTimeFormatter dateTimeFormatter) {
		this.dateTimeFormatter = dateTimeFormatter;
	}
    */

	//자동 주입 대상 타입이 Optional인 경우 일치하는 빈이 존재하지않으면 값이 없는 Optional(=null)을 인자로 전달
//	@Autowired
//	public void setDateFormatter(Optional<DateTimeFormatter> formatterOpt) {
//		if (formatterOpt.isPresent()) {
//			this.dateTimeFormatter = formatterOpt.get();
//		} else {
//			this.dateTimeFormatter = null;
//		}
//	}
	
	@Autowired
	public void setDateFormatter(@Nullable DateTimeFormatter dateTimeFormatter) {
		this.dateTimeFormatter = dateTimeFormatter;
	}
	
}
