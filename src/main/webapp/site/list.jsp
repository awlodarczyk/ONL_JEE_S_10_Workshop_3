<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: adam
  Date: 15/06/2021
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="/fragment/header.jsp" %>
<!-- Page Heading -->
<div class="d-sm-flex align-items-center justify-content-between mb-4">
    <h1 class="h3 mb-0 text-gray-800">Lista użytkowników</h1>
</div>
<div class="row">
    <div class="col-xl-12 col-md-12 mb-2">
        <div class="card border-left-primary shadow h-100 py-2">
            <div class="card-body">
                <div class="row no-gutters align-items-center">


                        <table class="table">
                            <tr>
                                <th>Id</th>
                                <th>Nazwa użytkownika</th>
                                <th>Email</th>
                                <th>Akcja</th>
                            </tr>
                            <c:forEach items="${users}" var="user">
                                <tr>
                                    <td>${user.id}</td>
                                    <td>${user.username}</td>
                                    <td>${user.email}</td>
                                    <td>
                                        <div class="row m-2">
                                            <a href='<c:url value="/user/show?id=${user.id}"/>' class="d-none d-inline-block btn btn-sm btn-info btn-block shadow-sm"><i class="fas fa-user fa-sm text-white-50"></i> Pokaż</a>
                                        </div>
                                        <div class="row m-2">
                                            <a href='<c:url value="/user/edit?id=${user.id}"/>' class="d-none d-inline-block btn btn-block btn-sm btn-secondary shadow-sm"><i class="fas fa-user-check fa-sm text-white-50"></i> Edytuj</a>
                                        </div>
                                        <div class="row m-2">
                                            <form class="col m-0 p-0" method="post" action="<c:url value="/user/delete"/>">
                                                <input type="hidden" name="id" value="${user.id}">
                                                <button class="d-none d-inline-block btn btn-sm btn-block btn-danger shadow-sm"><i class="fas fa-trash fa-sm text-white-50"></i> Usuń</button>
                                            </form>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>

                </div>
            </div>
        </div>
    </div>
</div>

<%@ include file="/fragment/footer.jsp" %>