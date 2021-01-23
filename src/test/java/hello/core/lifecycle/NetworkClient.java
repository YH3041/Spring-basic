package hello.core.lifecycle;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient {

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);

    }

    //외부에서 set 할 수 있도록 만듬
    public void setUrl(String url) {
        this.url = url;
    }
    
    //서비스 시작시 호출
    public void connect() {
        System.out.println("connect = " + url);
    }

    //연결이 된 상태에서의 메세지
    public void call(String message) {
        System.out.println("call = " + url + "message = " + message);
    }

    //서비스 종료시 호출
    public void disconnect() {
        System.out.println("close = " + url);
    }


//    @Override
//    //의존관계 주입이 끝나면 호출해주겠다.
//    public void afterPropertiesSet() throws Exception {
//        connect();
//        call("초기화 연결 메세지");
//    }
//
//    @Override
//    //스프링 빈 종료 될 때 호출
//    public void destroy() throws Exception {
//        disconnect();
//    }


    @PostConstruct
    public void init() {
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메시지");

    }

    @PreDestroy
    public void close() {
        System.out.println("NetworkClient.init");
        disconnect();
    }
}


