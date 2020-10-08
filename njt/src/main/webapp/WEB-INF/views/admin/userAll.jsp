

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"  crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"  crossorigin="anonymous">

        <script   src="https://code.jquery.com/jquery-3.2.1.min.js"     crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"  crossorigin="anonymous"></script> 
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <!--<link rel="stylesheet" type="text/css" href="/njt/resources/styles/index2.css">-->

        <title>JSP view all Users!</title>
    </head>
    <body>
        <%@include file = "../headerAdmin.jsp" %>
        <br><br><br><br>
        <div class="col-6 col-md-1"></div>
        <div class="col-6 col-md-10">
            <table class="table table-condensed table-align" id="myTable">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Username</th>
                        <th>Email</th>
                        <th>Ime</th>
                        <th>Prezime</th>
                        <th>Id Plivača/th>
                        <th>Aktivan </th>


                        <th class='text-right'><a href="/njt/admin/registration" class="btn btn-dark"><span class='fa fa-fw fa-plus'></span></a></th>
                    </tr>
                </thead>
                <tbody>

                    <c:forEach items="${users}" var="user" varStatus="status"> 
                        <tr>
                            <td>${user.id}</td>
                            <td>${user.username}</td>
                            <td>${user.email}</td>
                            <td>${plivaci[status.index].imePlivaca}</td>
                            <td>${plivaci[status.index].prezimePlivaca}</td>
                            <td>${user.plivaciId}</td>
                            <td>${plivaci[status.index].status}</td>
                            <td>
                                <a href="/njt/admin/editU/${user.id}" class="btn btn-dark"><span class='fa fa-fw fa-pencil'></span></a>
                                <a href="/njt/admin/deleteU/${user.id}" class="btn btn-dark"><span class='fa fa-fw fa-trash'></span></a>
                            </td>

                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
