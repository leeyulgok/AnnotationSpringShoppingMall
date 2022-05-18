<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<main class="form-signin">
	<form action="signupService" method="post" name="form">
	  <h1 class="h3 mb-3 fw-normal" style="text-align: center; font-size: 40px; color:white;">Please Sign Up</h1>
	  <div class="form-floating">
	    <input type="text" class="form-control" name="name" placeholder="name">
	    <label for="floatingInput">Your Name</label>
	  </div>
	  <div class="form-floating">
	    <input type="text" class="form-control" id="id" name="id" placeholder="Id">
	    <label for="floatingInput">Your Id</label>
	  </div>
	  <div class="form-floating">
	    <input type="password" class="form-control"id="password" name="password" placeholder="Password">
	    <label for="floatingInput">Password</label>
	  </div>
	  <div class="form-floating">
	    <input type="password" class="form-control" name="passwordCheck" placeholder="PasswordCheck">
	    <label for="floatingInput">PasswordCheck</label>
	  </div>
		<input class="btn btn-success" type="button" onClick="goPopup();" value="주소검색"/>
	  <div class="form-floating">
	    <input type="text" class="form-control" name="address" placeholder="address">
	    <label for="floatingInput">Address</label>
	  </div>
	  <div class="form-floating">
	    <input type="text" class="form-control" name="phone" placeholder="phone">
	    <label for="floatingInput">Phone</label>
	  </div>
	  <div class="form-floating">
	    <input type="email" class="form-control" name="email" placeholder="email">
	    <label for="floatingInput">Email</label>
	  </div>
	  <br><button class="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>
	</form>
</main>
<script>
function goPopup() {
		var pop = window.open("/jusoPopup","pop","width=570,height=420, scrollbars=yes, resizable=yes");
	}
function jusoCallBack(address) {
		document.form.address.value = address;
	}
</script>