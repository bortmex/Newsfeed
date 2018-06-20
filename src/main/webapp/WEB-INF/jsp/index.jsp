<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alexa
  Date: 19.06.2018
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<script type="text/javascript" src="resources/js/startpage.js" defer></script>

<c:if test="${pageContext.request.queryString=='_addNews'}">
    <script type="text/javascript" src="resources/js/successAddNews.js" defer></script>
</c:if>
<!-- Wrapper -->
<div id="wrapper">

    <!-- Header -->
    <header id="header">
        <h1><a href="createnews">Создать новость</a></h1>
        <nav class="main">
            <ul>
                <li class="menu">
                    <a class="fa-search" id="menusearch" href="#menu">Filter</a>
                </li>
            </ul>
        </nav>
    </header>


    <!-- Menu -->
    <section id="menu">

        <!-- Search -->
        <section>
                <ol>
                    <h4>Поиск по имени</h4>
                    <form class="search">
                        <input type="text" id="name" name="searchname" placeholder="Search"/>
                    </form>
                </ol>
                <ol>
                    <h4>Поиск по содержанию</h4>
                    <form class="search">
                        <input type="text" id="content" name="searchcontent" placeholder="Search"/>
                    </form>
                </ol>
        </section>
        <!-- Links -->
        <section>
            <ul class="links">
                <li>
                    <h4>Выберите категорию</h4>
                    <select id="selectpicker" class="selectpicker">
                            <option id="nocategory_empty">Все категории</option>
                        <c:forEach items="${categories}" var="categories">
                            <option id="${categories.id}">${categories.name}</option>
                        </c:forEach>
                    </select>
                </li>
            </ul>
        </section>

        <!-- Actions -->
        <section>
            <ul class="actions vertical">
                <li><a type="submit" id="applyfilter" class="button big fit">Применить фильтр</a></li>
                <li><a type="submit" id="canselfilter" class="button big fit">Очистить фильтр</a></li>
            </ul>
        </section>
    </section>

    <!-- Main -->
    <div id="main">
        <%--
                <c:forEach items="${news}" var="news">

                <!-- Post -->
                <article class="post">
                    <header>
                        <div class="title">
                            <h2><a href="#">${news.name}</a></h2>
                            <p>Категория: ${news.categories.name}</p>
                        </div>
                        <div class="meta">
                            <time class="published">${news.datacreate}</time>
                        </div>
                    </header>
                    <p>${news.content}</p>
                    <footer>
                        <ul class="actions">
                            <li><a href="#" class="button big">Редактировать</a></li>
                            <li><a href="#" class="button big">Удалить</a></li>
                        </ul>
                    </footer>
                </article>

                </c:forEach>--%>
        <!-- Pagination -->
        <%--        <ul class="actions pagination">
                    <li><a href="" class="disabled button big previous">Редактировать</a></li>
                    <li><a href="#" class="button big next">Удалить</a></li>
                </ul>--%>

    </div>

</div>

<!-- Scripts -->
<script src="resources/js/skel.min.js"></script>
<script src="resources/js/util.js"></script>
<script src="resources/js/main.js"></script>

</body>
</html>
