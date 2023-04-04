package org.example;

public class WiseSaying { //접근 가능한(꺼내쓸 수 있는) WiseSaying이라는 클래스 생성
    //private를 쓰는 이유? -> 클래스 내부에서만 사용가능 하게 하기 위해서
    private long id; //long타입의 id 선언
    private String content; //String타입의 content 선언
    private String authorName; //Strignt타입의 authorName선언

    public WiseSaying(long id, String content, String authorName) { //WiseSaying안에 담긴 배열값?
        this.id = id; // this는 객체 자신(long id)을 가리키는 레퍼런스 변수로 자신의 객체(long id의 id)에 접근할때 사용(지정하기 위해서 존재)
        this.content = content; // String content 의 content
        this.authorName = authorName;// String authorName의 authorName
    }

    public long getId() { //getId() 괄호안이 공백이면 위의 클래스 값을 가져옴
        return id; // WiseSaying클래스에 있는 private long id의 값을 반환
    }

    public String getContent() {
        return content; //WiseSaying클래스에 있는 private String content의 값을 가져옴
    }

    public String getAuthorName() {
        return authorName; //WiseSaying클래스에 있는 private String authorName의 값을 가져옴
    }
}
//<작성하기 전 생각해볼 것>
//1. 클래스안에 필요한거 생각해보기
// > id(이름)
// > content(명언)
// > authorName(작가이름)

//2. 클래스 안에 선언될 값의 타입은 무엇인지 생각해보기
// App에서 id = long 으로 썼고, content는 String으로 썼고, authorName은 String으로 씀.

//3. 클래스 안에 값을 넣어줬다면, 정확한 값을 가져와서 쓰기 위해 getter/setter를 만들어준다.
// > getter는 변수들의 외부 노출을 제한하고 노출범위를 정해준다. (은닉성)
// > setter는 변수의 값 대입이 여러곳에서 제한없이 가능한것을 접근제한자(private)로 막고, 접근 범위에 한해서
   //메소드로 대입하기 전 값을 처리한 후 대입되게 하기 위해 사용.