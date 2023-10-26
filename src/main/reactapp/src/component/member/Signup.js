import styles from '../../css/login.css'; // css 호출
import {Link} from 'react-router-dom'; // Link 컴포넌트 호출
import axios from 'axios';
import {useState} from 'react';

export default function Signup( props ){

    // 1. 회원가입 버튼을 클릭 했을 때.
    const onSignup = (e)=>{
        // 2. 입력받은 데이터 구성
        let info = {
                        memail : document.querySelector('.memail').value ,
                        mpassword : document.querySelector('.mpassword').value ,
                        mname : document.querySelector('.mname').value ,
                        mphone : document.querySelector('.mphone').value
                    }; console.log(info);
                    // 유효성검사

                    // 3. 통신
                    axios
                        .post('http://localhost:80/member/post', info)
                        .then( r => {
                             if(r.data){
                                       alert('회원가입 성공');
                                       window.location.href= '/login';
                              }else{
                                        alert('회원가입 실패');
                               }
                             })
    }
    // 2. 이메일 중복검사 [ 이메일 입력할 때 마다. ]
    let [ memail , setMemail ] = useState('')
    let [ memailCheck , setMemailCheck ] = useState('')

    const emailInputChange = ( e ) => {
        // 1. [ 기존방법 ]
            // let memail = document.querySelector('.memail').value; console.log(memail)
        // 2. [useState]
        let memailInput = e.target.value; // e.target.value : 입력받은값
        setMemail( memailInput ); // 랜더링 // 바로 실행 x 해당 함수가 모두 끝나고
        // ----------------------------------------------//
        // axios <----> ajax 비동기 통신 함수
        // axios.HTTP메소드명('URL' , { params : { 속성명 : 값 , 속성명 : 값 }})
         // axios.HTTP메소드명('URL , json객체 ) : body 형식
        axios.get('/member/findMemail' , { params : {'memail' : memailInput } } )
                  .then( r => {
                     if( r.data ){ setMemailCheck('사용중인 아이디입니다.') } // 중복 입니다.
                     else{setMemailCheck('사용가능한 아이디 입니다.') }
                   })
    }


    return(<>
    <div className="loginContainer">
        <h3>Ezen Signup</h3>
        <form>
              이메일[아이디]  <input type="text" placeholder='@포함 7~30글자' className='memail'
              value = { memail } onChange = { emailInputChange}/>
              <span> { memailCheck }</span>
              비밀번호  <input type="password" placeholder='특수문자 조함 5~30글자' className='mpassword'/>
              비밀번호확인  <input type="password" placeholder='특수문자 조함 5~30글자' className='mpassword2'/>
              이름  <input type="text" placeholder='이름' className='mname'/>
              전화번호  <input type="text" placeholder='연락처' className='mphone'/>
              <button onClick={ onSignup }  type="button">회원가입</button>
        </form>
    </div>
    </>)
}