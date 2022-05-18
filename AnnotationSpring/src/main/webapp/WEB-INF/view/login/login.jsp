<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<main class="form-signin">
	<form action="loginService" method="post">
	  <h1 class="h3 mb-3 fw-normal" style="text-align: center; font-size: 40px; color:white;">Please Login</h1>
	  <div class="form-floating">
	    <input type="text" class="form-control" id="id" name="id" placeholder="Id">
	    <label for="floatingInput">Your Id</label>
	  </div>
	  <div class="form-floating">
	    <input type="password" class="form-control" id="password" name="password" placeholder="Password">
	    <label for="floatingPassword">Password</label>
	  </div><br>
	  <div class="checkbox mb-3" style="float: right;">
	    <label style="color: white;">
	      <input type="checkbox" value="remember-me"> Remember me
	    </label>
	  </div>
	  <button class="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>
	  <p class="mt-5 mb-3 text-muted" style="text-align: center;">&copy; 2017–2022</p>
	</form>
</main>