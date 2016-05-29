<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="polls">
		<xsl:apply-templates />
	</xsl:template>

	<xsl:template match="poll">
		<div
			style="width:calc(33% - 40px);display:inline-block;margin:10px;padding:10px;background-color:#d3d3d3">
			<h1 align="center">
				<xsl:element name="a">
					<xsl:attribute name="href">
						details.jsp?id=<xsl:value-of select="id" />
    				</xsl:attribute>
					<xsl:attribute name="style">
        				color:black;text-decoration:none;
    				</xsl:attribute>
					<xsl:value-of select="title" />
				</xsl:element>
			</h1>
			<p align="center">
				By
				<b>
					<xsl:value-of select="author" />
				</b>
			</p>
			<p>
				<span>
					Options:
					<xsl:value-of select="count(options/option)" />
				</span>
				<span style="float:right;">
					Responses:
					<xsl:value-of select="count(responses/response)" />
				</span>
			</p>
		</div>
	</xsl:template>
</xsl:stylesheet>