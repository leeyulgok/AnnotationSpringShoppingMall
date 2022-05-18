<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="js/backstrech.min.js"></script>
<script src="js/scripts.js"></script>
<script>
	$(function(){
		$.backstretch(["/image/main/main1.jpg","/image/main/main2.jpg","/image/main/main3.jpg"],
		{duration: 4000, fade:500});
	});
</script>