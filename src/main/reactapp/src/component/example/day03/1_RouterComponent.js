/*
    컴포넌트 만들기
        - 파일명 : 아무거나.js 혹은 아무거나.jsx [ 권장 : 컴포넌트명과 동일하게 ]
        - 컴포넌트 원형
            - 컴포넌트명 : 첫글자는 대문자 [ 무조건 , 카멜 표기법 ]
            export default function Component( props ){
                return(<></>)
            }
    컴포넌트 랜더링
        - 최상위 랜더링( 가장 먼저 랜더링 )
            1. index.js
                import 컴포넌트명 from '컴포넌트 경로'
                root.render(<React.StrictMode> <컴포넌트명/> </React.StrictMode> )

            2. 라우터 : 가상 URL 만들기
                - 실제 라우터 : 연결 경로를 자동으로 전환해주는 기계
                - 리액트 라우터 : 가상 경로[URL]를 만들어서 컴포넌트를 전환해주는 라이브러리
                - 설치
                    1. https://www.npmjs.com/
                    2. router-dom 검색
                    3. 리액트 버전 주의 ( 리액트 16버전 이상부터는 6.이상 쓰기 )
                        npm i router-dom   [ 2.2.11 ]
                        npm i react-router-dom [ 6.17.0 ] < 수업버전
                    4. 터미널(alt + f12)
                        1. 켜져있는 터미널 종료
                        2. 리액트 프로젝트로 이동 [ cd src/main/reactapp ]
                        3. npm i react-router-dom
                - 해당 파일에서 외부 라이브러리 import
                    import { BrowserRouter , Routes , Route , Link } from 'react-router-dom';
                    import 호출할 컴포넌트명 from '호출할 컴포넌트 경로'

                    <BrowserRouter>
                         <Routes >
                              <Route path='컴포넌트URL' element = { <컴포넌트명 /> } />
                         </Routes >
                    </BrowserRouter>

                - 다른 컴포넌트에서 컴포넌트(페이지) 전환
                    라우터경로: Route 컴포넌트의 path속성
                    1. <a href='{서버/라우터 경로}'> </a> 리로드
                    2. <Link to='라우터경로'> </Link>
*/

import { BrowserRouter , Routes , Route , Link } from 'react-router-dom'; // npm i react-router-dom 설치 후 가능
import Component1 from '../day01/1_component' // 다른 폴더에 있는 컴포넌트 호출
import Component2 from '../day01/2_component' // 다른 폴더에 있는 컴포넌트 호출
import Component3 from '../day01/3_component' // 다른 폴더에 있는 컴포넌트 호출
import Component4 from '../day01/4_component' // 다른 폴더에 있는 컴포넌트 호출

 export default function RouterComponent( props ){
     return(<>
        <BrowserRouter> {/* 브라우저 라우터 시작 */}
            < FixComponent /> {/* BrowserRouter 안에 있고 Routes 밖에 있는 컴포넌트 */}
            <Routes> {/* 화면이 전환되는 컴포넌트들의 URL 정의 공간 */}
                    { /* http://localhost:3000/day01/Component1 */}
                   <Route path='day01/Component1' element= { <Component1 /> } /> {/* 컴포넌트로 연결 할 가상 URL 경로 정의 */}
                   <Route path='day01/Component2' element= { <Component2 /> } /> {/* 컴포넌트로 연결 할 가상 URL 경로 정의 */}
                   <Route path='day01/Component3' element= { <Component3 /> } /> {/* 컴포넌트로 연결 할 가상 URL 경로 정의 */}
                   <Route path='day01/Component4' element= { <Component4 /> } /> {/* 컴포넌트로 연결 할 가상 URL 경로 정의 */}
             </Routes>
        </BrowserRouter> {/* 브라우저 라우터 종료 */}
     </>)
 }
 function FixComponent( props ){
    return(<>
        <div> {/* a 태그는 페이지 리로드 */}
            <a href='day01/Component1'>컴포넌트1</a>
            <a href='day01/Component2'>컴포넌트2</a>
            <a href='day01/Component3'>컴포넌트3</a>
            <a href='day01/Component4'>컴포넌트4</a>
        </div>
        <div> {/* Link 컴포넌트는 페이지 리로드x */}
            <Link to='day01/Component1'>컴포넌트1</Link>
            <Link to='day01/Component1'>컴포넌트2</Link>
            <Link to='day01/Component1'>컴포넌트3</Link>
            <Link to='day01/Component1'>컴포넌트4</Link>
        </div>
    </>)
 }