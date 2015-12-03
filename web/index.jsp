<%-- 
    Document   : index
    Created on : 19/nov/2015, 13:44:35
    Author     : Cluster C Frontend Customer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Booking online system - Login page</title>

    <h1>Welcome to the Booking online system!</h1>       
</head>
<body>
    <a href="/ClusterCFrontendCustomer/register.jsp">  register profile page </a>
    <br>
    <br>
    <a href="/ClusterCFrontendCustomer/login.jsp">  to test purposes </a>
    <br>
    <br>

    <div id="msgUserPassword" style="display:none;" >Please fill in the username and password</div>
    <div id="msgUser"         style="display:none;" >Please fill in the username </div>
    <div id="msgPassword"     style="display:none;" >Please fill in the password</div>
    <div id="invalidUser"     style="display:none;" >The email is not valid. Please check!</div>



    <!-- script to validate the user/email and password formats -->
    <script type="text/javascript">
        function showMsg(id) {
        document.getElementById('msgUserPassword').style.display = "none";
        document.getElementById('msgUser').style.display = "none";
        document.getElementById('msgPassword').style.display = "none";
        document.getElementById('invalidUser').style.display = "none";
        document.getElementById(id).style.color = "#ff0000";
        document.getElementById(id).style.display = "block";
        }

        function loginValidation()
        {
        var valid = true;
        if ((document.login_form.user.value.length === 0) || (document.login_form.pass.value.length === 0))
        {
        valid = false;
        if (document.login_form.user.value.length === 0)
        {
             if (document.login_form.pass.value.length === 0)
             {
                showMsg('msgUserPassword');
             } 
             else 
                   {
                        if (validateEmail("user") === true)
                        {
                            showMsg('invalidUser');
                        }
                        else
                        {
                            showMsg('msgUser');
                        }
                    }                    
        } else
            {
                showMsg('msgPassword');
            }
        }

        return valid;
        }


      
    </script>
    
    <!-- end of the javascript script
      function validateEmail("user")
        {
             var re = /^(([^<>()[\]\.,;:\s@\"]+(\.[^<>()[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,})$/i;
            return re.test("user");
        }
    
    -->    




    <form name="login_form" action="LoginServlet" method="post"
          onSubmit="return loginValidation();">
        <table border="0">
            <tr align="left" valign="top">
                <td>Email:</td>
                <td><input type="text" name="user" class="inputbox" /></td>
            </tr>
            <tr align="left" valign="top">
                <td>Password:</td>
                <td><input type="password" name="pass" class="inputbox" /></td>
            </tr>
            <tr align="left" valign="top">
                <td></td>
                <td><input type="submit" name="submit" value="Login" /></td>
            </tr>
        </table>
        <c:out value="${loginresult}">
        </c:out>

    </form>

</body>

