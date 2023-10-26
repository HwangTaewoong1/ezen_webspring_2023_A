import { Link } from 'react-router-dom';
import styles from '../css/header.css' // css 파일 호출
import axios from 'axios';
import { useState } from 'react';
export default function Header( props ){

    // 로그아웃
   // function 함수명(e) {}
   //const 변수명 = (e) => {}
    /*
    function onLogout(){
    axios.get('/member/logout')
    .then( r => {console.log(r);
            alert('로그아웃 되었습니다.');
        })
    }*/
    // 로그인상태 저장할 상태변수 선언
    let [ login , setLogin ] = useState(null);

    // 로그아웃
    const logOut = (e) => {
        axios.get('/member/logout')
        .then( r => {
            if(r.data){
            window.location.reload(); // 새로고침
            // vs
            // this.forceUpdate(); // 강제 리랜더링
            //setLogin( null);
            }
        });
    }

    // - 회원정보 호출 [ 로그인 여부 확인 ]
    axios.get('/member/get')
    .then(r => {
        if(r.data != ''){
            setLogin(r.data);
        }
    })

    return(<>
        <header>
            <h2> <Link to='/'> 이젠리액트 </Link> </h2>
            <ul>
                <li> <Link to='/example'>리액트예제 </Link></li>
                <li> <Link to='/example/day02/TodoList'>TODO </Link></li>
                <li> <Link to='/'>비회원게시판 </Link></li>
                <li> <Link to='/'>회원게시판 </Link></li>

                {/* 삼항연산자 조건 ? 참 : 거짓 */}
                {/* 조건  ? (<></>) : (<></>)  */}
                { login == null
                    ? (<>
                         <li> <Link to='/login'>로그인 </Link></li>
                         <li> <Link to='/signup'>회원가입 </Link></li>
                        </>)
                    : (<>
                        <li> {login.memail} 님 </li>
                        <li> <Link to='/'>내정보 </Link></li>
                        <li> <div onClick={logOut}>로그아웃 </div></li>
                        </>)
                }
            </ul>
        </header>
    </>)
}