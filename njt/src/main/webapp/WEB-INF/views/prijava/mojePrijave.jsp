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

        <title>JSP view all Takmicenja!</title>
    </head>
    <body>
        <%@include file = "../header.jsp" %>
        <br><br><br><br>

        <div class="col-6 col-md-1"></div>

        <div class="col-6 col-md-10">
            <div class='text-right'>
                <a href="/njt/prijava/all" class="btn btn-dark"><span class="fa fa-fw fa-remove"></span></a>
            </div>
            <table class="table table-condensed table-align" id="myTable">
                <tr>
                    <th>Id</th>
                    <th>Naziv</th>
                    <th>Datum Održavanja</th>
                    <th>Zemlja</th>
                    <th>Broj prijava</th>
                    <th>Disciplina</th>
                </tr>

                <c:forEach items="${takmicenja}" var="takmicenje"> 
                    <tr>
                        <td>${takmicenje.takmicenjeId}</td>
                        <td>${takmicenje.naziv}</td>
                        <td>${takmicenje.datumOdrzavanja}</td>
                        <td>${takmicenje.zemlja.naziv}</td>
                        <td>${takmicenje.brojPrijava}</td>
                        <td>${takmicenje.disciplina.imeDiscipline}</td>
                        <td>
                            <a href="/njt/takmicenje/get/${takmicenje.takmicenjeId}" class="btn btn-dark"><span class='fa fa-fw fa-question'></span></a>
                        </td>

                    </tr>
                </c:forEach>
            </table>

    </body>
</html>
