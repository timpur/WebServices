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
			<h2 style="text-align:center;">Select a Metting Time</h2>

			<xsl:call-template name="options" />
			<br />
			<xsl:call-template name="responses" />

		</div>

	</xsl:template>

	<xsl:template name="options">
		<xsl:for-each select="options/option">
			<p style="text-align:center;">
				<xsl:value-of select="@id" />
				:
				<xsl:value-of select="value" />
			</p>
		</xsl:for-each>
	</xsl:template>

	<xsl:template name="responses">
		<h2 style="text-align:center;">Responses</h2>
		<table
			style="width:200px;margin-left:auto;margin-right:auto;text-align:center;border-collapse:collapse;border: 1px solid black;">
			<thead>
				<tr style="border: 1px solid black;">
					<td>Name</td>
					<td>Options</td>
				</tr>
			</thead>
			<tbody>
				<xsl:for-each select="responses/response">
					<tr style="border: 1px solid black;">
						<td style="border: 1px solid black;">
							<xsl:value-of select="name" />
						</td>
						<td style="border: 1px solid black;">
							<xsl:call-template name="ResponseOptions" />
						</td>
					</tr>
				</xsl:for-each>
			</tbody>
		</table>
	</xsl:template>

	<xsl:template name="ResponseOptions">
		<xsl:for-each select="options/option">
			<p>
				<xsl:value-of select="@id"></xsl:value-of>
			</p>
		</xsl:for-each>
	</xsl:template>

</xsl:stylesheet>