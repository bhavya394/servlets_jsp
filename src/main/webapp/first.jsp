<%@page errorPage="display.jsp" %>
<% out.println("Exception");
int a=50,b=0;
out.println(a/b);
%>