package hello.core.singleton;

public class SingletonService {


    //static 설정 시 클래스 level에 올라가기 때문에 하나만 존재한다.
    private static final SingletonService instance = new SingletonService();

    //instance를 조회할 수 있는 방법은 getInstance 밖에 없다. 또한 항상 같은 인스턴스만 반환
    public static SingletonService getInstance() {
        return instance;
    }

    //다른 클래스(외부)에서의 생성을 막기 위해서 private 생성자 설정
    private SingletonService() {
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

}
