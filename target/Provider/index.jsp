<%@ page import="ua.kh.baklanov.db.mysql.MySQLFactory" %>
<%@ page import="ua.kh.baklanov.db.dao.UserDAO" %>
<%@ page import="ua.kh.baklanov.model.entity.User" %>
<html>
<body>
<h2>Hello World!</h2>
<%
    MySQLFactory db = MySQLFactory.getInstance();
    UserDAO dao = db.getUserDAO();
    User user=new User();
    user.setLogin("login3");
    user.setPassword("password3");
    user.setEmail("email");
    user.setIdRole(1);
    dao.insert(user);
    user = dao.getByLogin("login3");
    out.println(user.getId());
    out.println(user.getLogin());
    out.println(user.getPassword());
    out.println(user.getEmail());
    out.println(user.getIdRole());
%>
</body>
</html>
