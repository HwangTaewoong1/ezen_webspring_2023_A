import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';

// 3. 내가 만든 컴포넌트(jsx파일 내 함수) 호출
import Index from './component/Index'
import 상태관리컴포넌트 from './component/example/day05/1_상태관리컴포넌트'
import 생명주기컴포넌트 from './component/example/day05/2_생명주기컴포넌트'

// 1. index.html에 <div id="root"> dom객체 호출
const root = ReactDOM.createRoot(document.getElementById('root'));

// 2. 리액트 랜더링 ( JSX --> HTML 변환 )
// <React.StrictMode> : 예외처리 컴포넌트
root.render(<Index />);
// root.render(<상태관리컴포넌트 />);
// root.render(<생명주기컴포넌트 />);
// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
