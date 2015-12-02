<!DOCTYPE>

<%@ page import="com.amimof.ServerInfo" %>
<%@ page import="com.amimof.ServerInfo.JVMEntry" %>
<%@ page import="java.util.List" %>

<% 
	ServerInfo srv = new ServerInfo(); 
	List<JVMEntry> entries = srv.getJvmProps();
%>

<html>
	<head>
		<title>Example Web App</title>
		<style type="text/css">
			#jvmcontainer {
				background-color: #FFF5C3;
				padding: 10px;
			}
		</style>
	</head>
	<body>
		
		<h3>Server Info</h3>		
		HostName: <%= srv.getServerHostName()%> <br/>
		IPAddr: <%= srv.getServerIpAddr() %> <br/>
		TotalMem: <%= srv.getTotalMem() %> bytes<br/>
		FreeMem: <%= srv.getFreeMem() %> bytes<br/>
		MaxMem: <%= srv.getMaxMem() %> bytes<br/>
		NumProcs: <%= srv.getAvailProcs() %>
		
		<h3>JVM System Properties</h3>
		<div id="jvmcontainer">
			<% for(JVMEntry entry : entries) { %>
				<%= entry.getName() %> = <%= entry.getValue() %> <br/>
			<% } %>
		</div>
		
	</body>
</html>
