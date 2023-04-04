package org.example;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class App {
   // private final Scanner sc;
    Scanner sc = new Scanner(System.in); //new 스캐너가 시스템을 출력받는다.
    //public App(Scanner sc) {
        //this.sc = sc;
   //}

    public void run() { //main에서 run을 실행시킴.
        System.out.println("== 명언 앱 =="); // 명언앱을 출력한다. //println은 자동개행 , printf는 같은선상 출력
        //System.out.printf("명령) ");
        /* long lastWiseSayingsId = 1; // 정수형 long 타입으로 lastWiseSayings 변수를 선언하고
        선언한 변수 lastWiseSayings에 1을 담는다.
         */
        // while문 밖에서 선언하는 이유 -> 조건문안에서 선언하게 되면 시작할때 계속 초기화가 되기때문에 밖에서 선언해서 증감연산자를 쓰기위해
        //int = -128 ~ 127까지만 담기고 long은 더 많은 범위를 담을 수 있기 때문에 long로 쓴다.
        // lastWiseSayingsId = 맨뒤에 있는 이름의 앞글자는 구문하기 편하게 대문자로 해준다.

        long lastWiseSayingsId = 0; //lastWiseSayingsId에 담긴 값은 0
        List<WiseSaying> wiseSayings = new ArrayList<>(); //<WiseSaying>이라는 List에 wiseSayings 변수에 새로운 ArrayList라는 객체 선언

        while (true) { // 조건이 true일때 실행되는 반복 while문을 사용해서
            System.out.printf("명령) "); // 명령)를 출력한다.
            String command = sc.nextLine().trim(); //문자열을 나타내는 자료형 String 으로 작업처리 코드를 작성하지 않고
            //객체를 받아서 작업 객체의 실행 메소드를 호출할수 있는 commnad 패턴으로 스캐너 클래스의 메소드인 nextLine()을 활용해서
            // 엔터치기 전까지 쓴 모든 문자열 sc를 반환하고 trim으로 문자열 공백(앞,뒤만 제거됨)을 제거해준다.

            if (command.equals("종료")) { // 객체의 내용을 비교하는 equals 메소드를 이용해서 종료를 입력하면
                break; //break로 강제 탈출
            } else if (command.equals("등록")) { //"등록"이라는 문자열을 입력할 경우 아래 내용
                //equals를 쓰는 이유 -> 참조형 데이터(기본형 데이터 int, char를 제외한 모든 값)를 비교하는데,
                //"등록"이 참조형(문자열 = String)이기 때문에 문자열을 비교하기 위해서 equals를 사용
                //command = run의 내용 이고 종료라는 참조형 데이터가 있는 지 비교해보고 종료가 입력될 때 까지 반복
                long id = lastWiseSayingsId + 1;
                System.out.printf("명언 : "); //"명언 : "을 출력한다.
                String content = sc.nextLine().trim(); // 문자열로 받을거라서 String(문자열 출력 자료형) content(변수이름)
                //sc(스캐너 변수)의 nextLint()으로 엔터치지 전까지의 문자열 반환, trim()으로 앞뒤 공백 제거
                System.out.printf("작가 : ");//"작가 : "를 출력한다.
                String authorName = sc.nextLine().trim(); // 문자열로 받을거라서 String(문자열 출력 자료형) authorName(변수이름)


                WiseSaying wiseSaying = new WiseSaying(id, content, authorName);//WiseSaying 이라는 클래스 wiseSaying변수에
                // (id, content, authorName)의 값이 담긴 WiseSayings라는 객체를 선언
                wiseSayings.add(wiseSaying); //WiseSayings라는 클래스에 add 메소드를 사용해서 wiseSaying 배열값을 추가한다.

                System.out.printf( "%d번 명언이 등록되었습니다.\n", id); //%와 d사이에 오는 숫자만큼 자리를 확보한다.
                //println사용법 -> println("zzz" + 변수명)
                //printf사용법 -> printf("%d", 변수명)
                /*lastWiseSayingsId++; // 증감연산자 ++는 한 개의 피연산자(lastWiseSayings)를 갖는 단항 연산자로써
                ++는 피연산자를 1씩 증가시킨다.
                */
                lastWiseSayingsId = id; //"등록"을 입력할때 위에서 lastWiseSayingsId +1 이라고 선언했기 때문에 id값에 1을 더해준다는 뜻.
            } else if (command.equals("목록")) { //"목록"이라고 입력했을 경우 아래와 같이 출력
                //System.out.printf("생성된 명언수 : %d\n", wiseSayings.size());//생성된 명언과 wiseSayings 리스트에 들어있는 원소의 수를 출력한다.
                System.out.println("번호 / 작가 / 명언"); //번호/작가/명언 출력해준다.
                System.out.printf("-".repeat(30)); // 문자열(String 메소드 중 하나) 반복 메서드인 repeat (30개) 를 활용해서 구분을 지어준다.

                for (int i = wiseSayings.size() -1; i >=0; i--) { // int i가 wiseSayings.size() 의 -1 일때, i가 0보다 크거나 같을때까지,
                    // i를 감소연산자를 활용해 1개씩 빼준다.
                    WiseSaying wiseSaying = wiseSayings.get(i); //WiseSaying  wiseSaying변수에 담긴 wiseSayings의 get()을 이용해서
                    // i번째 값을 출력해서 변수 wiseSaying에 담아달라.

                    System.out.printf("%d / %s / %s\n", wiseSaying.getId(), wiseSaying.getContent(), wiseSaying.getAuthorName());
                    // int/String/String 개행 하고, wiseSaying 클래스의 getId, getContent, getAuthorName을 출력해라.
                }
            }
        }
    }
}
//<5단계 part 1: 목록 명령 추가할 때 생각할 것들>
//1. 출력 조건 살펴보기( 출력 -> 생성된 명언수 : %d(등록이 실행된 횟수),  )
//2. Wise Saying 클래스에 담긴 내용들을 한번 더 살펴보고 이 내용을 어떻게 쓸 지 조건 나열해보기
// > 생성된 명언수가 계속 카운팅 되어야 한다.
// > 목록이라는 명령안에서는 id, content, authorName의 값이 담겨야 한다.
// > 위의 값은 어떻게 담을지 고민(ArrayList활용)
// > ArrayList의 값을 쓰기 위해서는 add 메소드를 활용해야함. (add() 괄호안에 담길 값이 있어야 하니까 값을 담을 변수를 선언해야한다.)
// > length와 size의 차이점 -> length는 배열의 전체 길이, length()는 문자열의 길이, size()는 리스트에 들어있는 원소의 수
//3. else if문을 이용해서 command.eqauls("목록") -> command = run값

//<5단계 part 2: 리팩토링 할 때 생각할 것들>
//출력 예시 -> 번호/작가/명언이 출력되어야 하고 2/ 작자미상/ 과거에 집착하지 마라. 1/ 작자미상/ 현재를 사랑하라. (내림차순)
//1. 각 패키지에 모듈을 도임할 거라서 모듈(Controller) 구조 생각하기 (System Controller시스템/ WiseSayingcController모듈/ entity빌드)
// > 패키지 만들때 .으로 구분해서 하위 클래스 만들기 (ex) systemcontroller.SystemController)
// > 각 패키지의 역할 파악하기 (System Controller는 실행/종료를 위한 모듈, WiseSayingControlloer는 명언앱과 관련된 로직을 위한 모듈,
// entity는 모델과 관련된 로직을 모아 둔 모듈