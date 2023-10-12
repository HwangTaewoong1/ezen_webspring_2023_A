console.log('todo.js open');

// 1. POST AJAX
function Post1(){
    let tcontent = document.querySelector('.tcontent').value;

    $.ajax({
        url: '/todo',
        type: 'post',
        data: { tno: 0, tcontent: tcontent, tstate: true },
        success: r => {
            if( r ){ alert('등록 성공'); }
        },
        error: e => { }
    })
    tcontent = ''; // 등록 성공했으면 변수 초기화
    get1(); // 새로고침
} // f end

get1(); // 웹 켜질때 한번 실행
// 2. GET AJAX
function get1(){
    $.ajax({
        url: '/todo',
        type: 'get',
        data: {},
        success: r => { console.log(r);

            let todo_bottom = document.querySelector('.todo_bottom'); // js 출력구역
            let html = ``;

            r.forEach( s =>{

                if( s.tstate ){
                     html += `
                            <div class="todo">
                                <div class="tcontent"> ${s.tcontent} </div>
                                <div class="ectbtns">
                                    <button onclick="put1( ${s.tno}, '${s.tcontent}', '${s.tstate}' )" type="button"> 상태변경 </button>
                                    <button onclick="delete1( ${s.tno} )" type="button"> 제거하기 </button>
                                </div>
                            </div>`
                        }
                        else {
                                html += `
                                    <div class="todo successTodo">
                                        <div class="tcontent"> ${s.tcontent} </div>
                                        <div class="ectbtns">
                                            <button onclick="put1( ${s.tno}, '${s.tcontent}', '${s.tstate}' )" type="button"> 상태변경 </button>
                                            <button onclick="delete1( ${s.tno} )" type="button"> 제거하기 </button>
                                        </div>
                                    </div>`
                       }
            })
             todo_bottom.innerHTML = html;
        },
        error: e => { }
    })
} // f end

// 2. post


// 3. put ajax
function put1( tno, tcontent, tstate ){

        $.ajax({
            url: '/todo',
            type: 'put',
            data: { tno: tno, tcontent: tcontent, tstate: tstate },
            success: r => {
                if( r ){ console.log(r)
                    alert('수정 성공');
                }
            },
            error: e => { }
        })
    get1(); // 새로고침
}

// 4. delete ajax
function delete1( tno ){

        $.ajax({
            url: '/todo',
            type: 'delete',
            data: { tno: tno, },
            success: r => {

                if( r ){
                    console.log(r);
                    alert('삭제 성공')
                }
            },
            error: e => { }
        })

    get1(); // 새로고침
}