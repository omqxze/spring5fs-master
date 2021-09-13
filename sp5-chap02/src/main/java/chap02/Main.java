package chap02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


//main()메소드를 통해 스프링과 Greeter를 실행하는 자바 클래스

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppContext.class);
		Greeter g1 = ctx.getBean("greeter1", Greeter.class);
		Greeter g2 = ctx.getBean("greeter1", Greeter.class);
		System.out.println("(g1 == g2) = " + (g1 == g2));
		ctx.close();
	}
}
