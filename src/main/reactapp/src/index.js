import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';

// 3. 내가 만든 컴포넌트(jsx파일 내 함수) 호출
// import 컴포넌트명 from 'jsx파일경로';
// import Component1 from './component/example/day01/1_component.jsx'
// import Component2 from './component/example/day01/2_component.jsx'
// import Component3 from './component/example/day01/3_component.jsx'
import Component4 from './component/example/day01/4_component.jsx'
// 1. index.html에 <div id="root"> dom객체 호출
const root = ReactDOM.createRoot(document.getElementById('root'));

// 2. 리액트 랜더링 ( JSX --> HTML 변환 )
// <React.StrictMode> : 예외처리 컴포넌트
// root.render( <React.StrictMode> <App /> </React.StrictMode> );
// root.render( <React.StrictMode> <Component1 /> </React.StrictMode> );
// root.render( <React.StrictMode> <Component2 /> </React.StrictMode> );
root.render( <React.StrictMode> <Component4 /> </React.StrictMode> );

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
