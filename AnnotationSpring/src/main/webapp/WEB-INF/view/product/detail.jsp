<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<style>
	#pimage{
		width: 600px;
		height: 700px;
	}
	.card-img-top{
		width: 100%;
		height: 170px;
	}
</style>
<section class="py-5">
            <div class="container px-4 px-lg-5 my-5">
                <div class="row gx-4 gx-lg-5 align-items-center">
                    
                    <c:forEach var="d" items="${detail}">                    
	                    <div class="col-md-6">
	                    	<img class="card-img-top mb-5 mb-md-0" src="image/product${d.fileName}" alt="..." id="pimage"/>
	                   	</div>
	                    
	                    <div class="col-md-6">
	                    	<c:set var="date" value="${d.regdate}" />
	                        <div class="small mb-1">제품 번호 : ${d.pNumber} / 판매일 : ${fn:substring(date,0,10)} / 조회수 : ${d.hit}</div>
	                        <h1 class="display-5 fw-bolder">${d.pName}</h1>
	                        <div class="fs-5 mb-5">
	                            <!-- <span class="text-decoration-line-through">$45.00</span> -->
	                            <span>가격 : ${d.price}</span>
	                        </div>
	                        <div class="small mb-1">상품설명</div>
	                        <p class="lead">${d.content}</p>
	                        <div class="offset-md-5">
	                           <!-- <input class="form-control text-center me-3" id="inputQuantity" type="text" value="1" style="max-width: 3rem" />
	                             <button class="btn btn-outline-dark flex-shrink-0" type="button">
	                                <i class="bi-cart-fill me-1"></i>
	                                Add to cart
	                            </button> -->
	                            <c:choose>
	                            	<c:when test="${sessionScope.id ne null}">
	                            		<form action="addCart" method="post" class="col mb-5">
				                            <input type="hidden" name="pNumber" value="${d.pNumber}">
						                    <input type="hidden" name="pName" value="${d.pName}">
						                    <input type="hidden" name="imagePath" value="${d.filePath}">
						                    <input type="hidden" name="imageName" value="${d.fileName}">
						                    <input type="hidden" name="price" value="${d.price}">
						                    <input type="hidden" name="count" value="1">
				                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
				                                <div class="text-center"><button class="btn btn-outline-dark mt-auto" type="submit">
				                                <i class="bi-cart-fill me-1"></i>
				                                Add to cart</button></div>
				                            </div>
	                            		</form>
	                            	</c:when>
	                            	<c:otherwise>
	                            		<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
				                                <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="login">
				                                <i class="bi-cart-fill me-1"></i>
				                                Add to cart</a></div>
				                            </div>
	                            	</c:otherwise>
	                            </c:choose>
	                        </div>
	                    </div>
                    </c:forEach>
              	</div>
              	<c:forEach var="d" items="${detail}">   
	                <c:choose>
	                	<c:when test="${sessionScope.id eq 'admin'}">
			                <div class="offset-md-10">
				                <a class="btn btn-warning" type="button" href="update?pNumber=${d.pNumber}">수정</a>
				                <a class="btn btn-danger" type="button" href="deleteService?pNumber=${d.pNumber}">삭제</a>
			                </div>
	                	</c:when>
	                	<c:otherwise>
	                		<div class="offset-md-10">
				                <a class="btn btn-primary" href="list">목록</a>
			                </div>
	                	</c:otherwise>
	                </c:choose>
                </c:forEach>
            </div>
        </section>
        <!-- Related items section-->
        <section class="py-5 bg-light">
            <div class="container px-4 px-lg-5 mt-5">
                <h2 class="fw-bolder mb-4">HIT Products</h2>
                <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                    <c:forEach var="h" items="${hitList}">                    
	                    <div class="col mb-5">
	                        <div class="card h-100">
	                            <!-- Sale badge-->
		                            <c:choose>
			                            <c:when test="${h.sale eq 1}">
				                            <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">Sale</div>
			                            </c:when>
		                            </c:choose>
		                            <!-- Product image-->
		                            <a href="detail?pNumber=${h.pNumber}">
		                            	<img class="card-img-top" src="image/product${h.fileName}" alt="..."/>
		                            	<!-- https://dummyimage.com/450x300/dee2e6/6c757d.jpg -->
		                            </a>
		                            <!-- Product details-->
		                            <div class="card-body p-4">
		                                <div class="text-center">
		                                    <!-- Product name-->
		                                    <h5 class="fw-bolder"><a href="detail?pNumber=${h.pNumber}" style="color: black; text-decoration: none;">${h.pName}</a></h5>
		                                    <!-- Product reviews-->
		                                    <div class="d-flex justify-content-center small text-warning mb-2">
		                                    	<div class="bi-star-fill"></div>
		                                        <div class="bi-star-fill"></div>
		                                        <div class="bi-star-fill"></div>
		                                        <div class="bi-star-fill"></div>
		                                        <div class="bi-star-fill"></div>
		                                    </div>
		                                    <!-- Product price-->
		                                    <!-- <span class="text-muted text-decoration-line-through">$20.00</span> -->
		                                    ${h.price}원
		                                </div>
		                            </div>
		                            <!-- Product actions-->
		                            <c:choose>
		                            	<c:when test="${sessionScope.id ne null}">
		                            		<form action="addCart" method="post" class="col mb-5">
					                            <input type="hidden" name="pNumber" value="${h.pNumber}">
							                    <input type="hidden" name="pName" value="${h.pName}">
							                    <input type="hidden" name="imagePath" value="${h.filePath}">
							                    <input type="hidden" name="imageName" value="${h.fileName}">
							                    <input type="hidden" name="price" value="${h.price}">
							                    <input type="hidden" name="count" value="1">
					                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
					                                <div class="text-center"><button class="btn btn-outline-dark mt-auto" type="submit">Add to cart</button></div>
					                            </div>
		                            		</form>
		                            	</c:when>
		                            	<c:otherwise>
		                            		<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
					                                <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="login">Add to cart</a></div>
					                            </div>
		                            	</c:otherwise>
		                            </c:choose>
		                        </div>
		                    </div>
                    </c:forEach>
                </div>
            </div>
        </section>