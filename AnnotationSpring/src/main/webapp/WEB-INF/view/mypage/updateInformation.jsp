<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
	.subcontainer{
		padding: 30px 50px 50px 50px;
		margin-bottom: 350px;
	}
	.headContainer{
		height: 100%;
		text-align: center;
	}
	.mainContainer{
		width: 80%;
		text-align: center;
		display: inline-block;
	}	
</style>
<div class="subcontainer">
	<h1>My Page</h1><hr>
	<div class="headContainer">
		<h2>내 정보</h2>
		<div class="mainContainer">
			<form action="updateInformationService" method="post">
				<table class="table">
					<thead>
						<c:forEach var="s" items="${list}">
							<tr>
								<td>구매자 성함</td>
								<td style="background-color: black; opacity: 80%; color: white;">
								${s.name}
								</td>
							</tr>
							<tr>
								<td>주소</td>
								<td style="background-color: black; opacity: 80%; color: white;">
								<input type="text" value="${s.address}" size="40" name="address" id="address"> <input class="btn-success" type="button" onClick="goPopup();" value="주소검색"/>
								</td>
							</tr>
							<tr>
								<td>전화번호</td>
								<td style="background-color: black; opacity: 80%; color: white;">
								<input type="text" value="${s.phone}" size="40" placeholder="전화번호를 숫자만 입력하세요" name="phone">
								</td>
							</tr>
							<tr>
								<td>이메일</td>
								<td style="background-color: black; opacity: 80%; color: white;">
								<input type="email" value="${s.email}" size="40" placeholder="이메일을 입력해주세요" name="email">
								</td>
							</tr>
						</c:forEach>
					</thead>
				</table>
				<div class="offset-md-11">
						<button class="btn btn-primary" type="submit">변경완료</button>
				</div>
			</form>
				
		</div>
	</div>
</div>
<script>
function goPopup() {
		var pop = window.open("/jusoPopup","pop","width=570,height=420, scrollbars=yes, resizable=yes");
	}
function jusoCallBack(address) {
		document.getElementById('address').value = address
	}
</script>