<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
        <title>view all prijave</title>
    </head>
    <body>
        <%@include file = "../headerAdmin.jsp" %>
        <br><br><br><br>
        <div class="col-6 col-md-1"></div>
        <div class="col-6 col-md-10">
            <div class="list-group" align="center">
                <div class="list-group-item">
                    <b><font size="4"><a href="/njt/admin/takmicenjeAll">Prijava</a> / Dodavanje </font></b>
                </div>
            </div>
            <br><br>

            <div class="container-fluid">
                <form:form action="/njt/admin/addP/${takmicenje.takmicenjeId}" method="post" modelAttribute="prijava">
                    <div class="form-group">
                        <form:label path="takmicenje.takmicenjeId">Takmičenje</form:label>
                        <form:select class="form-control" path="takmicenje.takmicenjeId">                                          
                            <form:options items="${takmicenja}" itemLabel="naziv" itemValue="takmicenjeId" />
                        </form:select>
                    </div>
                    <div class="form-group">
                        <form:label path="plivac.plivacId">Plivač</form:label>
                        <form:select class="form-control" path="plivac.plivacId">                                          
                            <form:options items="${plivaci}" itemLabel="brojLicence" itemValue="plivacId" />
                        </form:select>
                    </div>
                    <div class='text-right'>
                        <button type="submit" class="btn btn-dark"><span class="fa fa-fw fa-check-square"></span></button>
                        <a href="/njt/admin/prijavaAll" class="btn btn-dark"><span class="fa fa-fw fa-remove"></span></a>
                    </div>

                </form:form>
            </div>         
             <div class="col-6 col-md-1"></div>
            <div class="col-6 col-md-10">
                <table class="table table-condensed table-align" id="myTable">
                    <tr>
                        <th>Id</th>
                        <th>Ime</th>
                        <th>Prezime</th>
                        <th>Zemlja</th>
                        <th>Pol</th>
                        <th>Datum Prijave</th>
                    </tr>

                    <c:forEach items="${prijave}" var="prijava"> 
                        <tr>
                            <td>${prijava.prijavaId}</td>
                            <td>${prijava.plivac.imePlivaca}</td>
                            <td>${prijava.plivac.prezimePlivaca}</td>
                            <td>${prijava.plivac.zemlja.naziv}</td>
                            <td>${prijava.plivac.pol}</td>
                            <td>${prijava.datumPrijave}</td>
                            <td>              
                                <a href="/njt/admin/deleteP/${prijava.prijavaId}" class="btn btn-dark"><span class='fa fa-fw fa-trash'></span></a>
                            </td>


                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
        <div class="col-6 col-md-1"></div>
    </body>
</html>
