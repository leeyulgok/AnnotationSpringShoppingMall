<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
$( document ).ready(function(){
	var sel1 = {
    	" ":"Type",
    	"T":"Top",
        "B":"Bottom",
       	"S":"Shoes",
   		"A":"Acc"
    };
	
    var sel2_1 = {
    	"T01": "Outer",
        "T02": "Shirt",
        "T03": "MtoM",
        "T04": "T-Shirt"
    };
    var sel2_2 = {
    	"B01": "Jean",
        "B02": "Cotton",
        "B03": "Shorts"
    };
    var sel2_3 = {
    	"S01": "Sneakers",
        "S02": "Runnig"
    };
    var sel2_4 = {
    	"A01": "Acc"
    };
    
    var sel3 = {
    	"Small": "S",
        "Medium": "M",
        "Large": "L"
    };
    
   //sel1에 서버에서 받아온 값을 넣기위해..
   // map배열과 select 태그 id를 넘겨주면 option 태그를 붙여줌.
   // map[키이름] = 그 키에 해당하는 value를 반환한다.
   //retOption(데이터맵, select함수 id)
   function retOption(mapArr, select){
    	var html = '';
    	var keys = Object.keys(mapArr);
    	for (var i in keys) {
    	    html += "<option value=" + "'" + keys[i] + "'>" + mapArr[keys[i]] + "</option>";
    	}
        
        $("select[id='" + select +"']").html(html);
   }
   
   $("select[id='sel1']").on("change", function(){
    	var option = $("#sel1 option:selected").val();
        var subSelName = '';
    	if(option == "T") {
        	subSelName = "sel2_1";
        } else if(option == "B"){
        	subSelName = "sel2_2";
        } else if(option == "S"){
        	subSelName = "sel2_3";
        } else if(option == "A"){
        	subSelName = "sel2_4";
        } else{
        	$("#sel2").hide();
        	return;
        }
        $("#sel2").show();
        retOption(eval(subSelName), "sel2");
    })
   retOption(sel1, "sel1");

   $("select[id='sel1']").on("change", function(){
		var option = $("#sel1 option:selected").val();
	    var subSelName = '';
		if(option == "T" || option == "B") {
	    	subSelName = "sel3";
	    } else {
	    	$("#sel3").hide();
	    	return;
	    }
	    $("#sel3").show();
	    retOption(eval(subSelName), "sel3");
	})
	retOption(sel1, "sel1");
});
function readURL(input) {
	  if (input.files && input.files[0]) {
	    var reader = new FileReader();
	    reader.onload = function(e) {
	      document.getElementById('preview').src = e.target.result;
	    };
	    reader.readAsDataURL(input.files[0]);
	  } else {
	    document.getElementById('preview').src = "";
	  }
	}
</script>
<style>
	img{
		width: 600px;
		height: 700px;
	}
</style>
<section class="py-5">
            <div class="container px-4 px-lg-5 my-5">
                <div class="row gx-4 gx-lg-5 align-items-center">
                    
                    <c:forEach var="u" items="${update}">                    
                    <div class="col-md-6">
                    	<img class="card-img-top mb-5 mb-md-0" src="image/product${u.fileName}" alt="..." id="preview"/>
                    </div>
                    
                    <div class="col-md-6">
                    	<h1>Product Update</h1><hr>
                    	<form action="updateService" method="post" enctype="multipart/form-data" name="form">
                    		<input type="hidden" name="pNumber" value="${u.pNumber}">
                    		<h2>Type</h2>
	                    		<select name="type" id="sel1"></select>
	                    		<select name="typeNumber" id="sel2" style="display: none"></select>
	                    		<select name="size" id="sel3" style="display: none"></select>
                    		<h2>Name</h2>
                    			<input type="text" name="pName" size="45" placeholder="제품 이름" value="${u.pName}">
                    		<h2>Price</h2>
                    			<input type="text" name="price" size="45" placeholder="숫자만 입력하세요." value="${u.price}">
                    		<h2>Content</h2>
                    			<textarea rows="5" cols="45" placeholder="제품설명" maxlength="150" name="content">${u.content}</textarea>
                    		<p><a style="font-size: 30px;">Sale</a> Yes OR NO  
                    		<c:choose>
                    			<c:when test="${u.sale == 1}">
		                    		<input type="checkbox" value="1" name="sale" checked>
                    			</c:when>
                    			<c:otherwise>
                    				<input type="checkbox" value="1" name="sale">
                    			</c:otherwise>
                    		</c:choose>
                    		</p>
                    		<input type="file" name="file" onchange="readURL(this)">
                    		<br><br><button class="btn btn-lg btn-primary" type="submit">Update</button>
                    	</form>
                    </div>
                    </c:forEach>
              	</div>
            </div>
        </section>