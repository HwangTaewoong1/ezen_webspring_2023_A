import styles from '../../css/login.css'; // css 호출
import {Link} from 'react-router-dom'; // Link 컴포넌트 호출
import axios from 'axios';

export default function Login( props ){
    // 1. 로그인 버튼을 클릭했을 때
    function onLogin(e){ console.log(e);

        // 2. AXIOS 를 이용한 restful 로 Spring Controller 데이터 전달
            // 3. 데이터 구성
            let info = {
                memail : document.querySelector('.memail').value ,
                mpassword : document.querySelector('.mpassword').value
            }; console.log(info);
            // 4. !! axios 통신 [ Spring Controller 매핑 확인 후 ]
            axios
                .post('http://localhost:80/member/login', info)
                .then( r => {
                    if(r.data){
                        alert('로그인 성공');
                        window.location.href= '/';
                    }else{
                        alert('로그인 실패');
                    }
                 })

    }


    return(<>
        <div className="loginContainer">
            <h3> ReactEzenLogin</h3>
            <form>
                아이디  <input maxLength="30"
                name='memail' className='memail'
                placeholder='email address'  type="text" />

                비밀번호  <input maxLength='20'
                name='mpassword' className='mpassword'
                placeholder='password' type="password" />

                { /* Link 컴포넌트 사용하려면 import */}
                <Link to="">아이디찾기</Link> <Link to="">비밀번호찾기</Link>
                <button onClick={ onLogin } type="button">로그인</button>
            </form>
        </div>
    </>)
}