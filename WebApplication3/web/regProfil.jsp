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
           
            <div class="meny"> 
                <h:form>
                    <h:commandLink value="Startsiden" action="start" />
                    <h:commandLink value="Registrer profil" action="regProfil" />
                    <h:commandLink value="Velg kriterier" action="velgKriterier" />
                    <h:commandLink value="Vis matcher" action="visMatch" />
                    <h:commandLink value="Vis statistikk" action="visStat" />
                </h:form>
            </div>
             <h1>Registrer din profil:</h1>
             Hei, <h:outputText value="#{Bruker.brukernavn}" />
             <h:form>
                 <br /> Spm 1:<br />
                 
                 <h:selectOneRadio value="#{Bruker.preferanse1}" >
                     
                     <f:selectItems value="#{Bruker.alternativer}" />
 
                 </h:selectOneRadio>
                 <h:commandButton action="regProfil" value="Lagre verdier" />
                 
               
                 
                
                 
             </h:form>
        </body>
    </html>
</f:view>
