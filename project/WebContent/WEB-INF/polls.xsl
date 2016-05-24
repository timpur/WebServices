<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="polls">
		<html>
			<head>
			</head>
		</html>
		<body>
			<xsl:apply-templates/>
		</body>
	</xsl:template>
	
	<xsl:template match="poll">
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Author</th>
					<th>Creation Date</th>
					<th>Location</th>
					<th>Description</th>
					<th>Status</th>
					<!-- status of poll closed/open -->
					<th>Options</th>
					<th>Responses</th>
				</tr>
			</thead>
		</table>
		<tbody>
			<xsl:apply-templates/>
		</tbody>
	</xsl:template>
	
</xsl:stylesheet>