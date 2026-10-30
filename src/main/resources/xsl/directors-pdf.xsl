<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:fo="http://www.w3.org/1999/XSL/Format">
    <xsl:template match="/">

        <fo:root font-family="Helvetica">
            <fo:layout-master-set>
                <fo:simple-page-master master-name="only"
                                       page-width="21cm" page-height="29.7cm" margin="2cm">
                    <fo:region-body margin-bottom="2cm"/>
                    <fo:region-after extent="1.5cm"/>
                </fo:simple-page-master>
            </fo:layout-master-set>
            <fo:page-sequence master-reference="only">
                <fo:static-content flow-name="xsl-region-after">
                    <fo:block>
                        <fo:leader leader-pattern="rule" leader-length="17cm"/>
                    </fo:block>
                    <fo:block>p. <fo:page-number/></fo:block>
                </fo:static-content>
                <fo:flow flow-name="xsl-region-body">
                    <fo:block font-size="20pt" font-weight="bold" line-height="30pt">
                        Directors
                    </fo:block>
                    <fo:table width="100%" table-layout="fixed" font-size="9pt">
                        <fo:table-column column-width="proportional-column-width(0.5)"/>
                        <fo:table-column column-width="proportional-column-width(1.2)"/>
                        <fo:table-column column-width="proportional-column-width(1.3)"/>
                        <fo:table-column column-width="proportional-column-width(1)"/>
                        <fo:table-column column-width="proportional-column-width(1)"/>
                        <fo:table-column column-width="proportional-column-width(1)"/>
                        <fo:table-column column-width="proportional-column-width(1)"/>
                        <fo:table-column column-width="proportional-column-width(3.5)"/>
                        <fo:table-header>
                            <fo:table-row background-color="#aba3a2" font-weight="bold">
                                <fo:table-cell border="0.5pt solid black" padding="3pt">
                                    <fo:block>ID</fo:block>
                                </fo:table-cell>
                                <fo:table-cell border="0.5pt solid black" padding="3pt">
                                    <fo:block>First Name</fo:block>
                                </fo:table-cell>
                                <fo:table-cell border="0.5pt solid black" padding="3pt">
                                    <fo:block>Last Name</fo:block>
                                </fo:table-cell>
                                <fo:table-cell border="0.5pt solid black" padding="3pt">
                                    <fo:block>Birth year</fo:block>
                                </fo:table-cell>
                                <fo:table-cell border="0.5pt solid black" padding="3pt">
                                    <fo:block>Average rating</fo:block>
                                </fo:table-cell>
                                <fo:table-cell border="0.5pt solid black" padding="3pt">
                                    <fo:block>Active</fo:block>
                                </fo:table-cell>
                                <fo:table-cell border="0.5pt solid black" padding="3pt">
                                    <fo:block>Main genre</fo:block>
                                </fo:table-cell>
                                <fo:table-cell border="0.5pt solid black" padding="3pt">
                                    <fo:block>Movies</fo:block>
                                </fo:table-cell>
                            </fo:table-row>
                        </fo:table-header>
                        <fo:table-body>
                            <xsl:for-each select="directors/director">
                                <fo:table-row background-color="#f4f1ec">
                                    <fo:table-cell border="0.5pt solid black" padding="3pt">
                                        <fo:block><xsl:value-of select="id"/></fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border="0.5pt solid black" padding="3pt">
                                        <fo:block><xsl:value-of select="first-name"/></fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border="0.5pt solid black" padding="3pt">
                                        <fo:block><xsl:value-of select="last-name"/></fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border="0.5pt solid black" padding="3pt">
                                        <fo:block><xsl:value-of select="birth-year"/></fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border="0.5pt solid black" padding="3pt">
                                        <fo:block><xsl:value-of select="average-rating"/></fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border="0.5pt solid black" padding="3pt">
                                        <fo:block><xsl:value-of select="active"/></fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border="0.5pt solid black" padding="3pt">
                                        <fo:block><xsl:value-of select="main-genre"/></fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border="0.5pt solid black" padding="3pt">
                                        <xsl:for-each select="movies/movie">
                                            <fo:block>
                                                <xsl:value-of select="title"/>
                                                (<xsl:value-of select="release-year"/>),
                                                <xsl:value-of select="rating"/>
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
