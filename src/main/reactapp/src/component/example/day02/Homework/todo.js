
import styles from './todo.css';

export default function Todo( props ){ /* 하나의 게시물 구역 */
    return(<>
        <div className="">
            <div className="commentBox">
                                    <div className="todo">
                                    <div className="tcontent"> {props.content} </div>
                                    <div className="etcbtns">
                                        <button type="button"> 상태변경 </button>
                                        <button type="button"> 제거하기 </button>
                                   </div>
                                 </div> { /* 게시물 내용 */ }
            </div>
        </div>
    </>);
}