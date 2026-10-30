<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body style="font-family: Verdana, sans-serif;">
                <h2>Directors</h2>

                <table border="1" cellpadding="5">
                    <tr bgcolor="#aba3a2">
                        <th>ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Birth year</th>
                        <th>Average rating</th>
                        <th>Active</th>
                        <th>Main genre</th>
                        <th>Movies</th>
                    </tr>
                    <xsl:for-each select="directors/director">
                        <tr bgcolor="#f4f1ec">
                            <td><xsl:value-of select="id"/></td>
                            <td><xsl:value-of select="first-name"/></td>
                            <td><xsl:value-of select="last-name"/></td>
                            <td><xsl:value-of select="birth-year"/></td>
                            <td><xsl:value-of select="average-rating"/></td>
                            <td><xsl:value-of select="active"/></td>
                            <td><xsl:value-of select="main-genre"/></td>
                            <td>
                                <xsl:for-each select="movies/movie">
                                    <xsl:value-of select="title"/>
                                    (<xsl:value-of select="release-year"/>),
                                    <xsl:value-of select="rating"/>
                                    <br/>
                                </xsl:for-each>
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
