package hello.core.singleton;

public class SingletonService {

    // 1. static 영역에 객체를 딱 1개만 생성해둔다.
    private static final SingletonService instance = new SingletonService();

    // 2. public으로 설정해 객체 인스턴스가 필요하면 이 static 메소드를 통해서만 조회할 수 있도록 한다.
    public static SingletonService getInstance() {
        return instance; // 자바가 뜰 때, SingletonService 객체를 생성해서 instance에 참조값을 넣어놓는다.
    }

    // 3. 생성자를 private으로 선언해 외부에서 new 키워드로 객체 생성을 하지 못하도록 한다.
    private SingletonService() {
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}