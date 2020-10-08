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
        <title>JSP view all Plivači!</title>
    </head>
    <body>
        <%@include file = "../header.jsp" %>
        <br><br><br><br>
           <div class="col-6 col-md-1"></div>
        <div class="col-6 col-md-10">
        <table class="table table-condensed table-align" id="myTable">
            <thead>
            <tr>
                <th>Id</th>
                <th>Ime plivača</th>
                <th>Prezime plivača</th>
                <th>Datum Rođenja</th>
                <th>Status</th>
                <th>Zemlja</th>
                <th>Pol</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${plivaci}" var="plivac"> 
                <tr>
                    <td> <p class='form-control-static'>${plivac.plivacId} </p></td>
                    <td><p class='form-control-static'>${plivac.imePlivaca} </p></td>
                    <td><p class='form-control-static'>${plivac.prezimePlivaca} </p></td>
                    <td><p class='form-control-static'>${plivac.datumRodjenja} </p></td>
                    <td><p class='form-control-static'>${plivac.status} </p></td>
                    <td><p class='form-control-static'>${plivac.zemlja.naziv} </p></td>
                    <td><p class='form-control-static'>${plivac.pol} </p></td>
                    <td>
                        <a href="/njt/plivac/get/${plivac.plivacId}" class="btn btn-dark"><span class='fa fa-fw fa-question'></span></a>
                    </td>
                    
                </tr>
            </c:forEach>
            </tbody>
        </table>
        </div>
        
    </body>
</html>
