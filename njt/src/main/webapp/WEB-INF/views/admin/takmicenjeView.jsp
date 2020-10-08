<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <!--<link rel="stylesheet" type="text/css" href="../../resources/styles/index2.css">-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"  crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"  crossorigin="anonymous">

        <script   src="https://code.jquery.com/jquery-3.2.1.min.js"     crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"  crossorigin="anonymous"></script> 
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <!--<link rel="stylesheet" type="text/css" href="/njt/resources/styles/index2.css">-->


        <title>Takmičenje</title>
    </head>
    <body>
        <%@include file = "../headerAdmin.jsp" %>
        <br><br><br><br><br><br>

        <div class="col-6 col-md-1"></div>
        <div class="col-6 col-md-10">

            <div class="list-group">
                <div class="list-group-item" align="center">
                    <b><font size="4"><a href="/admin/takmicenjeAll">Takmičenje</a> / Detalji </font></b>
                </div>
            </div>

            <div class='text-right'>
                <a href="/njt/admin/editT/${viewTakmicenje.takmicenjeId}" class="btn btn-dark"><span class="fa fa-fw fa-pencil"></span></a>
                <a href="/njt/admin/takmicenjeAll" class="btn btn-dark"><span class="fa fa-fw fa-remove"></span></a>
            </div>

            <div class='form-horizontal'>

                <div class='form-group'>
                    <label class='control-label col-xs-4'>Id takmičenja </label>
                    <div class='col-xs-8'>
                        <p class="form-control-static">
                            ${viewTakmicenje.takmicenjeId}
                        </p>
                    </div>
                </div>

                <div class='form-group'>
                    <label class='control-label col-xs-4'>Naziv</label>
                    <div class='col-xs-8'>
                        <p class="form-control-static">
                            ${viewTakmicenje.naziv}
                        </p>
                    </div>
                </div>

                <div class='form-group'>
                    <label class='control-label col-xs-4'>Datum Održavanja</label>
                    <div class='col-xs-8'>
                        <p class="form-control-static">
                            ${viewTakmicenje.datumOdrzavanja}
                        </p>
                    </div>
                </div>     

                <div class='form-group'>
                    <label class='control-label col-xs-4'>Rok za prijave</label>
                    <div class='col-xs-8'>
                        <p class="form-control-static">
                            ${viewTakmicenje.rokZaPrijave}
                        </p>
                    </div>
                </div> 

                <div class='form-group'>
                    <label class='control-label col-xs-4'>Tip</label>
                    <div class='col-xs-8'>
                        <p class="form-control-static">
                            ${viewTakmicenje.tip}
                        </p>
                    </div>
                </div>

                <div class='form-group'>
                    <label class='control-label col-xs-4'>Dozvoljen broj prijava</label>
                    <div class='col-xs-8'>
                        <p class="form-control-static">
                            ${viewTakmicenje.dozvoljenBrojPrijava}
                        </p>
                    </div>
                </div>

                <div class='form-group'>
                    <label class='control-label col-xs-4'>Broj prijava</label>
                    <div class='col-xs-8'>
                        <p class="form-control-static">
                            ${viewTakmicenje.brojPrijava}
                        </p>
                    </div>
                </div>
                        <div class='form-group'>
                    <label class='control-label col-xs-4'>Disciplina</label>
                    <div class='col-xs-8'>
                        <p class="form-control-static">
                            ${viewTakmicenje.disciplina.imeDiscipline}
                        </p>
                    </div>
                </div>
                        <div class='form-group'>
                    <label class='control-label col-xs-4'>Zemlja</label>
                    <div class='col-xs-8'>
                        <p class="form-control-static">
                            ${viewTakmicenje.zemlja.naziv}
                        </p>
                    </div>
                </div>
            </div>
            <br>

        </div>
        <div class="col-6 col-md-1"></div>
        <br><br>
    </body>
</html>
