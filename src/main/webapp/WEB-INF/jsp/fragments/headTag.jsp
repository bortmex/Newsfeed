<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

 <%--   <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>--%>

<%--<meta http-equiv="X-UA-Compatible" content="IE=edge">--%>
    <title>Новостная лента</title>
    <base href="${pageContext.request.contextPath}/"/>
    <link rel="stylesheet" href="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css">
    <link rel="shortcut icon" href="">
    <%--<link rel="stylesheet" href="resources/css/custom.min.css">--%>

    <%--<link rel="stylesheet" href="resources/css/font-awesome.min.css">
    <link rel="stylesheet" href="resources/css/nprogress.css">
    <link rel="stylesheet" href="resources/css/animate.min.css">--%>
    <!--[if lte IE 8]><script src="resources/js/html5shiv.js"></script><![endif]-->
    <link rel="stylesheet" href="resources/css/main.css" />

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,600" rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="resources/css/iziToast.min.css">

    <!--http://stackoverflow.com/a/24070373/548473-->
    <script type="text/javascript" src="webjars/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js" defer></script>
    <script type="text/javascript" src="webjars/noty/2.3.8/js/noty/packaged/jquery.noty.packaged.min.js" defer></script>
    <script type="text/javascript" src="resources/js/iziToast.min.js" defer></script>
</head>
