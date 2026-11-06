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
                    <fo:block>p.
                        <fo:page-number/>
                    </fo:block>
                </fo:static-content>
                <fo:flow flow-name="xsl-region-body">
                    <fo:block font-size="20pt" font-weight="bold" line-height="30pt">
                        Movies
                    </fo:block>
                    <xsl:choose>
                        <xsl:when test="movies/movie">
                            <fo:table width="100%" table-layout="fixed" font-size="10pt">
                                <fo:table-column column-width="proportional-column-width(4)"/>
                                <fo:table-column column-width="proportional-column-width(1)"/>
                                <fo:table-column column-width="proportional-column-width(1)"/>
                                <fo:table-header>
                                    <fo:table-row background-color="#aba3a2" font-weight="bold">
                                        <fo:table-cell border="0.5pt solid black" padding="3pt">
                                            <fo:block>Title</fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell border="0.5pt solid black" padding="3pt">
                                            <fo:block>Release year</fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell border="0.5pt solid black" padding="3pt">
                                            <fo:block>Rating</fo:block>
                                        </fo:table-cell>
                                    </fo:table-row>
                                </fo:table-header>
                                <fo:table-body>
                                    <xsl:for-each select="movies/movie">
                                        <fo:table-row background-color="#f4f1ec">
                                            <fo:table-cell border="0.5pt solid black" padding="3pt">
                                                <fo:block>
                                                    <xsl:value-of select="title"/>
                                                </fo:block>
                                            </fo:table-cell>
                                            <fo:table-cell border="0.5pt solid black" padding="3pt">
                                                <fo:block>
                                                    <xsl:value-of select="release-year"/>
                                                </fo:block>
                                            </fo:table-cell>
                                            <fo:table-cell border="0.5pt solid black" padding="3pt">
                                                <fo:block>
                                                    <xsl:value-of select="rating"/>
                                                </fo:block>
                                            </fo:table-cell>
                                        </fo:table-row>
                                    </xsl:for-each>
                                </fo:table-body>
                            </fo:table>
                        </xsl:when>
                        <xsl:otherwise>
                            <!-- FOP does not allow an empty fo:table-body, so show a message instead -->
                            <fo:block>No movies found.</fo:block>
                        </xsl:otherwise>
                    </xsl:choose>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet>
