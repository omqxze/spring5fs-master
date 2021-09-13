package chap02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//스프링 설정 파일
//해당 클래스를 스프링 설정 클래스로 지정
@Configuration
public class AppContext {

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
