import styles from '../../css/login.css'; // css 호출
import {Link} from 'react-router-dom'; // Link 컴포넌트 호출
import axios from 'axios';
import {useState , useEffect } from 'react';

export default function Info( props ){ // 로그인 상태별로 , 회원권한(mrol) 별로 페이지 접근 제한

    // axios로 부터 전달받은 로그인된 회원정보를 상태변수에 저장
    const [ member , setMember ] = useState( null ); // 예시 { memail : 'qwe' mphone : 'qwe' }

    // 로그인 정보 호출해서 출력하기. [ 최초로 1번 실행 ]
    useEffect( ()=>{
             axios.get('/member/get').then( r=>{ setMember( r.data ); } );
    } , [] )

    // 1. 이름 입력 상태 변경
    const mnameInputChange = (e)=>{
         setMember({...member , mname : e.target.value })
     }

     // 2. 전화번호 변경 [ 바로.. 이벤트 속성 처리 ]


    const onDelete = (e) => {
        if( window.confirm('정말 탈퇴하시겠습니까?') ){ // 확인버튼 눌렀을때
            axios.delete("/memeber/delete" , { params : { mno : member.mno }})
            .then
        }
    }

    return(<>
    <div className="loginContainer">
        <h3>Ezen myinfo</h3>
        <form>
              회원등급 <div> { member != null ? member.mrol : '' } </div>
              이메일 <input disabled type="text" value={ member!=null ? member.memail : '' } className='memail'/>
              새 비밀번호  <input type="password" placeholder='특수문자 조함 5~30글자' className='mpassword'/>
              새 비밀번호 확인  <input type="password" placeholder='특수문자 조함 5~30글자' className='mpassword2'/>

              이름  <input type="text"
              value={ member != null ? member.mname : ''}
              placeholder='이름'
              onChange={ mnameInputChange }
              className='mname'
              />

              전화번호  <input type="text"
              value={ member != null ? member.mphone : ''}
              className='mphone'
              onChange={ (e) => { setMember( { ...member , mphone : e.target.value } ) } }
              />

              <button type="button"> 정보 수정 </button>
              <button type="button"> 회원 탈퇴 </button>
        </form>
    </div>
    </>)
}