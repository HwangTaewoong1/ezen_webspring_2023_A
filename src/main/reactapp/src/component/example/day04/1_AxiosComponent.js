/*
    - HTTP 기반의 비동기 통신 함수.
    Axios ( React 라이브러리 )< ----- > Ajax( jquery라이브러리 )
         1. 설치
             1. 터미널[ alt + f12 ]
             2. 리액트 프로젝트 폴더내 설치
             3. npm i axios

         2. 컴포넌트에서 axios 사용하기
             1. import
                 파일 상단에 import axios from 'axios'
             2. ajax vs axios
                 $ajax({ url: '' , method : , data : , success : , })
                   vs
                 axios.methodType(url).then( 반환 매개변수 => {})

             3.
                - JSON 객체를 HTTP BODY 형식으로 보낼때.
                axios
                     .methodType( url , { json객체 })
                     .then( 반환 매개변수 => {} )

                 - JSON 객체를 HTTP BODY 형식으로 보낼때.
                axios
                     .methodType( url , { params : json객체 })
                     .then( 반환 매개변수 => {} )
*/
import axios from 'axios' // npm i axios 설치후 사용가능
export default function AxiosComponent( props ){

    // 컴포넌트(함수) 안에서 함수 정의하기
    // 1. 기본함수
    function 함수1( e ){ console.log(e) } // e: event [ event 발생 후 상태 / 결과 저장된 매개변수 ]

    // 2. 화살표 함수를 저장하는 상수
    // const 함수2 = function{ }

    // 3. * 화살표 함수를 저장하는 상수 *
    const 함수2 = ( e ) => { console.log(e); }

    // 4. * 화살표 함수를 매개변수 받기
    const 함수3 = ( e , data ) => { console.log(e); console.log(data); }
    // -------------------------------- axios -------------------------------//
    // 1. Get
    function doGet(){
        //axios.메소드( url).then( 리턴값 => {} )
        axios
            .get('https://jsonplaceholder.typicode.com/posts')
            .then( response => { console.log( response)});

        axios
            .get('https://jsonplaceholder.typicode.com/posts/1') // path
            .then( r => { console.log(r)});

        axios
            .get('https://jsonplaceholder.typicode.com/comments?postId=1') // queryString
            .then( r => { console.log(r)});

        axios
            .get('https://jsonplaceholder.typicode.com/comments' , { params : { 'postId' : 1 } }) // queryString
            .then( r => { console.log(r.data)});
    }
    // 2. Post
    function doPost(){
        let saveInfo ={ title : 'foo' , body : 'bar' , userId: 1 }
        axios
            .post('https://jsonplaceholder.typicode.com/posts' , saveInfo )
            .then( r => { console.log(r.data)});
    }
    // 3. Put
    function doPut(){
        let updateInfo = {  id: 1,  title: 'updateFoo',  body: 'updateBar',   userId: 1 }
        axios
            .put('https://jsonplaceholder.typicode.com/posts/1' , updateInfo )
            .then( r => { console.log(r.data)});
    }
    // 4. delete
    function doDelete(){
        axios
            .delete('https://jsonplaceholder.typicode.com/posts/1')
            .then( r => { console.log(r.data)});
    }

    return (<>
        <h3> Axios 테스트 </h3>
        {/* JSX에서 이벤트 속성 [ 1. 이벤트명(카멜 표기법) 2. { 함수명 } */}
        <button type="button" onClick={ 함수1 } > 함수1 </button>
        <button type="button" onClick={ 함수2 }> 함수2 </button>
        <button type="button" onClick={ e => 함수3( e, 3 ) }> 함수3 </button>
        <button type="button" onClick={ doGet }> doGet Axios </button>
        <button type="button" onClick={ doPost }> doPost Axios </button>
        <button type="button" onClick={ doPut }> doPut Axios </button>
        <button type="button" onClick={ doDelete }> doDelete Axios </button>
    </>)
}