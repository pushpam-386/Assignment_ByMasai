package push.classes;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Demo {

	public static void main(String[] args) {
		ApplicationContext ctx= new AnnotationConfigApplicationContext(appConfig.class);
		
		Travel travel =ctx.getBean("t1", Travel.class);
		
		travel.Show();
		
		Car car =ctx.getBean("c1", Car.class);
		
		car.show();
		
		
		AnnotationConfigApplicationContext acc=(AnnotationConfigApplicationContext) ctx;
		acc.close();
	}

}
