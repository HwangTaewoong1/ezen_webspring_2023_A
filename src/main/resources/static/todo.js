console.log("todo JS 실행");

// 1. post AJAX
function post1() {
    console.log("post1() 실행");

    let tcontent = document.querySelector(".tcontent").value;

    $.ajax({
        url : "/todo",
        method : "post",
        contentType: "application/json",
        data : JSON.stringify({ tcontent : tcontent , tstate : false }) ,
        success : function f(r){
            console.log(" post 통신성공 : "+r)
            if(r){
             alert("등록 되었습니다.");
             get1();
            }
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
        url : "/todo",
        method : "get",
        data : {} ,
        success : function f(r){
            console.log(" get 통신성공 : ")
            console.log(r)
            r.forEach( (s) => {

                if( !s.tstate ){ HTML +=`<div class="todo">`; }
                else { HTML +=`<div class="todo successTodo">`; }

                HTML +=`
                    <div class="tcontent"> ${s.tcontent} </div>
                    <div class="etcbtns">
                        <button onclick="put1(${s.tno},${s.tstate})" type="button"> 상태변경 </button>
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
function put1(tno,tstate) {
    console.log("putTodo() 실행");

    let newtstate = !tstate;

    $.ajax({
        url : "/todo",
        method : "put",
        data :JSON.stringify( { tno : tno, tstate : newtstate }) ,
        contentType: "application/json",
        success : function f(r){
            console.log("통신성공 : "+r)
                if(r) { alert("상태가 수정 되었습니다.");}
                else { alert("수정을 실패했습니다.");}
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
        url : "/todo",
        method : "delete",
        data : { tno : tno } ,
        success : function f(r){
            console.log("통신성공 : "+r)
            if(r){
                 alert("삭제되었습니다.");
                 get1();
            }
        } ,
        error : function f(e){
            console.log("통신실패 : "+e)
        }
    })
}