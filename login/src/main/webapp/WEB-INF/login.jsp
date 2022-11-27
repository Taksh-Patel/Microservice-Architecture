<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
form{
    background-color: skyblue;
    width: 250px;
    height: 300px;
    border-style: solid;
    border-color: blue;
    padding: 10px;
}
</style>

<div>
    <form action="/login" method="post">
        <c:if test="${not empty error}">
            <div style="color:red;"><h3>${error}</h3></div>
            <div> <br> </div>
        </c:if>
        <c:if test="${not empty registerSuccess}">
            <div style="color:green;"><h3>${registerSuccess}</h3></div>
            <div> <br> </div>
        </c:if>
        <c:if test="${not empty forgotPasswordSuccess}">
            <div style="color:green;"><h3>${forgotPasswordSuccess}</h3></div>
            <div> <br> </div>
        </c:if>
        <c:if test="${not empty passwordError}">
            <div style="color:red;"><h3>${passwordError}</h3></div>
            <div> <br> </div>
        </c:if>
        <div>Username : <input type="text" name="userName" value=""></div>
        <div> <br> </div>
        <div>Password : &nbsp;<input type="text" name="password" value=""></div>
        <div> <br> </div>
        <div><input type="submit" value="Login" style="background-color: lime;"></div>
        <div> <br> </div>
        <div><input type="button" value="Register" onclick="goToRegister()" style="background-color: orange;"></div>
        <div> <br> </div>
        <div><input type="button" value="Forgot Password" onclick="goToForgotPassword()" style="background-color: green;"></div>
    </form>
</div>
<script type="text/javascript">
    function goToRegister(){
        window.location.href="/register";
    }
</script>
<script type="text/javascript">
    function goToForgotPassword(){
        window.location.href="/forgot_password";
    }
</script>
