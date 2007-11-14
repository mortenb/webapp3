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
            <h1>Her kan du se på statistikk</h1>
                <h:dataTable value="#{Bruker.alleBrukere}" var="item" border="1">
                <h:column>
                    <f:facet name="header">
                        <f:verbatim>Brukernavn</f:verbatim>
                    </f:facet>
                    <h:outputText value="#{item.brukernavn}" />
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <f:verbatim>Spm1</f:verbatim>
                    </f:facet>
                    <h:outputText value="#{item.preferanse1}" />
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <f:verbatim>Spm2</f:verbatim>
                    </f:facet>
                    <h:outputText value="#{item.preferanse2}" />
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <f:verbatim>Spm3</f:verbatim>
                    </f:facet>
                    <h:outputText value="#{item.preferanse3}" />
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <f:verbatim>Spm4</f:verbatim>
                    </f:facet>
                    <h:outputText value="#{item.preferanse4}" />
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <f:verbatim>Spm5</f:verbatim>
                    </f:facet>
                    <h:outputText value="#{item.preferanse5}" />
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <f:verbatim>Spm6</f:verbatim>
                    </f:facet>
                    <h:outputText value="#{item.preferanse6}" />
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <f:verbatim>Spm7</f:verbatim>
                    </f:facet>
                    <h:outputText value="#{item.preferanse7}" />
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <f:verbatim>Spm8</f:verbatim>
                    </f:facet>
                    <h:outputText value="#{item.preferanse8}" />
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <f:verbatim>Spm9</f:verbatim>
                    </f:facet>
                    <h:outputText value="#{item.preferanse9}" />
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <f:verbatim>Spm10</f:verbatim>
                    </f:facet>
                    <h:outputText value="#{item.preferanse10}" />
                </h:column>
            </h:dataTable>
            <br />
            Her er spørsmålene: <br />
            <f:loadBundle basename="spmtext" var="text" />
                 Spm1:  <h:outputText value="#{text.spm1}" /> <br />
                 Spm2:  <h:outputText value="#{text.spm2}" /> <br />
                 Spm3:  <h:outputText value="#{text.spm3}" /> <br />
                 Spm4:  <h:outputText value="#{text.spm4}" /> <br />
                 Spm5:  <h:outputText value="#{text.spm5}" /> <br />
                 Spm6:  <h:outputText value="#{text.spm6}" /> <br />
                 Spm7:  <h:outputText value="#{text.spm7}" /> <br />
                 Spm8:  <h:outputText value="#{text.spm8}" /> <br />
                 Spm9:  <h:outputText value="#{text.spm9}" /> <br />
                 Spm10:  <h:outputText value="#{text.spm10}" /> <br />

        </body>
    </html>
</f:view>
