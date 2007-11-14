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
            <h1>Her kan du velge kriterier:</h1>
            
            <h:form>
                <f:loadBundle basename="spmtext" var="text" />
                 <h:outputText value="#{text.spm1}" /> <br />
                <h:selectOneRadio value="#{Bruker.kriterie1}" >
                   <f:selectItems value="#{Bruker.kriterieAlternativer}" />
                
                </h:selectOneRadio>
                  <br /> <h:outputText value="#{text.spm2}" /> <br /> 
                <h:selectOneRadio value="#{Bruker.kriterie2}" >
                   <f:selectItems value="#{Bruker.kriterieAlternativer}" />
                
                </h:selectOneRadio>
                <br /> <h:outputText value="#{text.spm3}" /> <br />  
                <h:selectOneRadio value="#{Bruker.kriterie3}" >
                   <f:selectItems value="#{Bruker.kriterieAlternativer}" />
                
                </h:selectOneRadio>
                <br /> <h:outputText value="#{text.spm4}" /> <br />  
                <h:selectOneRadio value="#{Bruker.kriterie4}" >
                   <f:selectItems value="#{Bruker.kriterieAlternativer}" />
                
                </h:selectOneRadio>
                <br /> <h:outputText value="#{text.spm5}" /> <br />  
                <h:selectOneRadio value="#{Bruker.kriterie5}" >
                   <f:selectItems value="#{Bruker.kriterieAlternativer}" />
                
                </h:selectOneRadio>
                <br /> <h:outputText value="#{text.spm6}" /> <br />  
                <h:selectOneRadio value="#{Bruker.kriterie6}" >
                   <f:selectItems value="#{Bruker.kriterieAlternativer}" />
                
                </h:selectOneRadio>
                <br /> <h:outputText value="#{text.spm7}" /> <br />  
                <h:selectOneRadio value="#{Bruker.kriterie7}" >
                   <f:selectItems value="#{Bruker.kriterieAlternativer}" />
                
                </h:selectOneRadio>
                <br /> <h:outputText value="#{text.spm8}" /> <br /> 
                <h:selectOneRadio value="#{Bruker.kriterie8}" >
                   <f:selectItems value="#{Bruker.kriterieAlternativer}" />
                
                </h:selectOneRadio>
                <br /> <h:outputText value="#{text.spm9}" /> <br /> 
                <h:selectOneRadio value="#{Bruker.kriterie9}" >
                   <f:selectItems value="#{Bruker.kriterieAlternativer}" />
                
                </h:selectOneRadio>
                <br /> <h:outputText value="#{text.spm10}" /> <br />  
                <h:selectOneRadio value="#{Bruker.kriterie10}" >
                   <f:selectItems value="#{Bruker.kriterieAlternativer}" />
                
                </h:selectOneRadio>
                <br />
                <h:commandButton action="velgKriterier" value="OK" />
            </h:form>
        </body>
    </html>
</f:view>
