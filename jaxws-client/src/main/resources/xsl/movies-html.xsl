<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" encoding="UTF-8"/>
    <xsl:template match="/">
        <html>
            <body style="font-family: Verdana, sans-serif;">
                <h2>Movies</h2>

                <xsl:choose>
                    <xsl:when test="movies/movie">
                        <table border="1" cellpadding="5">
                            <tr bgcolor="#aba3a2">
                                <th>Title</th>
                                <th>Release year</th>
                                <th>Rating</th>
                            </tr>
                            <xsl:for-each select="movies/movie">
                                <tr bgcolor="#f4f1ec">
                                    <td>
                                        <xsl:value-of select="title"/>
                                    </td>
                                    <td>
                                        <xsl:value-of select="release-year"/>
                                    </td>
                                    <td>
                                        <xsl:value-of select="rating"/>
                                    </td>
                                </tr>
                            </xsl:for-each>
                        </table>
                    </xsl:when>
                    <xsl:otherwise>
                        <p>No movies found.</p>
                    </xsl:otherwise>
                </xsl:choose>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
