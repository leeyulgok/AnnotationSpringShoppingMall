<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
	.card-img-top{
		width: 100%;
		height: 170px;
	}
</style>
<!-- Header-->
<header class="bg-dark py-5">
    <div class="container px-4 px-lg-5 my-5">
        <div class="text-center text-white">
            <h1 class="display-4 fw-bolder">Shop in style</h1>
            <p class="lead fw-normal text-white-50 mb-0">With this shop hompeage template</p>
        </div>
    </div>
</header>
<section class="py-5">
            <div class="container px-4 px-lg-5 mt-5">
                <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                    
                    <c:forEach var="s" items="${search}">                    
	                    <div class="col mb-5">
	                        <div class="card h-100">
	                            <!-- Sale badge-->
	                            <c:choose>
		                            <c:when test="${s.sale eq 1}">
			                            <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">Sale</div>
		                            </c:when>
	                            </c:choose>
	                            <!-- Product image-->
	                            <a href="detail?pNumber=${s.pNumber}">
	                            	<img class="card-img-top" src="image/product${s.fileName}" alt="..." />
	                            	<!-- https://dummyimage.com/450x300/dee2e6/6c757d.jpg -->
	                            </a>
	                            <!-- Product details-->
	                            <div class="card-body p-4">
	                                <div class="text-center">
	                                    <!-- Product name-->
	                                    <h5 class="fw-bolder"><a href="detail?pNumber=${s.pNumber}" style="color: black; text-decoration: none;">${s.pName}</a></h5>
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
	                                    ${s.price}원
	                                </div>
	                            </div>
	                            <!-- Product actions-->
	                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
	                                <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">Add to cart</a></div>
	                            </div>
	                        </div>
	                    </div>
                    </c:forEach>
                    
                </div>
            </div>
        </section>