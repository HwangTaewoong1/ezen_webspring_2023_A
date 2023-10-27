/*
    Index : 여러 컴포넌트 들을 연결하는 최상위 컴포넌트
        - 가상URL 정의해서 컴포넌트 연결하는 공간/컴포넌트
*/
import { BrowserRouter , Routes , Route , Link } from 'react-router-dom';

/* 라우터에 적용할 컴포넌트 호출 */
import Header from './Header';
import Main from './Main';
import Footer from './Footer';

import Component1 from './example/day01/1_component';
import Component2 from './example/day01/2_component';
import Component3 from './example/day01/3_component';
import Component4 from './example/day01/4_component';
import Component5 from './example/day01/component_과제';
import CssComponent from './example/day02/1_componentCSS';
import CommentList from './example/day02/CommentList';
import ExampleList from './example/ExampleList';
import TodoList from './example/day02/Homework/todoList';
import Login from './member/Login'
import Signup from './member/Signup'
import AxiosComponent from './example/day04/1_AxiosComponent'
import Info from './member/Info'

export default function Index( props ){

    return(<>
        <div className="webContainer">
            <BrowserRouter>
                <Header />
                    <Routes>
                        {/* Main */}
                        <Route path='/' element={ <Main />} />

                        {/* Example */}
                       <Route path='/example' element={ <ExampleList />} />
                        <Route path='/example/day01/컴포넌트1' element={ <Component1 />} />
                        <Route path='/example/day01/컴포넌트2' element={ <Component2 />} />
                        <Route path='/example/day01/컴포넌트3' element={ <Component3 />} />
                        <Route path='/example/day01/컴포넌트4' element={ <Component4 />} />
                        <Route path='/example/day01/컴포넌트5' element={ <Component5 />} />
                        <Route path='/example/day02/CSS적용컴포넌트' element={ <CssComponent />} />
                        <Route path='/example/day02/CommentList' element={ <CommentList />} />
                        <Route path='/example/day02/TodoList' element={ <TodoList />} />
                        <Route path='/example/day04/AxiosComponent' element={ <AxiosComponent />} />

                     {/* Member */}
                     <Route path='/login' element={ <Login />} />
                     <Route path='/signup' element={ <Signup />} />
                     <Route path='/info' element={ <Info />} />
                    </Routes>
                <Footer />
            </BrowserRouter>
        </div>
    </>)
}