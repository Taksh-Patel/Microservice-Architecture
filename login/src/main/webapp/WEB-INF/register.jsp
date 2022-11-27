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
    <form action="/set-user" method="post">
        <div><h2>Registration Page</h2></div>
        <div><br></div>
        <c:if test="${not empty registrationError}">
            <div style="color:red;"><h3>${registrationError}</h3></div>
            <div> <br> </div>
        </c:if>
        <div>Username : <input type="text" name="userName" value=""></div>
        <div> <br> </div>
        <div>Password : &nbsp;<input type="text" name="password1" value=""></div>
        <div> <br> </div>
        <div>Retype Password : &nbsp;<input type="text" name="password2" value=""></div>
        <div> <br> </div>
        <div><input type="submit" value="Register" style="background-color: lime;"></div>
    </form>
</div>