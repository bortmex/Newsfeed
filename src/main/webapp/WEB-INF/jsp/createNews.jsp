<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alexa
  Date: 19.06.2018
  Time: 23:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<style>
    textarea {
        resize: none;
    }
</style>
<body>
<script type="text/javascript" src="resources/js/createNews.js" defer></script>
<div id="wrapper">
    <header id="header">
        <c:if test="${editnew}">
        <h1>Редактирование новости</h1>
        </c:if>
        <c:if test="${!editnew}">
        <h1>Создание новости</h1>
        </c:if>
    </header>

    <div id="main">
        <form class="form-horizontal" id="detNewsForm">
            <article class="post">
                <header>
                    <div class="title">
                        <c:if test="${editnew}">
                            <input type="hidden" name="datacreate" value="${newsedit.datacreate}">
                        </c:if>
                        <c:if test="${!editnew}">
                            <input type="hidden" name="datacreate">
                        </c:if>
                        <c:if test="${editnew}">
                            <input type="hidden" name="id" value="${newsedit.id}">
                        </c:if>
                        <c:if test="${!editnew}">
                            <input type="hidden" name="id">
                        </c:if>
                        <p>
                            <label for="name">Название новости:</label>
                        <div>
                            <c:if test="${editnew}">
                                <input id="name" name="name" type="text" placeholder="" class="form-control input-md"
                                       value="${newsedit.name}">
                            </c:if>
                            <c:if test="${!editnew}">
                                <input id="name" name="name" type="text" placeholder="" class="form-control input-md">
                            </c:if>
                            <span style="color: red;" class="help-block" id="help1"></span>
                        </div>
                        </p>
                        <p>
                            <label for="content">Содержание новости:</label>
                        <div>
                            <c:if test="${editnew}">
                            <textarea rows="10" cols="45" id="content" name="content" placeholder=""
                                      class="form-control input-md">${newsedit.content}</textarea>
                            </c:if>
                            <c:if test="${!editnew}">
                            <textarea rows="10" cols="45" id="content" name="content" placeholder=""
                                      class="form-control input-md"></textarea>
                            </c:if>
                            <span style="color: red;" class="help-block" id="help2"></span>
                        </div>
                        </p>

                        <p>
                            <label for="selectpicker">Категории:</label>
                            <select id="selectpicker" class="selectpicker col-md-4">
                                <c:if test="${editnew}">
                                    <c:forEach items="${categories}" var="categories">

                                        <c:if test="${newsedit.categories.id==categories.id}">
                                            <option selected id="${categories.id}">${categories.name}</option>
                                        </c:if>
                                        <c:if test="${newsedit.categories.id!=categories.id}">
                                            <option id="${categories.id}">${categories.name}</option>
                                        </c:if>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${!editnew}">
                                    <c:forEach items="${categories}" var="categories">
                                        <option id="${categories.id}">${categories.name}</option>
                                    </c:forEach>
                                </c:if>
                            </select>
                            <span style="color: red;" class="help-block" id="help3"></span>
                    </div>

                    <input type="hidden" name="categoriesid" id="categoriesid">
                </header>
                <footer>
                    <ul class="actions">
                        <li><a type="submit" id="saveNews" class="button big">Сохранить</a></li>
                        <li><a href="" class="button big">Отмена</a></li>
                    </ul>
                </footer>
            </article>

        </form>
    </div>
</div>
</body>
</html>
