/*
    컴포넌트(함수) 만들기
        - 리액트 2가지 컴포넌트 [ 클래스형 컴포넌트 vs 함수형 컴포넌트 ]
        - 1. 리액트 컴포넌트 만들때 사용하는 확장자 .JSX 사용한 파일 생성
        - 2. function 컴포넌트명(){ } [ * 영문일때는 꼭 첫글자 대문자. ]
            - js 함수 선언 비슷
        - 3. export default 컴포넌트명;
            - 해당 jsx파일을 import 했을때 내보내기 할 컴포넌트 선언
        - 4. return HTML문법작성
            ** HTML 2줄 이상일때는  이용한 시작과 끝 구분
                1. (<> HTML문법 </>)
                2. (<div> HTML문법 </div>)

                function 컴포넌트명(){
                    return(<> </>)
                }
                export default 컴포넌트명
*/
function Component1(){
    return <h1> 컴포넌트란 무엇인가..</h1>
}

export default Component1;