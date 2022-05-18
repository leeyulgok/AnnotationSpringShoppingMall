<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
	.cartName{
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
			<h1>${sessionScope.id}님의 장바구니</h1><br>
		</div>
		<form action="purchase" method="post" name="form">
				<table class="table">
					<thead>
						<tr>
							<td>선택</td>
							<td>이미지</td>
							<td>상품번호</td>
							<td>상품명</td>
							<td>가격</td>
							<td>수량</td>
							<td>삭제</td>
						</tr>
					</thead>
					<tbody>
						<c:set var="total" value="0" />
						<c:forEach var="c" items="${cart}">
							<c:choose>
								<c:when test="${!empty cart}">								
									<tr>
										<td><input type="checkbox" name="purchaseChoice" value="${c.cartNumber}" checked="checked"></td>
										<td>
											<a href="detail?pNumber=${c.pNumber}"><img alt="" src="image/product${c.imageName}"></a>
										</td>
										<td><p>${c.pNumber}</p></td>
										<td><p>${c.pName}</p></td>
										<td><p>${c.price}</p></td>
										<td><p>${c.count}</p></td>
										<td><p><a  style="color: red;"class="btn btn-warning" type="button" href="deleteCart?cartNumber=${c.cartNumber}">X</a></p></td>
										<c:set var= "total" value="${total + c.price}"/>
									</tr>
								</c:when>
							</c:choose>
						</c:forEach>
					</tbody>
					<tfoot>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td>총 가격 :</td>
							<td><c:out value="${total}"/></td>
							<td>원</td>
						</tr>
					</tfoot>
				</table>
			
			<div class="offset-md-10">			
				<a class="btn btn-danger" type="button" href="deleteCartAll">전체 삭제하기</a>
				<button class="btn btn-primary" type="submit">구매하기</button>
			</div>
		</form>
	</div>
</section>