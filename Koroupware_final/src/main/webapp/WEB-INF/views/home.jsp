<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<p> Test values : ${test.testNum } & ${test.testStr }</p>
<button class="btn btn-primary">TEST BTN</button>
</body>
</html>
