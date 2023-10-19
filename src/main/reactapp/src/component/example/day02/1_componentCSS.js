// 리액트 확장자 : jsx , js

    // 1-1. css속성[ 카멜표기법 background-color --> backgroundColor ]이 정의된 객체 선언
    // 1-2. 마크업 style속성 = { CSS속성이 있는 객체 }

    // 2-1. 마크업 style속성 = { { 속성: 속성값 , 속성: 속성값 } }

    // 3. css 파일에서 순수css 문법
        // 1. 마크업 class명 정의
        // 2. css파일에 css문 작성
        // 3. import styles from '.css파일경로';

// 1. 컴포넌트 문법 원형
import styles from './component.css';
export default function CssComponent( props ) {

    // 1. CSS를 객체에 속성[*카멜 표기법*] 으로 선언하기
    const cssStyle = {
        backgroundColor: 'red',
        width: '500px', height: '100px' ,
        margin: '0 auto'
    }
    return(<> {/* jsx 구역 -- jsx문법만 사용. jsx 내에서 js문법 사용시 { } 사용. */}
        <div style= { cssStyle }> CSS 적용하는 방법1 </div>
        {/* style 속성에 = { { 속성: 속성값 , 속성: 속성값 } } */}
        <div style= { { backgroundColor: 'blue',
                        width: '500px',
                        height: '100px' ,
                        margin: '0 auto'
                     } }> CSS 적용하는 방법2 </div>
        <div className="box3"> CSS 적용하는 방법3 </div>
        {/* jsx 에선 class X --> className O */}
    </>);
}
/*
// 2. 컴포넌트 문법 원형
function CssComponent( props ) {
    return(<></>);
}

export default CssComponent;
*/