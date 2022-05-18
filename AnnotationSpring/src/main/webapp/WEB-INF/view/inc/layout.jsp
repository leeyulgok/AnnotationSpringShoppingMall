<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Shopping Mall</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
		<!-- Custom styles for this template -->
    	<link href="css/signin.css" rel="stylesheet">
    </head>
    <body>
        <!-- Navigation-->
        <tiles:insertAttribute name="header"/>
        <!-- Page Content-->
        <tiles:insertAttribute name="body"/>
        <!-- footer -->
        <tiles:insertAttribute name="footer"/>
    </body>
</html>
