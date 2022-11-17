<%@ page import="com.Dao.AdminDao" %>
<%@ page import="com.model.Users" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.model.Centre" %>
<%@ page import="com.Dao.centreDao" %><%--
  Created by IntelliJ IDEA.
  User: yc
  Date: 27/10/2022
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Administration</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="style.css.css" type="text/css"/>
    <script src="https://kit.fontawesome.com/5c1b47c11d.js" crossorigin="anonymous"></script>

</head>
<% //In case, if Admin session is not set, redirect to Login page
    if((request.getSession(false).getAttribute("admin")== null) )
    {

%>
<jsp:forward page="/index.jsp"></jsp:forward>
<%}%>
<div class="container mt-5 mb-1">
<%@include file="navadmine.jsp"%>
<!-- Button trigger modal -->
<div class="row">
    <div class="col text-start">
        <button type="button"  class="btn btn-info mb-4 mt-4" data-toggle="modal" data-target="#addexampleModal">
            <i class="fa-solid fa-plus" style="color:white"></i> Ajouter Un admin
        </button>
    </div>
</div>
<!-- Modal -->
<div class="modal fade" id="addexampleModal" tabindex="-1" role="dialog" aria-labelledby="addexampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="addexampleModalLabel">Administation</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form  action="AdminController" method="post">
                <div class="modal-body">
                    <input class="form-control" type="text" placeholder="Entrez Nom" name="nom"><br>
                    <input class="form-control" type="text" placeholder="Entrez Prénom" name="prenom"><br>
                    <%--        <button type="button" class="btn btn-primary" id="btn">Tanger</button>--%>
                    <select class="custom-select" name="ville" id="btn">
                        <option selected>Choisir Une ville</option>
                        <option value="Tanger">Tanger</option>
                        <option value="Zagora">Zagora</option>

                    </select>
                    <br>
                    <select class="custom-select mt-3" id="box" style="display: none" name="centre">
                        <%
                            centreDao dao = new centreDao();
                            List<Centre> list = dao.getAllcentre();
                            for(Centre v : list) {
                                if(v.getStatus().equals("Non") && v.getVille().equals("Tanger")){
                        %>
                        <option value="<%=v.getNomCentre()%>"><%=v.getNomCentre()%></option>
                        <%}}%>
                    </select>
                    <select class="custom-select mt-3" id="boxz" style="display: none" name="centre">
                        <%
                            for(Centre z : list) {
                                if(z.getStatus().equals("Non")&& z.getVille().equals("Zagora")){
                        %>
                        <option value="<%=z.getNomCentre()%>"><%=z.getNomCentre()%></option>
                        <%}}%>
                    </select>
                    <br>
                    <script>
                        const box = document.getElementById('box');

                        const btn = document.getElementById('btn');
                        //zagora
                        const boxz = document.getElementById('boxz');

                        btn.onchange = () => {
                            if (btn.value == "Tanger"){
                                if (box.style.display === 'none') {
                                    box.style.display = 'block';
                                    boxz.style.display = 'none'
                                }
                                else {
                                    box.style.display = 'none';
                                }
                            }else if (btn.value == "Zagora"){
                                if (boxz.style.display === 'none') {
                                    boxz.style.display = 'block';
                                    box.style.display = 'none';
                                } else {
                                    boxz.style.display = 'none';
                                }

                            }
                        };
                    </script>
                    <input class="form-control" type="email" placeholder="Entrez Adresse Email" name="email"><br>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">fermer</button>
                    <button type="submit" class="btn btn-primary">Ajouter</button>
                </div>
            </form>
        </div>
    </div>
</div>
    <div class="card-body table-responsive fixTableHead px-0 pt-0">
        <table class="table">
            <thead class="bg-info">
    <tr>
        <th scope="col" class="text-center px-5" >Nom</th>
        <th class="text-center px-5">Prénom</th>
        <th class="text-center px-5">Email</th>
        <th class="text-center px-5">Centre</th>
        <th class="text-center px-5">Ville</th>
        <th class="text-center px-5">Action</th>
    </tr>
    </thead>
    <tbody>
    <%
        AdminDao daouser = new AdminDao();
        List<Users> listU = daouser.getAllUser();
        for(Users v : listU) {
    %>

    <tr>
        <td class="text-center" style="background-color: aliceblue"><%=v.getNom() %></td>
        <td class="text-center" style="background-color: aliceblue"><%=v.getPrenom() %></td>
        <td class="text-center" style="background-color: aliceblue"><%=v.getEmail() %></td>
        <td class="text-center" style="background-color: aliceblue"><%=v.getVille() %></td>
        <td class="text-center" style="background-color: aliceblue"><%=v.getCentre() %></td>
        <td class="text-center" style="background-color: aliceblue"><!-- Button trigger modal -->
            <button type="button" class="btn btn-dark" data-toggle="modal" data-target="#delexampleModal<%=v.getIdUsers()%>">
                <i class="fa-solid fa-trash"></i>
            </button>
            <button type="button" class="btn btn-info" data-toggle="modal" data-target="#upexampleModal<%=v.getIdUsers()%>">
                <i class="fa-solid fa-pencil"></i>
            </button>
            <!-- Modal  delet-->
            <div class="modal fade" id="delexampleModal<%=v.getIdUsers()%>" tabindex="-1" role="dialog" aria-labelledby="delexampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="delexampleModalLabel">Suppression</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <form action="DeleteAdmin" method="post">
                            <div class="modal-body">
                                <input type="hidden" value="<%=v.getCentre()%>" name="centre">
                                <input type="hidden" value="<%=v.getVille()%>" name="ville">
                                Supprimer l'admin
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">fermer</button>
                                <input type="hidden" name="id" value="<%=v.getIdUsers()%>" />
                                <button type="submit" class="btn btn-primary">Supprimer</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="modal fade" id="upexampleModal<%=v.getIdUsers()%>" tabindex="-1" role="dialog" aria-labelledby="upexampleModal" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="upexampleModal">Modification</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <form  action="UpdateAdmin" method="post">
                            <div class="modal-body">
                                <input class="form-control" type="text" placeholder="Entrez Nom" name="nom" value="<%=v.getNom()%>"><br>
                                <input class="form-control" type="text" placeholder="Entrez Prénom" name="prenom" value="<%=v.getPrenom()%>"><br>
                                <br>
                                <input class="form-control" type="email" placeholder="Entrez Adresse Email" name="email" value="<%=v.getEmail()%>"><br>
                                <br><input type="hidden" value="<%=v.getPassword()%>" name="password">
                                <input type="hidden" value="<%=v.getCentre()%>" name="centre">
                                <input type="hidden" value="<%=v.getVille()%>" name="ville">
                                <input type="hidden" value="<%=v.getType()%>" name="type">
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">fermer</button>
                                <input type="hidden" name="id" value="<%=v.getIdUsers()%>" />
                                <button type="submit" class="btn btn-primary">Modifier</button>
                            </div>

                        </form>
                    </div>
                </div>
            </div>
        </td>
    </tr>
    </tbody>
    <%
        }
    %>
</table>
</div>
</div>
</body>
</html>
