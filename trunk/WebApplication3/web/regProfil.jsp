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
             Hei, <h:outputText value="#{Bruker.brukernavn}"/>
             <h:form>
                 
                 <h:selectOneRadio value="#{Bruker.preferanse1}">
                     
                     <f:selectItems value="#{Bruker.alternativer}" />
                         
                  
                 </h:selectOneRadio>
                 Spm 1:<br />
                 <h:selectOneRadio id="pref1" value="#{Bruker.preferanse1}" onclick="submit()" >
                     <f:selectItem itemValue="1" itemLabel="1" />
                     <f:selectItem  itemValue="2" itemLabel="2" />
                     <f:selectItem  itemValue="3" itemLabel="3" />
                     <f:selectItem  itemValue="4" itemLabel="4" />
                     <f:selectItem itemValue="5" itemLabel="5" />
                 </h:selectOneRadio>  
                 <br />Spm 2: <br />
                  <h:selectOneRadio id="pref2" value="#{Bruker.preferanse2}">
                     <f:selectItem id="pref21" itemValue="1" itemLabel="1" />
                     <f:selectItem id="pref22" itemValue="2" itemLabel="2" />
                     <f:selectItem id="pref23" itemValue="3" itemLabel="3" />
                     <f:selectItem id="pref24" itemValue="4" itemLabel="4" />
                     <f:selectItem id="pref25" itemValue="5" itemLabel="5" />
                 </h:selectOneRadio>    
                 
                 Skriv inn pref2: <h:inputText value="#{Bruker.preferanse2}"/>
               
                 <h:outputText value="#{Bruker.preferanse1}" />
                 
             </h:form>
        </body>
    </html>
</f:view>
