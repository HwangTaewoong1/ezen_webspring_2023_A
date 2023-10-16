console.log("todo JS 실행");

// 1. post AJAX
function post1() {
    console.log("post1() 실행");

    let tphone = document.querySelector(".tphone").value;
    let tcontent = document.querySelector(".tcontent").value;

    $.ajax({
        url : "/phone",
        method : "post",
        contentType: "application/json",
        data : JSON.stringify({ tcontent : tcontent , tphone : tphone }) ,
        success : function f(r){
             alert("등록 되었습니다.");
             tphone = '';
             tcontent = '';
             get1();
        } ,
        error : function f(e){
            console.log("통신실패 : "+e)
        }
    })
}

// 2. get AJAX -
get1();
function get1() {
    console.log("getTodo() 실행");

    let todo_bottom = document.querySelector(".todo_bottom");
    let HTML =``;
    $.ajax({
        url : "/phone",
        method : "get",
        data : {} ,
        success : function f(r){
            console.log(" get 통신성공 : ")
            console.log(r)
            r.forEach( (s) => {
                    HTML +=`<div style="diplay:flex;" class="todo">
                        <div class="tcontent"> 이름: ${s.tcontent} </div>
                        <div class="tcontent"> 휴대번호: ${s.tphone} </div>
                    <div class="etcbtns">
                        <button onclick="put1(${s.tno})" type="button"> 수정하기 </button>
                        <button onclick="delete1(${s.tno})" type="button"> 제거하기 </button>
                   </div>
                 </div>
                `;
            });
            todo_bottom.innerHTML = HTML;
        } ,
        error : function f(e){
            console.log("통신실패 : "+e)
        }
    })
}

// 3. put AJAX
function put1(tno) {
    console.log("putTodo() 실행");

    let newtcontent = prompt('변경할 이름을 입력하세요.'); console.log(newtcontent);
    let newtphone = prompt('변경할 휴대폰번호를 입력하세요.'); console.log(newtphone);

    $.ajax({
        url : "/phone",
        method : "put",
        data :JSON.stringify( { tno : tno, tcontent : newtcontent , tphone : newtphone }),
        contentType: "application/json",
        success : function f(r){
            alert("상태가 수정 되었습니다.");
                get1();

        } ,
        error : function f(e){
            console.log("통신실패 : ")
            console.log(e)
        }
    })
}

// 4. delete AJAX
function delete1(tno) {
    console.log("delete1() 실행");

    $.ajax({
        url : "/phone",
        method : "delete",
        data : { tno : tno } ,
        success : function f(r){
                 alert("삭제되었습니다.");
                 get1();
        } ,
        error : function f(e){
            console.log("통신실패 : "+e)
        }
    })
}