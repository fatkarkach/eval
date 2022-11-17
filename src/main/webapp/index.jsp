<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Login</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body class="bg-light">

<div class="container col-md-8 col-md-offset-3" style="overflow: auto">
    <div class="border border-primary bg-white" style="padding: 30px; margin-top: 30PX">
    <form action="LoginController" method="post" >
        <img src="marjan.png" class="mx-auto" width="200px" style=" display: block;margin-left: auto;margin-right: auto">
        <div class="form-group">
            <input type="email" class="form-control" id="email" placeholder="Entrez  Adresse Email" name="email" required>
        </div>
        <div class="form-group">
            <input type="password" class="form-control" id="password" placeholder="Entrez modepasse" name="password" required>
        </div>
        <button type="submit" class="btn btn-dark">Connecter</button>
    </form>
    </div>
</div>
</body>
</html>