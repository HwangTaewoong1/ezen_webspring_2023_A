console.log('todo.js open');

// 1.post ajax
.ajax({
    url:'/todo',
    type:'post',
    data:{},
    success: r=>{console.log(r)},
    })
// 2.get ajax
   .ajax({
    url:'/todo',
    type:'get',
    data:{},
    success:  r=>{console.log(r)} ,
    })
// 3.put ajax
.ajax({
    url:'/todo',
    type:'put',
    data:{},
    success:  r=>{console.log(r)},
    })
// 4.delete ajax
.ajax({
    url:'/todo',
    type:'delete',
    data:{},
    success: r=>{console.log(r)} ,
    })