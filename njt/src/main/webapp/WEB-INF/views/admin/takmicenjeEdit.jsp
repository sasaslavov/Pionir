<%--
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file = "/resources/js/bootstrap.js" %>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"  crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"  crossorigin="anonymous">

        <script   src="https://code.jquery.com/jquery-3.2.1.min.js"     crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"  crossorigin="anonymous"></script> 
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <link rel="stylesheet" href="/resources/demos/style.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script>
      $( function() {
      $( "#datumOdrzavanja" ).datepicker();
      $( "#rokZaPrijave" ).datepicker();
      } ); 
      </script>
        
        <!--<link rel="stylesheet" type="text/css" href="../../resources/styles/index2.css">-->
        <title>Takmičenje insert</title>
    </head>
    <body>
        <%@include file = "../headerAdmin.jsp" %>
        <br><br><br><br><br><br>

        <div class="col-6 col-md-1"></div>
        <div class="col-6 col-md-10">
            <div class="list-group" align="center">
                <div class="list-group-item">
                    <b><font size="4"><a href="/njt/admin/takmicenjeAll">Takmičenje</a> / Unos </font></b>
                </div>
            </div>
            <br><br>
            <script>
                function validateForm() {
                    var x = document.getElementById("naziv").value;
                    console.log(x);
                    if (x == "" || x == null) {
                        alert("Naziv takmicenja morate da popunite");
                        return false;
                    }
                    var x = document.getElementById("datumOdrzavanja").value;
                    console.log(x);
                    if (x == "" || x == null) {
                        alert("Datum odrzavanja morate da popunite");
                        return false;
                    }
                    var x = document.getElementById("rokZaPrijave").value;
                    console.log(x);
                    if (x == "" || x == null) {
                        alert("Rok za prijave morate da popunite");
                        return false;
                    }
                    var x = document.getElementById("tip").value;
                    console.log(x);
                    if (x == "" || x == null) {
                        alert("Tip morate da popunite");
                        return false;
                    }
                    var x = document.getElementById("dozvoljenBrojPrijava").value;
                    console.log(x);
                    if (x == "" || x == null || x < 1) {
                        alert("Dozvoljen broj prijava mora da bude veci ili jednak 1");
                        return false;
                    }
                }
            </script>
            <div class="container-fluid">
                <form:form action="/njt/admin/editT/${takmicenje.takmicenjeId}" onsubmit="return validateForm()" method="post" modelAttribute="takmicenje">
                    <div class="form-group">
                        <form:label path="takmicenjeId">ID</form:label>
                        <form:input path="takmicenjeId" class="form-control" id="takmicenjeId" disabled="true" />
                    </div>
                    <div class="form-group">
                        <form:label path="naziv">Naziv</form:label>
                        <form:input path="naziv" class="form-control" id="naziv" />
                    </div>  
                    <div class="form-group">
                        <form:label path="datumOdrzavanja">Datum Održavanja</form:label>
                        <fmt:formatDate value="${takmicenje.datumOdrzavanja}" var="formattedDate" type="date" pattern="yyyy/MM/dd" />                                           
                        <form:input path="datumOdrzavanja" class="form-control" id="datumOdrzavanja" value="${formattedDate}"/>
                    </div>  
                    <div class="form-group">
                        <form:label path="rokZaPrijave">Rok za Prijave</form:label>
                        <fmt:formatDate value="${takmicenje.datumOdrzavanja}" var="formattedDate" type="date" pattern="yyyy/MM/dd" />                                           
                        <form:input path="rokZaPrijave" class="form-control" id="rokZaPrijave" value="${formattedDate}"/>
                    </div>  
                    <div class="form-group">
                        <form:label path="tip">Tip</form:label>
                        <form:input path="tip" class="form-control" id="tip" />
                    </div>
                    <br>
                    <div class="form-group">
                        <form:label path="dozvoljenBrojPrijava">Dozvoljen broj prijava</form:label>
                        <form:input path="dozvoljenBrojPrijava" class="form-control" id="dozvoljenBrojPrijava" />
                    </div>
                    <br>
                    <div class="form-group">
                        <form:label path="brojPrijava">Broj prijava</form:label>
                        <form:input path="brojPrijava" class="form-control" id="brojPrijava" disabled="true" />
                    </div>
                    <br>

                    <div class="form-group">
                        <form:label path="disciplina.disciplinaId">Disciplina</form:label>
                        <form:select class="form-control" path="disciplina.disciplinaId">                                          
                            <form:options items="${discipline}" itemLabel="imeDiscipline" itemValue="disciplinaId" />
                        </form:select>
                    </div>
                    <div class="form-group">
                        <form:label path="zemlja.zemljaId">Zemlja</form:label>
                        <form:select class="form-control" path="zemlja.zemljaId">                                          
                            <form:options items="${zemlje}" itemLabel="naziv" itemValue="zemljaId" />
                        </form:select>
                    </div>
                    <div class='text-right'>
                        <button type="submit" class="btn btn-dark"><span class="fa fa-fw fa-check-square"></span></button>
                        <a href="/njt/admin/takmicenjeAll" class="btn btn-dark"><span class="fa fa-fw fa-remove"></span></a>
                    </div>

                </form:form>
            </div>         
        </div>
        <div class="col-6 col-md-1"></div>
    </body> 
</html>
