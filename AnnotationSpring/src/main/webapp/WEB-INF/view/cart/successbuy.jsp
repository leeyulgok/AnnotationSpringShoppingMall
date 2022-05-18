<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
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
<section class="py-5">
	<div class="container px-4 px-lg-5 mt-5">
		<div class="cartName">
			<h1>구매완료</h1><hr><br>
		</div>
			<h2>구매자 정보</h2>
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
			<h2>구매상품</h2>
				<table class="table">
					<thead>
						<tr>
							<td>이미지</td>
							<td>상품번호</td>
							<td>상품명</td>
							<td>가격</td>
							<td>수량</td>
						</tr>
					</thead>
					<tbody>
						<c:set var="total" value="0" />
						<c:forEach var="r" items="${list}">
							<input type="hidden" name="cartNumber" value="${r.cartNumber}"/>
							<c:choose>
								<c:when test="${!empty cart}">								
									<tr>
										<td><img alt="" src="image/product${r.imageName}"></td>
										<td><p>${r.pNumber}</p></td>
										<td><p>${r.pName}</p></td>
										<td><p>${r.price}</p></td>
										<td><p>${r.count}</p></td>
										<c:set var= "total" value="${total + r.price}"/>
									</tr>
								</c:when>
							</c:choose>
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
			<div class="offset-md-11">
				<a class="btn btn-primary" type="button" href="list">완료</a>
			</div>
	</div>
</section>