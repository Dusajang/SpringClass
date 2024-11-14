console.log("Dept Module........");

const deptService = (function(){

	// http://localhost/scott/dept/new 새로운 부서 추가
	// JSON.stringify(dept) js객체 -> JSON
	function add(dept,callback, error){
		console.log("> deptService.add()........");
		
		$.ajax({
			type:'post',
			url:'/scott/dept/new',
			data:JSON.stringify(dept),
			contentType:"application/json; charset=utf-8",
			cache:false,
			beforeSend:function (xhr){
				console.log("add.beforeSend........");
			},
			success:function(result, status, xhr){
				if(callback){
					callback(result);
				} //if
			},
			error:function(xhr, status, er){
				if(error){
					error(er);
				}//if
			}
		});
		
	}// add


function deleteDept(deptno, callback, error) {
    console.log("> deptService.delete()...");

    $.ajax({
        type: 'DELETE',
        url: '/scott/dept/delete/' + deptno, // 경로에 deptno를 포함하여 전송
        contentType: "application/json; charset=utf-8",
        cache: false,
        beforeSend: function(xhr) {
            console.log("delete.beforeSend...");
        },
        success: function(result, status, xhr) {
            if (callback) {
                callback(result);
            }
             $(event.target).closest("tr").remove();
        },
        error: function(xhr, status, er) {
            if (error) {
                error(er);
            }
        }
    });

}
	return {
		add:add,
	};
})();


function deleteDept(deptno, callback, error) {
    console.log("> deptService.delete()...");

    $.ajax({
        type: 'DELETE',
        url: '/scott/dept/delete/' + deptno, // 경로에 deptno를 포함하여 전송
        contentType: "application/json; charset=utf-8",
        cache: false,
        beforeSend: function(xhr) {
            console.log("delete.beforeSend...");
        },
        success: function(result, status, xhr) {
            if (callback) {
                callback(result);
            }
             $(event.target).closest("tr").remove();
        },
        error: function(xhr, status, er) {
            if (error) {
                error(er);
            }
        }
    });

}




