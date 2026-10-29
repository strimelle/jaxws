<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version = "1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match = "/">
        <html>
            <body>
                <h2>Directors</h2>

                    <table border = "1">
                        <tr bgcolor = "#aba3a2">
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
                            <tr>
                                <td><xsl:value-of select = "id"/></td>
                                <td><xsl:value-of select = "first-name"/></td>
                                <td><xsl:value-of select = "last-name"/></td>
                                <td><xsl:value-of select = "birth-year"/></td>
                                <td><xsl:value-of select = "average-rating"/></td>
                                <td><xsl:value-of select = "active"/></td>
                                <td><xsl:value-of select = "main-genre"/></td>
                                <td>
                                    <table>
                                        <tr>
                                        <xsl:for-each select="movies/movie">
                                            <tr><td><xsl:value-of select = "title"/></td>
                                            <td><xsl:value-of select = "release-year"/></td>
                                            <td><xsl:value-of select = "rating"/></td></tr>
                                        </xsl:for-each>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                        </xsl:for-each>
                    </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>



