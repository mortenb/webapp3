<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">


<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>JSF-teambygger</title>
        </head>
        <body>
           
            
                <h:form>
            <div class="meny"> 
                    <h:commandLink value="Startsiden" action="start" />
                    <h:commandLink value="Registrer profil" action="regProfil" />
                    <h:commandLink value="Velg kriterier" action="velgKriterier" />
                    <h:commandLink value="Vis matcher" action="visMatch" />
                    <h:commandLink value="Vis statistikk" action="visStat" />
            </div>
                    Velkommen 
                    <h:outputText value="#{Bruker.brukernavn}" />
                </h:form>
            
             <h1>Velkommen til Teambyggeren! </h1>
             
        </body>
    </html>
</f:view>
