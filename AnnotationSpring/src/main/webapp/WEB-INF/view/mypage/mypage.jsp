<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<style>
	.subcontainer{
		padding: 30px 50px 50px 50px;
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
	.cartName{
		text-align: center;
		margin-top: -50px;
		padding-left: 30px;
	}
	.table{
		width: 100%;
	}
	.table thead{
		text-align: center;
		background-color: olive; opacity: 90%;
	}
	.table tfoot{
		background-color: olive; opacity: 90%;
	}
	.table tbody{
		text-align: center;
	}
	
	.table tbody tr td img{
		height: 75px;
		width: 75px;
	}
	.table tbody tr td p{
		padding-top: 23px;
	}
</style>
<div class="subcontainer">
	<h1>My Page</h1><hr>
	<div class="headContainer">
		<h2>내 정보</h2>
		<div class="mainContainer">
				<table class="table">
					<thead>
						<c:forEach var="s" items="${sign}">
							<tr>
								<td>구매자 성함</td>
								<td style="background-color: black; opacity: 80%; color: white;">${s.name}</td>
							</tr>
							<tr>
								<td>주소</td>
								<td style="background-color: black; opacity: 80%; color: white;">${s.address}</td>
							</tr>
							<tr>
								<td>전화번호</td>
								<td style="background-color: black; opacity: 80%; color: white;">${s.phone}</td>
							</tr>
							<tr>
								<td>이메일</td>
								<td style="background-color: black; opacity: 80%; color: white;">${s.email}</td>
							</tr>
						</c:forEach>
					</thead>
				</table>
				<div class="offset-md-11">
					<form action="updateInformation" method="post">
						<button class="btn btn-success" type="submit">개인정보 변경하기</button>
					</form>
				</div>
				<hr>
			<h2>구매내역</h2>
				<table class="table">
					<thead>
						<tr>
							<td>구매일자</td>
							<td>이미지</td>
							<td>상품번호</td>
							<td>상품명</td>
							<td>가격</td>
						</tr>
					</thead>
					<tbody>
						<c:set var="total" value="0" />
						<c:forEach var="b" items="${buy}">
							<c:set var="date" value="${b.buyDate}" />							
							<tr>
								<td><p>${fn:substring(date,0,10)}</p></td>
								<td><img alt="" src="image/product${b.imageName}"></td>
								<td><p>${b.pNumber}</p></td>
								<td><p>${b.pName}</p></td>
								<td><p>${b.price}</p></td>
								<c:set var= "total" value="${total + b.price}"/>
							</tr>
						</c:forEach>
					</tbody>
					<tfoot>
						<tr>
							<td> </td>
							<td> </td>
							<td> </td>
							<td>총 가격 : </td>
							<td><c:out value="${total}"/> 원</td>
						</tr>
					</tfoot>
				</table>
		</div>
	</div>
</div>