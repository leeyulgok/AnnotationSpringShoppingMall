<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	.subcontainer{
		padding: 30px 50px 50px 50px;
		margin-bottom: 350px;
	}
	.headContainer{
		width: 100%;
		height: 100%;
		text-align: center;
	}	
</style>
<div class="subcontainer">
	<h1>My Page</h1>
	<div class="headContainer">
		<hr>
		<h3>비밀번호 확인</h3><br>
		<div class="mainForm">
			<form action="mypage" method="post">
				<input type="password" name="password" maxlength="20" placeholder="비밀번호를 입력해주세요." size="40">
				<div class="offset-md-10">
	                <button class="btn btn-primary" type="submit">확인하기</button>
                </div>
			</form>
		</div>
	</div>
</div>