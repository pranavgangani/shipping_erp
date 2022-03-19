<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
    </head>
    <body class="text-center">
        <div layout:fragment="content">
            <form class="form-signin" action="/login" method="post">
                <img class="mb-4" src="https://getbootstrap.com/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72" />
                <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
                <c:if test="${param.error}">
                    <div>
                        Invalid email and password.
                    </div>
                </c:if>
                <c:if test="${param.logout}">
                    <div>
                        You have been logged out.
                    </div>
                </c:if>
                <label for="inputEmail" class="sr-only">Email address</label>
                <input type="email" name="email" id="inputEmail" class="form-control" placeholder="Email" required="" />
                <label for="inputPassword" class="sr-only">Password</label>
                <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required="" />
                <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
            </form>
        </div>
    </body>
</html>