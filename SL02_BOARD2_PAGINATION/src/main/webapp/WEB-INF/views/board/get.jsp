<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" type="image/x-icon" href="images/SiSt.ico">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/resources/cdn-main/example.css">
<script src="/resources/cdn-main/example.js"></script>
<style>
 span.material-symbols-outlined{
    vertical-align: text-bottom;
 }  
</style>
</head>
<body>
<header>
  <h1 class="main"><a href="#" style="position: absolute;top:30px;">Doodda77 HOme</a></h1>
  <ul>  
    <li><a href="#">로그인</a></li>
    <li><a href="#">회원가입</a></li>
  </ul>
</header>
<div>
  <xmp class="code"> 
  	get.jsp
  </xmp>
  
  <form action="/board/register" method="post">
     <table>  
       <tbody>
         <tr>
           <th>글번호</th>
           <td><input type="text" name="bno" class="full"  readonly="readonly"  value="${ boardVO.bno }"></td>        
         </tr> 
         <tr>
           <th>제목</th>
           <td><input type="text" name="title" class="full"  readonly="readonly"  value="${ boardVO.title }"></td>        
         </tr> 
         <tr>
           <th>내용</th>
           <td><textarea  name="content" class="full" readonly="readonly"><c:out value="${ boardVO.content }"></c:out></textarea></td>        
         </tr> 
         <tr>
           <th>작성자</th>
           <td><input type="text" name="writer" class="short" readonly="readonly" value="${ boardVO.writer }"></td>        
         </tr>  
       </tbody> 
       <tfoot>
         <tr>
           <td colspan="2">
             <button type="button"  data-oper="modify" class="edit">Modify</button>
             <button type="button"  data-oper="remove" class="delete">Delete</button>
             <button type="button" data-oper="list"  class="list">List</button>
           </td>
         </tr>
       </tfoot>
     </table>
     
     <input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
     
     <!-- pageNum, amount -->
     <input type="hidden" name="pageNum" value="${ criteria.pageNum }">
     <input type="hidden" name="amount" value="${ criteria.amount }">
       
  </form> 
  
  <script>
  	$(function (){
		var formObj = $("form");
		$("tfoot button").on("click", function (event){
			let operation = $(this).data("oper");
			if (operation==='modify') {
				//location.href = "/board/modify?bno=2"
				//location.href = "/board/modify/2"
				formObj
				.attr({
					"action":"/board/modify",
					"method":"get"
				})
				.submit();
			}else if (operation === 'remove') {
			    if (confirm("글을 삭제하시겠습니까?")) {
			        // 사용자가 확인 버튼을 클릭했을 때 실행할 코드
			        console.log("삭제를 진행합니다.");
			        formObj
					.attr({
						"action":"/board/delete",
						"method":"get"
					})
					.submit();
			    } else {
			        // 사용자가 취소 버튼을 클릭했을 때 실행할 코드
			        console.log("삭제를 취소합니다.");
			    }
			}else if (operation==='list') {
				// location.href = "/board/list"
				let pageNumTag = $(":hidden[name='pageNum']").clone();
				let amountTag = $(":hidden[name='amount']").clone();
				
				formObj
					.attr({
						"action":"/board/list",
						"method":"get" 
					})
					.empty()
					.append(pageNumTag)
					.append(amountTag)
					.submit();
			}
		})//click
		
	})//document.ready
  </script>
  
  
</div> 
</body>
</html>







 
