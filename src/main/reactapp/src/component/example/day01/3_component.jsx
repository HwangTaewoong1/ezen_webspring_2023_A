/*
    컴포넌트 내부에서 다른 컴포넌트를 호출하는 방법
        1. 같은 jsx 파일이면 import 생략
        2. 다른 jsx 파일이면 import
*/


function Component3(){
    return(<>
            <h3>  'Component3'컴포넌트(함수)에서 작성된 HTML</h3>
            {/* 다른 컴포넌트(함수) 호출하는 방법 */}
            <Myselfmadetag /> {/* 주석처리 */}
            <input />
    </>)
}
function Myselfmadetag(){
    return(<>
            <div> 'myselfmadetag'컴포넌트(함수)에서 작성된 HTML </div>
    </>)
}
export default Component3;