<%@ page import="com.Dao.AdminDao" %>
<%@ page import="com.model.Users" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.Dao.centreDao" %>
<%@ page import="com.model.Centre" %><%--
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
<body>
<div class="container mt-5 mb-1">
<%@include file="navadmine.jsp"%>
<!-- Button trigger modal -->
  <div class="row">
    <div class="col text-start">
    <button type="button" class="btn btn-info mb-4 mt-4" data-toggle="modal" data-target="#addexampleModal">
      <i class="fa-solid fa-plus" style="color:white"></i> Ajouter Un centre
    </button>
  </div>
</div>
<!-- Modal -->
<div class="modal fade" id="addexampleModal" tabindex="-1" role="dialog" aria-labelledby="addexampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="addexampleModalLabel">Centres Marjan</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <form  action="CentreServlet" method="post">
        <div class="modal-body">
          <input class="form-control" type="text" placeholder="Entrez Nom du centre" name="nom_centre"><br>
          <select class="custom-select" name="ville">
            <option selected>Choisir Une ville</option>
            <option value="Tanger">Tanger</option>
            <option value="Zagora">Zagora</option>
          </select>
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
      <th scope="col" class="text-center px-5">centre</th>
      <th class="text-center px-5">ville</th>
      <th class="text-center px-5">Status</th>
      <%--<th class="text-center px-5">Action</th>--%>
    </tr>
    </thead>
    <tbody>
    <%
      centreDao dao = new centreDao();
      List<Centre> list = dao.getAllcentre();
      for(Centre v : list) {
    %>

    <tr>
      <td class="text-center" style="background-color: aliceblue"><%=v.getNomCentre() %></td>
      <td class="text-center" style="background-color: aliceblue"><%=v.getVille() %></td>
      <td class="text-center" style="background-color: aliceblue"><%=v.getStatus()%></td>
     <%-- <td class="text-center" style="background-color: aliceblue"><!-- Button trigger modal -->
        <button type="button" class="btn" data-toggle="modal" data-target="#delexampleModal<%=v.getIdCentre()%>">
          <img src="delete.png">
        </button>
        <button type="button" class="btn" data-toggle="modal" data-target="#upexampleModal<%=v.getIdCentre()%>">
          <img src="editing.png">
        </button>
        <!-- Modal  delet-->
        <div class="modal fade" id="delexampleModal<%=v.getIdCentre()%>" tabindex="-1" role="dialog" aria-labelledby="delexampleModalLabel" aria-hidden="true">
          <div class="modal-dialog" role="document">
            <div class="modal-content">
              <div class="modal-header">
                <h5 class="modal-title" id="delexampleModalLabel">Suppression</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
              </div>
              <form action="DeleteCentre" method="post">
                <div class="modal-body">
                  Supprimer le centre
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-secondary" data-dismiss="modal">fermer</button>
                  <input type="hidden" name="id" value="<%=v.getIdCentre()%>" />
                  <button type="submit" class="btn btn-primary">Supprimer</button>

                </div>
              </form>
            </div>
          </div>
        </div>
        &lt;%&ndash;modal update&ndash;%&gt;
        <div class="modal fade" id="upexampleModal<%=v.getIdCentre()%>" tabindex="-1" role="dialog" aria-labelledby="upexampleModal" aria-hidden="true">
          <div class="modal-dialog" role="document">
            <div class="modal-content">
              <div class="modal-header">
                <h5 class="modal-title" id="upexampleModal">Modification</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
              </div>
              <form  action="UpdateCentre" method="post">
                <div class="modal-body">
                  <input class="form-control" type="text" placeholder="Entrez Nom centre" name="centre" value="<%=v.getNomCentre()%>"><br>
                  <input type="hidden" value="<%=v.getVille()%>" name="ville">
                  <input type="hidden" value="<%=v.getStatus()%>" name="status">
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-secondary" data-dismiss="modal">fermer</button>
                  <input type="hidden" name="id" value="<%=v.getIdCentre()%>" />
                  <button type="submit" class="btn btn-primary">Modifier</button>
                </div>

              </form>
            </div>
          </div>
        </div>
      </td>--%>
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
