// ------------------------- JS 형식 ------------------------ //
import { useState , useEffect } from 'react'

export default function 생명주기컴포넌트(){

    // 1. use state 함수를 이용한 초기값 0으로 하는 [ 변수 , 수정함수 ] 리턴 받음
    let [ value , setValue ] = useState( 0 );
    const valueUpdate = (e) => { value++; setValue(value); }

    let [ data , setData ] = useState( 0 );
    const dataUpdate = (e) => { data++; setData(data); }

    // 2. 컴포넌트 생명주기 1.탄생 / 2.업데이트 / 3. 제거 할 때 실행되는 함수
        // 1. 컴포넌트 탄생 / 업데이트 /    <= 컴포넌트가 첫 실행과 업데이트할 때 실행되는 함수
        // useEffect
    useEffect( ()=>{ console.log('[1]Effect 실행') } );
        // 2. 컴포넌트 탄생               <= 컴포넌트가 첫 실행될때만 실행되는 함수
        // useEffect( 함수, [])
    useEffect( ()=>{ console.log('[2]Effect 실행') } , [ ] );
       // 3. 컴포넌트 탄생  / 특정 상태 업데이트
       // useEffect( 함수 , [의존성배열])
    useEffect( ()=>{ console.log('[3]Effect 실행') } , [ data ] );

    // ------------------- JSX 형식 START --------------- //
    return(<>
        <div> { value } </div>
        <button onClick={ valueUpdate }> + </button>

        <div> { data } </div>
        <button onClick={ dataUpdate }> + </button>
    </>);
    // ------------------- JSX 형식 END  --------------- //

}
// ------------------------- JS 형식 ------------------------ //

/*

    컴포넌트의 생명주기[ Life Cycle]
        탄생 [ Mounting ] --------------> 업데이트 [ Updating ] -------------------------> 제거[UnMount]
        1. 함수/컴포넌트 생성
                |                         1. setState()    : 상태 변경 되었을 때
        2. 함수/컴포넌트 호출                2. forceUpdate() : 강제 랜더링
                |                         3. new props     : props가 변경 되었을 때
                |                                |
                |                                |
                        3. 가상 DOM UPDATE
                |                                |
                |                                |
                |                                |
            컴포넌트 탄생                     컴포넌트 업데이트                             컴포넌트 업데이트

           [ Mounting ]
        useEffect( ()=>{} )
        useEffect( ()=>{} , [] )
        useEffect( ()=>{} , [ useState 변수명 ] )

           [ Updating ]
        useEffect( ()=>{} )
        useEffect( ()=>{} , [ useState 변수명 ] )


    useEffect : 컴포넌트의
*/