<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:fo="http://www.w3.org/1999/XSL/Format">
    <xsl:template match="/">

        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master master-name="only"
                                       page-width="21cm" page-height="29.7cm" margin="2cm">
                    <fo:region-body margin-bottom="1cm"/>
                    <fo:region-after extent="1.5cm"/>
                </fo:simple-page-master>
            </fo:layout-master-set>
            <fo:page-sequence master-reference="only">
                <fo:static-content flow-name="xsl-region-after">
                    <fo:block>
                        <fo:leader leader-pattern="rule" leader-length="10cm"/>
                    </fo:block>
                    <fo:block>p.
                        <fo:page-number/>

                    </fo:block>
                </fo:static-content>
                <fo:flow flow-name="xsl-region-body">
                    <fo:block font-size="20pt" font-family="serif" line-height="30pt">
                        Directors
                    </fo:block>
                    <fo:table width="100%" table-layout="fixed" font-size="9pt">
                        <fo:table-header>
                            <fo:table-row>
                                <fo:table-cell border="0.5pt solid black" padding="2pt" background-color="#aba3a2"
                                               font-weight="bold">
                                    <fo:block>ID</fo:block>
                                </fo:table-cell>
                                <fo:table-cell border="0.5pt solid black" padding="2pt" background-color="#aba3a2"
                                               font-weight="bold">
                                    <fo:block>First Name</fo:block>
                                </fo:table-cell>
                                <fo:table-cell border="0.5pt solid black" padding="2pt" background-color="#aba3a2"
                                               font-weight="bold">
                                    <fo:block>Last Name</fo:block>
                                </fo:table-cell>
                                <fo:table-cell border="0.5pt solid black" padding="2pt" background-color="#aba3a2"
                                               font-weight="bold">
                                    <fo:block>Birth year</fo:block>
                                </fo:table-cell>
                                <fo:table-cell border="0.5pt solid black" padding="2pt" background-color="#aba3a2"
                                               font-weight="bold">
                                    <fo:block>Average rating</fo:block>
                                </fo:table-cell>
                                <fo:table-cell border="0.5pt solid black" padding="2pt" background-color="#aba3a2"
                                               font-weight="bold">
                                    <fo:block>Active</fo:block>
                                </fo:table-cell>
                                <fo:table-cell border="0.5pt solid black" padding="2pt" background-color="#aba3a2"
                                               font-weight="bold">
                                    <fo:block>Main genre</fo:block>
                                </fo:table-cell>
                                <fo:table-cell border="0.5pt solid black" padding="2pt" background-color="#aba3a2"
                                               font-weight="bold">
                                    <fo:block>Movies</fo:block>
                                </fo:table-cell>
                            </fo:table-row>
                        </fo:table-header>
                        <fo:table-body>
                            <xsl:for-each select="directors/director">
                                <fo:table-row>
                                    <fo:table-cell>
                                        <fo:block>
                                            <xsl:value-of select="id"></xsl:value-of>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block>
                                            <xsl:value-of select="first-name"></xsl:value-of>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block>
                                            <xsl:value-of select="last-name"></xsl:value-of>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block>
                                            <xsl:value-of select="birth-year"></xsl:value-of>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block>
                                            <xsl:value-of select="average-rating"></xsl:value-of>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block>
                                            <xsl:value-of select="active"></xsl:value-of>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block>
                                            <xsl:value-of select="main-genres"></xsl:value-of>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <xsl:for-each select="movies/movie">
                                            <fo:block>
                                                <xsl:value-of select="title"></xsl:value-of>
                                            </fo:block>
                                            <fo:block>
                                                <xsl:value-of select="release-year"></xsl:value-of>
                                            </fo:block>
                                            <fo:block>
                                                <xsl:value-of select="rating"></xsl:value-of>
                                            </fo:block>
                                        </xsl:for-each>
                                    </fo:table-cell>
                                </fo:table-row>
                            </xsl:for-each>
                        </fo:table-body>
                    </fo:table>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet>

