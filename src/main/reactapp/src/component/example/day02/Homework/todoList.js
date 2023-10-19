// ! 다른 컴포넌트 호출 하기 : import 컴포넌트명 from '파일경로'
import Todo from './todo.js';

export default function TodoList( props ){

    let response = [
            {content : '리액트 배우기'} ,
            {content : '자바 배우기'} ,
            {content : '파이썬 배우기'} ,
            {content : 'C언어 배우기'} ,
    ];

    return(<>
       <div className="todowrap">
        <h1> 나만의 할 일 목록 </h1>
        <div class="todo_top">
                    <input className="tcontent" type="text"/>
                    <button type="button">등록</button>
        </div>

       {
            response.map((r)=>{
                return( <Todo content = { r.content } />);
            })
       }
       </div>
    </>);
}