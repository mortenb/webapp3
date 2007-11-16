<jsp:useBean id="Bruker" class="matchmaker.Bruker" scope="session"  />
<jsp:setProperty name="Bruker" property="brukernavn" value="<%= request.getRemoteUser() %>" />
<% response.sendRedirect("startside.faces"); %>