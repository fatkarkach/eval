<%@ page import="com.Dao.AdmincDao" %>
<%@ page import="com.model.Stock" %>
<%@ page import="java.util.List" %>
<%@ page import="com.Dao.UserDao" %>
<%@ page import="com.model.Users" %>
<%@ page import="java.util.stream.Collectors" %><%--
  Created by IntelliJ IDEA.
  User: yc
  Date: 28/10/2022
  Time: 15:31
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
    if((request.getSession(false).getAttribute("user")== null) )
    {
%>
<jsp:forward page="/index.jsp"></jsp:forward>
<%}%>
<body>
<div class="container mt-5 mb-1">

<%@include file="navadmic.jsp"%>

    <!-- Button trigger modal -->
    <div class="row">
        <div class="col text-start">
            <button type="button" class="btn btn-info mb-4 mt-4" data-toggle="modal" data-target="#addexampleModal">
                <i class="fa-solid fa-plus" style="color:white"></i> Ajouter Un produit
            </button>
        </div>
    </div>
    <!-- Modal -->
    <div class="modal fade" id="addexampleModal" tabindex="-1" role="dialog" aria-labelledby="addexampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="addexampleModalLabel">Ajouter un produit</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <form  action="Addpro" method="post">
                    <div class="modal-body">
                        <select class="custom-select" name="categorie">
                            <option selected>Choisir Une Catégorie</option>
                            <option value="multimédia">multimédia</option>
                            <option value="Bio & Santé">Bio & Santé</option>
                        </select>
                        <br>
                        <br>
                        <input class="form-control" type="text" placeholder="Entrez Nom produit" name="produit">
                        <br>
                        <input class="form-control" type="number" placeholder="Entrez Prix de produit" name="prix">
                        <br>
                        <input class="form-control" type="number" placeholder="Entrez Prix quantités" name="quantites">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">fermer</button>
                        <button type="submit" class="btn btn-primary">Ajouter</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <%--tableau--%>
    <div class="card-body table-responsive fixTableHead px-0 pt-0">
        <table class="table">
            <thead class="bg-info">
            <tr>
                <th scope="col" class="text-center px-5">Catégorie</th>
                <th class="text-center px-5">Produit</th>
                <th class="text-center px-5">Prix</th>
                <th class="text-center px-5">Quantités</th>
                <th class="text-center px-5">Action</th>
            </tr>
            </thead>
            <tbody>
            <%
                AdmincDao dao = new AdmincDao();
                List<Stock> listA = dao.getAllStock();
                UserDao userDao=new UserDao();
                int id_user=userDao.id;
                AdmincDao admincDao=new AdmincDao();
                Users users=admincDao.getuser(id_user);
                List<Stock>  listB = listA.stream()
                        .filter(x -> x.getUsersByIdUsers().equals(users))
                        .collect(Collectors.toList());
                for(Stock v : listB) {
            %>
            <tr>
                <td class="text-center" style="background-color: aliceblue"><%=v.getCategorie()%></td>
                <td class="text-center" style="background-color: aliceblue"><%=v.getProduit()%></td>
                <td class="text-center" style="background-color: aliceblue"><%=v.getPrix()%>DH</td>
                <td class="text-center" style="background-color: aliceblue"><%=v.getQuantites()%></td>
                <td class="text-center" style="background-color: aliceblue">
                <button type="button" class="btn btn-dark" data-toggle="modal" data-target="#delexampleModal<%=v.getIdStock()%>">
                    <i class="fa-solid fa-trash"></i>
                </button>
                <button type="button" class="btn btn-info" data-toggle="modal" data-target="#upexampleModal<%=v.getIdStock()%>">
                    <i class="fa-solid fa-pencil"></i>
                </button>
                    <div class="modal fade" id="delexampleModal<%=v.getIdStock()%>" tabindex="-1" role="dialog" aria-labelledby="delexampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="delexampleModalLabel">Suppression</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <form action="DeletStock" method="post">
                                    <div class="modal-body">
                                        Supprimer  le stock
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">fermer</button>
                                        <input type="hidden" name="id" value="<%=v.getIdStock()%>" />
                                        <button type="submit" class="btn btn-primary">Supprimer</button>

                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="modal fade" id="upexampleModal<%=v.getIdStock()%>" tabindex="-1" role="dialog" aria-labelledby="upexampleModal" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="upexampleModal">Modification</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <form  action="UpdateStock" method="post">
                                        <div class="modal-body">
                                            <select class="custom-select" name="categorie">
                                                <option selected><%=v.getCategorie()%></option>
                                                <option value="multimédia">multimédia</option>
                                                <option value="Bio & Santé">Bio & Santé</option>
                                            </select>
                                            <br>
                                            <br>
                                            <input class="form-control" type="text" placeholder="Entrez Nom produit" name="produit" value="<%=v.getProduit()%>">
                                            <br>
                                            <input class="form-control" type="number" placeholder="Entrez Prix de produit" name="prix" value="<%=v.getPrix()%>">
                                            <br>
                                            <input class="form-control" type="number" placeholder="Entrez la quantités" name="quantites" value="<%=v.getQuantites()%>">
                                            <br>
                                            <input type="hidden" value="<%=v.getUsersByIdUsers().getIdUsers()%>" name="id_users">

                                    </div>

                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">fermer</button>
                                        <input type="hidden" name="id" value="<%=v.getIdStock()%>" />
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
