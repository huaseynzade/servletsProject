<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="index.css">
    <title>JSP - Hello World</title>
    <style>
        /*body {*/
        /*    background-color: #f2f2f2;*/
        /*    font-family: Arial, sans-serif;*/
        /*    text-align: center;*/
        /*    margin: 0;*/
        /*    padding: 0;*/
        /*    height: 100vh;*/
        /*    display: flex;*/
        /*    justify-content: center;*/
        /*    align-items: center;*/
        /*}*/
        /*a {*/
        /*    text-decoration: none;*/
        /*    font-size: 24px;*/
        /*    color: #fff;*/
        /*    display: inline-block;*/
        /*    padding: 10px 20px;*/
        /*    border-radius: 5px;*/
        /*    margin-bottom: 20px;*/
        /*    transition: background-color 0.5s ease;*/
        /*}*/
        /*.primary {*/
        /*    background-color: #EF81BE;*/
        /*    transition-delay: 0.2s;*/
        /*    margin-right: 10px; !* Düğmeler arasındaki boşluğu ayarlar *!*/
        /*}*/
        /*.secondary {*/
        /*    background-color: #D880EF;*/
        /*}*/
        /*a.primary:hover {*/
        /*    background-color: #DB80E6;*/
        /*    transition-delay: 0s;*/
        /*}*/
        /*a.secondary:hover {*/
        /*    background-color: #EC81C6;*/
        /*}*/

        * {
            margin: 0;
            padding: 0;
            outline: 0;
        }
        .filter {
            position: absolute;
            left: 0;
            top: 0;
            bottom: 0;
            right: 0;
            z-index: 1;
            background: rgb(233, 76, 161);
            background: -moz-linear-gradient(90deg, rgba(233, 76, 161, 1) 0%, rgba(199, 74, 233, 1) 100%);
            background: -webkit-linear-gradient(90deg, rgba(233, 76, 161, 1) 0%, rgba(199, 74, 233, 1) 100%);
            background: linear-gradient(90deg, rgba(233, 76, 161, 1) 0%, rgba(199, 74, 233, 1) 100%);
            filter: progid:DXImageTransform.Microsoft.gradient(startColorstr="#e94ca1", endColorstr="#c74ae9", GradientType=1);
            opacity: .7;
        }
        table {
            position: absolute;
            z-index: 2;
            left: 50%;
            top: 50%;
            transform: translate(-50%, -50%);
            width: 60%;
            border-collapse: collapse;
            border-spacing: 0;
            box-shadow: 0 2px 15px rgba(64, 64, 64, .7);
            border-radius: 12px 12px 0 0;
            overflow: hidden;
        }
        td, th {
            padding: 15px 20px;
            text-align: center;
        }
        th {
            background-color: #ba68c8;
            color: #fafafa;
            font-family: 'Open Sans', Sans-serif;
            font-weight: 200;
            text-transform: uppercase;
        }
        tr {
            width: 100%;
            background-color: #fafafa;
            font-family: 'Montserrat', sans-serif;
        }
        tr:nth-child(even) {
            background-color: #eeeeee;
        }
        /* Buton stillemeleri */
        a {
            text-decoration: none;
            font-size: 24px;
            color: #fff;
            display: inline-block;
            padding: 10px 20px;
            border-radius: 5px;
            margin: 10px;
            transition: background-color 0.3s ease;
            position: relative;
            z-index: 3;
        }
        .primary {
            background-color: #8068B5;
        }
        .secondary {
            background-color: #FE275D;
        }
        a:hover {
            background-color: #674394;
        }

        body {
            text-align: center;
            align-items: center;
            justify-content: center;
        }

    </style>
</head>
<body>
<div class="filter"></div>
    <a href="products" class="primary">Show Full List</a>
    <a href="in.html" class="secondary">Find Product</a>



</body>
</html>