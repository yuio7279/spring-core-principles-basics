package hello.core.singleton;

public class SingletonService {

    //static이기때문에 메모리상에 객체를 생성한 채로 유지한다.
    private static final SingletonService instance = new SingletonService();

    //오직 getInstance 메서드로만 사용할 수 있게끔 한다. static 메서드이기때문에 객체생성 없이 바로 사용 가능하다.
    public static SingletonService getInstance(){
        return instance;
    }
    //private 생성자로 객체생성을 막는다.
    private SingletonService(){

    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
