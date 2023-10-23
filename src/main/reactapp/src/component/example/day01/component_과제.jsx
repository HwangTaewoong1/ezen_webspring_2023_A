function Component5(){
    return (<>
          <Myselfmadetagtype1 도서명="이것이 자바다" 저자 ="유재석" 가격={30000} />
          <Myselfmadetagtype1 도서명="이것이 파이썬" 저자 ="강호동" 가격={25000} />
          <Myselfmadetagtype1 도서명="이것이 리액트" 저자 ="신동엽" 가격={28000} />
     </>)
}

function Myselfmadetagtype1( props ){ // props : 컴포넌트의 매개변수(객체)
    return (<>
        <h2> 도서명 : { props.도서명 }</h2>
        <h4>저자 : {props.저자}/ 소비자가격 : {props.가격}</h4>
     </>)
    // ------------------- JSX 구역  E ------------------
}
export default Component5;