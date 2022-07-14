<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Member_Project</title>
    <link href="Member_Project.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script>
    $(document).ready(function () {


    	$("#button_register").click(function () {
    	    if ((!$('#member_name_register').val()) || (!$('#member_phone_register').val()) || (!$('#member_id_register').val()) || (!$('#member_pass_register').val())) {

    	        alert('빈 칸이 있어요!');
    	         } else {
    	        alert('회원가입 성공!');
    	        }
    	    
    	});

    	$("#button_login").click(function () {
    	    if ((!$('#member_id_login').val()) || (!$('#member_pass_login').val())) 
    	    {alert('빈 칸이 있어요!');}
    	    else {alert('로그인 성공!');}});

    	$("#button_remove").click(function () {
    	    if ((!$('#member_id_remove').val()) || (!$('#member_pass_remove').val())) 
    	    {alert('빈 칸이 있어요!');} 
    	    else {alert('제거성공!');}
    	});

    	$("#button_open_remove").click(function () {
    	    $("#remove_main").css("visibility", "visible");});


    	$("#button_open_login").click(function () {
    	    $("#login_main").css("visibility", "visible");});





    	});
    </script>
</head>

<body>
    <div id=main>
        <div id="regisetr_main">
            <form action="register.jsp" method="post">
                <h2>회원가입</h2>
                <div id="div_register">
                    <input type="text" id="member_name_register" placeholder="이름"><br>
                    <input type="text" id="member_phone_register" placeholder="핸드폰 번호"><br>
                    <input type="text" id="member_id_register" placeholder="ID"><br>
                    <input type="password" id="member_pass_register" placeholder="Password"><br>
                    <button type="submit" id="button_register">회원가입</button>
                    <button type="button" id="button_open_login">로그인창 오픈</button>
                </div>
            </form>
        </div>


        <div id="login_main">
            <form action="login.jsp" method="post">
                <h2>로그인</h2>
                <div id="div_login">
                    <input type="text" id="member_id_login" name = "mId" placeholder="ID"><br>
                    <input type="password" id="member_pass_login" name = "mPass" placeholder="Password"><br>
                    <button type="submit" id="button_login">로그인</button>
                    <button type="button" id="button_open_remove">회원탈퇴창 오픈</button>
                </div>
            </form>
        </div>

        <div id="remove_main">
            <form action="remove.jsp" method="post">
                <h2>회원탈퇴</h2>
                <div id="div_remove">
                    <input type="text" id="member_id_remove" placeholder="ID"><br>
                    <input type="password" id="member_pass_remove" placeholder="Password"><br>
                    <button type="submit" id="button_remove">회원탈퇴</button>
                </div>
            </form>
        </div>
    </div>
</body>

</html>