<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
form{
    background-color: #89f5ee;
    width: 350px;
    height: 300px;
    border-style: solid;
    border-color: blue;
    padding: 10px;
}
</style>

<div>
    <form action="/update-user" method="post">
        <div><h2>Forgot Password</h2></div>
        <div><br></div>
        <c:if test="${not empty forgotPasswordError}">
            <div style="color:red;"><h3>${forgotPasswordError}</h3></div>
            <div> <br> </div>
        </c:if>
        <div>Username : <input type="text" name="userName" value=""></div>
        <div> <br> </div>
        <div>New Password : &nbsp;<input type="text" name="password1" value=""></div>
        <div> <br> </div>
        <div>Retype Password : &nbsp;<input type="text" name="password2" value=""></div>
        <div> <br> </div>
        <div><input type="submit" value="Submit" style="background-color: lime;"></div>
    </form>
</div>