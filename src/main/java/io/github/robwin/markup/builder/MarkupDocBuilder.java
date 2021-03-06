/*
 *
 *  Copyright 2015 Robert Winkler
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 *
 */
package io.github.robwin.markup.builder;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

/**
 * @author Robert Winkler
 */
public interface MarkupDocBuilder {

    MarkupDocBuilder documentTitle(String title);

    MarkupDocBuilder documentTitleWithAttributes(String title);

    MarkupDocBuilder sectionTitleLevel1(String title);

    MarkupDocBuilder sectionTitleLevel2(String title);

    MarkupDocBuilder sectionTitleLevel3(String title);

    MarkupDocBuilder sectionTitleLevel4(String title);

    MarkupDocBuilder textLine(String text);

    MarkupDocBuilder paragraph(String text);

    MarkupDocBuilder listing(String text);

    MarkupDocBuilder source(String text, String language);

    MarkupDocBuilder boldTextLine(String text);

    MarkupDocBuilder italicTextLine(String text);

    MarkupDocBuilder unorderedList(List<String> list);

    @Deprecated
    MarkupDocBuilder tableWithHeaderRow(List<String> rowsInPSV);

    MarkupDocBuilder table(List<List<String>> cells);

    MarkupDocBuilder tableWithColumnSpecs(List<MarkupTableColumn> columnSpecs, List<List<String>> cells);

    MarkupDocBuilder anchor(String anchor, String text);

    String anchorAsString(String anchor, String text);

    MarkupDocBuilder crossReference(String anchor, String text);

    String crossReferenceAsString(String anchor, String text);

    MarkupDocBuilder crossReferenceTitle(String anchor, String text);

    String crossReferenceTitleAsString(String anchor, String text);

    MarkupDocBuilder newLine();

    /**
     * Returns a string representation of the document.
     */
    String toString();

    /**
     * Writes the content of the builder to a file and clears the builder.
     * An extension will be dynamically added to fileName depending on the markup language.
     *
     * @param directory the directory where the generated file should be stored
     * @param fileName the base name of the file without extension
     * @param charset the the charset to use for encoding
     * @throws java.io.IOException if the file cannot be written
     */
    void writeToFile(String directory, String fileName, Charset charset) throws IOException;

    /**
     * Writes the content of the builder to a file and clears the builder.
     *
     * @param directory the directory where the generated file should be stored
     * @param fileName the name of the file
     * @param charset the the charset to use for encoding
     * @throws java.io.IOException if the file cannot be written
     */
     void writeToFileWithoutExtension(String directory, String fileName, Charset charset) throws IOException;

}
