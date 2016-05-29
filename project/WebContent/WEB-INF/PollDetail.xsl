<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output omit-xml-declaration="yes" indent="yes"
		media-type="html" />

	<xsl:template match="poll">

		<div>
			<h1 align="center">
				<xsl:value-of select="title" />
			</h1>
			<p style="text-align:center;">
				By
				<b>
					<xsl:value-of select="author" />
				</b>
			</p>
			<p style="text-align:center;">
				Date Create:
				<b>
					<xsl:value-of select="creationDate" />
				</b>
			</p>
			<p style="text-align:center;">
				Location:
				<b>
					<xsl:value-of select="location" />
				</b>
			</p>
			<p style="text-align:center;">
				Description:
				<b>
					<xsl:value-of select="description" />
				</b>
			</p>
			<br />
			<h2 style="text-align:center;">Select a Metting Time</h2>

			<form style="text-align:center;" action="summary.jsp" method="post">
				<xsl:element name="input">
					<xsl:attribute name="type">hidden</xsl:attribute>
					<xsl:attribute name="name">id</xsl:attribute>
					<xsl:attribute name="value">
							<xsl:value-of select="id" />
						</xsl:attribute>
				</xsl:element>
				<xsl:for-each select="options/option">
					<xsl:element name="input">
						<xsl:attribute name="type">checkbox</xsl:attribute>
						<xsl:attribute name="name">option</xsl:attribute>
						<xsl:attribute name="value">
							<xsl:value-of select="@id" />
						</xsl:attribute>
					</xsl:element>
					<xsl:value-of select="value" />
					<br />
				</xsl:for-each>
				<br />
				<div>
					Name:
					<input type="text" name="name" />
				</div>
				<br />
				<input type="submit" value="Submit" />
			</form>


		</div>

	</xsl:template>

</xsl:stylesheet>