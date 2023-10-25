import styles from '../../css/login.css'; // css 호출
import {Link} from 'react-router-dom'; // Link 컴포넌트 호출
import axios from 'axios';

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

    return(<>
    <div className="loginContainer">
        <form>
              이메일[아이디]  <input type="text" placeholder='@포함 7~30글자' className='memail'/>
              비밀번호  <input type="password" placeholder='특수문자 조함 5~30글자' className='mpassword'/>
              비밀번호확인  <input type="password" placeholder='특수문자 조함 5~30글자' className='mpassword2'/>
              이름  <input type="text" placeholder='이름' className='mname'/>
              전화번호  <input type="text" placeholder='연락처' className='mphone'/>
              <button onClick={ onSignup }  type="button">회원가입</button>
        </form>
    </div>
    </>)
}