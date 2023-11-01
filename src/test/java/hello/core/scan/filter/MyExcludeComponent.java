package hello.core.scan.filter;

import java.lang.annotation.*;

//TYPE : 클래스레벨에 부착
//이 어노테이션들은 따로 학습하기
@Target(ElementType.TYPE)

@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyExcludeComponent {

}
