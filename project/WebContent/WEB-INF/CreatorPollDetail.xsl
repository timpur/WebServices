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
			<p style="text-align:center;">
				Status:
				<b>
					<xsl:value-of select="status" />
				</b>
			</p>
			<br />
			<div style="text-align:center;">
				<xsl:element name="input">
					<xsl:attribute name="type">button</xsl:attribute>
					<xsl:attribute name="value">Close Poll</xsl:attribute>
					<xsl:attribute name="onClick">location.href=location.href + '&amp;close=true';</xsl:attribute>
				</xsl:element>
			</div>
			<br />
			<h2 style="text-align:center;">Metting Times</h2>
			<p style="text-align:center;">
				<xsl:for-each select="options/option">
					<xsl:value-of select="value" />
					<br />
				</xsl:for-each>
			</p>
		</div>
	</xsl:template>

</xsl:stylesheet>