<%-- 
    Document   : register
    Created on : 20/nov/2015, 11:45:32
    Author     : Cluster C
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register a profile!</title>
    </head>
    <body>
        <h1>Register a profile!</h1>
        <form method="post" action="" name="myForm" onSubmit="pass(); return false;">
            <input type="password" placeholder="type your pass" name="pass_1">
            <input type="password" placeholder="confirm your pass" name="pass_2">
            <input type="submit" value="validate">
        </form> 
        
        
        <script>
            function pass() {
                var pass_1 = document.forms["myForm"].pass_1.value.length;
                var pass_2 = document.forms["myForm"].pass_2.value.length;
                if (pass_1 != pass_2) {
                    alert("the pass and repeat pass must be equal");
                    return false;
                }
                return true;
            }
        </script>
    </body>
</html>
