package chap02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//스프링 설정 파일
//해당 클래스를 스프링 설정 클래스로 지정
@Configuration
public class AppContext {

	//Bean->스프링이 생성하는 객체
	//@Bean 해당 메서드가 생성한 객체를 스프링이 관리하는 빈 객체로 등록
	//이게 붙으면 알맞게 초기화를 해줘야함
	@Bean
	public Greeter greeter() {
		Greeter g = new Greeter();
		g.setFormat("%s, 안녕하세요!");
		return g;
	}

	@Bean
	public Greeter greeter1(){
		Greeter g1=new Greeter();
		g1.setFormat("안녕하세요,%s님!");
		return g1;
	}

}
